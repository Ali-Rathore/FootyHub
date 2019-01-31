package com.example.alirathore22.footyhub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonSignin;
    private EditText editTextEmail, editTextPassword;
    private TextView textViewSignup;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        //if user is already logged in do the below:
        if(firebaseAuth.getCurrentUser() != null){
            //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonSignin = findViewById(R.id.buttonSignin);

        textViewSignup = findViewById(R.id.textViewSignup);

        progressDialog = new ProgressDialog(this);

        buttonSignin.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }

    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //to check if strings we are getting are empty or not:
        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "Please enter your Email",Toast.LENGTH_SHORT ).show();
            //stopping the function execution
            return;
        }
        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Please enter your Password",Toast.LENGTH_SHORT ).show();
            //stopping the function execution
            return;
        }

        //If Validations are okay, we show a progressdialog

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if(task.isSuccessful()){
                    //start profile activity
                    finish();
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view == buttonSignin){
            userLogin();
        }
        if(view == textViewSignup){
            startActivity(new Intent(this, MainActivity.class));
            finish();

        }
    }
}
