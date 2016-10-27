package com.company;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Date;

public class HandEval
{


    private static int weight = 0, comb = 0;
    public static Hand bestHand = new Hand();
    public static boolean isStraightDraw = false, isFlushDraw = false;
    private static LinkedList<Hand> handStack;

    public static boolean isEqual(Integer[] arr1, Integer[] arr2) //сравнивает два массива на равенство
    {
        boolean equal = true;
        if(arr1.length == arr2.length)
        {

            for (int i = 0; i < arr1.length; i++)
            {
                if(arr1[i] != arr2[i])
                    equal = false;
            }
        }
        return equal;
    }

    public static LinkedList<Integer[]> sevenToFive() //возвращает все возможные пятикарточные комбинации из семи карт
    {
        int i = 0, j = 0;
        LinkedList<Integer> arr = new LinkedList<Integer>();
        for(i = 0; i < 7; i++)
            arr.add(i);
        LinkedList<Integer> arr6 = new LinkedList<Integer>();
        LinkedList<Integer> arr5 = new LinkedList<Integer>();
        LinkedList<Integer[]> arrList = new LinkedList<Integer[]>();
        //убираем первый элемент из списка
        for(i = 0; i < arr.size(); i++) {
            arr6.clear();
            arr6.addAll(arr);
            arr6.remove(i);
            //убираем второй элемент из списка
            for (j = 0; j < arr6.size(); j++) {
                arr5.clear();
                arr5.addAll(arr6);
                arr5.remove(j);
                Integer[] tmpArr = arr5.toArray(new Integer[5]);
                Arrays.sort(tmpArr);
                int tmp;
                tmp = 0;
                for (Integer[] x: arrList)
                {
                    if (isEqual(tmpArr, x))
                        tmp++;
                }
                if (tmp == 0)
                    arrList.add(tmpArr);
            }
        }
        return arrList;


    }

    public static ArrayList<Integer[]> sixToFive()
    {
        int i = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(i = 0; i < 6; i++)
            arr.add(i);
        ArrayList<Integer> arr6 = new ArrayList<Integer>();
        ArrayList<Integer[]> arrList = new ArrayList<Integer[]>();
        //убираем первый элемент из списка
        for(i = 0; i < arr.size(); i++) {
            arr6.clear();
            arr6.addAll(arr);
            arr6.remove(i);
            Integer[] tmpArr = arr6.toArray(new Integer[5]);
            arrList.add(tmpArr);
        }
        return arrList;

    }

    public static int evaluate(Hand hand)
    {
        int best = 0, weight = 0,  count = 1;
        ArrayList<Integer[]> arr6 = sixToFive();
        LinkedList<Integer[]> arr7 = sevenToFive();
        Hand tmpHand  = new Hand();
        long ms;
        switch (hand.getSize())
        {
            case 5:
                bestHand.clearHand();
                bestHand.addAll(hand.getHand());
                return getCombination(hand);
            case 6:

                for(Integer[] intArr: arr6)
                {
                    tmpHand.clearHand();
                    HandEval.weight = 0;

                    for (int i = 0; i < intArr.length; i++)
                    {
                        tmpHand.addCard(hand.getCardById(intArr[i]));
                    }
                    comb = getCombination(tmpHand);
                    if (comb > best )
                    {
                        best = comb;
                        weight = 0;
                    }
                    if (comb == best)
                    {
                        if (HandEval.weight > weight) {
                            weight = HandEval.weight;
                            bestHand.clearHand();
                            bestHand.addAll(tmpHand.getHand());
                            HandEval.weight = 0;
                        }
                    }

                }
                HandEval.weight = 0;
                return best;
            case 7:

                for(Integer[] intArr: arr7)
                {
                    HandEval.weight = 0;
                    tmpHand.clearHand();
                    for (int i = 0; i < intArr.length; i++)
                    {
                        tmpHand.addCard(hand.getCardById(intArr[i]));
                    }
                    comb = getCombination(tmpHand);
                    if (comb > best )
                    {
                        best = comb;
                        weight = 0;
                    }
                    if (comb == best)
                    {
                        if (HandEval.weight > weight) {
                            weight = HandEval.weight;
                            bestHand.clearHand();
                            bestHand.addAll(tmpHand.getHand());
                            HandEval.weight = 0;
                        }
                    }

                }
                HandEval.weight = 0;
                return best;


        }
        return 0;
    }

    private static int getCombination(Hand hand)
    {
        String s = combination(hand);
        int result = 0;
        if(s.equals("one pair"))
            result = 1;
        if(s.equals("four of a kind"))
            result = 7;
        if (s.equals("high card"))
            result = 0;
        if (s.equals("two pairs"))
            result = 2;
        if (s.equals("three of a kind"))
            result = 3;
        if (s.equals("full house"))
            result = 6;
        if (isFlush(hand))
            result = 5;
        if (isStraight(hand))
            result = 4;
        if(isFlush(hand) && isStraight(hand))
            result = 8;
        if (isFlush(hand) && isBroadway){
            result = 9;
            isBroadway = false;
        }

        return result;


    }
    private static String combination(Hand hand)
    {
        HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>();
        //инициализируем гистограмму
        for (int i = 0; i < 5; i++){
            if (!histogram.containsKey(hand.getCardById(i).getRank()))
                histogram.put(hand.getCardById(i).getRank(), 0);

        }

        for (int i = 0; i < 5; i++){
            histogram.put(hand.getCardById(i).getRank(), histogram.get(hand.getCardById(i).getRank())+1);
            weight += hand.getCardById(i).getRank();
        }

        switch (histogram.size())
        {
            case 2:
                for(Map.Entry<Integer, Integer> map: histogram.entrySet())
                {
                    if (map.getValue() == 4) return "four of a kind";
                    if (map.getValue() == 3) return "full house";
                }
                break;
            case 3:
                for(Map.Entry<Integer, Integer> map: histogram.entrySet())
                {
                    if (map.getValue() == 3) return "three of a kind";
                    if (map.getValue() == 2) return "two pairs";
                }


            case 4:
                return "one pair";
            case 5:
                return "high card";

        }

        return "";
    }

    private static boolean isFlush(Hand hand)
    {
        int i = 0, count = 0;
        for (i = 0; i < 4; i++)
        {
            if(hand.getCardById(i).getSuit() == hand.getCardById(i+1).getSuit())
                count++;
        }
        if (count == 3) isFlushDraw = true;
        if (count == 4)
            return true;

        else return false;

    }
    private static boolean isBroadway;
    private static boolean isStraight(Hand hand)
    {
        Integer[] broadway = {8,9,10,11,12};
        Integer[] wheel = {0,1,2,3,12};
        Integer[] sortedArr = new Integer[5];
        int i = 0, count = 0;
        for (Card c: hand.getHand()){
            sortedArr[i] = c.getRank();
            i++;
        }
        Arrays.sort(sortedArr);
        for (i = 0; i < 4; i++)
        {
            if (sortedArr[i+1] - sortedArr[i] == 1)
                count++;
        }
        if (isEqual(sortedArr, wheel))
            return true;
        if (isEqual(sortedArr, broadway))
            isBroadway = true;
        if(count == 4)
            return true;
        if(count == 3) isStraightDraw = true;
        return false;

    }
    public static boolean isPocketPair(){
        if (Round.pocket.get(0).getRank() == Round.pocket.get(1).getRank()) return true;
        return false;
    }

}
