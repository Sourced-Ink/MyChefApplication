package com.example.mycheflogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mycheflogin.Model.DbAdapter;
import com.example.mycheflogin.Model.DbModelClass;
import com.example.mycheflogin.Model.RecyclerItemClickListener;
import com.example.mycheflogin.RecyclerPackage.MyDbClass;
import java.util.ArrayList;

public class SearchResult extends AppCompatActivity {
    MyDbClass dbClass;
    ArrayList<DbModelClass> objDbModelClassArrayList;
    RecyclerView recyclerView;
    View viewV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView=findViewById(R.id.dataLV);

        dbClass=new MyDbClass(this);
        objDbModelClassArrayList=new ArrayList<>();

        populateRecyclerView(viewV);
    }

    public void populateRecyclerView(View view){
        try {
            objDbModelClassArrayList=  dbClass.getAllData();
            DbAdapter dbAdapter = new DbAdapter(objDbModelClassArrayList);
            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(dbAdapter);
            recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                    Intent intentHome = new Intent(SearchResult.this, RecipeStepsActivity.class);
                    startActivity(intentHome);
                }

                @Override
                public void onItemLongClick(View view, int position) {

                }
            }) {
            });

            }
        catch (Exception e){
            Toast.makeText(SearchResult.this, "Show data: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        SearchActivity.progressDialog.dismiss();

    }


}