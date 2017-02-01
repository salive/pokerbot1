package com.company;

import java.util.*;

/**
 * Created by jchuprakov on 24.08.2016.
 */
public class Charts {
    public static HashMap<Integer, ArrayList<Integer>> chart;
    public Charts()
    {
        chart = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<12;i++){
            arr.add(i);
        }
        chart.put(1212, arr); //AA
        chart.put(1111, arr); //KK
        chart.put(1010, arr); //QQ
        chart.put(99, arr); //JJ
        chart.put(88, arr); //TT
        chart.put(77, arr); //99
        chart.put(1211, arr); //AKo
        chart.put(1210, arr); //AQo
        chart.put(-1211, arr); //AKs
        chart.put(-1210, arr); //AQs
        chart.put(-129, arr); //AJs

        arr.remove(arr.size()-1);
        chart.put(129,arr); //AJo
        chart.put(66, arr); //88
        chart.put(55, arr); //77

        arr.remove(arr.size()-1);









    }

    public static boolean check(int key, int ch) {
        // 0 - button first to act, raise
        // 1 - button first to act, call push or raise
        // 2 - sb, buuton raises we call
        // 3 - sb, button raises, we push
        // 4 - bb, button raises, sb folds, call
        // 5 - bb, button raises, sb folds, push
        // 6 - bb, button folds, sb limps, we raise
        // 7 - bb, button folds, sb limps, we raise and call push
        // 8 - bb, button folds, sb raise, we call
        // 9 - bb, button folds, sb raise, we push
        // 10 - sb, bb, call openpush from anybody
        // 11 - sb, bb, call openpush from both

        if(chart.get(key).contains(ch)) return true;
        else return false;
    }









}
