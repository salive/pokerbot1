package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jchuprakov on 17.08.2016.
 */
public class Card
{
    private int rank, suit;

    private static String[] suits = { "h", "s", "d", "c" };
    private static String[] ranks  = { "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "J", "Q", "K", "A" };

    public static String rankAsString( int __rank ) {
        return ranks[__rank];
    }
    //Random randomGenerator = new Random();

    public Card(){

    }


    public Card(int rank, int suit)
    {
        this.rank=rank;
        this.suit=suit;
    }

    public @Override String toString()
    {
        return ranks[rank] + "" + suits[suit];
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public static Card convert(String s){
        char[] ch = new char[1];
        String tempString;
        int rank = 0, suit = 0;
        s.getChars(0,1, ch, 0);
        tempString = String.valueOf(ch[0]);
        switch (tempString)
        {
            case "2":
                rank = 0;
                break;
            case "3":
                rank = 1;
                break;
            case "4":
                rank = 2;
                break;
            case "5":
                rank = 3;
                break;
            case "6":
                rank = 4;
                break;
            case "7":
                rank = 5;
                break;
            case "8":
                rank = 6;
                break;
            case "9":
                rank = 7;
                break;
            case "10":
                rank = 8;
                break;
            case "J":
                rank = 9;
                break;
            case "Q":
                rank = 10;
                break;
            case "K":
                rank = 11;
                break;
            case "A":
                rank = 12;
                break;


        }

        s.getChars(1,2, ch, 0);
        tempString = String.valueOf(ch[0]);
        switch (tempString)
        {
            case "h":
                suit = 0;
                break;
            case "s":
                suit = 1;
                break;
            case "d":
                suit = 2;
                break;
            case "c":
                suit = 3;
                break;
        }
        Card card = new Card(rank, suit);
        return card;
    } //конвертирует строку вида Ah в объект карты

    public static Card generate ()
    {
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(Main.deck.getSize());
        Card c = Main.deck.getCard(r);
        Main.deck.remove(r);
        return c;
    }
    public void set(int _Rank, int _Suit){
        rank = _Rank;
        suit = _Suit;
    }

    public static int convertToKey(ArrayList<Card> c){             //конвертирует объект карты в ключ для поиска по чарту
        String tmp="";
        if ((c.get(0).getRank())>=(c.get(1).getRank())) tmp+=c.get(0).getRank()+c.get(1).getRank();
        else tmp+=c.get(1).getRank()+c.get(0).getRank();
        if(c.get(0).getSuit()==c.get(1).getSuit()) tmp = "-"+tmp;
        return Integer.parseInt(tmp);
    }
}
