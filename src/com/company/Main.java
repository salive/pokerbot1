package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.HashMap;


public class Main {

    public static Hand hand = new Hand();
    public static Deck deck = new Deck();
    public static boolean isFlopSet = false, isPocketSet = false, isTurnSet = false, isRiverSet = false;
    public static Player player1 = new Player("Hero");
    public static Player player2 = new Player("player2");
    public static Player player3 = new Player("player3");
    public static HashMap<Integer, ArrayList<Integer>> tables = new HashMap<Integer, ArrayList<Integer>>();
    public static void main(String[] args) throws Exception
    {
        String[] combs  = {"high card", "one pair", "two pair", "three of a kind", "full house", "straight",
                "flush", "four of a kind", "flush straight", "royal flush"};
        String[] stages = {"preflop", "flop", "turn", "river"};
        String[] positions = {"EP", "MP", "LP"};
        Date d1, d2;
        long db1, db2;





    }

}
