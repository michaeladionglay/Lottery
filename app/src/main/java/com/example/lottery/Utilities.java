package com.example.lottery;

import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBar;

class Utilities {

    static void setupHomeIndicator(ActionBar actionBar) {
        if (actionBar != null) {
            // Comment out the below line to show the default home indicator
            //actionBar.setHomeAsUpIndicator(R.drawable.separator);

            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}