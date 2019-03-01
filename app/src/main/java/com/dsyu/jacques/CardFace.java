package com.dsyu.jacques;

public class CardFace {

    public int getCardFace(int value) {
        switch (value) {
            case 1: return R.drawable.card1;
            case 2: return R.drawable.card2;
            case 3: return R.drawable.card3;
            case 4: return R.drawable.card4;
            case 5: return R.drawable.card5;
            case 6: return R.drawable.card6;
            case 7: return R.drawable.card7;
            case 8: return R.drawable.card8;
            case 9: return R.drawable.card9;
            case 10: return R.drawable.card10;
            case 11: return R.drawable.card11;
            case 12: return R.drawable.card12;
            case 13: return R.drawable.card13;
        }
        return 0;
    }
}
