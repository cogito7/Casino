/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchoffs;

import casino.Player;
import java.util.Random;

/**
 *
 * @author TheMy
 */
public class FiveDollar extends OneDollar {

    public FiveDollar(Player player) {
        NAME="Five Dollar";
        BONUS_SYMBOL = '$';
        BASE = 40;
        NUMS = 10;
        SYMS = 2;
        BONUS = 20.00;
        WINNING_NUMBERS = 2;
        this.player = player;
        rand = new Random();
        createTicket();
        displayTicket();
        cashTicket();
    }
    void displayTicket() {
        System.out.println("+-----------------------------------------------------+");
        System.out.println("| WINNING NUMBER        " + winningNumbers.get(0) + "    " + winningNumbers.get(1) + "     \t\t\t|");
        System.out.println("|                                                       |");
        System.out.println("| YOUR NUMBERS                                          |");
        System.out.println("|      " + playerNumbers.get(0) + "  " + playerNumbers.get(1) + "  " + playerNumbers.get(2) + "  " + playerNumbers.get(3) + "  " + playerNumbers.get(4) + "   \t\t\t\t|");
        System.out.println("|      " + playerNumbers.get(5) + "  " + playerNumbers.get(6) + "  " + playerNumbers.get(7) + "  " + playerNumbers.get(8) + "  " + playerNumbers.get(9) + "\t\t\t\t|");
        System.out.println("|                                                       |");
        System.out.println("| PRIZES                                                |");
        System.out.println("|      " + prizes.get(0) + "  " + prizes.get(1) + "  " + prizes.get(2) + "  " + prizes.get(3) + "  " + prizes.get(4) + "\t\t\t|");
        System.out.println("|      " + prizes.get(5) + "  " + prizes.get(6) + "  " + prizes.get(7) + "  " + prizes.get(8) + "  " + prizes.get(9) + "\t\t\t|");
        System.out.println("|                                      \t\t\t|");
        System.out.println("| SYMBOLS                              \t\t\t|");
        System.out.println("|                                      \t\t\t|");
        System.out.println("|        " + bonus.get(0) + "      " + bonus.get(1) + "                      \t\t\t|");
        System.out.println("+-----------------------------------------------------+");

    }
}
