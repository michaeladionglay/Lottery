package com.example.lottery;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView ticketName;
    public TextView allprizesRemain;
    public TextView grandprizeRemain;

    MyViewHolder(View view) {
        super(view);
        ticketName = view.findViewById(R.id.ticket_name);
        allprizesRemain = view.findViewById(R.id.winning_tickets);
        grandprizeRemain = view.findViewById(R.id.grand_prize);

    }
}
