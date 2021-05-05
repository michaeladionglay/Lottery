package com.example.lottery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static TextView Games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Games = findViewById(R.id.gameList);

        new getAllGames().execute();

        Button getListOf$1Games = findViewById(R.id.getListOf1Games);
        Button getListOf$2Games = findViewById(R.id.getListOf2Games);
        Button getListOf$3Games = findViewById(R.id.getListOf3Games);
        Button getListOf$5Games = findViewById(R.id.getListOf5Games);
        Button getListOf$10Games = findViewById(R.id.getListOf10Games);
        Button getListOf$20Games = findViewById(R.id.getListOf20PlusGames);

        getListOf$1Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getListOf$1Games().execute();
            }
        });
        getListOf$2Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getListOf$2Games().execute();
            }
        });
        getListOf$3Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getListOf$3Games().execute();
            }
        });
        getListOf$5Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getListOf$5Games().execute();
            }
        });
        getListOf$10Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getListOf$10Games().execute();
            }
        });
        getListOf$20Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getListOf$20Games().execute();
            }
        });
    }
}