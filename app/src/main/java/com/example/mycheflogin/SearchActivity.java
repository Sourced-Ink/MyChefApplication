package com.example.mycheflogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.*;
import android.widget.MultiAutoCompleteTextView;

public class SearchActivity extends AppCompatActivity {
    private MultiAutoCompleteTextView multiAutoCompleteTextViewIngre;
    private AutoCompleteTextView autoCompleteTextViewCuis;
    private Button showrecipesearch;
    private String mystring;

//    public SearchActivity(String mystring){
//        this.mystring=mystring;
//        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        showrecipesearch = findViewById(R.id.btnShowRecipeSearch);
        multiAutoCompleteTextViewIngre = findViewById(R.id.multiAuto);
        autoCompleteTextViewCuis = findViewById(R.id.multiAuto2);

        String[] ingredients = getResources().getStringArray(R.array.ingredients_array);
        multiAutoCompleteTextViewIngre = findViewById(R.id.multiAuto);
        ArrayAdapter<String> adapterIngre = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ingredients);
        multiAutoCompleteTextViewIngre.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteTextViewIngre.setAdapter(adapterIngre);
        multiAutoCompleteTextViewIngre.setThreshold(1);

        String[] cuisines = getResources().getStringArray(R.array.cuisines_array);
        autoCompleteTextViewCuis = findViewById(R.id.multiAuto2);
        ArrayAdapter<String> adapterCuis = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cuisines);
//        AutoCompleteTextViewCuis.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        autoCompleteTextViewCuis.setAdapter(adapterCuis);
//        multiAutoCompleteTextViewCuis.setThreshold(1);

        showrecipesearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast();
                Intent intentHome = new Intent(SearchActivity.this, SearchResult.class);
                startActivity(intentHome);
            }
        });

    }
    public String getQueryStuff (){
        String mystring = autoCompleteTextViewCuis.getText().toString();
        Toast.makeText(this, mystring, Toast.LENGTH_SHORT).show();
        return mystring;
    }

    public void toast(){
        String mystring = autoCompleteTextViewCuis.getText().toString();
        String arr[] = mystring.split(",", 2);
        String firstWord = arr[0];
        Toast.makeText(this, firstWord, Toast.LENGTH_SHORT).show();
    }


}
