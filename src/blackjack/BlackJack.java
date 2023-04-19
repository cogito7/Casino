/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import casino.Player;
import java.util.Scanner;
import constants.Constants;
import static constants.Constants.*;
import java.util.ArrayList;

/**
 *
 * @author TheMy
 */
public class BlackJack {

    private Player player;
    private boolean play;
    private Scanner scnr;
    private Deck deck;

    //member variables for Casino 4
    private Dealer dealer;
    private Card card;

    public BlackJack(Player player) {
        this.player = player;
        this.scnr = new Scanner(System.in);
        this.play = true;
        this.deck = new Deck();
        this.dealer = new Dealer();
        this.card = new Card();

    }

    public void play() {
        displayRules();
        if (player.getCash() < Constants.BET) {
            System.out.println("Not enough cash to play");
            play = false;
        }
        while (play == true) {
            System.out.println("Your cash balance is $" + player.getCash());
            if (player.getCash() < Constants.BET) {
                System.out.println("Not enough cash to play");
                play = false;
                break;
            }
            player.setCash(player.getCash() - BET);
            System.out.println("The cards are being dealt");
                player.setHand(new ArrayList<Card>());
                player.setScore(Constants.ZERO);
                player.setBusted(false);
                dealer.setHand(new ArrayList<Card>());
                dealer.setScore(Constants.ZERO);
                int i;
                for (i = 0; i < 2; i++) {
                    card = dealer.deal(deck);
                    player.getHand().add(card);

                }
                   System.out.println("Player's score " + player.getScore());
                while (player.hitOrStand() == Constants.HIT) {
                    card = dealer.deal(deck);
                    player.getHand().add(card);
                    System.out.println("Player's score " + player.getScore());
                    if (player.getScore() > Constants.BUST) {
                    System.out.println("Player busted! You lost the hand.");
                    player.setBusted(true);
                    break;
                }

            }
            if (player.isBusted()) {
                play = player.playAgain();
            } else {
                System.out.println("Dealer's score " + dealer.getScore());
                while (dealer.hitOrStand() == Constants.HIT) {
                    card = dealer.deal(deck);
                    dealer.getHand().add(card);
                    System.out.println("Dealer's score " + dealer.getScore());

                    if (dealer.getScore() > Constants.BUST) {
                        System.out.println("Dealer busted!");

                        break;
                    }
                }
                results();
                play = player.playAgain();

            }
        }
    }

    private void results() {
        System.out.println("Player's score " + player.getScore());
        System.out.println("Dealer's score " + dealer.getScore());
        if (dealer.getScore() > Constants.BUST) {
            System.out.println("Dealer busted! Player wins $10");
            player.setCash(player.getCash() + 10);
        } else if (dealer.getScore() == player.getScore()) {
            System.out.println("It was a push! Player wins $10!");
            player.setCash(player.getCash() + 10);
        } else if (player.getScore() > dealer.getScore()) {
            System.out.println("Player WINS! Player wins $20!");
            player.setCash(player.getCash() + 20);
        } else {
            System.out.println("Dealer WINS!");
        }

    }

    private void displayRules() {
        System.out.println("Let's play Black Jack!");
        System.out.println("Your cash balance is $" + player.getCash());
        System.out.println("The bet is $" + BET);
        System.out.println("Dealer must HIT if their score is 16 or less");
        System.out.println("Dealer must STAND if their score is 17 or higher");
        System.out.println("If the player wins the hand, they receive $" + WIN);
        System.out.println("If the dealer wins the hand, the $" + BET + " bet is lost");
        System.out.println("If it is a PUSH, the player keeps their $" + BET + " bet");

    }
}
