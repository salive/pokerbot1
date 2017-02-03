package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.SyncFailedException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.HashMap;
import java.io.IOException;


public class Main {

    public static Hand hand1 = new Hand();
    public static Hand hand2 = new Hand();
    public static Deck deck = new Deck();
    public static boolean isFlopSet = false, isPocketSet = false, isTurnSet = false, isRiverSet = false;
    public static Player player1 = new Player("Hero");
    public static Player player2 = new Player("player2");
    public static Player player3 = new Player("player3");
    public static HashMap<Integer, Table> tables = new HashMap<Integer, Table>();
    public static void main(String[] args) throws Exception
    {
        String[] combs  = {"high card", "one pair", "two pair", "three of a kind", "full house", "straight",
                "flush", "four of a kind", "flush straight", "royal flush"};
        String[] stages = {"preflop", "flop", "turn", "river"};
        String[] positions = {"EP", "MP", "LP"};
        Date d1, d2;
        long db1, db2;
        player1.setPocket(Card.convert("Ah"),Card.convert("5s") );
        player2.setPocket(Card.generate(), Card.generate());
        Board.addCards(Card.generate());
        Board.addCards(Card.generate());
        Board.addCards(Card.generate());
        Board.addCards(Card.generate());
        Board.addCards(Card.generate());
        hand1.addAll(player1.getPocket());
        hand1.addAll(Board.getBoard());
        hand2.addAll(player2.getPocket());
        hand2.addAll(Board.getBoard());
        System.out.println("Player1 pocket "+player1.getPocket());
        System.out.println("Player2 pocket "+player2.getPocket());
        System.out.println("Board is "+Board.getBoard());
        System.out.println("Player1 have a "+combs[HandEval.evaluate(hand1)]);
        System.out.println("Player1 besthand "+HandEval.);
        System.out.println("Player2 have a "+combs[HandEval.evaluate(hand2)]);


    }




























    public static void lookup() throws Exception
    {
        String st = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tmp;

            while (!st.equals("exit")) {

                    st = reader.readLine();

                if (st.equals("table")) {
                    System.out.println("Number:");
                    tmp = Integer.parseInt(reader.readLine());
                    if (!tables.containsKey(tmp)) {
                        Table tb = new Table();
                        ArrayList<Card> tmp_arr = new ArrayList<>();
                        tb.setId(tmp);
                        System.out.println("Stage");
                        tb.setStage(Integer.parseInt(reader.readLine()));
                        if (tb.getStage() != 0) {
                            System.out.println("Board");
                            tmp_arr.clear();
                            String temp;
                            while (true) {
                                temp = reader.readLine();
                                if (!temp.equals("done")) {
                                    tmp_arr.add(Card.convert(temp));
                                } else break;
                            }
                        }
                        System.out.println("Pocket:");
                        tmp_arr.clear();
                        tmp_arr.add(Card.convert(reader.readLine()));
                        tmp_arr.add(Card.convert(reader.readLine()));
                        tb.setPocket(tmp_arr);
                        System.out.println("Pot");
                        tb.setPot(Integer.parseInt(reader.readLine()));
                        System.out.println("Position");
                        tb.setPosition(Integer.parseInt(reader.readLine()));
                        System.out.println("Players left");
                        tb.setPlayers_left(Integer.parseInt(reader.readLine()));
                        System.out.println("Stakes:");
                        tb.setBB(Integer.parseInt(reader.readLine()));
                        System.out.println("Hero stack");
                        tb.setHero_stack(Integer.parseInt(reader.readLine()));
                        System.out.println("Op1 stack");
                        tb.setOp1_stack(Integer.parseInt(reader.readLine()));
                        System.out.println("Op2 stack");
                        tb.setOp2_stack(Integer.parseInt(reader.readLine()));
                        System.out.println("Op1 act");
                        tb.setOp1_action(Integer.parseInt(reader.readLine()));
                        System.out.println("Op2 act");
                        tb.setOp2_action(Integer.parseInt(reader.readLine()));
                        tables.put(tmp, tb);
                    } else {

                    }
                }

            }

        }


    /*public static int Action(Table tb) {
        switch (tb.getStage()) {
            case 0:                                    //preflop
                switch (tb.last_action) {
                case 0:                                //last action - fold
                    switch (tb.getPosition()) {
                        case 0:                        //on button
                            if(Charts.check(Card.convertToKey(tb.getPocket()),0)) {tb.last_action=3; return 3;}
                            else {tb.last_action = 0; return 0;}
                        case 1:                        // on SB
                            switch (tb.getOp2_action())
                            {
                                case 0:
                                    if(Charts.check(Card.convertToKey(tb.getPocket()),0)) {tb.last_action=3; return 3;}
                                    else {tb.last_action = 0; return 0;}

                                case 2:
                                    if(Charts.check(Card.convertToKey(tb.getPocket()),0)) {tb.last_action=3; return 3;}
                                    else {tb.last_action = 0; return 0;}
                                case 3:
                                    if((Charts.check(Card.convertToKey(tb.getPocket()),2))&&(!Charts.check(Card.convertToKey(tb.getPocket()),3))) {tb.last_action=1; return 1;}
                                    else if(Charts.check(Card.convertToKey(tb.getPocket()),3)) {tb.last_action = 4; return 4;}
                                    else {tb.last_action = 0; return 0;}
                                case 4:
                                    if(Charts.check(Card.convertToKey(tb.getPocket()),10)){tb.last_action = 4; return 4;}
                                    else {tb.last_action = 0; return 0;}
                            }
                            break;
                        case 2:                           //on BB
                            if (tb.getOp1_action()==0){   // Button folds
                                switch (tb.getOp2_action()) {
                                    case 2:
                                        if (Charts.check(Card.convertToKey(tb.getPocket()),6)) {tb.last_action = 3; return 3;}
                                        else {tb.last_action=1; return 1;}

                                    case 3:
                                        if((Charts.check(Card.convertToKey(tb.getPocket()),8))&&(!Charts.check(Card.convertToKey(tb.getPocket()),9))) {tb.last_action = 2; return 2;}
                                        else if (Charts.check(Card.convertToKey(tb.getPocket()),9)) {tb.last_action = 4; return 4;}
                                        else {tb.last_action =0; return 0;}
                                    case 4:
                                        if(Charts.check(Card.convertToKey(tb.getPocket()),10)){tb.last_action = 4; return 4;}
                                        else {tb.last_action = 0; return 0;}
                                }
                            }
                            if ((tb.getOp1_action()==2)&& (tb.getOp2_action()==2)) {tb.last_action=1; return 1;} // button and sb calls
                            if (tb.getOp1_action()>2)                                                            //button raises
                            {
                                switch (tb.getOp2_action())
                                {
                                    case 0:
                                        if ((Charts.check(Card.convertToKey(tb.getPocket()),4))&&(!Charts.check(Card.convertToKey(tb.getPocket()),5))) {tb.last_action = 1; return 1;}
                                        else if (Charts.check(Card.convertToKey(tb.getPocket()),5)) {tb.last_action = 4; return 4;}
                                        else {tb.last_action= 0; return 0;}
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                        if (Charts.check(Card.convertToKey(tb.getPocket()),11)) {tb.last_action = 4; return 4;}
                                        else {tb.last_action = 0; return 0;}


                                }
                            }



                    }
            }
        }
        return 0;

    }*/

}
