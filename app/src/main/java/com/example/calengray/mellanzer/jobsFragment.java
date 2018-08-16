package com.example.calengray.mellanzer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class jobsFragment extends Fragment{

  private Button display_button1;
  private Button display_button2;
  private Button display_button3;
  public String editJobNameData;
  Firebase myFirebase;

    public jobsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jobs, container, false);

        final Button display_button1 = (Button) view.findViewById(R.id.display_button1);
        Button display_button2 = (Button) view.findViewById(R.id.display_button2);
        Button display_button3 = (Button) view.findViewById(R.id.display_button3);
        Button display_button4 = (Button) view.findViewById(R.id.display_button4);

        Firebase.setAndroidContext(getActivity().getApplicationContext());
        myFirebase = new Firebase("https://fir-storage-5c406.firebaseio.com/" + editJobNameData);

        myFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String myChildText = dataSnapshot.getValue(String.class);
                display_button1.setText(myChildText);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                display_button1.setText("Error Found");
            }
        });

        return view;

    }
}
