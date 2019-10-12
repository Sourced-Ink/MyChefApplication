package com.example.mycheflogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchResult extends AppCompatActivity {
    List<String> searchResults=new ArrayList<>();
    Database database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        database=new Database(this);

        recipeResults();

    }


    public void recipeResults(){
        searchResults=database.getRecipeName();

    }
}
