package com.example.mycheflogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class medactivity extends AppCompatActivity {
    private Button bakedfishbutton;
    private Button medchickenbutton;
    private Button chickpeabutton;
    private Button onepotbutton;
    private Button scampibutton;

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

