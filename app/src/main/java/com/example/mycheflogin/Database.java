package com.example.mycheflogin;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.example.mycheflogin.Recipes;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "MyChefDb.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //function to get all recipes
    public List<Recipes> getRecipe(){

        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
        String []sqlSelect={"recipeName"};
        String tableName="Recipes";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db,sqlSelect,null,null,null,null,null);
        List<Recipes> result=new ArrayList<>();

        if(cursor.moveToFirst()){
            do{
                Recipes recipes=new Recipes();
                recipes.setRecipeName(cursor.getString(cursor.getColumnIndex("recipeName")));

                result.add(recipes);
            }while(cursor.moveToNext());

        }
        return result;
    }

    public List<String> getRecipeName(){

        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
        String [] sqlSelect={"recipeName"};
        String tableName="Recipes";

        qb.setTables(tableName);
        Cursor cursor=qb.query(db,sqlSelect,null,null,null,null,null);
        List<String> result=new ArrayList<>();

        if(cursor.moveToFirst()){
            do{
                result.add(cursor.getString(cursor.getColumnIndex("recipeName")));
            }while(cursor.moveToNext());
        }
        return result;
    }
}
