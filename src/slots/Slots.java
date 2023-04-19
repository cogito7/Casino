/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slots;

import casino.Player;
import static constants.Constants.BET;
import static constants.Constants.SLOTS;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author TheMy
 */
public class Slots {
    
    private final int SLOTS = 3;
    private final char SYMBOLS[] = {'$', '%', '&', '#', '@', '!'};
    private char spins[] = new char[3];
    private Random rand;
    private Player player;
    private boolean play;
    private Scanner scnr;
    
    public Slots(Player player) {
        this.player = player;
        scnr = new Scanner(System.in);
        play = true;
        rand = new Random();  
        
    }
    
    public void play() {
        int input = 0;
        int currentCash;
        int i;
        System.out.println("Let's play the slot machines!");
        System.out.println("Your cash balance is $" + player.getCash());
        System.out.println("The bet is $5");
        System.out.println("Match two symbols to win $5");
        System.out.println("Match all three symbols to win $50");
        
       
        if (player.getCash() < BET) {
            System.out.println("Not enough cash to play.");
            play = false;
        }
        
        while(play == true) {
            currentCash = player.getCash();
            player.setCash(currentCash - BET);
            System.out.println("Spinning...");
            
            for (i = 0; i < SLOTS; i++)
            {
                spins[i] = randomSymbol();
                System.out.print(spins[i] + " ");
            }
            System.out.println();
            
            if (spins[0] == spins[1] && spins[1] == spins[2]) {
                System.out.println("Three symbols matched, you won $50!");
                currentCash = player.getCash();
                player.setCash(currentCash + 50);
            } 
            else if (spins[0] == spins[1] || spins[1] == spins[2] || spins[0] == spins[2]) {
                System.out.println("Two symbols matched, you won $5!");
                currentCash = player.getCash();
                player.setCash(currentCash + 5);               
            }
            else {
                // you lose
                System.out.println("None of the symbols matched. You win $0!");
            }
            
            // game is done
            System.out.println("CASH = $" + player.getCash());

            if (player.getCash() < BET) {
                System.out.println("You are out of cash, you cannot play");
                play = false;
            }
            else{
                System.out.println("Would you like to spin again (Yes = 1, No = 0)?");
                input = scnr.nextInt();
                if (input == 1) {
                    play = true;
                }
                else{
                    play = false;
                    break;
                }
            }

        }
        
        System.out.println("Thank you for playing slots at Knights Casino! Your cash out is $" + player.getCash());
    }
    
    private char randomSymbol() {
    int num;
    char symbol = ' ';
    num = rand.nextInt(SYMBOLS.length);
    
    //checking through array of symbols for matches
    switch(num)
    {
        case 0: 
            symbol = SYMBOLS[0];
            break;
        case 1:
            symbol = SYMBOLS[1];
            break;
        case 2:
            symbol = SYMBOLS[2];
            break;
        case 3:
            symbol = SYMBOLS[3];
            break;
        case 4:
            symbol = SYMBOLS[4];
            break;
        case 5:
            symbol = SYMBOLS[5];
            break;
            
    }
    return symbol;
    
            
}
}
