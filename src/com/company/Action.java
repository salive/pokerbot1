package com.company;

/**
 * Created by jchuprakov on 19.08.2016.
 */
public class Action {

    private static int action = 0;
    public static void setAction(int action){
        Action.action = action;
    }
    private static void Fold()
    {
    }
    private static void Call(){

    }

    private static void Raise()
    {

    }

    private static void AllIn()
    {

    }

    public static void Move()
    {
        switch (action){
            case 0:
                Fold();
                System.out.println("Hand was folded, sorry Master");
                Round.setStage(0);
                Round.clearPocket();
                Board.clearBoard();
                Main.isFlopSet = false;
                Main.isPocketSet = false;
                Main.isTurnSet = false;
                Main.isRiverSet = false;
                Main.hand.clearHand();
                HandEval.isStraightDraw = false;
                HandEval.isFlushDraw = false;
                HandEval.bestHand.clearHand();
                Main.deck.fill();
                break;
            case 1:
                Call();
                break;
            case 2:
                Raise();
                System.out.println("I was raised, Master!");
                break;
            case 3:
                AllIn();
                System.out.println("ALLIN!!!!111");
                break;
        }
    }

}
