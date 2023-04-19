/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import constants.Constants.Cards;
import constants.Constants.Color;
import constants.Constants.Face;

/**
 *
 * @author TheMy
 */
public class Card {
    
    //Casino 4 member variables
    public int value;

    public int getValue() {
        value = 0;
        if (face.ordinal() >= Face.TWO.ordinal() && face.ordinal() <= Face.NINE.ordinal()) {
            value = face.ordinal() + 2;
        }
        else if (face == Face.ACE) {
            value = 11;
        }
            else {
            value = 10;
        }

        return value;
    }
    //Casino 4 method
    public String toString(){
        String card = face.name() + " of " + this.cards.name();
        return card;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    private Cards cards;

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }
    private Face face;

    public Face getFace() {
        
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public int hashCode() {
        int hashcode = 0;

        return hashcode;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            Card c;
            c = (Card) obj;
            return (c.face.equals(this.face)
                    && c.color.equals(this.color)
                    && c.cards.equals(this.cards));
        } else {
            return false;
        }
    }

}
