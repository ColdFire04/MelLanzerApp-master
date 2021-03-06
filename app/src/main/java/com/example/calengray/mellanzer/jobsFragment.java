package com.example.calengray.mellanzer;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class jobsFragment extends Fragment {

    private Button display_button1;
    Firebase myFirebase;
    public RelativeLayout RelativeLayout;
    private Button createNewJobBtn;

    public jobsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jobs, container, false);

       Button createNewJobBtn = (Button) view.findViewById(R.id.createNewJobBtn);

        createNewJobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //NEW JOB BUTTON TAKES YOU TO newJobActivity
                Intent intent = new Intent(getActivity(), newJobActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
}