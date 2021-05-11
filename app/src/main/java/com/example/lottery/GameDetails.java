package com.example.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class GameDetails extends AppCompatActivity {
    private TextView gameName;
    private TextView gamePrice;
    private TextView gameNumber;
    private TableLayout prizeTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        gameName = findViewById(R.id.gameName);
        gamePrice = findViewById(R.id.gamePriceTextEntry);
        gameNumber = findViewById(R.id.gameNumberTextEntry);
        prizeTable = findViewById(R.id.prizeTable);

        Intent intent = getIntent();
        Game game = (Game)intent.getSerializableExtra("GameDetails");

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


}