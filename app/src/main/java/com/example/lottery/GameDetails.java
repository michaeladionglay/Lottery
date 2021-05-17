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
        gameNumber.setText(Conversion.removeTrailingZeros(game.GameNumber.toString()));
        int rowCount = 0;

        for (Double prizevalue : game.getPrizeValues()) {
            rowCount++;
        }

        int prizeValues = rowCount;
        for (Double prizeValue : game.getPrizeValues()) {
            TableRow prizeTableRow = (TableRow) prizeTable.getChildAt(prizeValues);
            TextView cell = (TextView) prizeTableRow.getChildAt(0);
            cell.setText(Conversion.removeTrailingZeros(prizeValue.toString()));
            prizeValues--;
        }

        int total = rowCount;
        for (Double totalAvailablePrizes : game.getTotalAvailablePrizes()) {
            TableRow prizeTableRow = (TableRow) prizeTable.getChildAt(total);
            TextView cell = (TextView) prizeTableRow.getChildAt(1);
            cell.setText(Conversion.removeTrailingZeros(totalAvailablePrizes.toString()));
            total--;
        }

        int unclaimed = rowCount;
        for (Double totalUnclaimedPrizes : game.getUnclaimedPrizes()) {
            TableRow prizeTableRow = (TableRow) prizeTable.getChildAt(unclaimed);
            TextView cell = (TextView) prizeTableRow.getChildAt(2);
            cell.setText(Conversion.removeTrailingZeros(totalUnclaimedPrizes.toString()));
            unclaimed--;
        }
    }
}