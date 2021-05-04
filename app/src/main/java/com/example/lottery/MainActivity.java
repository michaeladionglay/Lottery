package com.example.lottery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static TextView $1Games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        $1Games = findViewById(R.id.listOf1Games);
        Button getListOf$1Games = findViewById(R.id.getListOf1Games);

        getListOf$1Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getListOf$1Games().execute();
            }
        });
    }
}