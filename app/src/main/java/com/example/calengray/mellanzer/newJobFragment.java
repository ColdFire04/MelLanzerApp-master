package com.example.calengray.mellanzer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class newJobFragment extends Fragment implements View.OnClickListener{

    private EditText job_input;
    private Button goButton;
    private Button display_button;
    String text;

    public newJobFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_job, container, false);



        display_button = (Button) view.findViewById(R.id.display_button);

        goButton.setOnClickListener(this);

            return view;
    }

    public void onClick(View view) {
        if(view.getId() == goButton.getId());
        text=job_input.getText().toString();
        display_button.setText(text);
        }
}
