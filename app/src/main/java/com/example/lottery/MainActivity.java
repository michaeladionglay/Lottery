package com.example.lottery;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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
        Games.setMovementMethod(new ScrollingMovementMethod());

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
                new getGameType().execute("($1)");
            }
        });
        getListOf$2Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getGameType().execute("($2)");
            }
        });
        getListOf$3Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getGameType().execute("($3)");
            }
        });
        getListOf$5Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getGameType().execute("($5)");
            }
        });
        getListOf$10Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getGameType().execute("($10)");
            }
        });
        getListOf$20Games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getGameType().execute("($20)");
            }
        });
    }
}