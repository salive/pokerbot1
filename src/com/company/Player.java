package com.company;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by jchuprakov on 25.10.2016.
 */
public class Player {
    private ArrayList<Card> pocket = new ArrayList<Card>();
    private int position;
    private int stack = 0;
    private int handval;
    private int comb;
    public String name;
    public Hand hand;
    public boolean lose = false;

    public Player(Card c1, Card c2, String name)
    {
        pocket.clear();
        pocket.add(c1);
        pocket.add(c2);
        this.name = name;
    }

    public Player()
    {
        this.name = "unnamed";
    }

    public Player(String name)
    {
        this.name = name;
    }
    public void setComb(int c)
    {
        this.comb = c;
    }
    public int getComb()
    {
        return comb;
    }

    public void setPocket(Card c1, Card c2)
    {
        pocket.clear();
        pocket.add(c1);
        pocket.add(c2);
    }

    public void setPosition(int p)
    {
        position = p;
    }

    public void setStack(int s)
    {
        stack += s;
    }
    public void setStackDirect(int s)
    {
        stack = s;
    }

    public void setHandval(int h)
    {
        handval = h;
    }

    public ArrayList<Card> getPocket()
    {
        return pocket;
    }

    public int getPosition()
    {
        return position;
    }

    public int getStack()
    {
        return stack;
    }

    public int getHandval()
    {
        return handval;
    }


}
