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
public class TenDollar extends OneDollar {

    public TenDollar(Player player) {
        NAME = "Ten Dollar";
        BONUS_SYMBOL = '&';
        BASE = 60;
        NUMS = 15;
        SYMS = 4;
        BONUS = 30.00;
        WINNING_NUMBERS = 4;
        this.player = player;
        rand = new Random();
        createTicket();
        displayTicket();
        cashTicket();
    }

    void displayTicket() {
        System.out.println("+-----------------------------------------------------+");
        System.out.println("| WINNING NUMBER        " + winningNumbers.get(0) + "    " + winningNumbers.get(1) + "  " + winningNumbers.get(2) + "  " + winningNumbers.get(3) + "\t\t|");
        System.out.println("|                                      \t\t\t|");
        System.out.println("| YOUR NUMBERS                         \t\t\t|");
        System.out.println("|\t" + playerNumbers.get(0) + "\t" + playerNumbers.get(1) + "\t" + playerNumbers.get(2) + "\t" + playerNumbers.get(3) + "\t" + playerNumbers.get(4) + "\t\t|");
        System.out.println("|\t" + playerNumbers.get(5) + "\t" + playerNumbers.get(6) + "\t" + playerNumbers.get(7) + "\t" + playerNumbers.get(8) + "\t" + playerNumbers.get(9) + "\t\t|");
        System.out.println("|\t" + playerNumbers.get(10) + "\t" + playerNumbers.get(11) + "\t" + playerNumbers.get(12) + "\t" + playerNumbers.get(13) + "\t" + playerNumbers.get(14) + "\t\t|");
        System.out.println("|                                                     \t|");
        System.out.println("| PRIZES                                              \t|");
        System.out.println("|      " + prizes.get(0) + "  " + prizes.get(1) + "  " + prizes.get(2) + "  " + prizes.get(3) + "  " + prizes.get(4) + "\t\t\t|");
        System.out.println("|      " + prizes.get(5) + "  " + prizes.get(6) + "  " + prizes.get(7) + "  " + prizes.get(8) + "  " + prizes.get(9) + "\t\t\t|");
        System.out.println("|      " + prizes.get(10) + "  " + prizes.get(11) + "  " + prizes.get(12) + "  " + prizes.get(13) + "  " + prizes.get(14) + "\t\t\t|");
        System.out.println("|                                          \t\t|");
        System.out.println("| SYMBOLS                                  \t\t|");
        System.out.println("|                                          \t\t|");
        System.out.println("|\t" + bonus.get(0) + "\t" + bonus.get(1) + "\t" + bonus.get(2) + "\t" + bonus.get(3) + "                \t|");
        System.out.println("+-----------------------------------------------------+");

    }
}
