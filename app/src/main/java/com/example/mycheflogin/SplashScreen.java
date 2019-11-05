package com.example.mycheflogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private TextView loadingcomplete;
    private ProgressBar progressBar;
    private int progressStatis = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        loadingcomplete = findViewById(R.id.tvLoadingComplete);
        progressBar = findViewById(R.id.progreesbar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatis < 100){
                    progressStatis++;
                    android.os.SystemClock.sleep(70);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatis);
                        }
                    });
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loadingcomplete.setVisibility(View.VISIBLE);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }).start();



//        Thread myThread = new Thread(){
//            @Override
//            public void run() {
//                try {
//                    sleep(6000);
//                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        myThread.start();
    }
}
