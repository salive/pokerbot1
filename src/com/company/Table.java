package com.company;

import java.util.ArrayList;

/**
 * Created by jchuprakov on 25.01.2017.
 */
public class Table {
    private int id;
    private int stage;
    private int players_left;
    private int op1_stack, op2_stack, hero_stack, op1_action, op2_action;
    private int position;
    private ArrayList<Card> pocket;
    private Board board;
    private int BB;
    private int pot;
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public int last_action;
    public Table() {
        last_action = 0;
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
    public int getPot() {        return pot;
    }
    public void setPot(int pot) {
        this.pot = pot;
    }
    public int getStage() {
        return stage;
    }
    public void setStage(int stage) {
        this.stage = stage;
    }
    public int getOp1_action() {
        return op1_action;
    }
    public int getOp2_action() {
        return op2_action;
    }
    public void setOp1_action(int op1_action) {
        this.op1_action = op1_action;
    }
    public void setOp2_action(int op2_action) {
        this.op2_action = op2_action;
    }
}

