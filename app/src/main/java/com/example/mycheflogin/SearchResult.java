package com.example.mycheflogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
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
//import com.example.mycheflogin.Model.RecyclerItemClickListener;
import com.example.mycheflogin.RecyclerPackage.MyDbClass;
import java.util.ArrayList;

public class SearchResult extends AppCompatActivity implements DbAdapter.OnClicking {
    public static final String STEPS="steps";

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
            if(objDbModelClassArrayList==null){

            }
            DbAdapter dbAdapter = new DbAdapter(objDbModelClassArrayList, this);
            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(dbAdapter);
            }
        catch (Exception e){
            Toast.makeText(SearchResult.this, "Show data: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        SearchActivity.progressDialog.dismiss();

    }

    @Override
    public void onItemClick(int position) {
        Log.d("Wah", "onItemClick: clicked");

        DbModelClass onClicking=objDbModelClassArrayList.get(position);

        Intent intent=new Intent(this, RecipeStepsActivity.class);
        intent.putExtra(STEPS, onClicking.getRecipeSteps());
        startActivity(intent);
    }
}