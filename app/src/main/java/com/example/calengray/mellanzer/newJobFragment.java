package com.example.calengray.mellanzer;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;


public class newJobFragment extends Fragment implements View.OnClickListener{

int x = 1;

    private static final int PICK_IMAGE_REQUEST = 234;
    private ImageView bannerPreview;
    private Button chooseFileButton, finishJobButton;
    public EditText editJobName;
    public String editJobNameData;
    private EditText editEstimatedStart;
    private String editEstimatedStartData;
    private EditText editEstimatedCompletion;
    private String editEstimatedCompletionData;
    private EditText editJobAddress;
    private String editJobAddressData;
    private Firebase myFirebase;
    private Uri filePath;
    private StorageReference storageReference;

    public newJobFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_job, container, false);

        Firebase.setAndroidContext(getActivity());

        myFirebase = new Firebase("https://fir-storage-5c406.firebaseio.com/" + editJobNameData);
        bannerPreview = (ImageView) view.findViewById(R.id.bannerPreview);
        chooseFileButton = (Button) view.findViewById(R.id.chooseFileButton);
        finishJobButton = (Button) view.findViewById(R.id.finishJobButton);
        storageReference = FirebaseStorage.getInstance().getReference();
        editJobName = (EditText) view.findViewById(R.id.editJobName);
        editEstimatedStart = (EditText) view.findViewById(R.id.editEstimatedStart);
        editEstimatedCompletion = (EditText) view.findViewById(R.id.editEstimatedCompletion);
        editJobAddress = (EditText) view.findViewById(R.id.editJobAddress);



        finishJobButton.setOnClickListener(this);
        chooseFileButton.setOnClickListener(this);

        //BUTTON ENABLING AND DISABLING



         TextWatcher infoInputTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String editJobNameInput = editJobName.getText().toString().trim();
                String editJobStartInput = editEstimatedStart.getText().toString().trim();
                String editJobEndInput = editEstimatedCompletion.getText().toString().trim();
                String editJobAddressInput = editJobAddress.getText().toString().trim();


                finishJobButton.setEnabled(!editJobAddressInput.isEmpty() &&
                        !editJobStartInput.isEmpty() && !editJobEndInput.isEmpty() && !editJobNameInput.isEmpty());


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        };

        editJobName.addTextChangedListener(infoInputTextWatcher);
        editEstimatedStart.addTextChangedListener(infoInputTextWatcher);
        editEstimatedCompletion.addTextChangedListener(infoInputTextWatcher);
        editJobAddress.addTextChangedListener(infoInputTextWatcher);






        finishJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //SENDS DATA

                editJobNameData = editJobName.getText().toString();
                editEstimatedStartData = editEstimatedStart.getText().toString();
                editEstimatedCompletionData = editEstimatedCompletion.getText().toString();
                editJobAddressData = editJobAddress.getText().toString();

                Firebase myNewChildJob = myFirebase.child("Job Name" + x++);
                Firebase myNewChildStart = myFirebase.child("Job Estimated Start" + x++);
                Firebase myNewChildEnd = myFirebase.child("Job Estimated Completion" + x++);
                Firebase myNewChildAddress = myFirebase.child("Job Address" + x++);


                myNewChildJob.setValue(editJobNameData);
                myNewChildStart.setValue(editEstimatedStartData);
                myNewChildEnd.setValue(editEstimatedCompletionData);
                myNewChildAddress.setValue(editJobAddressData);

                Toast.makeText(getActivity(), editJobNameData + " Created", Toast.LENGTH_SHORT).show();
 /*               Toast.makeText(getActivity(), editEstimatedStartData, Toast.LENGTH_SHORT).show();
               Toast.makeText(getActivity(), editEstimatedCompletionData, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), editJobAddressData, Toast.LENGTH_SHORT).show();
*/

                editJobName.setText("");
                editEstimatedStart.setText("");
                editEstimatedCompletion.setText("");
                editJobAddress.setText("");


                //GO TO JOBS PAGE


                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.main_frame, new jobsFragment());
                fr.commit();

            }
        });

        return view;
    }

        //CHOOSE IMAGE

    private void showFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select an Image"), PICK_IMAGE_REQUEST);
    }

        //UPLOAD IMAGE
    private void uploadFile() {

        if(filePath != null) {

            final ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference riversRef = storageReference.child("images/jobBanner" + x++);

            riversRef.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(getActivity().getApplicationContext(), "File Uploaded", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            progressDialog.dismiss();
                            Toast.makeText(getActivity().getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();

                        }

                    })
                            .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                    double progress = (100.0 * taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(((int)progress)+ "% Uploaded");
                                }
                            });


        }else{
            //DISPLAY ERROR TOAST
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
                filePath = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePath);
                    bannerPreview.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }




        //CONVERT INPUT TO STRINGS

    @Override
    public void onClick(View view) {

        editJobNameData = editJobName.getText().toString();
        editEstimatedStartData = editEstimatedStart.getText().toString();
        editEstimatedCompletionData = editEstimatedCompletion.getText().toString();
        editJobAddressData = editJobName.getText().toString();

        Firebase myNewChild = myFirebase.child(editJobNameData);
        Firebase myNewChild1 = myFirebase.child(editEstimatedStartData);
        Firebase myNewChild2 = myFirebase.child(editEstimatedCompletionData);
        Firebase myNewChild3 = myFirebase.child(editJobAddressData);


        if(view == chooseFileButton) {
            showFileChooser();
        }else if(view == finishJobButton) {
            uploadFile();
        }

    }
}
