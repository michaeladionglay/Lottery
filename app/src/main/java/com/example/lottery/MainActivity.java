package com.example.lottery;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    public static List<Game> gameList = new ArrayList<>();  // Main content is here
    private RecyclerView recyclerView; // Layout's recyclerview
    public static GamesAdapter mAdapter;
    public static String X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        // Data to recyclerview adapter
        mAdapter = new GamesAdapter(gameList, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new getAllGames().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        int pos = recyclerView.getChildLayoutPosition(v);
        Game game = gameList.get(pos);

        Intent intent = new Intent(this, GameDetails.class);
        intent.putExtra("GameDetails", game);
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Make choice between menu options
        switch (item.getItemId()) {
            case R.id.menu_all:
                gameList.clear();
                new getAllGames().execute();
                return true;

            case R.id.menu_1_dollar:
                X = "1";
                gameList.clear();
                new getGameType().execute();
                return true;

            case R.id.menu_2_dollars:
                X = "2";
                gameList.clear();
                new getGameType().execute();
                return true;

            case R.id.menu_3_dollars:
                X = "3";
                gameList.clear();
                new getGameType().execute();
                return true;

            case R.id.menu_5_dollars:
                X = "5";
                gameList.clear();
                new getGameType().execute();
                return true;

            case R.id.menu_10_dollars:
                X = "10";
                gameList.clear();
                new getGameType().execute();
                return true;

            case R.id.menu_20_dollars:
                X = "20";
                gameList.clear();
                new getGameType().execute();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}