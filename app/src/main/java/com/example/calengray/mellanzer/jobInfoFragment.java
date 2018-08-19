package com.example.calengray.mellanzer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.annotations.Nullable;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class jobInfoFragment extends Fragment {

    private ImageView jobBanner;
    private TextView EstimatedStartConst;
    private TextView EstimatedEndConst;
    private TextView JobTitle;
    private Button optionsButton;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;


    public jobInfoFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_job_info, container, false);

            jobBanner = (ImageView) view.findViewById(R.id.jobBanner);
            EstimatedStartConst = (TextView) view.findViewById(R.id.EstimatedStartConst);
            EstimatedEndConst = (TextView) view.findViewById(R.id.EstimatedEndConst);
            optionsButton = (Button) view.findViewById(R.id.optionsButton);

            firebaseAuth = FirebaseAuth.getInstance();
            firebaseDatabase = FirebaseDatabase.getInstance();

//        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

            return view;

    }
}

