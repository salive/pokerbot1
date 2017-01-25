package com.company;

import java.util.ArrayList;

/**
 * Created by jchuprakov on 19.08.2016.
 */
public class Round {
    private static int stage = 0;
    private static int position;

    public static ArrayList<Card> pocket;

    public static void setPosition(int position)
    {
        Round.position = position;
    }

    public static int getPosition()
    {
        return Round.position;
    }



    public static void clearPocket() {
        Round.pocket.clear();
    }

    public ArrayList<Card> getPocket() {
        return pocket;
    }

    private static boolean isMyTurn = false;

    public void setIsMyTurn(boolean isMyTurn) {
        this.isMyTurn = isMyTurn;
    }

    public static int getStage() {
        return stage;
    }

    public static void setStage(int stage)
    {
        Round.stage = stage;
    }

    public static void Action()
    {


    }


}
