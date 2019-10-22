package com.example.mycheflogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class indianactivity extends AppCompatActivity {
    private Button butterbutton;
    private Button chillibutton;
    private Button currybutton;
    private Button dalbutton;
    private Button fishbutton;
    private BottomNavigationView menuhome, menutophome;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carribeanactivity);

        butterbutton = (Button) findViewById(R.id.butterbutton);
        butterbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openbutteractivity();
            }
        });

        chillibutton = (Button) findViewById(R.id.chillibutton);
        chillibutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view6)
            {
                openchilliactivity();
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
                                Intent intent = new Intent(indianactivity.this, HelpActivity.class);
                                startActivity(intent);
                                return true;
                            }
                        });
                        break;
                    case R.id.searchtop:
                        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                Intent intent = new Intent(indianactivity.this, SearchActivity.class);
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
                                        Intent intent = new Intent(indianactivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.accountItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(indianactivity.this, PersonalActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.recipeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(indianactivity.this, FavouritesActivity.class);
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


        currybutton = (Button) findViewById(R.id.currybutton);
        currybutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view7)
            {
                opencurryactivity();
            }
        });

        dalbutton = (Button) findViewById(R.id.dalbutton);
        dalbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view8)
            {
                opendalactivity();
            }
        });

        fishbutton = (Button) findViewById(R.id.fishbutton);
        fishbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view9)
            {
                openfishactivity();
            }
        });

        menuhome = (BottomNavigationView) findViewById(R.id.menu_Pers);
        menutophome = (BottomNavigationView) findViewById(R.id.topNav);
    }



    public void openbutteractivity()
    {
        Intent intent5 = new Intent(this,butteractivity.class);
        startActivity(intent5);

    }
    public void openchilliactivity()
    {
        Intent intent6 = new Intent(this,chilliactivity.class);
        startActivity(intent6);

    }

    public void opencurryactivity()
    {
        Intent intent7 = new Intent(this,curryactivity.class);
        startActivity(intent7);

    }

    public void opendalactivity()
    {
        Intent intent8 = new Intent(this,dalactivity.class);
        startActivity(intent8);

    }

    public void openfishactivity()
    {
        Intent intent9 = new Intent(this,fishactivity.class);
        startActivity(intent9);

    }
}