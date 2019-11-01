package com.example.mycheflogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class carribeanactivity extends AppCompatActivity {
    private Button garlicbutton;
    private Button pepperpotbutton;
    private Button jerkbutton;
    private Button goatbutton;
    private Button roastporkbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carribeanactivity);

        garlicbutton = (Button) findViewById(R.id.garlicbutton);
        garlicbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                opengarlicactivity();
            }
        });
        pepperpotbutton = (Button) findViewById(R.id.pepperpotbutton);
        pepperpotbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view6)
            {
                openpepperpotactivity();
            }
        });

        jerkbutton = (Button) findViewById(R.id.jerkbutton);
        jerkbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view7)
            {
                openjerkactivity();
            }
        });

        goatbutton = (Button) findViewById(R.id.goatbutton);
        goatbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view8)
            {
                opengoatactivity();
            }
        });

        roastporkbutton = (Button) findViewById(R.id.roastporkbutton);
        roastporkbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view9)
            {
                openroastactivity();
            }
        });
    }

    public void opengarlicactivity()
    {
        Intent intent5 = new Intent(this,garlicactivity.class);
        startActivity(intent5);

    }
    public void openpepperpotactivity()
    {
        Intent intent6 = new Intent(this,pepperpotactivity.class);
        startActivity(intent6);

    }

    public void openjerkactivity()
    {
        Intent intent7 = new Intent(this,jerkactivity.class);
        startActivity(intent7);

    }

    public void opengoatactivity()
    {
        Intent intent8 = new Intent(this,goatactivity.class);
        startActivity(intent8);

    }

    public void openroastactivity()
    {
        Intent intent9 = new Intent(this,roastactivity.class);
        startActivity(intent9);

    }
}

