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
        Hand hand = new Hand();
        hand.addAll(pocket);
        hand.addAll(Board.getBoard());
        switch (Round.stage){
            //preflop
            case 0:
                Action.setAction(0);
                Integer[] tmpArr = new Integer[2];
                tmpArr[0] = pocket.get(0).getRank();
                tmpArr[1] = pocket.get(1).getRank();
                /*switch(position){
                    case 0:
                        for(Integer[] arr : Charts.noRaiseEp){
                            if(HandEval.isEqual(tmpArr, arr)) Action.setAction(2);
                        }
                        break;
                    case 1:
                        for(Integer[] arr : Charts.noRaiseMp){
                            if(HandEval.isEqual(tmpArr, arr)) Action.setAction(2);
                        }
                        break;
                    case 2:
                        for(Integer[] arr : Charts.noRaiseLp){
                            if(HandEval.isEqual(tmpArr, arr)) Action.setAction(2);
                        }
                        break;

                }*/
                Action.Move();
                Action.setAction(0);
                break;
            //flop
            case 1:
                if (HandEval.evaluate(hand) > 0)
                    Action.setAction(2);
                else Action.setAction(0);
                Action.Move();
                break;
            case 2:
                if (HandEval.evaluate(hand) > 1)
                    Action.setAction(2);
                else Action.setAction(0);
                Action.Move();
                break;
            case 3:
                if (HandEval.evaluate(hand) > 2)
                    Action.setAction(2);
                else Action.setAction(0);
                Action.Move();
                break;


        }


    }


}
