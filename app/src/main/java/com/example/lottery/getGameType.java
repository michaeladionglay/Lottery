package com.example.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class getGameType {

    protected List<Game> filterGames() {
        MainActivity.gameList.clear();
        List<Game> filterGames = new ArrayList<>();

        for (Game game: MainActivity.allGameList) {
            if (game.Name.contains("($" + MainActivity.X + ")")) {
                filterGames.add(game);
            }
        }

        if (MainActivity.X == "20"){
            for (Game game: MainActivity.allGameList) {
                if (game.Name.contains("($25)") || game.Name.contains("($30)")){
                    filterGames.add(game);
                }
            }
        }

        if (MainActivity.X == "grand"){
            HashMap<Game, Double> tempMap = new HashMap<Game, Double>();
            for (Game game: MainActivity.allGameList) {
                tempMap.put(game, game.Percentage_grand);
            }
            HashMap<Game, Double> sortedList = sortByValue(tempMap);
            List<Game> glist = new ArrayList<>();
            for (Game g: sortedList.keySet()){
                glist.add(g);
            }
            Collections.reverse(glist);
            for(Game game: glist){
                filterGames.add(game);
            }
        }

        return filterGames;
    }

    public static HashMap<Game, Double> sortByValue(HashMap<Game, Double> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Game, Double> > list
                = new LinkedList<Map.Entry<Game, Double> >(
                hm.entrySet());

        // Sort the list using lambda expression
        Collections.sort(list,(i1,
                               i2) -> i1.getValue().compareTo(i2.getValue()));

        // put data from sorted list to hashmap
        HashMap<Game, Double> temp
                = new LinkedHashMap<>();
        for (Map.Entry<Game, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}