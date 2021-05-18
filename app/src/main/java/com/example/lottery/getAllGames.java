package com.example.lottery;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.*;

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
                    //Total unclaimed prizes sum / total avail prizes sum
                    Double TotalAvailSum = Conversion.findSum(doubleTotalAvailPrizesList);
                    Double TotalUnclaimedSum = Conversion.findSum(doubleTotalUnclaimedPrizesList);
                    Double percentage_all = (TotalUnclaimedSum/TotalAvailSum) * 100;
                    game.setPercentage_all(percentage_all);
                    //grand prize: unclaimed/total
                    Double lastElement_TotalAvail = doubleTotalAvailPrizesList.get(doubleTotalAvailPrizesList.size() - 1);
                    Double lastElement_TotalUnclaimed = doubleTotalUnclaimedPrizesList.get(doubleTotalUnclaimedPrizesList.size() - 1);
                    Double percentage_grand = (lastElement_TotalUnclaimed/lastElement_TotalAvail) * 100;
                    game.setPercentage_grand(percentage_grand);

                    MainActivity.gameList.add(game);
                    MainActivity.allGameList.add(game);
                    //ListOfAllGamesHolder.allGameList.add(game);
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
        //MainActivity.
    }
}