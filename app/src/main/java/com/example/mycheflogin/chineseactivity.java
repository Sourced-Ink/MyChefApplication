package com.example.mycheflogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class chineseactivity extends AppCompatActivity
{
    private Button friedricebutton;
    private Button oystersaucebutton;
    private Button peppersteakbutton;
    private Button beefstirbutton;
    private Button kungpaobutton;
    private BottomNavigationView menuhome, menutophome;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chineseactivity);

        friedricebutton = (Button) findViewById(R.id.friedricebutton);
        friedricebutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openfriedriceactivity();
            }
        });

        oystersaucebutton = (Button) findViewById(R.id.oystersaucebutton);
        oystersaucebutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view6)
            {
                openoystersauceactivity();
            }
        });

        peppersteakbutton = (Button) findViewById(R.id.peppersteakbutton);
        peppersteakbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view7)
            {
                openpeppersteakactivity();
            }
        });

        beefstirbutton = (Button) findViewById(R.id.beefstirbutton);
        beefstirbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view8)
            {
                openbeefstiractivity();
            }
        });

        kungpaobutton = (Button) findViewById(R.id.kungpaobutton);
        kungpaobutton   .setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view9)
            {
                openkungpaoactivity();
            }
        });

        menuhome = (BottomNavigationView) findViewById(R.id.menu_Pers);
        menutophome = (BottomNavigationView) findViewById(R.id.topNav);

        menutophome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.helpItem:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent( chineseactivity.this, HelpActivity.class);
                                startActivity(intent);
                                return true;
                            }
                        });
                        break;
                    case R.id.searchtop:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent( chineseactivity.this, SearchActivity.class);
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
                                        Intent intent = new Intent( chineseactivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.accountItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent( chineseactivity.this, PersonalActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.recipeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent( chineseactivity.this, FavouritesActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

//                            case R.id.helpItem:
//                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                                    @Override
//                                    public boolean onMenuItemClick(MenuItem menuItem) {
//                                        Intent intent = new Intent(HomeActivity.this, HelpActivity.class);
//                                        startActivity(intent);
//                                        return true;
//                                    }
//                                });
//                                break;
                        }
                        return true;
                    }
                }
        );
    }

    public void openkungpaoactivity()
    {
        Intent intent5 = new Intent(this,kungpaoactivity.class);
        startActivity(intent5);

    }
    public void openbeefstiractivity()
    {
        Intent intent6 = new Intent(this,beefstiractivity.class);
        startActivity(intent6);

    }

    public void openpeppersteakactivity()
    {
        Intent intent7 = new Intent(this,peppersteakactivity.class);
        startActivity(intent7);

    }

    public void openoystersauceactivity()
    {
        Intent intent8 = new Intent(this,oystersauceactivity.class);
        startActivity(intent8);

    }

    public void openfriedriceactivity()
    {
        Intent intent9 = new Intent(this,friedriceactivity.class);
        startActivity(intent9);

    }
}