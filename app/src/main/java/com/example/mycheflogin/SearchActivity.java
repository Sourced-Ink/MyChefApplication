package com.example.mycheflogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.*;
import android.widget.MultiAutoCompleteTextView;

import com.example.mycheflogin.RecyclerPackage.MyDbClass;

public class SearchActivity extends AppCompatActivity {
    private MultiAutoCompleteTextView multiAutoCompleteTextViewIngre;
    private static AutoCompleteTextView autoCompleteTextViewCuis;
    private static Button showrecipesearch;
    public static ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        showrecipesearch = findViewById(R.id.btnShowRecipeSearch);
        multiAutoCompleteTextViewIngre = findViewById(R.id.multiAuto);
        autoCompleteTextViewCuis = findViewById(R.id.multiAuto2);
        progressDialog=new ProgressDialog(this);

        String[] ingredients = getResources().getStringArray(R.array.ingredients_array);
        multiAutoCompleteTextViewIngre = findViewById(R.id.multiAuto);
        ArrayAdapter<String> adapterIngre = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ingredients);
        multiAutoCompleteTextViewIngre.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteTextViewIngre.setAdapter(adapterIngre);
        multiAutoCompleteTextViewIngre.setThreshold(1);

        String[] cuisines = getResources().getStringArray(R.array.cuisines_array);
        autoCompleteTextViewCuis = findViewById(R.id.multiAuto2);
        ArrayAdapter<String> adapterCuis = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cuisines);
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

    }

    public static String getQueryStuff(){
        String mystring = autoCompleteTextViewCuis.getText().toString();
        return mystring;
    }


}
