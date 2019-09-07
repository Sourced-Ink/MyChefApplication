package com.example.mycheflogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private EditText username, userpassword, useremail;
    private Button signupBTN;
    private TextView userlogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        //button for when the user has filled in all the details
        signupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateUserDetails()){

                    //converting into a string and removing all wide spaces the user entered thus we using trim()
                    String user_email = useremail.getText().toString().trim();
                    String user_password = userpassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                firebaseAuth.getCurrentUser().sendEmailVerification();
                                Toast.makeText(SignUpActivity.this, "Sign up was successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                startActivity(intent);
                                sendEmailVerificationk();
                            }
                            else{
                                Toast.makeText(SignUpActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        //button for if the user already has an account
        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });
    }

    private void setupUIViews(){
        username = findViewById(R.id.SignUpUserNameInput);
        userpassword = findViewById(R.id.SignUpPasswordInput);
        useremail = findViewById(R.id.SingUpEmailInput);
        signupBTN = findViewById(R.id.SignUpButton);
        userlogin = (Button) findViewById(R.id.SignUpCancelButton);
    }

    //function for checking if the user has filled in all the fields
    private Boolean validateUserDetails(){
        Boolean result = false;

        String name = username.getText().toString();
        String password = userpassword.getText().toString();
        String email = useremail.getText().toString();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "Please fill in all the details!!!", Toast.LENGTH_SHORT).show();
        }else {
            result = true;
        }

        if (userpassword.length() < 8){
            userpassword.setError("Please enter 8 characters");
        }

        return result;
    }

    private void sendEmailVerificationk(){
        //getting the firebase user we dont use getInstance cause its a new user
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUpActivity.this, "Sign up was successful, Verification email sent!", Toast.LENGTH_SHORT).show();
                        //do this so that user cannot go into the app without verifying their email
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(SignUpActivity.this, "Verification email has not being sent!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }
}
