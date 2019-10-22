package com.example.mycheflogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class medactivity extends AppCompatActivity {
    private Button bakedfishbutton;
    private Button medchickenbutton;
    private Button chickpeabutton;
    private Button onepotbutton;
    private Button scampibutton;
    private BottomNavigationView menuhome, menutophome;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carribeanactivity);

        bakedfishbutton = (Button) findViewById(R.id.bakedfishbutton);
        bakedfishbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openbakedfishactivity();
            }
        });

        medchickenbutton = (Button) findViewById(R.id.medchickenbutton);
        medchickenbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view6)
            {
                openmedchickenactivity();
            }
        });

        chickpeabutton = (Button) findViewById(R.id.chickpeabutton);
        chickpeabutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view7)
            {
                openchickpeaactivity();
            }
        });

        onepotbutton = (Button) findViewById(R.id.onepotbutton);
        onepotbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view8)
            {
                openonepotactivity();
            }
        });

        scampibutton = (Button) findViewById(R.id.scampibutton);
        scampibutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view9)
            {
                openscampiactivity();
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
                                Intent intent = new Intent(medactivity.this, HelpActivity.class);
                                startActivity(intent);
                                return true;
                            }
                        });
                        break;
                    case R.id.searchtop:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent(medactivity.this, SearchActivity.class);
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
                                        Intent intent = new Intent(medactivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.accountItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(medactivity.this, PersonalActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.recipeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(medactivity.this, FavouritesActivity.class);
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

    public void openscampiactivity()
    {
        Intent intent5 = new Intent(this,scampiactivity.class);
        startActivity(intent5);

    }
    public void openonepotactivity()
    {
        Intent intent6 = new Intent(this,potpastaactivity.class);
        startActivity(intent6);

    }

    public void openchickpeaactivity()
    {
        Intent intent7 = new Intent(this,chickpeaactivity.class);
        startActivity(intent7);

    }

    public void openmedchickenactivity()
    {
        Intent intent8 = new Intent(this,medchickenactivity.class);
        startActivity(intent8);

    }

    public void openbakedfishactivity()
    {
        Intent intent9 = new Intent(this,bakedfishactivity.class);
        startActivity(intent9);

    }
}

