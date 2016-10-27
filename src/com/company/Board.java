package com.company;

import java.util.ArrayList;

/**
 * Created by jchuprakov on 19.08.2016.
 */
public class Board {
    private static ArrayList<Card> cards = new ArrayList<Card>();

    public static ArrayList<Card> getBoard()
    {
        return cards;
    }

    public static void addCards(Card card)
    {
        cards.add(card);
    }

    public static void clearBoard()
    {
        cards.clear();
    }
}
