package com.example.mad_03_signin_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.uid);
        password=findViewById(R.id.pwd);
    }

    public void signup(View v){
        if(password.getText().toString().length()>=8 && validatepassword(password.getText().toString()))
        {
            Toast.makeText(this, "sign up succesfull", Toast.LENGTH_LONG).show();
            Intent i=new Intent(this,SigninActivity.class);
            Bundle b=new Bundle();
            b.putString("uid",username.getText().toString());
            b.putString("passwd",password.getText().toString());
            i.putExtras(b);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "password is not meeting the constraint", Toast.LENGTH_LONG).show();
        }
    }
    public boolean validatepassword(String passwd)
    {
        Pattern ptrn;
        Matcher mat;
        String passwdptrn="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[<>/@%$#&+=])(?=\\S+$).{8,}$";
        ptrn=Pattern.compile(passwdptrn);
        mat=ptrn.matcher(passwd);
        return mat.matches();


    }
}

