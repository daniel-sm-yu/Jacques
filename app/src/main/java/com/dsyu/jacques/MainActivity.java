package com.dsyu.jacques;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
                                            public static final String TAG = MainActivity.class.toString();

    private boolean[] playerHand = new boolean[4];
    private boolean[] cpuHand = new boolean[4];
    private ImageButton card1, card2, card3, card4, card5, card6, card7, card8;
    private Button jacquesButton;
    private TextView playerScore, cpuScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CardFace cardFace = new CardFace();
        final CardValue cardValues = new CardValue();
        final Score score = new Score();
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);
        card8 = findViewById(R.id.card8);
        jacquesButton = findViewById(R.id.jacquesButton);
        playerScore = findViewById(R.id.playerScoreTextView);
        cpuScore = findViewById(R.id.cpuScoreTextView);

        // Removes every player card not in player's hand
        jacquesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playerHand[0]) {
                    card1.setImageResource(R.drawable.black);
                    playerHand[0] = true;
                }
                if (!playerHand[1]) {
                    card2.setImageResource(R.drawable.black);
                    playerHand[1] = true;
                }
                if (!playerHand[2]) {
                    card3.setImageResource(R.drawable.black);
                    playerHand[2] = true;
                }
                if (!playerHand[3]) {
                    card4.setImageResource(R.drawable.black);
                    playerHand[3] = true;
                }
            }
        });

        // Updates player cards with clicked
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playerHand[0]) {
                    card1.setImageResource(cardFace.getCardFace(cardValues.getValue(1)));
                    playerHand[0] = true;
                    playerScore.setText(score.addPlayerScore(cardValues.getValue(1)));
                }
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playerHand[1]) {
                    card2.setImageResource(cardFace.getCardFace(cardValues.getValue(2)));
                    playerHand[1] = true;
                    playerScore.setText(score.addPlayerScore(cardValues.getValue(2)));
                }
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playerHand[2]) {
                    card3.setImageResource(cardFace.getCardFace(cardValues.getValue(3)));
                    playerHand[2] = true;
                    playerScore.setText(score.addPlayerScore(cardValues.getValue(3)));
                }
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playerHand[3]) {
                    card4.setImageResource(cardFace.getCardFace(cardValues.getValue(4)));
                    playerHand[3] = true;
                    playerScore.setText(score.addPlayerScore(cardValues.getValue(4)));
                }
            }
        });



    }
}
