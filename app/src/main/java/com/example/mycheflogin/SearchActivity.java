package com.example.mycheflogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.List;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private IngredientAdapter adapter;
    private List<Ingredients> ingredientsList;
    DatabaseReference dbIngredients;
    DatabaseReference dbTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ingredientsList = new ArrayList<>();
        adapter = new IngredientAdapter(this, ingredientsList);
        recyclerView.setAdapter(adapter);



        dbIngredients = FirebaseDatabase.getInstance().getReference("Ingredients");
        dbIngredients.addListenerForSingleValueEvent(valueEventListener);
        recyclerView.bringToFront();
    }
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            ingredientsList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //String ingredientEx = snapshot.child("name").getValue().toString();
                    Ingredients ingredient = snapshot.getValue(Ingredients.class);
                    ingredientsList.add(ingredient);
                    //Log.d("myTag", ingredientEx);
                }
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };


}
