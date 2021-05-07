package com.example.lottery;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class getListOf$1Games extends AsyncTask<Void, Void, Void> {

    List<Game> $1Games = new ArrayList<>();
    StringBuilder ListOfGamesInTextView = new StringBuilder();
    @RequiresApi(api = Build.VERSION_CODES.N)
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

                if (lottoName.contains("($1)")){
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

                    ListOfGamesInTextView.append(game.getName().toString() +"\n");
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

        MainActivity.Games.setText(String.valueOf(ListOfGamesInTextView));
    }
}
