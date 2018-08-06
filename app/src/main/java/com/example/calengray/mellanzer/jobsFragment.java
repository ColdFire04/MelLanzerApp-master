package com.example.calengray.mellanzer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class jobsFragment extends Fragment implements View.OnClickListener {

    private EditText job_input;
    private Button goButton;
    private Button display_button;
    String text;

    public jobsFragment() {



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_jobs, container, false);

            Button display_button = (Button)v.findViewById(R.id.display_button);
            String buttonText = display_button.getText().toString();

            if (buttonText.equals("Button")){
                display_button.setVisibility(View.GONE);
            } else {
                display_button.setVisibility(View.VISIBLE);

                return v;
            }



    }



    public void onClick(View v) {

        if(v.getId() == goButton.getId());
        text=job_input.getText().toString();
        display_button.setText(text);


    }





}
