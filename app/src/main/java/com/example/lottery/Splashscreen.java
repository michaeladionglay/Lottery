package com.example.lottery;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int timeOut = 3000;
        new Handler().postDelayed(() -> {
            Intent i = new Intent(Splashscreen.this, MainActivity.class);
            startActivity(i);

            finish();
        }, timeOut);
    }

}
