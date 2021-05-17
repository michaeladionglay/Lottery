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


public class getGameType {

    protected List<Game> filterGames() {
        MainActivity.gameList.clear();
        List<Game> filterGames = new ArrayList<>();

        for (Game game: MainActivity.allGameList)
            if (game.Name.contains("($" + MainActivity.X + ")")) {
                filterGames.add(game);
            }
        return filterGames;
    }
}