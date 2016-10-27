package com.company;

import java.util.ArrayList;

/**
 * Created by jchuprakov on 25.10.2016.
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    public Deck() {

        fill();
    }
    public String toString()
    {
        String result = new String();
        for(Card c: deck)
        {
            result+=' '+c.toString();
        }
        return result;
    }

    public Card getCard(int index)
    {
        return deck.get(index);
    }

    public void remove(int index)
    {
        deck.remove(index);
    }

    public int getSize()
    {
        return deck.size();
    }

    public void fill()
    {
        deck.clear();
        for (int i=0; i<13;i++)
        {
            for (int j=0;j<4;j++){
                Card c = new Card(i,j);
                deck.add(c);
            }
        }

    }
}
