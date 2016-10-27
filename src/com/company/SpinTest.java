package com.company;

/**
 * Created by jchuprakov on 25.10.2016.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
public class SpinTest {


    private static int pot, side_pot;
    public static int sb, bb;
    static String[] combs  = {"high card", "one pair", "two pair", "three of a kind", "straight", "flush",
            "full house", "four of a kind", "flush straight", "royal flush"};
    static String dealerPreflopAction = "", sbPreflopAction = "", bbPreflopAction = "";
    static int dealerStake=0, sbStake=0, bbStake=0, playersLeft=3;
    static boolean isDealerAllIn = false, isSbAllIn = false, isBBAllIn = false;
    public static boolean gameOver = false, split = false;
    public static int heroWinCount = 0;
        public SpinTest()
    {

    }

    public static Player getDealer()
    {
        if (Main.player1.getPosition() == 0) return Main.player1;
        else if (Main.player2.getPosition() == 0) return Main.player2;
        else return Main.player3;
    }

    public static Player getSB()
    {
        if (Main.player1.getPosition() == 1) return Main.player1;
        else if (Main.player2.getPosition() == 1) return Main.player2;
        else return Main.player3;
    }

    public static Player getBB()
    {
        if (Main.player1.getPosition() == 2) return Main.player1;
        else if (Main.player2.getPosition() == 2) return Main.player2;
        else return Main.player3;
    }


    public static void Round ()
    {


        Player lucky = new Player();
        while (!gameOver) {
            SpinTest.pot = 0;
            Player[] plArr;
            int pocketWeight = 0;
            switch (playersLeft) {
                case 3:
                    Main.player1.setPocket(Card.generate(), Card.generate());
                    Main.player2.setPocket(Card.generate(), Card.generate());
                    Main.player3.setPocket(Card.generate(), Card.generate());
                    Main.player1.hand = new Hand();
                    Main.player2.hand = new Hand();
                    Main.player3.hand = new Hand();

                    pocketWeight = Main.player1.getPocket().get(0).getRank() + Main.player1.getPocket().get(1).getRank();
                    plArr = new Player[3];
                    if ((pocketWeight >= 19)
                            || ((pocketWeight >= 20) && (Main.player1.getPocket().get(0).getSuit() == Main.player1.getPocket().get(1).getSuit()))
                            || ((pocketWeight >= 10) &&(Main.player1.getPocket().get(0).getRank() == Main.player1.getPocket().get(1).getRank())))
                    {
                        plArr = new Player[3];
                        plArr[0] = Main.player1;
                        plArr[1] = Main.player2;
                        plArr[2] = Main.player3;
                       // System.out.println("Hero raised");
                        if ((getDealer().getStack() <= getSB().getStack()) && (getDealer().getStack() <= getBB().getStack())) {
                            pot += ((3 * getDealer().getStack()));
                            getSB().setStack(-getDealer().getStack());
                            getBB().setStack(-getDealer().getStack());
                            getDealer().setStack(-getDealer().getStack());
                        } else if ((getSB().getStack() <= getDealer().getStack()) && (getSB().getStack() <= getBB().getStack())) {
                            pot += ((3 * getSB().getStack()));
                            getDealer().setStack(-getSB().getStack());
                            getBB().setStack(-getSB().getStack());
                            getSB().setStack(-getSB().getStack());
                        } else {
                            pot += ((3 * getBB().getStack()));
                            getSB().setStack(-getBB().getStack());
                            getDealer().setStack(-getBB().getStack());
                            getBB().setStack(-getBB().getStack());
                        }

                    } else {
                        plArr = new Player[2];
                        plArr[0] = Main.player2;
                        plArr[1] = Main.player3;
                        //System.out.println("Hero folded");
                    }
                    if (getSB().getStack() >= sb) {
                        getSB().setStack(-sb);
                        pot += sb;
                    } else {
                        pot += getSB().getStack();
                        getSB().setStackDirect(0);
                    }
                    if (getBB().getStack() >= bb) {
                        getBB().setStack(-bb);
                        pot += bb;
                    } else {
                        pot += getBB().getStack();
                        getBB().setStackDirect(0);
                    }

                    Board.addCards(Card.generate());
                    Board.addCards(Card.generate());
                    Board.addCards(Card.generate());
                    Board.addCards(Card.generate());
                    Board.addCards(Card.generate());
                    lucky = winner(plArr);
                    if(!split ) lucky.setStack(+pot);
                    else{
                        Main.player2.setStack((int)Math.round(pot/2));
                        Main.player3.setStack((int)Math.round(pot/2));
                        split = false;
                    }
                    //System.out.println("Winner is: " + lucky.name);

                   // System.out.println("Dealer is: " + getDealer().name);
                    //System.out.println("Board is: " + Board.getBoard());
                   // System.out.println("Player 1 hand is: " + Main.player1.getPocket());
                    //System.out.println("Player 1 combination is: " + combs[Main.player1.getComb()]);
                    //System.out.println("Player 2 hand is: " + Main.player2.getPocket());
                    //System.out.println("Player 2 combination is: " + combs[Main.player2.getComb()]);
                    //System.out.println("Player 3 hand is: " + Main.player3.getPocket());
                    //System.out.println("Player 3 combination is: " + combs[Main.player3.getComb()]);
                    //System.out.println("Player 1 stack is: " + Main.player1.getStack());
                    //System.out.println("Player 2 stack is: " + Main.player2.getStack());
                    //System.out.println("Player 3 stack is: " + Main.player3.getStack());
                    //System.out.println("Pot was: " + pot);
                   // System.out.println("_________________________________________________________");
                    Board.clearBoard();
                    Main.deck.fill();
                    if (Main.player1.getPosition() != 0) Main.player1.setPosition(Main.player1.getPosition() - 1);
                    else Main.player1.setPosition(2);
                    if (Main.player2.getPosition() != 0) Main.player2.setPosition(Main.player2.getPosition() - 1);
                    else Main.player2.setPosition(2);
                    if (Main.player3.getPosition() != 0) Main.player3.setPosition(Main.player3.getPosition() - 1);
                    else Main.player3.setPosition(2);
                    break;
                case 2:

                    if (Main.player2.lose) {
                        if (Main.player1.getPosition() != 0) {
                            Main.player1.setPosition(0);
                            Main.player3.setPosition(1);
                        } else {
                            Main.player1.setPosition(1);
                            Main.player3.setPosition(0);
                        }
                        Main.player1.setPocket(Card.generate(), Card.generate());
                        Main.player3.setPocket(Card.generate(), Card.generate());
                        Main.player1.hand = new Hand();
                        Main.player3.hand = new Hand();
                        pocketWeight = Main.player1.getPocket().get(0).getRank() + Main.player1.getPocket().get(1).getRank();
                        plArr = new Player[2];
                        plArr[0] = Main.player1;
                        plArr[1] = Main.player3;
                        if (getSB().getStack() >= sb) {
                            getSB().setStack(-sb);
                            pot += sb;
                        } else {
                            pot += getSB().getStack();
                            getSB().setStackDirect(0);
                        }
                        if (getDealer().getStack() >= bb) {
                            getDealer().setStack(-bb);
                            pot += bb;
                        } else {
                            pot += getDealer().getStack();
                            getDealer().setStackDirect(0);
                        }
                        if ((pocketWeight >= 14)
                                ||
                                ((pocketWeight >= 12) && (Main.player1.getPocket().get(0).getSuit() == Main.player1.getPocket().get(1).getSuit()))
                                ||
                                (Main.player1.getPocket().get(0).getRank() == Main.player1.getPocket().get(1).getRank())) {

                           // System.out.println("Hero raised");
                            if (getDealer().getStack() <= getSB().getStack()) {
                                pot += ((2 * getDealer().getStack()));
                                getSB().setStack(-getDealer().getStack());
                                getDealer().setStack(-getDealer().getStack());
                            } else {
                                pot += ((2 * getSB().getStack()));
                                getDealer().setStack(-getSB().getStack());
                                getSB().setStack(-getSB().getStack());
                            }
                            if (getSB().getStack() >= sb) {
                                getSB().setStack(-sb);
                                pot += sb;
                            } else {
                                pot += getSB().getStack();
                                getSB().setStackDirect(0);
                            }
                            Board.addCards(Card.generate());
                            Board.addCards(Card.generate());
                            Board.addCards(Card.generate());
                            Board.addCards(Card.generate());
                            Board.addCards(Card.generate());
                            lucky = winner(plArr);
                            if(!split)
                                lucky.setStack(+pot);
                            else{
                                Main.player1.setStack((int)Math.round(pot/2));
                                Main.player2.setStack((int)Math.round(pot/2));
                                split = false;
                            }
                           // System.out.println("Winner is: " + lucky.name);

                            //System.out.println("Dealer is: " + getDealer().name);
                           // System.out.println("Board is: " + Board.getBoard());
                           // System.out.println(Main.player1.name + " hand is: " + Main.player1.getPocket());
                           // System.out.println(Main.player1.name + " combination is: " + combs[Main.player1.getComb()]);
                            //System.out.println(Main.player3.name + " hand is: " + Main.player3.getPocket());
                           // System.out.println(Main.player3.name + " combination is: " + combs[Main.player3.getComb()]);
                            Board.clearBoard();
                            Main.deck.fill();

                        }


                        else {Main.player2.setStack(+pot); }
                        //System.out.println(Main.player1.name + " stack is: " + Main.player1.getStack());
                        //System.out.println(Main.player3.name + " stack is: " + Main.player3.getStack());
                        //System.out.println("_________________________________________________________");


                    } else {
                        if (Main.player1.getPosition() != 0) {
                            Main.player1.setPosition(0);
                            Main.player2.setPosition(1);
                        } else {
                            Main.player1.setPosition(1);
                            Main.player2.setPosition(0);
                        }
                        Main.player1.setPocket(Card.generate(), Card.generate());
                        Main.player2.setPocket(Card.generate(), Card.generate());
                        Main.player1.hand = new Hand();
                        Main.player2.hand = new Hand();
                        plArr = new Player[2];
                        plArr[0] = Main.player1;
                        plArr[1] = Main.player2;
                        if (getSB().getStack() >= sb) {
                            getSB().setStack(-sb);
                            pot += sb;
                        } else {
                            pot += getSB().getStack();
                            getSB().setStackDirect(0);
                        }
                        if (getDealer().getStack() >= bb) {
                            getDealer().setStack(-bb);
                            pot += bb;
                        } else {
                            pot += getDealer().getStack();
                            getDealer().setStackDirect(0);
                        }
                        pocketWeight = Main.player1.getPocket().get(0).getRank() + Main.player1.getPocket().get(1).getRank();
                        if ((pocketWeight >= 14)
                                ||
                                ((pocketWeight >= 12) && (Main.player1.getPocket().get(0).getSuit() == Main.player1.getPocket().get(1).getSuit()))
                                ||
                                (Main.player1.getPocket().get(0).getRank() == Main.player1.getPocket().get(1).getRank())) {

                            //System.out.println("Hero raised");
                            if (getDealer().getStack() <= getSB().getStack()) {
                                pot += ((2 * getDealer().getStack()));
                                getSB().setStack(-getDealer().getStack());
                                getDealer().setStack(-getDealer().getStack());
                            } else {
                                pot += ((2 * getSB().getStack()));
                                getDealer().setStack(-getSB().getStack());
                                getSB().setStack(-getSB().getStack());
                            }

                            Board.addCards(Card.generate());
                            Board.addCards(Card.generate());
                            Board.addCards(Card.generate());
                            Board.addCards(Card.generate());
                            Board.addCards(Card.generate());
                            lucky = winner(plArr);
                            //System.out.println("Winner is: " + lucky.name);
                            if(!split)
                                lucky.setStack(+pot);
                            else{
                                Main.player1.setStack((int)Math.round(pot/2));
                                Main.player2.setStack((int)Math.round(pot/2));
                                split = false;
                            }
                           // System.out.println("Dealer is: " + getDealer().name);
                           // System.out.println("Board is: " + Board.getBoard());
                           // System.out.println(Main.player1.name + " hand is: " + Main.player1.getPocket());
                           // System.out.println(Main.player1.name + " combination is: " + combs[Main.player1.getComb()]);
                            //System.out.println(Main.player2.name + " hand is: " + Main.player2.getPocket());
                            //System.out.println(Main.player2.name + " combination is: " + combs[Main.player2.getComb()]);
                            Board.clearBoard();
                            Main.deck.fill();



                        }

                        else {Main.player2.setStack(+pot);}
                        //System.out.println(Main.player1.name + " stack is: " + Main.player1.getStack());
                        //System.out.println(Main.player2.name + " stack is: " + Main.player2.getStack());
                        //System.out.println("_________________________________________________________");
                    }

                    break;

            }
            Main.deck.fill();

            if (Main.player1.getStack() <= 0) {
                gameOver = true;
               // System.out.println("Game over");
                Main.player1.lose = true;
            }
            if ((Main.player2.getStack() <= 0) && (!Main.player2.lose)) {
                playersLeft -= 1;
                Main.player2.lose = true;
                //System.out.println("Player2 eliminated");
            }
            if ((Main.player3.getStack() <= 0) && (!Main.player3.lose)) {
                playersLeft -= 1;
                Main.player3.lose = true;
                //System.out.println("Player3 eliminated");
            }
            if (playersLeft == 1) {
                gameOver = true;
                heroWinCount += 1;
                //System.out.println("Hero wins");
            }
        }

            Main.player1.setStackDirect(500);
            Main.player2.setStackDirect(500);
            Main.player3.setStackDirect(500);
            SpinTest.playersLeft = 3;
            Main.player2.lose = false;
            Main.player3.lose = false;
            gameOver = false;
            Main.deck.fill();



    }

    private static Player winner(Player args[])
    {

        switch (args.length) {
            case 2:

                args[0].hand.addAll(args[0].getPocket());
                args[0].hand.addAll(Board.getBoard());
                args[0].setComb(HandEval.evaluate(args[0].hand));
                args[0].setHandval(HandEval.bestHand.getWeight());

                args[1].hand.addAll(args[1].getPocket());
                args[1].hand.addAll(Board.getBoard());
                args[1].setComb(HandEval.evaluate(args[1].hand));
                args[1].setHandval(HandEval.bestHand.getWeight());

                if (args[0].getComb() > args[1].getComb()) return args[0];
                else if (args[0].getComb() < args[1].getComb()) return args[1];
                else {
                if (args[0].getHandval() > args[1].getHandval()) return args[0];
                if (args[0].getHandval() < args[1].getHandval()) return args[1];
                if (args[0].getHandval() == args[1].getHandval()) { split= true;return args[0];};
                }
            case 3:

        }

                args[0].hand.addAll(args[0].getPocket());
                args[0].hand.addAll(Board.getBoard());
                args[0].setComb(HandEval.evaluate(args[0].hand));
                args[0].setHandval(HandEval.bestHand.getWeight());

                args[1].hand.addAll(args[1].getPocket());
                args[1].hand.addAll(Board.getBoard());
                args[1].setComb(HandEval.evaluate(args[1].hand));
                args[1].setHandval(HandEval.bestHand.getWeight());

                args[2].hand.addAll(args[2].getPocket());
                args[2].hand.addAll(Board.getBoard());
                args[2].setComb(HandEval.evaluate(args[2].hand));
                args[2].setHandval(HandEval.bestHand.getWeight());
                if ((args[0].getComb() > args[1].getComb() && (args[0].getComb() > args[2].getComb()))) return args[0];
                else if ((args[1].getComb() > args[2].getComb() && (args[1].getComb() > args[0].getComb()))) return args[1];
                else if ((args[2].getComb() > args[1].getComb() && (args[2].getComb() > args[0].getComb()))) return args[2];

                else if ((args[0].getComb() > args[1].getComb() && (args[0].getComb() == args[2].getComb()))) {
                    if (args[0].getHandval() > args[2].getHandval()) return args[0];
                    if (args[0].getHandval() <= args[2].getHandval()) return args[2];

                }
                else if ((args[1].getComb() > args[0].getComb() && (args[1].getComb() == args[2].getComb()))) {
                    if (args[1].getHandval() > args[2].getHandval()) return args[1];
                    if (args[1].getHandval() <= args[2].getHandval()) return args[2];

                }
                else if ((args[0].getComb() > args[2].getComb() && (args[0].getComb() == args[1].getComb()))) {
                    if (args[0].getHandval() > args[1].getHandval()) return args[0];
                    if (args[0].getHandval() <= args[1].getHandval()) return args[1];

                }
                else if ((args[0].getComb() == args[2].getComb() && (args[0].getComb() == args[1].getComb()))) {
                    if ((args[0].getHandval() > args[1].getHandval()) && ((args[0].getHandval() > args[2].getHandval()))) return args[0];
                    if ((args[1].getHandval() > args[0].getHandval()) && ((args[1].getHandval() > args[2].getHandval()))) return args[1];
                    if ((args[2].getHandval() > args[1].getHandval()) && ((args[2].getHandval() > args[0].getHandval()))) return args[2];

                }

                return args[0];

    }


}

