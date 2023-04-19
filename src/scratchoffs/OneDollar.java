/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchoffs;

import casino.Player;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author TheMy
 */
public class OneDollar {

    char winningBonus;
    ArrayList<Integer> winningNumbers;
    ArrayList<Integer> playerNumbers;
    ArrayList<Double> prizes;
    ArrayList<Character> bonus;
    Player player;
    Random rand;
    final char SYMBOLS[] = {'$', '%', '&', '#', '@', '!'};
    char BONUS_SYMBOL = '!';
    int BASE = 20;
    int NUMS = 5;
    int SYMS = 2;
    String NAME = "One Dollar";
    double BONUS = 10.00;
    int WINNING_NUMBERS = 1;
    
    public OneDollar(){
        
    }
    
    public OneDollar(Player player) {
        this.player = player;
        rand = new Random();
        createTicket();
        displayTicket();
        cashTicket();

    }

    private int randomNumber() {
        int result;
        result = rand.nextInt(BASE);
        return result;
    }

    private double randomPrize() {
        double result;
        result = (double) (rand.nextInt(BASE) + 1);
        return result;
    }

    private char randomSymbol() {
        int num;
        char symbol;
        num = rand.nextInt(SYMBOLS.length);
        //switch for {'$', '%', '&', '#', '@', '!'};
        switch (num) {
            case 0:
                symbol = '$';
                break;
            case 1:
                symbol = '%';
                break;
            case 2:
                symbol = '&';
                break;
            case 3:
                symbol = '#';
                break;
            case 4:
                symbol = '@';
                break;
            case 5:
                symbol = '!';
                break;
            default:
                symbol = ' ';
        }
        return symbol;

    }

    void createTicket() {
        winningNumbers = new ArrayList<Integer>();
        for (int i = 0; i < WINNING_NUMBERS; i++){
            winningNumbers.add(randomNumber());
        }
        winningBonus = randomSymbol();
        playerNumbers = new ArrayList<Integer>();
        prizes = new ArrayList<Double>();
        bonus = new ArrayList<Character>();
        for (int i = 0; i < NUMS; i++) {
            playerNumbers.add(randomNumber());
            prizes.add(randomPrize());

        }
        for (int i = 0; i < SYMS; i++) {
            bonus.add(randomSymbol());

        }
    }

    void displayTicket() {
        System.out.println("+-----------------------------------------------------+");
        System.out.println("| WINNING NUMBER        " + winningNumbers.get(0) + "                \t\t|");
        System.out.println("|                                                       |");
        System.out.println("| YOUR NUMBERS                                          |");
        System.out.println("|      " + playerNumbers.get(0) + "  " + playerNumbers.get(1) + "  " + playerNumbers.get(2) + "  " + playerNumbers.get(3) + "  " + playerNumbers.get(4) + "          \t\t\t|");
        System.out.println("|                                                       |");
        System.out.println("| PRIZES                                                |");
        System.out.println("|      " + prizes.get(0) + "  " + prizes.get(1) + "  " + prizes.get(2) + "  " + prizes.get(3) + "  " + prizes.get(4) + "          \t\t|");
        System.out.println("|                                                \t|");
        System.out.println("| SYMBOLS                                        \t|");
        System.out.println("|                                                \t|");
        System.out.println("|        " + bonus.get(0) + "      " + bonus.get(1) + "                                \t|");
        System.out.println("+----------------------------------------------------+");

    }
    void cashTicket() {
        int cash = 0;
        System.out.println("Bonus symbol is "+BONUS_SYMBOL);
        System.out.println("Bonus is worth $"+BONUS);
        for(int i = 0; i < playerNumbers.size(); i++){
            for (int j = 0; j < winningNumbers.size(); j++) {
                if (playerNumbers.get(i) == winningNumbers.get(j)) {
                    cash += prizes.get(i);
                    break;
                }
            }
        }
        for(int i = 0; i < bonus.size(); i++){
            if (bonus.get(i) == BONUS_SYMBOL) {
                cash += BONUS;
            }
        }
        System.out.println("Your " + NAME + " Scratch Off won you $" + cash);
        player.setCash(player.getCash()+cash);
    }
}
