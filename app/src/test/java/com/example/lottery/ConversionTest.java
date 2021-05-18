package com.example.lottery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class ConversionTest {

    List <String> listOfStrings = Arrays.asList("1", "2", "3", "4");


    @Test
    public void testStringToDouble() {
        try {
            List<Double> newDoubleList = Conversion.convertLstStringToLstDouble_dollar(listOfStrings);
            assertEquals(newDoubleList.get(0),new Double("1"));
            assertTrue(newDoubleList.size() == 4);
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Test
    public void testDoubleToString() {
        try {
            List<Double> newDoubleList = Conversion.convertLstStringToLstDouble(listOfStrings);
            assertEquals(newDoubleList.get(0),new Double("1"));
            assertTrue(newDoubleList.size() == 4);
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Test
    public void testRemoveTrailingZeros() {
        String prizeValue = "$12.00";
        String newString = Conversion.removeTrailingZeros(prizeValue);
        assertNotNull(newString);
        assertEquals(newString, "$12");
    }


}
