package com.example.mycheflogin;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycheflogin.Model.DbAdapter;

public class RecipeStepsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);


        TextView words = (TextView) findViewById(R.id.tvrecipesteps);

        words.setText(DbAdapter.steps());

//        StringBuilder stringBuilder = new StringBuilder();
//        String message = " WHAT IS MYCHEF? " + "\n\n" +
//                " Do you have only few ingredients at home and don't know what to make? " + "\n\n" +
//                " MyChef is a recipe search application that finds recipes you can make with ingredients you currently have at home. MyChef has over hundreds of recipes, so no matter what ingredients you have, MyChef has you covered. " + "\n\n" +
//                " For best results, make sure to tell the MyChef application about every ingredient you have at home. The more ingredients you add to MyChef, the better the recipes. " + "\n\n" +
//                " MyChef is also a good way of serving money. Taking full advantages of the ingredients you have, and naturally making you buy less groceries. " + "\n\n" +
//                " HOW DO I ADD MY INGREDIENTS? " + "\n" +
//                " To add your ingredients to MyChef you can either click search for the ingredients that you have or check for ingredients through the category section. " + "\n\n" +
//                " For best results, add all ingredients you have in your home. The more ingredients you tell the MyChef application you have, the better the recipes will be. " + "\n\n" +
//                " HOW DO I FAVOURITE A RECIPE? " + "\n" +
//                " First, sign up for an account, or sign in if you already have an account. To favourite a recipe, click the heart icon near any recipe. To unfavourite, simply click the (now red) heart icon again. " + "\n\n" +
//                " WHERE CAN I VIEW MY FAVOURITES RECIPES? " + "\n" +
//                " First, sign up for an account, or sign in if you already have an account. To view favourites click on the recipe book button which will bring up all recipes you liked. " + "\n\n" +
//                " WHAT ARE THE BENEFITS OF SIGNING UP FOR AN ACCOUNT? " + "\n" +
//                " If you sign up for an account allows you to have full access to the application, like adding favourites to your recipe book also saves recipes which you like and you can easily find them later.  " + "\n\n" +
//                " HOW CAN I CONTACT MYCHEF? " + "\n" +
//                " You can email us at: " + "\n" +
//                " chiko.mutandwa100@gmail.com " + "\n" +
//                " justpanagos@gmail.com " + "\n" +
//                " alex.davids1996@gmail.com " + "\n" +
//                " muttalibmoos@gmail.com " + "\n" +
//                " tylerassur@gmail.com " + "\n" +
//                " liampoole02@gmail.com " + "\n\n" +
//                " WHO CREATED MYCHEF? " + "\n" +
//                " MyChef was created by: " + "\n" +
//                " Chiko Mutandwa " + "\n" +
//                " Justin Panagos " + "\n" +
//                " Liam Poole " + "\n" +
//                " Muttalib Moos " + "\n" +
//                " Alexander Davids " + "\n" +
//                " Tyler Assur " + "\n\n" +
//                " v.1.0 ";
//
//        for (int i = 0; i < 1; i++){
//            stringBuilder.append(message);
//        }
//
//        words.setText(stringBuilder.toString());
    }

}
