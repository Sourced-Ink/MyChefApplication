package com.example.mycheflogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycheflogin.RecyclerPackage.MyDbClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static com.example.mycheflogin.SearchActivity.progressDialog;

public class SignUpActivity extends AppCompatActivity {

    private static EditText username;
    private EditText userpassword, useremail;
    private Button signupBTN;
    private TextView userlogin;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    MyDbClass myDbClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setupUIViews();

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        myDbClass=new MyDbClass(this);
        //button for when the user has filled in all the details
        signupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateUserDetails()){
                    progressDialog.setMessage("Please wait.....Signing Up");
                    progressDialog.show();

                    //converting into a string and removing all wide spaces the user entered thus we using trim()
                    String user_email = useremail.getText().toString().trim();
                    String user_password = userpassword.getText().toString().trim();
                    final String  user_name=username.getText().toString().trim();


                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
//                                progressDialog.setMessage("Please wait.....Signing Up");
//                                progressDialog.show();
                                myDbClass.insertNameToDb(user_name);
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
        username = findViewById(R.id.etUserName);
        userpassword = findViewById(R.id.etUserPassword);
        useremail = findViewById(R.id.etUserEmail);
        signupBTN = findViewById(R.id.btnSignup);
        userlogin = findViewById(R.id.tvUserLogin);
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

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> ob = new HashMap<>();
        ob.put("name", name);
        db.collection("Users")
                .add(ob)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("d", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("f", "Error adding document", e);
                    }
                });

        return result;
    }

    public static String getName() {
        return username.getText().toString();

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
                        Toast.makeText(SignUpActivity.this, "Verification email has not sent!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }
}
