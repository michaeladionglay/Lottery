package com.example.lottery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
    public void onClick(View v) {  // click listener called by ViewHolder clicks
        //Right now this just confirms we are clicking on correct item. Will use this to transfer data into next activity
        int pos = recyclerView.getChildLayoutPosition(v);
        Game m = gameList.get(pos);
        Toast.makeText(v.getContext(), m.toString(), Toast.LENGTH_SHORT).show();
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



//Leaving this commented code here just in case we need to easily review it in the future.
//For the most part, this should all be ignored.
/**

 private class getAllGames extends AsyncTask<Void, Void, Void> {

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
gameList.add(game);
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
mAdapter.notifyDataSetChanged();

}
}

 **/

/**
 public class getGameType extends AsyncTask<Void, Void, Void> {

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

if (lottoName.contains("($"+X+")")){
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
gameList.add(game);

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

mAdapter.notifyDataSetChanged();
}
}
 **/

