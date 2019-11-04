package com.example.mycheflogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class CuisineActivity extends AppCompatActivity {

    private BottomNavigationView menuhome, menutophome;
    private ImageButton carribeanbuttton;
    private ImageButton chinesebutton;
    private ImageButton frenchbutton,ItalainaButton, indianButton, medButton, germanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuisine);

        menuhome = (BottomNavigationView) findViewById(R.id.menu_Pers);
        menutophome = (BottomNavigationView) findViewById(R.id.topNav);

        carribeanbuttton = (ImageButton) findViewById(R.id.carribeanbutton);
        chinesebutton = (ImageButton) findViewById(R.id.chinesebutton);
        frenchbutton = (ImageButton) findViewById(R.id.frenchbutton);
        ItalainaButton = (ImageButton) findViewById(R.id.italianButton);

        medButton = (ImageButton) findViewById(R.id.medButton);
        germanButton = (ImageButton) findViewById(R.id.germanButton);
        indianButton = (ImageButton) findViewById(R.id.indianButton) ;

        carribeanbuttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view10)
            {
                opencarribeanbutton();
            }
        });
        chinesebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view10)
            {
                Intent intent = new Intent(CuisineActivity.this,chineseactivity.class);
                startActivity(intent);            }
        });
        frenchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view10)
            {
                opench();
            }
        });
        ItalainaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view10)
            {
                Intent intent = new Intent(CuisineActivity.this,italianactivity.class);
                startActivity(intent);
            }
        });
        germanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view10)
            {
                Intent intent = new Intent(CuisineActivity.this,germanactivity.class);
                startActivity(intent);
            }
        });
        indianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view10)
            {
                Intent intent = new Intent(CuisineActivity.this,indianactivity.class);
                startActivity(intent);
            }
        });
        medButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view10)
            {
                Intent intent = new Intent(CuisineActivity.this,medactivity.class);
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
                                Intent intent = new Intent(CuisineActivity.this, HelpActivity.class);
                                startActivity(intent);
                                return true;
                            }
                        });
                        break;
                    case R.id.searchtop:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent(CuisineActivity.this, SearchActivity.class);
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
                                        Intent intent = new Intent(CuisineActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        return false;
                                    }
                                });
                                break;

                            case R.id.accountItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(CuisineActivity.this, PersonalActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.recipeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(CuisineActivity.this, FavouritesActivity.class);
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

    // caribian
    public void opencarribeanbutton()
    {
        Intent intent10 = new Intent(this,carribeanactivity.class);
        startActivity(intent10);
    }
    //french
    public void opench()
    {
        Intent intent10 = new Intent(this,frenchactivity.class);
        startActivity(intent10);
    }
    //chinise
//    public void openchinise()
//    {
////        Intent intent10 = new Intent(this,chineseactivity.class);
////        startActivity(intent10);
//    }
    //german
    public void opengerman()
    {
        Intent intent10 = new Intent(this,germanactivity.class);
        startActivity(intent10);
    }
    //indian
    public void openIndian()
    {
        Intent intent10 = new Intent(this,indianactivity.class);
        startActivity(intent10);
    }
    //italian
    public void openitlaina()
    {
        Intent intent10 = new Intent(this,italianactivity.class);
        startActivity(intent10);
    }
    // medatarianin
    public void openMed()
    {
        Intent intent10 = new Intent(this,medactivity.class);
        startActivity(intent10);
    }

}
