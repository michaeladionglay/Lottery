package com.example.lottery;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<MyViewHolder> {


    private List<Game> gameList;
    private MainActivity mainAct;

    GamesAdapter(List<Game> gmeList, MainActivity ma) {
        this.gameList = gmeList;
        mainAct = ma;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_ticket_list_row, parent, false);

        itemView.setOnClickListener(mainAct);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Game game = gameList.get(position);

        if (position %2 == 1){
            holder.itemView.setBackgroundColor(Color.parseColor("#72ab59"));//Blue
        }
        else{
            holder.itemView.setBackgroundColor(Color.parseColor("#FFEFC764"));//Gold
        }

        holder.ticketName.setText(game.getName());
        holder.allprizesRemain.setText(String.format("%.0f",game.getPercentage_all())+"% Winning Tickets");
        holder.grandprizeRemain.setText(String.format("%.0f",game.getPercentage_grand())+"% Grand Prize Tickets");
        //holder.empId.setText(String.format(Locale.getDefault(), "%d", employee.getEmpId()));
        //holder.department.setText(employee.getDepartment());
        //holder.dateTime.setText(new Date().toString());
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

}

