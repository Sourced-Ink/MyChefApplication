package com.example.mycheflogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.errorprone.annotations.Var;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText oldPass,newPass,confirmedPass;
    private Button passwordChange;
    //private FirebaseAuth firebaseAuth;
    private BottomNavigationView menuhome, menutophome;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        passwordChange = findViewById(R.id.btnChangePassword);
        oldPass = findViewById(R.id.etOldPassword);
        newPass = findViewById(R.id.etNewPassword);
        confirmedPass = findViewById(R.id.etConfrimNewPassword);
        menuhome = (BottomNavigationView) findViewById(R.id.menu_Pers);
        menutophome = (BottomNavigationView) findViewById(R.id.topNav);

        auth = FirebaseAuth.getInstance();

        menutophome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.helpItem:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent(ChangePasswordActivity.this, HelpActivity.class);
                                startActivity(intent);
                                return true;
                            }
                        });
                        break;
                    case R.id.searchtop:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent(ChangePasswordActivity.this, SearchActivity.class);
                                startActivity(intent);
                                return true;
                            }
                        });
                        break;
                }

                return true;
            }
        });

        menuhome.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.homeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(ChangePasswordActivity.this, HomeActivity.class);

                                        return true;
                                    }
                                });
                                break;

                            case R.id.accountItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(ChangePasswordActivity.this, PersonalActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.recipeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(ChangePasswordActivity.this, FavouritesActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

//                            case R.id.helpItem:
//                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                                    @Override
//                                    public boolean onMenuItemClick(MenuItem menuItem) {
//                                        Intent intent = new Intent(HomeActivity.this, HelpActivity.class);
//                                        startActivity(intent);
//                                        return true;
//                                    }
//                                });
//                                break;
                        }
                        return true;
                    }
                }
        );



        passwordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (oldPass.getText().toString().trim().length() > 0 && newPass.getText().toString().trim().length() > 0 && confirmedPass.getText().toString().trim().length() > 0) {

                    if (newPass.getText().toString().trim().length() < 8 && confirmedPass.getText().toString().trim().length() < 8) {
                        newPass.setError("Each field has to be 8 or more characters.");
                        confirmedPass.setError("Each field has to be 8 or more characters.");
                    }
                        if(newPass.getText().toString().equals(confirmedPass.getText().toString())){
                            FirebaseUser user = auth.getCurrentUser();

                        if(user != null && user.getEmail() != null){
                            AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(), oldPass.getText().toString());

                            // Prompt the user to re-provide their sign-in credentials
                            user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()) {
                                                FirebaseUser user = auth.getCurrentUser();
                                                Toast.makeText(ChangePasswordActivity.this,"Re-Authentication successful.", Toast.LENGTH_SHORT).show();
                                                user.updatePassword(newPass.getText().toString())
                                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful()) {
                                                                    Toast.makeText(ChangePasswordActivity.this,"Password changed successfully.", Toast.LENGTH_SHORT).show();
                                                                    auth.signOut();

                                                                    startActivity(new Intent(ChangePasswordActivity.this,MainActivity.class));
                                                                    finish();
                                                                }
                                                            }
                                                        });
                                            }else {
                                                Toast.makeText(ChangePasswordActivity.this, "Re-Authentication failed.", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });

                        }else {
                            startActivity(new Intent(ChangePasswordActivity.this, MainActivity.class));
                            finish();
                        }

                    }else {
                        Toast.makeText(ChangePasswordActivity.this, "Confirmed password doesn't match the new password.", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(ChangePasswordActivity.this, "Please make sure all of the fields are filled.", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }

}