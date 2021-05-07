package com.example.lottery;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView ticketName;

    MyViewHolder(View view) {
        super(view);
        ticketName = view.findViewById(R.id.ticket_name);
    }
}
