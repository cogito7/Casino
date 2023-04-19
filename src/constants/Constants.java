/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author TheMy
 */
public class Constants {

    public enum Color {
        RED,
        BLACK
    };
        public enum Cards {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES 
    };
        public enum Face {
        TWO,
        THREE,
        FOUR,
        FIVE, 
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    };
    
    public static final int BLACK_JACK = 1;
    public static final int SCRATCH = 2;
    public static final int SLOTS = 3;
    public static final int BET = 5;
    public static final int PAIR_PAYOUT = 5;
    public static final int TRIPLE_PAYOUT = 50;
    public static final int WIN = 20;
    public static final int STANDARD = 52;
    public static final Color RED = Color.RED;
    public static final Color BLACK = Color.BLACK;
    public static final Cards CLUBS = Cards.CLUBS;
    public static final Cards DIAMONDS = Cards.DIAMONDS;
    public static final Cards HEARTS = Cards.HEARTS;
    public static final Cards SPADES = Cards.SPADES;
    public static final Face TWO = Face.TWO;
    public static final Face THREE = Face.THREE;
    public static final Face FOUR = Face.FOUR;
    public static final Face FIVE = Face.FIVE;
    public static final Face SIX = Face.SIX;
    public static final Face SEVEN = Face.SEVEN;
    public static final Face EIGHT = Face.EIGHT;
    public static final Face NINE = Face.NINE;
    public static final Face TEN = Face.TEN;
    public static final Face JACK = Face.JACK;
    public static final Face QUEEN = Face.QUEEN;
    public static final Face KING = Face.KING;
    public static final Face ACE = Face.ACE;
    //Casino 4 Constants
    public static final int HIT = 1;
    public static final int STAND = 0;
    public static final int DEALER_HIT = 16;
    public static final int DEALER_STAND = 17;
    public static final int ZERO = 0;
    public static final int BUST = 21;
    //Casino 5 Constants
    public static final int ONE_DOLLAR = 1;
    public static final int FIVE_DOLLAR = 5;
    public static final int TEN_DOLLAR = 10;
    
    
}
