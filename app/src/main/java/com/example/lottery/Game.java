package com.example.lottery;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Game implements Serializable {
    String Name;
    String Price;
    Double GameNumber;
    List<Double> PrizeValues;
    List<Double> TotalAvailablePrizes;
    List<Double> UnclaimedPrizes;
    Date DrawDate;
    String TicketLocation;
    Double Amount;
    Enum GameType;

    public void setName(String name){
        this.Name = name;
    }

    public String getName(){
        return this.Name;
    }

    public void setPrice(String price){
        this.Price = price;
    }

    public String getPrice(){
        return this.Price;
    }

    public void setGameNumber(Double gameNumber){
        this.GameNumber = gameNumber;
    }

    public Double getGameNumber(){
        return this.GameNumber;
    }
    
    public void setPrizeValues(List<Double> prizeValues){
        this.PrizeValues = prizeValues;
    }

    public List<Double> getPrizeValues(){
        return this.PrizeValues;
    }
    
    public void setTotalAvailablePrizes(List<Double> totalAvailablePrizes){
        this.TotalAvailablePrizes = totalAvailablePrizes;
    }

    public List<Double> getTotalAvailablePrizes(){
        return this.TotalAvailablePrizes;
    }

    public void setUnclaimedPrizes(List<Double> unclaimedPrizes){
        this.UnclaimedPrizes = unclaimedPrizes;
    }

    public List<Double> getUnclaimedPrizes(){
        return this.UnclaimedPrizes;
    }

    public void setDrawDate(Date drawDate){
        this.DrawDate = drawDate;
    }

    public Date getDrawDate(){
        return this.DrawDate;
    }

    public void setTicketLocation(String ticketLocation){
        this.TicketLocation = ticketLocation;
    }

    public String getTicketLocation(){
        return this.TicketLocation;
    }

    public void setAmount(Double amount){
        this.Amount = amount;
    }

    public Double getAmount(){
        return this.Amount;
    }

    public void setGameType(Enum gameType){
        this.GameType = gameType;
    }

    public Enum getGameType(){
        return this.GameType;
    }

    @NonNull
    @Override
    public String toString() {
        return Name;
    }
}

