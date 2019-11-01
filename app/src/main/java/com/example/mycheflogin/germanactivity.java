package com.example.mycheflogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class germanactivity extends AppCompatActivity {

    private Button pancakesbutton;
    private Button potbutton;
    private Button dumpbutton;
    private Button greenbutton;
    private Button porkbutton;

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

