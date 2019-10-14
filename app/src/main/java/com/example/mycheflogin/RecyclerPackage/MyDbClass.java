package com.example.mycheflogin.RecyclerPackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;
import com.example.mycheflogin.Model.DbModelClass;
import com.example.mycheflogin.SearchActivity;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import java.util.ArrayList;

public class MyDbClass extends SQLiteAssetHelper {

    SearchActivity searchActivity=new SearchActivity();
    private static final String DATABASE_NAME = "MyChefDb.db";
    private static final int DATABASE_VERSION = 1;

    Context context;

    public MyDbClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }


    public ArrayList getAllData( ) {
        try
        {
            SQLiteDatabase db=this.getReadableDatabase();
            ArrayList<DbModelClass> objModelClassArrayList = new ArrayList<>();
            if (db != null)
            {
                Cursor objCursor = db.rawQuery("select * from Recipes where recipeCuisine = 'chinese'",null);
                if (objCursor.getCount() != 0)
                {
                    while (objCursor.moveToNext()) {
                        String imageDes = objCursor.getString(0);
//                        byte[] imageByte = objCursor.getBlob(1);
//                        Bitmap ourImage = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);
                        objModelClassArrayList.add(
                                new DbModelClass(
                                        imageDes/*, ourImage*/
                                )
                        );
                    }
                        return objModelClassArrayList;
                }
                else
                    {
                Toast.makeText(context, "No data retrieved...", Toast.LENGTH_SHORT).show();
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