package com.example.mycheflogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class germanactivity extends AppCompatActivity {

    private Button pancakesbutton;
    private Button potbutton;
    private Button dumpbutton;
    private Button greenbutton;
    private Button porkbutton;
    private BottomNavigationView menuhome, menutophome;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carribeanactivity);

        pancakesbutton = (Button) findViewById(R.id.pancakesbutton);
        pancakesbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                Intent intent5 = new Intent(germanactivity.this ,pancakesactivity.class);
//                startActivity(intent5);
                openpancakesactivity();
            }
        });

        potbutton = (Button) findViewById(R.id.potbutton);
        potbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view6)
            {
                openpotactivity();
            }
        });

        dumpbutton = (Button) findViewById(R.id.dumpbutton);
        dumpbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view7)
            {
                opendumpactivity();
            }
        });

        greenbutton = (Button) findViewById(R.id.greenbutton);
        greenbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view8)
            {
                opengreenactivity();
            }
        });

        porkbutton = (Button) findViewById(R.id.porkbutton);
        porkbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view9)
            {
                openporkactivity();
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
                                Intent intent = new Intent(germanactivity.this, HelpActivity.class);
                                startActivity(intent);
                                return true;
                            }
                        });
                        break;
                    case R.id.searchtop:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent(germanactivity.this, SearchActivity.class);
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
                                        Intent intent = new Intent(germanactivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.accountItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(germanactivity.this, PersonalActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.recipeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(germanactivity.this, FavouritesActivity.class);
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

    public void openpancakesactivity()
    {
        Intent intent5 = new Intent(this,pancakesactivity.class);
        startActivity(intent5);

    }
    public void openpotactivity()
    {
        Intent intent6 = new Intent(this,potactivity.class);
        startActivity(intent6);

    }

    public void opendumpactivity()
    {
        Intent intent7 = new Intent(this,dumpactivity.class);
        startActivity(intent7);

    }

    public void opengreenactivity()
    {
        Intent intent8 = new Intent(this,greenactivity.class);
        startActivity(intent8);

    }

    public void openporkactivity()
    {
        Intent intent9 = new Intent(this,porkactivity.class);
        startActivity(intent9);

    }
}

