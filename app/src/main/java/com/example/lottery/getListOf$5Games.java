package com.example.lottery;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class getListOf$5Games extends AsyncTask<Void, Void, Void> {

    List<String> $5Games = new ArrayList<String>();
    StringBuilder ListOfGamesInTextView = new StringBuilder();

    @Override
    protected Void doInBackground(Void... params) {

        try {
            Document doc = Jsoup.connect("https://www.illinoislottery.com/about-the-games/unpaid-instant-games-prizes").get();

            for (Element row : doc.select(
                    "table.unclaimed-prizes-table.unclaimed-prizes-table--itg tr")) {

                String game = row.select("td.unclaimed-prizes-table__cell:nth-of-type(1)").text();

                if (game.contains("($5)")){
                    $5Games.add(game);
                    ListOfGamesInTextView.append(game+"\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.Games.setText(String.valueOf(ListOfGamesInTextView));
    }
}
