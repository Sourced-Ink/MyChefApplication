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
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {

    private EditText etuseremail, username;
    private Button cancelF, searchF;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        etuseremail = findViewById(R.id.FPEmailInput);
        username = findViewById(R.id.FPUsernameInput);
        cancelF = findViewById(R.id.FPcnacel);
        searchF = findViewById(R.id.FPgetPassword);
        firebaseAuth = FirebaseAuth.getInstance();

        searchF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_email = etuseremail.getText().toString().trim();
                if (user_email.equals("")){
                    Toast.makeText(ForgetPasswordActivity.this, "Please enter your registered email ID", Toast.LENGTH_SHORT).show();
                }else{
                    firebaseAuth.sendPasswordResetEmail(user_email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ForgetPasswordActivity.this, "Password reset email sent!", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ForgetPasswordActivity.this, MainActivity.class));
                            }else{
                                Toast.makeText(ForgetPasswordActivity.this, "Error in sending password reset email", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        cancelF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPasswordActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
