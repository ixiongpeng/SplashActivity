package com.example.xiongpeng.splashactivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import static android.R.id.message;

public class SplashActyivity extends AppCompatActivity {

    Handler handler = null;
    TextView tv = null;
    int times = 1;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler = new Handler();
        tv = (TextView)findViewById(R.id.tv);

        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActyivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Intent intent = new Intent(SplashActyivity.this, MainActivity.class);
                startActivity(intent);

                if(runnable != null){
                    handler.removeCallbacks(runnable);
                }
                
                break;
        }
        return true;
    }




}



