package com.example.calengray.mellanzer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class jobsFragment extends Fragment{

    public EditText editJobName;
    private Button display_button;
    public String editJobNameData;

    public jobsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jobs, container, false);

        return view;

    }
}
