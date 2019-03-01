package com.dsyu.jacques;

import java.util.ArrayList;

public class CardValue {

    private int[] cardValues = new int[8];

    CardValue() {
        // Randomly generates unique values for the 8 cards
        ArrayList<Integer> deck = new ArrayList<Integer>();
        for (int i = 1; i < 14; i++) {
            deck.add(i);
        }
        for (int i = 0; i < 8; i++) {
            int num = (int) (Math.random () * (13-i));
            cardValues[i] = deck.get(num);
            deck.remove(num);
        }
    }

    public int getValue(int cardNum) {
        return cardValues[cardNum-1];
    }
}
