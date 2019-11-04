package com.example.mycheflogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashSet;

public class CategoryActivity extends AppCompatActivity {
    private BottomNavigationView menuhome, menutophome;
    private Button choose_meat, choose_diary, choose_veg, choose_seafood, choose_fruits, choose_spice, choose_sauce, choose_desert, choose_baking, choose_fish,show_recipe;
    private TextView showIngrediants;

//    ArrayList<String> selection = new ArrayList<>();

    HashSet selection = new HashSet<>();

    //for meats
    String[] listMeatItems;
    boolean[] checkedMeatItems;
    ArrayList<Integer> userSelectedMeats = new ArrayList<>();

    //for diary
    String[] listDiaryItems;
    boolean[] checkedDiaryItems;
    ArrayList<Integer> userSelectedDiary = new ArrayList<>();

    //for vegtables
    String[] listVegItems;
    boolean[] checkedVegItems;
    ArrayList<Integer> userSelectedVeg = new ArrayList<>();

    //for seafood
    String[] listSeafoodItems;
    boolean[] checkedSeafoodItems;
    ArrayList<Integer> userSelectedSeafood = new ArrayList<>();

    //for spices
    String[] listSpiceItems;
    boolean[] checkedSpiceItems;
    ArrayList<Integer> userSelectedSpice = new ArrayList<>();

    //for sauce
    String[] listSauceItems;
    boolean[] checkedSauceItems;
    ArrayList<Integer> userSelectedSauce = new ArrayList<>();

    //for fruits
    String[] listFruitItems;
    boolean[] checkedFruitItems;
    ArrayList<Integer> userSelectedFruit = new ArrayList<>();

    //for desert
    String[] listDesertItems;
    boolean[] checkedDesertItems;
    ArrayList<Integer> userSelectedDesert = new ArrayList<>();

    //for baking
    String[] listBakingItems;
    boolean[] checkedBakingItems;
    ArrayList<Integer> userSelectedBaking = new ArrayList<>();

    //for fish
    String[] listFishItems;
    boolean[] checkedFishItems;
    ArrayList<Integer> userSelectedFish = new ArrayList<>();

//    public void ShowSelected(){
//        String finalSelection = "";
//        for (Object selections: selection) {
//            finalSelection = finalSelection + selections;
//        }
//        showIngrediants.setText(showIngrediants.getText() + finalSelection);
//        selection.clear();
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        choose_meat = findViewById(R.id.btnChooseMeat);
        choose_diary = findViewById(R.id.btnChooseDairy);
        choose_veg = findViewById(R.id.btnChooseVeg);
        choose_seafood = findViewById(R.id.btnChooseSeafood);
        choose_fruits = findViewById(R.id.btnChooseFruits);
        choose_spice = findViewById(R.id.btnChooseSpices);
        choose_sauce = findViewById(R.id.btnChooseSauces3);
        choose_desert = findViewById(R.id.btnChooseDesert);
        choose_baking = findViewById(R.id.btnChooseBaking);
        choose_fish = findViewById(R.id.btnChooseFish);
        show_recipe = findViewById(R.id.btnShowRecipeCat);
        showIngrediants = findViewById(R.id.tvShowingIndgrediants);
        menuhome = findViewById(R.id.menu_Pers);
        menutophome = findViewById(R.id.topNav);



        //Passing the values of the array and checking how many checkboxes needed thus passing the listMeatItems.length
        listMeatItems = getResources().getStringArray(R.array.type_of_meats);
        checkedMeatItems = new boolean[listMeatItems.length];

        //for diary
        listDiaryItems = getResources().getStringArray(R.array.type_of_diary);
        checkedDiaryItems = new boolean[listDiaryItems.length];

        //for vegetables
        listVegItems = getResources().getStringArray(R.array.type_of_veg);
        checkedVegItems = new boolean[listVegItems.length];

        //for seafood
        listSeafoodItems = getResources().getStringArray(R.array.type_of_seafood);
        checkedSeafoodItems = new boolean[listSeafoodItems.length];

        //for spice
        listSpiceItems = getResources().getStringArray(R.array.type_of_spice);
        checkedSpiceItems = new boolean[listSpiceItems.length];

        //for sauce
        listSauceItems = getResources().getStringArray(R.array.type_of_sauce);
        checkedSauceItems = new boolean[listSauceItems.length];

        //for fruits
        listFruitItems = getResources().getStringArray(R.array.type_of_fruits);
        checkedFruitItems = new boolean[listFruitItems.length];

        //for desert
        listDesertItems = getResources().getStringArray(R.array.type_of_desert);
        checkedDesertItems = new boolean[listDesertItems.length];

        //for baking
        listBakingItems = getResources().getStringArray(R.array.type_of_baking);
        checkedBakingItems = new boolean[listBakingItems.length];

        //for fish
        listFishItems = getResources().getStringArray(R.array.type_of_fish);
        checkedFishItems = new boolean[listFishItems.length];


        //the meat section
        choose_meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CategoryActivity.this);
                mBuilder.setTitle(getString(R.string.meat_title));
                mBuilder.setMultiChoiceItems(listMeatItems, checkedMeatItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        //checking if the item is checked
                        if (isChecked){
                            //and if item is not part of the list add it to the list this also helps us so that we don't duplicate the data
                            if (!userSelectedMeats.contains(position)){
                                userSelectedMeats.add(position);
                            }else {
                                userSelectedMeats.remove(position);
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
                        for (int i = 0; i < userSelectedMeats.size(); i++){
                            //we first loop through the array list then add the original array with all meats and pass in the arraylist with what the user has selected
                            item = item + listMeatItems[userSelectedMeats.get(i)];

                            //Basically we saying if the index inside the arraylist is not the last item
                            if (i != userSelectedMeats.size() - 1){
                                item = item + ", ";
                                selection.add(item);
                            }
                        }

                       showIngrediants.setText(showIngrediants.getText() + item + ", ");

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
                        for (int i = 0; i < checkedMeatItems.length; i++){
                            checkedMeatItems[i] = false;
                            userSelectedMeats.clear();
                            showIngrediants.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        //the diary section
        choose_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CategoryActivity.this);
                mBuilder.setTitle(getString(R.string.diary_lable));
                mBuilder.setMultiChoiceItems(listDiaryItems, checkedDiaryItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        //checking if the item is checked
                        if (isChecked){
                            //and if item is not part of the list add it to the list this also helps us so that we don't duplicate the data
                            if (!userSelectedDiary.contains(position)){
                                userSelectedDiary.add(position);
                            }else {
                                userSelectedDiary.remove(position);
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
                        for (int i = 0; i < userSelectedDiary.size(); i++){
                            //we first loop through the array list then add the original array with all diarys and pass in the arraylist with what the user has selected
                            item = item + listDiaryItems[userSelectedDiary.get(i)];

                            //Basically we saying if the index inside the arraylist is not the last item
                            if (i != userSelectedDiary.size() - 1){
                                item = item + ", ";
                                selection.add(item);
                            }
                        }
                        showIngrediants.setText(showIngrediants.getText() + item + ", ");

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
                        for (int i = 0; i < checkedDiaryItems.length; i++){
                            checkedDiaryItems[i] = false;
                            userSelectedDiary.clear();
                            showIngrediants.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });


        //the vegtable section
        choose_veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CategoryActivity.this);
                mBuilder.setTitle(getString(R.string.vegtable_title));
                mBuilder.setMultiChoiceItems(listVegItems, checkedVegItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        //checking if the item is checked
                        if (isChecked){
                            //and if item is not part of the list add it to the list this also helps us so that we don't duplicate the data
                            if (!userSelectedVeg.contains(position)){
                                userSelectedVeg.add(position);
                            }else {
                                userSelectedVeg.remove(position);
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
                        for (int i = 0; i < userSelectedVeg.size(); i++){
                            //we first loop through the array list then add the original array with all diarys and pass in the arraylist with what the user has selected
                            item = item + listVegItems[userSelectedVeg.get(i)];

                            //Basically we saying if the index inside the arraylist is not the last item
                            if (i != userSelectedVeg.size() - 1){

                                item = item + ", ";
                                selection.add(item);
                            }
                        }
                        showIngrediants.setText(showIngrediants.getText() + item + ", ");
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
                        for (int i = 0; i < checkedVegItems.length; i++){
                            checkedVegItems[i] = false;
                            userSelectedVeg.clear();
                            showIngrediants.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });


        //seafood section
        choose_seafood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CategoryActivity.this);
                mBuilder.setTitle(getString(R.string.seafood_title));
                mBuilder.setMultiChoiceItems(listSeafoodItems, checkedSeafoodItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        //checking if the item is checked
                        if (isChecked){
                            //and if item is not part of the list add it to the list this also helps us so that we don't duplicate the data
                            if (!userSelectedSeafood.contains(position)){
                                userSelectedSeafood.add(position);
                            }else {
                                userSelectedSeafood.remove(position);
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
                        for (int i = 0; i < userSelectedSeafood.size(); i++){
                            //we first loop through the array list then add the original array with all diarys and pass in the arraylist with what the user has selected
                            item = item + listSeafoodItems[userSelectedSeafood.get(i)];

                            //Basically we saying if the index inside the arraylist is not the last item
                            if (i != userSelectedSeafood.size() - 1){
                                item = item + ", ";
                                selection.add(item);
                            }
                        }
                        showIngrediants.setText(showIngrediants.getText() + item + ", ");
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
                        for (int i = 0; i < checkedSeafoodItems.length; i++){
                            checkedSeafoodItems[i] = false;
                            userSelectedSeafood.clear();
                            showIngrediants.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });


        //spice section
        choose_spice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CategoryActivity.this);
                mBuilder.setTitle(getString(R.string.spice_title));
                mBuilder.setMultiChoiceItems(listSpiceItems, checkedSpiceItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        //checking if the item is checked
                        if (isChecked){
                            //and if item is not part of the list add it to the list this also helps us so that we don't duplicate the data
                            if (!userSelectedSpice.contains(position)){
                                userSelectedSpice.add(position);
                            }else {
                                userSelectedSpice.remove(position);
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
                        for (int i = 0; i < userSelectedSpice.size(); i++){
                            //we first loop through the array list then add the original array with all diarys and pass in the arraylist with what the user has selected
                            item = item + listSpiceItems[userSelectedSpice.get(i)];

                            //Basically we saying if the index inside the arraylist is not the last item
                            if (i != userSelectedSpice.size() - 1){
                                //selection.add(item);
                                item = item + ", ";
                                selection.add(item);
                            }
                        }
                        showIngrediants.setText(showIngrediants.getText() + item + ", ");
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
                        for (int i = 0; i < checkedSpiceItems.length; i++){
                            checkedSpiceItems[i] = false;
                            userSelectedSpice.clear();
                            showIngrediants.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });



        //sauce section
        choose_sauce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CategoryActivity.this);
                mBuilder.setTitle(getString(R.string.sauce_title));
                mBuilder.setMultiChoiceItems(listSauceItems, checkedSauceItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        //checking if the item is checked
                        if (isChecked){
                            //and if item is not part of the list add it to the list this also helps us so that we don't duplicate the data
                            if (!userSelectedSauce.contains(position)){
                                userSelectedSauce.add(position);
                            }else {
                                userSelectedSauce.remove(position);
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
                        for (int i = 0; i < userSelectedSauce.size(); i++){
                            //we first loop through the array list then add the original array with all diarys and pass in the arraylist with what the user has selected
                            item = item + listSauceItems[userSelectedSauce.get(i)];

                            //Basically we saying if the index inside the arraylist is not the last item
                            if (i != userSelectedSauce.size() - 1){
                                item = item + ", ";
                                selection.add(item);
                            }
                        }
                        showIngrediants.setText(showIngrediants.getText() + item + ", ");
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
                        for (int i = 0; i < checkedSauceItems.length; i++){
                            checkedSauceItems[i] = false;
                            userSelectedSauce.clear();
                            showIngrediants.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });


        //fruits section
        choose_fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CategoryActivity.this);
                mBuilder.setTitle(getString(R.string.fruit_title));
                mBuilder.setMultiChoiceItems(listFruitItems, checkedFruitItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        //checking if the item is checked
                        if (isChecked){
                            //and if item is not part of the list add it to the list this also helps us so that we don't duplicate the data
                            if (!userSelectedFruit.contains(position)){
                                userSelectedFruit.add(position);
                            }else {
                                userSelectedFruit.remove(position);
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
                        for (int i = 0; i < userSelectedFruit.size(); i++){
                            //we first loop through the array list then add the original array with all diarys and pass in the arraylist with what the user has selected
                            item = item + listFruitItems[userSelectedFruit.get(i)];

                            //Basically we saying if the index inside the arraylist is not the last item
                            if (i != userSelectedFruit.size() - 1){
                                //selection.add(item);
                                item = item + ", ";
                                selection.add(item);
                            }
                        }
                        showIngrediants.setText(showIngrediants.getText() + item + ", ");
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
                        for (int i = 0; i < checkedFruitItems.length; i++){
                            checkedFruitItems[i] = false;
                            userSelectedFruit.clear();
                            showIngrediants.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });


        //desert section
        choose_desert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CategoryActivity.this);
                mBuilder.setTitle(getString(R.string.desert_title));
                mBuilder.setMultiChoiceItems(listDesertItems, checkedDesertItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        //checking if the item is checked
                        if (isChecked){
                            //and if item is not part of the list add it to the list this also helps us so that we don't duplicate the data
                            if (!userSelectedDesert.contains(position)){
                                userSelectedDesert.add(position);
                            }else {
                                userSelectedDesert.remove(position);
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
                        for (int i = 0; i < userSelectedDesert.size(); i++){
                            //we first loop through the array list then add the original array with all diarys and pass in the arraylist with what the user has selected
                            item = item + listDesertItems[userSelectedDesert.get(i)];

                            //Basically we saying if the index inside the arraylist is not the last item
                            if (i != userSelectedDesert.size() - 1){
                                item = item + ", ";
                                selection.add(item);
                            }
                        }
                        showIngrediants.setText(showIngrediants.getText() + item + ", ");
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
                        for (int i = 0; i < checkedDesertItems.length; i++){
                            checkedDesertItems[i] = false;
                            userSelectedDesert.clear();
                            showIngrediants.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });


        //baking section
        choose_baking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CategoryActivity.this);
                mBuilder.setTitle(getString(R.string.baking_title));
                mBuilder.setMultiChoiceItems(listBakingItems, checkedBakingItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        //checking if the item is checked
                        if (isChecked){
                            //and if item is not part of the list add it to the list this also helps us so that we don't duplicate the data
                            if (!userSelectedBaking.contains(position)){
                                userSelectedBaking.add(position);
                            }else {
                                userSelectedBaking.remove(position);
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
                        for (int i = 0; i < userSelectedBaking.size(); i++){
                            //we first loop through the array list then add the original array with all diarys and pass in the arraylist with what the user has selected
                            item = item + listBakingItems[userSelectedBaking.get(i)];

                            //Basically we saying if the index inside the arraylist is not the last item
                            if (i != userSelectedBaking.size() - 1){
                                item = item + ", ";
                                selection.add(item);
                            }
                        }
                        showIngrediants.setText(showIngrediants.getText() + item + ", ");
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
                        for (int i = 0; i < checkedBakingItems.length; i++){
                            checkedBakingItems[i] = false;
                            userSelectedBaking.clear();
                            showIngrediants.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });


        //fish section
        choose_fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CategoryActivity.this);
                mBuilder.setTitle(getString(R.string.fish_title));
                mBuilder.setMultiChoiceItems(listFishItems, checkedFishItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        //checking if the item is checked
                        if (isChecked){
                            //and if item is not part of the list add it to the list this also helps us so that we don't duplicate the data
                            if (!userSelectedFish.contains(position)){
                                userSelectedFish.add(position);
                            }else {
                                userSelectedFish.remove(position);
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
                        for (int i = 0; i < userSelectedFish.size(); i++){
                            //we first loop through the array list then add the original array with all diarys and pass in the arraylist with what the user has selected
                            item = item + listFishItems[userSelectedFish.get(i)];

                            //Basically we saying if the index inside the arraylist is not the last item
                            if (i != userSelectedFish.size() - 1){
                                item = item + ", ";
                                selection.add(item);
                            }
                        }
                        showIngrediants.setText(showIngrediants.getText() + item + ", ");
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
                        for (int i = 0; i < checkedFishItems.length; i++){
                            checkedFishItems[i] = false;
                            userSelectedFish.clear();
                            showIngrediants.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });


        //Show recipes
        show_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CategoryActivity.this, ShowRecipesActivity.class);
                startActivity(intent);

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
                                Intent intent = new Intent(CategoryActivity.this, HelpActivity.class);
                                startActivity(intent);
                                return true;
                            }
                        });
                        break;
                    case R.id.searchtop:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent(CategoryActivity.this, SearchActivity.class);
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
                                        Intent intent = new Intent(CategoryActivity.this, HomeActivity.class);

                                        return true;
                                    }
                                });
                                break;

                            case R.id.accountItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(CategoryActivity.this, PersonalActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.recipeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(CategoryActivity.this, FavouritesActivity.class);
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
    }
}
