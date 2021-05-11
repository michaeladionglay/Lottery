package com.example.lottery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        setContentView(R.layout.activity_game);
        int pos = recyclerView.getChildLayoutPosition(v);
        Game game = gameList.get(pos);

        TextView gameName = findViewById(R.id.gameName);
        TextView gamePrice = findViewById(R.id.gamePriceTextEntry);
        TextView gameNumber = findViewById(R.id.gameNumberTextEntry);
        TableLayout prizeTable = findViewById(R.id.prizeTable);

        gameName.setText(game.Name);
        gamePrice.setText(game.Price);
        gameNumber.setText(game.GameNumber.toString());

        int rowNumber = 1;

        for (Double prizeValue : game.getPrizeValues()) {
            TableRow prizeTableRow = (TableRow) prizeTable.getChildAt(rowNumber);
            TextView cell = (TextView) prizeTableRow.getChildAt(0);
            cell.setText(prizeValue.toString());
            rowNumber++;
        }
        rowNumber = 1;

        for (Double totalAvailablePrizes : game.getTotalAvailablePrizes()) {
            TableRow prizeTableRow = (TableRow) prizeTable.getChildAt(rowNumber);
            TextView cell = (TextView) prizeTableRow.getChildAt(1);
            cell.setText(totalAvailablePrizes.toString());
            rowNumber++;
        }

        rowNumber = 1;

        for (Double totalUnclaimedPrizes : game.getUnclaimedPrizes()) {
            TableRow prizeTableRow = (TableRow) prizeTable.getChildAt(rowNumber);
            TextView cell = (TextView) prizeTableRow.getChildAt(2);
            cell.setText(totalUnclaimedPrizes.toString());
            rowNumber++;
        }
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