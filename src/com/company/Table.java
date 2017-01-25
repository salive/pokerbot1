package com.company;

import java.util.ArrayList;

/**
 * Created by jchuprakov on 25.01.2017.
 */
public class Table {
    private int id;
    private int players_left;
    private int op1_stack, op2_stack, hero_stack;
    private int position;
    private ArrayList<Card> pocket;
    private Board board;
    private int BB;
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public Table() {

    }
    public void setPlayers_left(int players_left) {
        this.players_left = players_left;
    }
    public int getPlayers_left() {
        return players_left;
    }
    public int getOp1_stack() {
        return op1_stack;
    }
    public int getOp2_stack() {
        return op2_stack;

    }
    public void setOp1_stack(int op1_stack) {
        this.op1_stack = op1_stack;
    }
    public void setOp2_stack(int op2_stack) {
        this.op2_stack = op2_stack;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public ArrayList<Card> getPocket() {
        return pocket;
    }
    public Board getBoard() {
        return board;
    }
    public int getHero_stack() {
        return hero_stack;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public void setHero_stack(int hero_stack) {
        this.hero_stack = hero_stack;
    }
    public void setPocket(ArrayList<Card> pocket) {
        this.pocket = pocket;
    }
    public int getBB() {
        return BB;
    }
    public void setBB(int BB) {
        this.BB = BB;
    }

}

