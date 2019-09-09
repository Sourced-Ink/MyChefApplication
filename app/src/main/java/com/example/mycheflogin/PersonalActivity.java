package com.example.mycheflogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class PersonalActivity extends AppCompatActivity {

    private TextView changepassword, diet, logout;      private BottomNavigationView menuP;
    private FirebaseAuth firebaseAuth;

    String[] listDietItems;
    boolean[] checkedDietItems;
    ArrayList<Integer> userSelectedDiet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        changepassword =  findViewById(R.id.tvChangePassword);
        diet =  findViewById(R.id.tvDiet);
        logout =  findViewById(R.id.tvLogOut);
        menuP = findViewById(R.id.menu_Pers);
        firebaseAuth = FirebaseAuth.getInstance();

        listDietItems = getResources().getStringArray(R.array.type_of_diet);
        checkedDietItems = new boolean[listDietItems.length];

        changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonalActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        //user logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 firebaseAuth.signOut();
                 finish();
                 Intent intent = new Intent(PersonalActivity.this, MainActivity.class);
                 startActivity(intent);

            }
        });

        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(PersonalActivity.this);
                mBuilder.setTitle(getString(R.string.diet_title));
                mBuilder.setMultiChoiceItems(listDietItems, checkedDietItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        //checking if the item is checked
                        if (isChecked){
                            //and if item is not part of the list add it to the list this also helps us so that we don't duplicate the data
                            if (!userSelectedDiet.contains(position)){
                                userSelectedDiet.add(position);
                            }else {
                                userSelectedDiet.remove(position);
                            }
                        }
                    }
                });


                mBuilder.setCancelable(false);
                //making an OK button inside the box
                mBuilder.setPositiveButton(getString(R.string.ok_lable), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < userSelectedDiet.size(); i++){
                            //we first loop through the array list then add the original array with all diarys and pass in the arraylist with what the user has selected
                            item = item + listDietItems[userSelectedDiet.get(i)];

                            //Basically we saying if the index inside the arraylist is not the last item
                            if (i != userSelectedDiet.size() - 1){
                                item = item + ", ";
                            }
                        }

                        //items_in_meat.setText(item);
                    }
                });


                //making a dismiss button inside the box
                mBuilder.setNegativeButton(getString(R.string.dismiss_title), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });


                //making a clearAll button to clear all check boxes
                mBuilder.setNeutralButton(getString(R.string.clearall_title), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        //looping through all the checked items and clearing them by equaling them to false
                        for (int i = 0; i < checkedDietItems.length; i++){
                            checkedDietItems[i] = false;
                            userSelectedDiet.clear();
                            //items_in_meat.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });


        /*menuP.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.homeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(PersonalActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.accountItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(PersonalActivity.this, PersonalActivity.class);

                                        return false;
                                    }
                                });
                                break;

                            case R.id.recipeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(PersonalActivity.this, FavouritesActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.helpItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(PersonalActivity.this, HelpActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;
                        }
                        return true;
                    }
                }
        );

        */
    }
}
