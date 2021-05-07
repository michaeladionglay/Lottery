package com.example.lottery;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Conversion {
    public static List<Double> convertLstStringToLstDouble(List<String> stringList) {
        List<Double> doubleList = new ArrayList<>();
        for (String num : stringList) {
            if (num.contains(",")) {
                Double i = Double.parseDouble(num.replaceAll(",", ""));
                doubleList.add(i);
            } else {
                Double j = Double.parseDouble(num);
                doubleList.add(j);
            }
        }
        return doubleList;
    }

    public static List<Double> convertLstStringToLstDouble_dollar(List<String> stringList) throws ParseException {
        List<String> without$List = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();

        for (String str_with_$: stringList){
            NumberFormat format = NumberFormat.getCurrencyInstance();
            Number number = format.parse(str_with_$);
            doubleList.add(number.doubleValue());
        }
        return doubleList;
    }
}