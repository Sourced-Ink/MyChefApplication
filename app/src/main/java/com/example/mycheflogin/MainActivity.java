package com.example.mycheflogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText user_name, user_password;
    private TextView forgottenpassword, signup;
    private Button login, byPass;
    private int wrongDetails = 10;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name = findViewById(R.id.userName);
        user_password =  findViewById(R.id.userPassword);
        forgottenpassword = findViewById(R.id.tvForgotPass);
        signup = findViewById(R.id.tvSignUp);
        login = findViewById(R.id.userLogInbtn);

        //instance of the firebase authentication
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        //checking if a user has already logged into the app or not and if user has logged in they
        //need to be directed to the next page.
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null){
            finish();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }


        //assigning the login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPassword(user_name.getText().toString(), user_password.getText().toString());
                Intent intentHome = new Intent(MainActivity.this, HomeActivity.class);
            }
        });

        //sign in button for users who don't have accounts
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        //the button if the user has forgotten their password
        forgottenpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
    //Checking if the user has already an account and if the details match to the ones in the database
    private void checkPassword(String uName, String uPassword){

        //these are called clues to let the user know whats going on
        progressDialog.setMessage("Verifying Account");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(uName, uPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressDialog.dismiss();
                    //Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    checkEmailVerification();
                }else{
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    wrongDetails--;
                    progressDialog.dismiss();
                    if (wrongDetails == 0){
                        login.setEnabled(false);
                    }
                }
            }
        });
    }

    //checking if the user has already verified their email or not
    private void checkEmailVerification(){
        //getting the firebase user getInstace only used when user is already registered
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();

        //emailflag will check if user has verified their email
        Boolean emailflag = firebaseUser.isEmailVerified();

        if (emailflag){
            finish();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }else{
            //make the user log in again until email is verified
            Toast.makeText(this, "Verify your email address", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }

    }

}
