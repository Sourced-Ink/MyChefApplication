package com.example.mycheflogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.*;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
private MultiAutoCompleteTextView multiAutoCompleteTextViewIngre, multiAutoCompleteTextViewCuis;
private Button showrecipesearch;
Context context=this;
//Database database;
//DatabaseHelper databaseHelper;
SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 //       setContentView(R.layout.activity);

 //       showrecipesearch=findViewById(R.id.btnShowRecipeSearch);
 //       multiAutoCompleteTextViewIngre=findViewById(R.id.multiAuto);
 //       multiAutoCompleteTextViewCuis=findViewById(R.id.multiAuto2);

        String[] ingredients=getResources().getStringArray(R.array.ingredients_array);
   //     multiAutoCompleteTextViewIngre=findViewById(R.id.multiAuto);
        ArrayAdapter<String> adapterIngre=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,ingredients);
        multiAutoCompleteTextViewIngre.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteTextViewIngre.setAdapter(adapterIngre);
        multiAutoCompleteTextViewIngre.setThreshold(1);

        String [] cuisines=getResources().getStringArray(R.array.cuisines_array);
     //   multiAutoCompleteTextViewCuis=findViewById(R.id.multiAuto2);
        ArrayAdapter<String> adapterCuis=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,cuisines);
        multiAutoCompleteTextViewCuis.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteTextViewCuis.setAdapter(adapterCuis);
        multiAutoCompleteTextViewCuis.setThreshold(1);

        showrecipesearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(v);
            }
        });

    }


    public void add(View view){
        String name=multiAutoCompleteTextViewIngre.getText().toString();
   //     databaseHelper =new DatabaseHelper(context);
   //     sqLiteDatabase=databaseHelper.getWritableDatabase();
   //     databaseHelper.addInformation(name,sqLiteDatabase);
   //     Toast.makeText(getBaseContext(),"Data saved", Toast.LENGTH_LONG).show();
   //     databaseHelper.close();
    }

//    public void showInput(View view){
//        String input=editText.getText().toString();
//        Toast.makeText(this,input, Toast.LENGTH_SHORT).show();
//    }
//

}
