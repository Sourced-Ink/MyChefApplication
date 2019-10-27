package com.example.mycheflogin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mycheflogin.Model.DbAdapter;
//import static com.example.mycheflogin.SearchResult.IMAGE;
import static com.example.mycheflogin.SearchResult.STEPS;

public class RecipeStepsActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);

        textView = findViewById(R.id.recipeSteps);

        Intent intent=getIntent();
        String steps=intent.getStringExtra(STEPS);

        textView.setText(steps);
    }



}
