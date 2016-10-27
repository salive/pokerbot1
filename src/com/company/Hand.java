package com.company;

import java.util.ArrayList;


/**
 * Created by jchuprakov on 17.08.2016.
 */
public class Hand
{

    private  ArrayList<Card> hand = new ArrayList<Card>();
    public Hand()
    {

    }
    public void addCard(Card card)
    {
        this.hand.add(card);
    }

    public ArrayList<Card> getHand()
    {
        ArrayList<Card> hand  = new ArrayList<Card>();
        for(Card c: this.hand)
            hand.add(c);
        return hand;
    }

    public void addAll(ArrayList<Card> arrList)
    {
        for (Card c: arrList)
        {
            this.hand.add(c);
        }
    }

    public static ArrayList<Integer> getHandIds()
    {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        return arrList;
    }

    public Card getCardById(int id)
    {
        ArrayList<Card> hand= new ArrayList<Card>();
        hand = this.hand;
        return hand.get(id);
    }
    public void clearHand()
    {
        this.hand.clear();
    }

    public int getSize()
    {
        return hand.size();
    }

    public int getWeight(){
        int weight = 0;
        for (Card c: this.getHand())
        {
            weight+=c.getRank();
        }
        return weight;
    }



}
