package com.saifi369.firebaseauthapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout mEmailLayout,mPasswordLayout,mUsernameLayout;
    private Button mBtnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEmailLayout=findViewById(R.id.et_email);
        mPasswordLayout=findViewById(R.id.et_password);
        mUsernameLayout=findViewById(R.id.et_username);
        mBtnSignin=findViewById(R.id.btn_validate);
        
        mBtnSignin.setOnClickListener(this::submitData);

        mEmailLayout.setErrorTextColor(ColorStateList.valueOf(Color.BLUE));
        mUsernameLayout.setErrorTextColor(ColorStateList.valueOf(Color.BLUE));
        mPasswordLayout.setErrorTextColor(ColorStateList.valueOf(Color.BLUE));


    }

    private boolean validateEmailAddress(){

        String email=mEmailLayout.getEditText().getText().toString().trim();

        if(email.isEmpty()){
            mEmailLayout.setError("Email is required. Can't be empty.");
            return false;
        }else {
            mEmailLayout.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){

        String password=mPasswordLayout.getEditText().getText().toString().trim();

        if(password.isEmpty()){
            mPasswordLayout.setError("Password is required. Can't be empty.");
            return false;
        }else if(password.length()<8){
            mPasswordLayout.setError("Password is short. 8 Characters are required.");
            return false;
        }
        else {
            mPasswordLayout.setError(null);
            return true;
        }
    }

    private boolean validateUsername(){

        String username=mUsernameLayout.getEditText().getText().toString().trim();

        if(username.isEmpty()){
            mUsernameLayout.setError("Username is required. Can't be empty.");
            return false;
        }else if(username.length()<10){
            mUsernameLayout.setError("Username is short. 10 Characters are required.");
            return false;
        }else{
            mUsernameLayout.setError(null);
            return true;
        }

    }

    private void submitData(View view) {

        if(!validateEmailAddress() | !validatePassword() | !validateUsername()){
            return;
        }

        String data = mEmailLayout.getEditText().getText().toString().trim() +"\n"+
                mUsernameLayout.getEditText().getText().toString().trim() + "\n"+
                mPasswordLayout.getEditText().getText().toString();

        Toast.makeText(this, data, Toast.LENGTH_LONG).show();

    }
}
