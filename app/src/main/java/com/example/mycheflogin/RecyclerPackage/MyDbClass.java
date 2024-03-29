package com.example.mycheflogin.RecyclerPackage;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.example.mycheflogin.MainActivity;
import com.example.mycheflogin.Model.DbModelClass;
import com.example.mycheflogin.PersonalActivity;
import com.example.mycheflogin.SearchActivity;
import com.example.mycheflogin.SignUpActivity;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import java.util.ArrayList;

public class MyDbClass extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "MyChefDb.db";
    private static final int DATABASE_VERSION = 1;

    Context context;

    public MyDbClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public ArrayList<DbModelClass> getAllData() {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            ArrayList<DbModelClass> objModelClassArrayList = new ArrayList<>();

            if (db != null) {

                String myString=new String();

                for(int x=0; x<SearchActivity.getQueryIngredients().size();x++){
                    myString=myString+"'"+SearchActivity.getQueryIngredients().get(x).toString()+"'";
                    if(x<SearchActivity.getQueryIngredients().size()-1){
                        myString=myString+",";
                    }
                }

                System.out.println(myString);

                Cursor objCursor;

                if(SearchActivity.getQueryCuisine().isEmpty()){
                    objCursor=db.rawQuery("select distinct  a.recipeName, a.recipePicture, a.recipeSteps from (select r.recipeName, r.recipePicture, r.recipeSteps, count(*) as ing_available FROM recipe r inner join recipe_has_ingredient i on i.recipe_recipeName=r.recipeName where i.ingredient_ingredientName"

                            +" IN ("+myString+")"

                            +"group by r.recipeName, r.recipePicture, r.recipeSteps) as a JOIN(select r.recipeName, r.recipePicture, r.recipeSteps, count(*) as ing_required from recipe r inner join recipe_has_ingredient i on i.recipe_recipeName=recipeName group by r.recipeName, r.recipePicture, r.recipeSteps)as p on p.ing_required=a.ing_available ", null);

                }else if(SearchActivity.getQueryIngredients().isEmpty()) {

                    objCursor=db.rawQuery("select * from recipe where recipeCuisine = '"+SearchActivity.getQueryCuisine()+" '", null);

                }else{
                    objCursor = db.rawQuery("select distinct  a.recipeName, a.recipePicture, a.recipeSteps from (select r.recipeName, r.recipePicture, r.recipeSteps, count(*) as ing_available FROM recipe r inner join recipe_has_ingredient i on i.recipe_recipeName=r.recipeName where i.ingredient_ingredientName"

                            + " IN (" + myString + ")"

                            + "and recipeCuisine='" + SearchActivity.getQueryCuisine() + "' group by r.recipeName, r.recipePicture, r.recipeSteps) as a JOIN(select r.recipeName, r.recipePicture, r.recipeSteps, count(*) as ing_required from recipe r inner join recipe_has_ingredient i on i.recipe_recipeName=recipeName group by r.recipeName, r.recipePicture, r.recipeSteps)as p on p.ing_required=a.ing_available ", null);

                }

                if (objCursor.getCount() != 0) {

                    while (objCursor.moveToNext()) {
                        String imageDes = objCursor.getString(0);
                        byte[] imageByte = objCursor.getBlob(1);
                        String recipeSteps=objCursor.getString(2);

                        Bitmap ourImage = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);

                        objModelClassArrayList.add(
                                new DbModelClass(imageDes, ourImage, recipeSteps)
                        );
                    }

                    return objModelClassArrayList;

                } else {

                    Toast.makeText(context, "No results found...", Toast.LENGTH_SHORT).show();
                    return null;
                }
            } else {
                Toast.makeText(context, "Database is null...", Toast.LENGTH_SHORT).show();
                return null;
            }
        } catch (Exception e) {
            Toast.makeText(context, "getAllData..." + e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }

    }



}