package com.example.mycheflogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class italianactivity extends AppCompatActivity {
    private Button bakebutton;
    private Button polentabutton;
    private Button alfredobutton;
    private Button manbutton;
    private Button skilletbutton;
    private BottomNavigationView menuhome, menutophome;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italianactivity);

        bakebutton = (Button) findViewById(R.id.bakebutton);
        bakebutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openbakeactivity();
            }
        });

        polentabutton = (Button) findViewById(R.id.polentabutton);
        polentabutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view6)
            {
                openpolentaactivity();
            }
        });

        alfredobutton = (Button) findViewById(R.id.alfredobutton);
        alfredobutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view7)
            {
                openalfredoactivity();
            }
        });

        manbutton = (Button) findViewById(R.id.manbutton);
        manbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view8)
            {
                openmanactivity();
            }
        });

        skilletbutton = (Button) findViewById(R.id.skilletbutton);
        skilletbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view9)
            {
                openskilletactivity();
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
                                Intent intent = new Intent(italianactivity.this, HelpActivity.class);
                                startActivity(intent);
                                return true;
                            }
                        });
                        break;
                    case R.id.searchtop:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent(italianactivity.this, SearchActivity.class);
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
                                        Intent intent = new Intent(italianactivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.accountItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(italianactivity.this, PersonalActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.recipeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(italianactivity.this, FavouritesActivity.class);
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

    public void openbakeactivity()
    {
        Intent intent5 = new Intent(this,bakeactivity.class);
        startActivity(intent5);

    }
    public void openpolentaactivity()
    {
        Intent intent6 = new Intent(this,polentaactivity.class);
        startActivity(intent6);

    }

    public void openalfredoactivity()
    {
        Intent intent7 = new Intent(this,alfredoactivity.class);
        startActivity(intent7);

    }

    public void openmanactivity()
    {
        Intent intent8 = new Intent(this,manactivity.class);
        startActivity(intent8);

    }

    public void openskilletactivity()
    {
        Intent intent9 = new Intent(this,skilletactivity.class);
        startActivity(intent9);

    }
}

