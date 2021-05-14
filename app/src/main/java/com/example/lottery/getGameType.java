package com.example.lottery;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class getGameType extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {

            for (Game game : ListOfAllGamesHolder.allGameList) {
                if (game.Name.contains("($"+MainActivity.X+")")){
                    //selectedGameList.add(game);
                    MainActivity.gameList.add(game);
                }
            }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.mAdapter.notifyDataSetChanged();
    }
}