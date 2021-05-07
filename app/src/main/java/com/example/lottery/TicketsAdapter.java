package com.example.lottery;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TicketsAdapter extends RecyclerView.Adapter<MyViewHolder> {


    private List<Ticket> ticketList;
    private MainActivity mainAct;

    TicketsAdapter(List<Ticket> tckList, MainActivity ma) {
        this.ticketList = tckList;
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

        Ticket ticket = ticketList.get(position);

        holder.ticketName.setText(ticket.getName());
        //holder.empId.setText(String.format(Locale.getDefault(), "%d", employee.getEmpId()));
        //holder.department.setText(employee.getDepartment());
        //holder.dateTime.setText(new Date().toString());
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }

}