/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchoffs;

import casino.Player;
import constants.Constants;
import static constants.Constants.FIVE_DOLLAR;
import static constants.Constants.ONE_DOLLAR;
import static constants.Constants.TEN_DOLLAR;
import java.util.Scanner;

/**
 *
 * @author TheMy
 */
public class ScratchOffs {

    private Player player;
    private OneDollar one;
    private FiveDollar five;
    private TenDollar ten;
    boolean play;
    private Scanner scan;

    public ScratchOffs(Player player) {
        this.player = player;
        play = true;
        scan = new Scanner(System.in);

    }

    public void play() {
        int type;
        int quantity;
        int input;
        System.out.println("Let's play scratch off tickets!");
        System.out.println("Players can select from One Dollar, Five Dollar, and Ten Dollar tickets");
        System.out.println("Prizes are based on the ticket selected");

        if (player.getCash() < ONE_DOLLAR) {
            System.out.println("Player does not have enough cash to play");
            play = false;
        }
        while (play) {
            System.out.println("Which type of scratch off would you like (1 = One Dollar, 5 = Five Dollar, 10 = Ten Dollar)?");
            type = scan.nextInt();
            System.out.println("How many scratch offs would you like?");
            quantity = scan.nextInt();
            System.out.println("Getting your scratch offs...");
            for (int i = 0; i < quantity; i++) {
                switch (type) {
                    case ONE_DOLLAR:
                        player.setCash(player.getCash() - ONE_DOLLAR);
                        one = new OneDollar(player);
                        break;
                    case FIVE_DOLLAR:
                        player.setCash(player.getCash() - FIVE_DOLLAR);
                        five = new FiveDollar(player);
                        break;
                    case TEN_DOLLAR:
                        player.setCash(player.getCash() - TEN_DOLLAR);
                        ten = new TenDollar(player);
                        break;

                }
            }
            System.out.println("CASH = $" + player.getCash());
            if (player.getCash() >= ONE_DOLLAR) {
                System.out.println("Do you want to play again (Yes = 1, No = 0)?");
                input = scan.nextInt();
                if (input == 1) {
                    play = true;
                }
                else{
                    play = false;
                }
            }else{
                break;
            }
        }
        System.out.println("CASH = $" + player.getCash());

    }

}
