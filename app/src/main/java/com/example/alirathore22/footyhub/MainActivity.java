package com.example.alirathore22.footyhub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String email;

    private Button buttonRegister;
    private EditText editTextEmail, editTextPassword;
    private TextView textViewSignin;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        //to initialize firebaseAuth object:
        firebaseAuth = FirebaseAuth.getInstance();
        //if user is already logged in:
        if(firebaseAuth.getCurrentUser() != null){
            //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        buttonRegister = findViewById(R.id.buttonRegister);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        textViewSignin = findViewById(R.id.textViewSignin);

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
    }

    private void registerUser(){
        final String email = editTextEmail.getText().toString().trim();
        Log.d("email",email);
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

        //To register user to the server:
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //this listener will execute this method on complete when the registration is complete
                if (task.isSuccessful()){
                    //user successfully registered and logged in
                    //we will start the teamAndLeague activity here

                    finish();
                    startActivity(new Intent(getApplicationContext(), teamAndLeagueSelection.class));

                    Toast.makeText(MainActivity.this, "Registered Successfully.", Toast.LENGTH_SHORT).show();
                   progressDialog.hide();

                    AddUser();
                }
                else{
                    Toast.makeText(MainActivity.this, "Failed to register. Please try again.", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                }
            }

                private void AddUser() {
                    mDatabase.child("users").child(email.split("@")[0]).setValue("Barca");
                }
        });

    }

    @Override
    public void onClick(View view) {
        if (view == buttonRegister){
            registerUser();
        }
        if (view == textViewSignin){
            //open Login Activity
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}
