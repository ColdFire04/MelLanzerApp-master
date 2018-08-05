package com.example.calengray.mellanzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginPage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Button requestRegistration = findViewById(R.id.requestRegistration);

        requestRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5=new Intent(loginPage.this, requestRegistration.class);
                startActivity(int5);

            }
        });

        final EditText loginEmail = (EditText) findViewById(R.id.loginEmail);
        final EditText loginPassword = (EditText) findViewById(R.id.loginPassword);
        final Button loginButton = (Button) findViewById(R.id.loginButton);
    }

    @Override
    public void onClick(View view) {

    }
}
