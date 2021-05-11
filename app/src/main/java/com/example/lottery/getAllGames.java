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


public class getAllGames extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {

        try {
            Document doc = Jsoup.connect("https://www.illinoislottery.com/about-the-games/unpaid-instant-games-prizes").get();

            for (Element row : doc.select(
                    "table.unclaimed-prizes-table.unclaimed-prizes-table--itg tr")) {

                String lottoName = row.select("td.unclaimed-prizes-table__cell:nth-of-type(1)").text();
                String lottoPrice = row.select("td.unclaimed-prizes-table__cell:nth-of-type(2)").text();
                String lottoGameNum = row.select("td.unclaimed-prizes-table__cell:nth-of-type(3)").text();
                String lottoPrizeVal = row.select("td.unclaimed-prizes-table__cell:nth-of-type(4)").text();
                String lottoTotalAvailPrizes = row.select("td.unclaimed-prizes-table__cell:nth-of-type(5)").text();
                String lottoTotalUnclaimedPrizes = row.select("td.unclaimed-prizes-table__cell:nth-of-type(6)").text();

                String gameString = row.select("td.unclaimed-prizes-table__cell:nth-of-type(1)").text();
                //skip blank web scrapes
                if (lottoName!="") {

                    Game game = new Game();
                    //name
                    game.setName(lottoName);
                    //price
                    game.setPrice(lottoPrice);
                    //Game Number
                    game.setGameNumber(Double.parseDouble(lottoGameNum.split("\\(")[0]));
                    //Prize Values
                    List<String> stringPrizeValList = Arrays.asList(lottoPrizeVal.split(" "));
                    List<Double> intPrizeValList = Conversion.convertLstStringToLstDouble_dollar(stringPrizeValList);
                    game.setPrizeValues(intPrizeValList);
                    //Total Avail Prizes
                    List<String> stringTotalAvailPrizesList = Arrays.asList(lottoTotalAvailPrizes.split(" "));
                    List<Double> doubleTotalAvailPrizesList = Conversion.convertLstStringToLstDouble(stringTotalAvailPrizesList);
                    game.setTotalAvailablePrizes(doubleTotalAvailPrizesList);
                    //Total Unclaimed Prizes
                    List<String> stringTotalUnclaimedPrizesList = Arrays.asList(lottoTotalUnclaimedPrizes.split(" "));
                    List<Double> doubleTotalUnclaimedPrizesList = Conversion.convertLstStringToLstDouble(stringTotalUnclaimedPrizesList);
                    game.setUnclaimedPrizes(doubleTotalUnclaimedPrizesList);
                    MainActivity.gameList.add(game);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Notify Dataset change otherwise it won't display
        MainActivity.mAdapter.notifyDataSetChanged();
    }
}

//Leaving this commented code here just in case we need to easily review it in the future.
//For the most part, this should all be ignored.
/**
public class getAllGames extends AsyncTask<Void, Void, Void> {

    List<String> AllGames = new ArrayList<String>();
    StringBuilder ListOfGamesInTextView = new StringBuilder();

    @Override
    protected Void doInBackground(Void... params) {

        try {
            Document doc = Jsoup.connect("https://www.illinoislottery.com/about-the-games/unpaid-instant-games-prizes").get();

            for (Element row : doc.select(
                    "table.unclaimed-prizes-table.unclaimed-prizes-table--itg tr")) {

                String game = row.select("td.unclaimed-prizes-table__cell:nth-of-type(1)").text();

                    AllGames.add(game);
                    ListOfGamesInTextView.append(game+"\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
**/