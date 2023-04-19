/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author TheMy
 */
public class Dealer implements IDealer {
    private ArrayList<Card> hand;
    private int score;

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

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

    @Override
    public int hitOrStand() {
        if (score <= Constants.DEALER_HIT) {
            return Constants.HIT;
        } else {
            return Constants.STAND;
        }
    }

    @Override
    public Card deal(Deck deck) {
       Card card = null;
       Iterator<Card> iterator = deck.getDeck().iterator();
       if (iterator.hasNext()) {
           card = iterator.next();
           deck.getDeck().remove(card);
       }
       return card;
    }
    
}
