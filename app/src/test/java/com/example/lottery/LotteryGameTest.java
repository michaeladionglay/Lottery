package com.example.lottery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.example.lottery.Game;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LotteryGameTest {
    List prizedValueList = new ArrayList<Double>();
    List totalAvailablePrizesList = new ArrayList<Double>();
    List unclaimedPrizesList = new ArrayList<Double>();
    Game game = new Game();
    enum gameType { GROUP_PLAY, JACKPOT, FAST_PLAY, INSTANT_TICKET };

    @Before
    public void setup(){
        prizedValueList.add(new Double("12.99"));
        prizedValueList.add(new Double("4.00"));
        prizedValueList.add(new Double("7.10"));
        prizedValueList.add(new Double("1.00"));
        prizedValueList.add(new Double("2.00"));
        prizedValueList.add(new Double("3.00"));
        prizedValueList.add(new Double("4.00"));

        totalAvailablePrizesList.add(new Double("10"));
        totalAvailablePrizesList.add(new Double("20"));
        totalAvailablePrizesList.add(new Double("30"));

        unclaimedPrizesList.add(new Double("600"));
        unclaimedPrizesList.add(new Double("550"));
        unclaimedPrizesList.add(new Double("500"));
        unclaimedPrizesList.add(new Double("400"));
        unclaimedPrizesList.add(new Double("300"));
        unclaimedPrizesList.add(new Double("200"));


        game.setAmount(new Double("100.00"));
        game.setName("Lucky Number 3");
        game.setDrawDate(new Date());
        game.setPrice("20.00");
        game.setPrizeValues(prizedValueList);
        game.setTicketLocation("Chicago-Lincoln-Park");
        game.setTotalAvailablePrizes(totalAvailablePrizesList);
        game.setGameNumber(new Double(123.00));
        game.setUnclaimedPrizes(unclaimedPrizesList);
    }

    @After
    public void tearDown(){
       game = null;
       totalAvailablePrizesList.clear();
       unclaimedPrizesList.clear();;
       prizedValueList.clear();
    }

    @Test
    public void testFastPlayGameData() {
        game.setGameType(gameType.FAST_PLAY);
        assertNotNull(game.getGameType());

        assertNotNull(game.getName());
        assertEquals(game.getName(),"Lucky Number 3");

        assertNotNull(game.getTicketLocation());
        assertEquals(game.getTicketLocation(),"Chicago-Lincoln-Park");

        assertNotNull(game.getDrawDate());

        assertNotNull(game.getPrice());
        assertEquals(game.getPrice(),"20.00");
    }

}