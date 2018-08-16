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

public class jobsFragment extends Fragment {

    private Button display_button1;
    public String editJobNameData;
    Firebase myFirebase;

    public jobsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jobs, container, false);

        Bundle bundle = getArguments();

        String jobName = bundle.getString("JobName");

        Button display_button1 = view.findViewById(R.id.display_button1);

        display_button1.setText("JobName");

        return view;

    }
}
