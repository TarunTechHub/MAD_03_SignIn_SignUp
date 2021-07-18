package com.example.mad_03_signin_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    EditText username,password;
    int  attempt=0;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin2);
        username=findViewById(R.id.uid);
        password=findViewById(R.id.pwd);
        signin=findViewById(R.id.signin);
    }

    public void signin(View v)
    {
        Bundle b=getIntent().getExtras();
        String uname=b.getString( "uid");
        String pasword=b.getString("passwd");
        if(username.getText().toString().equals(uname)&& password.getText().toString().equals(pasword))
        {
            Toast.makeText(this, "Sign in sucessfull", Toast.LENGTH_LONG).show();
            attempt=0;
            Intent i=new Intent(this,success.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Sign in unsuccessfull", Toast.LENGTH_LONG).show();
            attempt++;
            if(attempt==3)
            {
                signin.setEnabled(false);
            }
        }

    }
}
