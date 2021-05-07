package com.example.lottery;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private List<Ticket> ticketList = new ArrayList<>();  // Main content is here
    private RecyclerView recyclerView; // Layout's recyclerview
    public TicketsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        // Data to recyclerview adapter
        mAdapter = new TicketsAdapter(ticketList, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new getAllGames().execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private class getAllGames extends AsyncTask<Void, Void, Void> {

        List<String> AllGames = new ArrayList<String>();
        StringBuilder ListOfGamesInTextView = new StringBuilder();

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Document doc = Jsoup.connect("https://www.illinoislottery.com/about-the-games/unpaid-instant-games-prizes").get();

                for (Element row : doc.select(
                        "table.unclaimed-prizes-table.unclaimed-prizes-table--itg tr")) {

                    String game = row.select("td.unclaimed-prizes-table__cell:nth-of-type(1)").text();
                    //skip blank web scrapes
                    if (game!="") {
                        ticketList.add(new Ticket(game));
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
            //Notify Dataset change otherwise it won't display
            mAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onClick(View v) {  // click listener called by ViewHolder clicks
        //Right now this just confirms we are clicking on correct item. Will use this to transfer data into next activity
        int pos = recyclerView.getChildLayoutPosition(v);
        Ticket m = ticketList.get(pos);
        Toast.makeText(v.getContext(), m.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Make choice between menu options
        switch (item.getItemId()) {
            case R.id.menu_all:
                ticketList.clear();
                new getAllGames().execute();
                mAdapter.notifyDataSetChanged();
                return true;


            case R.id.menu_1_dollar:
                //insert stuff here
                return true;

            case R.id.menu_2_dollars:
                //insert stuff here
                return true;

            case R.id.menu_3_dollars:
                //insert stuff here
                return true;

            case R.id.menu_5_dollars:
                //insert stuff here
                return true;

            case R.id.menu_10_dollars:
                //insert stuff here
                return true;

            case R.id.menu_20_dollars:
                //insert stuff here
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}