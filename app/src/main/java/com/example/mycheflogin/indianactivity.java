package com.example.mycheflogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class indianactivity extends AppCompatActivity {
    private Button butterbutton;
    private Button chillibutton;
    private Button currybutton;
    private Button dalbutton;
    private Button fishbutton;

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