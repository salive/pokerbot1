package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class Main {

    public static Hand hand = new Hand();
    public static Deck deck = new Deck();
    public static boolean isFlopSet = false, isPocketSet = false, isTurnSet = false, isRiverSet = false;
    public static Player player1 = new Player("Hero");
    public static Player player2 = new Player("player2");
    public static Player player3 = new Player("player3");
    public static void main(String[] args) throws Exception
    {
        String[] combs  = {"high card", "one pair", "two pair", "three of a kind", "full house", "straight",
                "flush", "four of a kind", "flush straight", "royal flush"};
        String[] stages = {"preflop", "flop", "turn", "river"};
        String[] positions = {"EP", "MP", "LP"};
        Date d1, d2;
        long db1, db2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random randomGenerator = new Random();
        String s;

        Main.player1.setStack(500);
        Main.player2.setStack(500);
        Main.player3.setStack(500);
        Main.player1.setPosition(1);
        Main.player2.setPosition(2);
        Main.player3.setPosition(0);

            SpinTest.sb = 10;
            SpinTest.bb = 20;
            int iters = 1000;
                double p;
                d1 = new Date();
                db1 = d1.getTime();
                for (int i=1;i<iters+1; i++) {
                    SpinTest.Round();


                    if (iters/i==50) System.out.println("50%");


                }
                d2 = new Date();
                db2 = d2.getTime();
                double percent = (SpinTest.heroWinCount*100/iters);
                System.out.println(SpinTest.heroWinCount);
                System.out.println(percent);
                System.out.println("Турниров x2: "+SpinTest.x2count);
                System.out.println("Турниров x4: "+SpinTest.x4count);
                System.out.println("Турниров x6: "+SpinTest.x6count);
                System.out.println("Турниров x10: "+SpinTest.x10count);
                System.out.println("Турниров x25: "+SpinTest.x25count);
                System.out.println("Турниров x120: "+SpinTest.x120count);
                System.out.println("Турниров x250: "+SpinTest.x250count);
                System.out.println("Турниров x12000: "+SpinTest.x12000count);

                System.out.println("Bankroll: "+SpinTest.bankroll);

                System.out.println("Biggest streak was: "+SpinTest.biggestStreak);

                System.out.println(db2-db1);


            //}
            //if (s.equals("exit")) break;
            //if (s.equals("cl"))
            //{
            //    Main.player1.setStackDirect(500);
              //  Main.player2.setStackDirect(500);
                //Main.player3.setStackDirect(500);
                //SpinTest.playersLeft = 3;
                //player2.lose = false;
               // player3.lose = false;

          //  }


    }
}
