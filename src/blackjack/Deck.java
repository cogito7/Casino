/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import constants.Constants.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author TheMy
 */
class Deck {

    Set<Card> deck;

    public Set<Card> getDeck() {
        return deck;
    }

    public void setDeck(Set<Card> deck) {
        this.deck = deck;
    }

    public Deck() {
        
//        System.out.println("****************************");
//        System.out.println("Generating the deck of cards");
//        System.out.println("****************************");
        generateDeck();
        /*
        System.out.println("****************************");
        System.out.println("Displaying the deck of cards");
        System.out.println("****************************");        
        displayDeck();
        */
//        System.out.println("***************************");
//        System.out.println("Shuffling the deck of cards");
//        System.out.println("***************************");
        shuffleDeck();
      /*  
        System.out.println("*************************************");
        System.out.println("Displaying the shuffled deck of cards");
        System.out.println("*************************************");        
        displayDeck();
*/
    }

    private void generateDeck() {
        deck = new HashSet();
        for (Face face : Face.values()) {
            for (Cards cards : Cards.values()) {
                Card c = new Card();
                c.setFace(face);
                c.setCards(cards);

                if (cards == Cards.DIAMONDS || cards == Cards.HEARTS) {
                    c.setColor(Color.RED);
                } else {
                    c.setColor(Color.BLACK);
                }
                if (!deck.contains(c)) {
                    deck.add(c);
                }
            }
        }
    }

    private void displayDeck() {
        System.out.println("Deck size:" + deck.size() + " cards");
        System.out.println("Deck includes: ");
        for (Card c : deck) {
            System.out.println("Card: " + c.getFace() + " of " + c.getCards() + " is color " + c.getColor());

        }

    }

    private void shuffleDeck() {
        List<Card> cList = new ArrayList(deck);
        Collections.shuffle(cList);
        deck = new HashSet(cList);
    }

}
