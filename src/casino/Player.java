/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import blackjack.Card;
import constants.Constants;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TheMy
 */
public class Player implements IPlayer {
    
    //CASINO 4 member variables
    private ArrayList<Card> hand;

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    private int score;

    public int getScore() {
        score = 0;
        int i;
        for (i = 0; i < hand.size(); i++)
            {
               score += hand.get(i).getValue(); 
                
            }
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    private boolean busted;

    public boolean isBusted() {
        return busted;
    }

    public void setBusted(boolean busted) {
        this.busted = busted;
    }
    private boolean play;

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }
     private Scanner scnr;
    public boolean playAgain() {
        System.out.println("Do you want to play again?");
       
        scnr = new Scanner(System.in);
        int choice;
        choice = scnr.nextInt();
        
        if (choice == 1) {
            return true;
        }
        else {
            return false;
        }
    }
    //previous Casino member variables

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
    private int cash;
    private Scanner scan;
    /*
    public Player() {
        scan = new Scanner(System.in);
        String name;
        int money;
        System.out.println("Enter player name");
        name = scan.next();
        System.out.println("Enter cash to play (minimum $10)");
        money = scan.nextInt();
        setName(name);
        setCash(money);
    }
*/
    
    public int hitOrStand() {  
    System.out.println("Do you want to hit (1) or stand (0)?");
        scnr = new Scanner(System.in);
        int choice;
        choice = scnr.nextInt();
        if (choice == Constants.HIT){
            return Constants.HIT;
    }
        else {
            return Constants.STAND;
        }
}
}
