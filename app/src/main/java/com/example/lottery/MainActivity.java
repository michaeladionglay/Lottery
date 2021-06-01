package com.example.lottery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    public static List<Game> gameList = new ArrayList<>();
    public static List<Game> allGameList = new ArrayList<>();
    private RecyclerView recyclerView; // Layout's recyclerview
    public static GamesAdapter mAdapter;
    public static String X;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utilities.setupHomeIndicator(getSupportActionBar());

        recyclerView = findViewById(R.id.recycler);
        // Data to recyclerview adapter
        mAdapter = new GamesAdapter(gameList, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TextView dateTime = findViewById(R.id.dateTime);

        new getAllGames().execute();

        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        dateTime.setText("Last updated: " + dateString);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new getAllGames().execute();

                long date = System.currentTimeMillis();
                TextView dateTime = findViewById(R.id.dateTime);
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy h:mm a");
                String dateString = sdf.format(date);
                dateTime.setText("Last updated: " + dateString);

                mAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
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
                mAdapter = new GamesAdapter(gameList, this);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                new getAllGames().execute();

                long date = System.currentTimeMillis();
                TextView dateTime = findViewById(R.id.dateTime);
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy h:mm a");
                String dateString = sdf.format(date);
                dateTime.setText("Last updated: " + dateString);
                return true;

            case R.id.menu_1_dollar:
                X = "1";
                gameList = new getGameType().filterGames();
                mAdapter = new GamesAdapter(gameList, this);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                return true;

            case R.id.menu_2_dollars:
                X = "2";
                gameList = new getGameType().filterGames();
                mAdapter = new GamesAdapter(gameList, this);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                return true;

            case R.id.menu_3_dollars:
                X = "3";
                gameList = new getGameType().filterGames();
                mAdapter = new GamesAdapter(gameList, this);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                return true;

            case R.id.menu_5_dollars:
                X = "5";
                gameList = new getGameType().filterGames();
                mAdapter = new GamesAdapter(gameList, this);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                return true;

            case R.id.menu_10_dollars:
                X = "10";
                gameList = new getGameType().filterGames();
                mAdapter = new GamesAdapter(gameList, this);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                return true;

            case R.id.menu_20_dollars:
                X = "20";
                gameList = new getGameType().filterGames();
                mAdapter = new GamesAdapter(gameList, this);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                return true;

            case R.id.menu_grand:
                X = "grand";
                gameList = new getGameType().filterGames();
                mAdapter = new GamesAdapter(gameList, this);
                recyclerView.setAdapter(mAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                return true;

            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}