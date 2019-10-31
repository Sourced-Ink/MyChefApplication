package com.example.mycheflogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.*;
import android.widget.MultiAutoCompleteTextView;

import com.example.mycheflogin.RecyclerPackage.MyDbClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity {
    private static AutoCompleteTextView multiAutoCompleteTextViewIngre;
    private static AutoCompleteTextView autoCompleteTextViewCuis;
    private static Button showrecipesearch;
    public static ProgressDialog progressDialog;
    private BottomNavigationView menuhome, menutophome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        menuhome = (BottomNavigationView) findViewById(R.id.menu_Pers);
        menutophome = (BottomNavigationView) findViewById(R.id.topNav);

        showrecipesearch = findViewById(R.id.btnShowRecipeSearch);
        multiAutoCompleteTextViewIngre = findViewById(R.id.multiAuto);
        autoCompleteTextViewCuis = findViewById(R.id.multiAuto2);
        progressDialog=new ProgressDialog(this);

        String[] ingredients = getResources().getStringArray(R.array.ingredients_array);
        multiAutoCompleteTextViewIngre = findViewById(R.id.multiAuto);
        ArrayAdapter<String> adapterIngre = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ingredients);
//        multiAutoCompleteTextViewIngre.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteTextViewIngre.setAdapter(adapterIngre);
        multiAutoCompleteTextViewIngre.setThreshold(0);

        String[] cuisines = getResources().getStringArray(R.array.cuisines_array);
        autoCompleteTextViewCuis = findViewById(R.id.multiAuto2);
        ArrayAdapter<String> adapterCuis = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cuisines);
        autoCompleteTextViewCuis.setThreshold(0);
        autoCompleteTextViewCuis.setAdapter(adapterCuis);

        showrecipesearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Searching for Recipes, Please Wait!");
                progressDialog.show();
                Intent intentHome = new Intent(SearchActivity.this, SearchResult.class);
                startActivity(intentHome);
            }
        });

        menutophome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.helpItem:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent(SearchActivity.this, HelpActivity.class);
                                startActivity(intent);
                                return true;
                            }
                        });
                        break;
                    case R.id.searchtop:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent(SearchActivity.this, SearchActivity.class);

                                return false;
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
                                        Intent intent = new Intent(SearchActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.accountItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(SearchActivity.this, PersonalActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.recipeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(SearchActivity.this, FavouritesActivity.class);
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

    }

    public static String getQueryStuff(){
        String mystring = autoCompleteTextViewCuis.getText().toString().trim();
        return mystring;
    }

    public static String getQueryIngredient(){
        String s=multiAutoCompleteTextViewIngre.getText().toString().trim();
        return s;
    }


}
