package com.dsyu.jacques;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.widget.Toast.makeText;
import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
                                            public static final String TAG = MainActivity.class.toString();
    private boolean[] playerHand = new boolean[4];
    private boolean[] cpuHand = new boolean[4];
    private ImageButton jacquesButton, card1, card2, card3, card4, card5, card6, card7, card8;
    private TextView playerScore, cpuScore;
    boolean playerStand, cpuStand;
    final CardFace cardFace = new CardFace();
    final CardValue cardValue = new CardValue();
    final Score score = new Score();
    final Ace ace = new Ace();
    int maxNum = 21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.wtf(TAG, "CREATE -----------------------------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);
        card8 = findViewById(R.id.card8);
        jacquesButton = findViewById(R.id.jacquesButton );
        playerScore = findViewById(R.id.playerScoreTextView);
        cpuScore = findViewById(R.id.cpuScoreTextView);

        // Removes every player card not in player's hand
        jacquesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf(TAG, "PLAYER STAND");
                playerStand = true;
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
                gameOverCheck();
                cpuTakeTurn();

            }
        });

        // Adds card to player's hand with clicked
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playerHand[0]) {
                    card1.setImageResource(cardFace.getCardFace( cardValue.getValue(1)));
                    playerHand[0] = true;
                    playerScore.setText(score.addPlayerScore( cardValue.getValue(1)));
                    ace.setPlayerAce( cardValue.getValue(1));
                    if (score.getPlayerScoreInt() > maxNum) {
                        if (score.playerGameOver(ace.usePlayerAce())) {

                            gameOver();

                        } else {
                            playerScore.setText(score.getPlayerScore());
                            cpuTakeTurn();
                        }
                    }
                    if (score.getPlayerScoreInt() <= maxNum) {
                        cpuTakeTurn();
                    }
                }
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playerHand[1]) {
                    card2.setImageResource(cardFace.getCardFace( cardValue.getValue(2)));
                    playerHand[1] = true;
                    playerScore.setText(score.addPlayerScore( cardValue.getValue(2)));
                    ace.setPlayerAce( cardValue.getValue(2));
                    if (score.getPlayerScoreInt() > maxNum) {
                        if (score.playerGameOver(ace.usePlayerAce())) {

                            gameOver();

                        } else {
                            playerScore.setText(score.getPlayerScore());
                            cpuTakeTurn();
                        }
                    }
                    if (score.getPlayerScoreInt() <= maxNum) {
                        cpuTakeTurn();
                    }
                }
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playerHand[2]) {
                    card3.setImageResource(cardFace.getCardFace( cardValue.getValue(3)));
                    playerHand[2] = true;
                    playerScore.setText(score.addPlayerScore( cardValue.getValue(3)));
                    ace.setPlayerAce( cardValue.getValue(3));
                    if (score.getPlayerScoreInt() > maxNum) {
                        if (score.playerGameOver(ace.usePlayerAce())) {

                            gameOver();

                        } else {
                            playerScore.setText(score.getPlayerScore());
                            cpuTakeTurn();
                        }
                    }
                    if (score.getPlayerScoreInt() <= maxNum) {
                        cpuTakeTurn();
                    }
                }
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playerHand[3]) {
                    card4.setImageResource(cardFace.getCardFace( cardValue.getValue(4)));
                    playerHand[3] = true;
                    playerScore.setText(score.addPlayerScore( cardValue.getValue(4)));
                    ace.setPlayerAce( cardValue.getValue(4));
                    if (score.getPlayerScoreInt() > maxNum) {
                        if (score.playerGameOver(ace.usePlayerAce())) {

                            gameOver();

                        } else {
                            playerScore.setText(score.getPlayerScore());
                            cpuTakeTurn();
                        }
                    }
                    if (score.getPlayerScoreInt() <= maxNum) {
                        cpuTakeTurn();
                    }
                }
            }
        });

    }
        private void playerFullHand() {
            int playerCards = 0;
            for (int i = 0; i < 4; i++) {
                if (playerHand[i]) {
                    playerCards++;
                }
            }
            Log.e( TAG, "PLAYER CARDS: " + String.valueOf( playerCards ) );
            if (playerCards == 4) {
                playerStand = true;
                Log.e( TAG, "PLAYER STAND" );
            }
        }

// SMART CPU ALGORITHM -----------------------------------------------------------------------------

        // Gets CPU to take a turn
        private void cpuTakeTurn () {
            playerFullHand();
            if (!cpuStand) {
                if (score.getCpuScoreInt() < score.getPlayerScoreInt()) {
                    cpuAddCard();
                } else if (playerStand) {
                    cpuStand();
                } else if (score.getCpuScoreInt() < 12) {
                    cpuAddCard();
                } else if (score.getCpuScoreInt() < 14) {
                    if ((int) Math.floor( Math.random() ) * 5 != 0) {
                        cpuAddCard();
                    }
                    else {
                        cpuStand();
                    }
                } else if (score.getCpuScoreInt() < 16) {
                    if ((int) Math.floor( Math.random() ) * 2 == 0) {
                        cpuAddCard();
                    }
                    else {
                        cpuStand();
                    }
                } else if (score.getCpuScoreInt() < 18) {
                    if ((int) Math.floor( Math.random() ) * 4 == 0) {
                        cpuAddCard();
                    } else {
                        cpuStand();
                    }
                }
            }
            gameOverCheck();
        }

        // Gets CPU to add a card to hand
        private void cpuAddCard(){
        // delays execution by a few seconds
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.wtf( TAG, "CARD ADDED" );
                // selects a card not yet added to cpu hand
                int randomCpuCardNum = (int) (Math.random() * 4);

                while (cpuHand[randomCpuCardNum]) {
                    randomCpuCardNum = (int) Math.floor( Math.random() * 4);
                    Log.wtf(TAG, "LOOP");
                }

                randomCpuCardNum += 5;

                switch (randomCpuCardNum) {
                    case 5:
                        card5.setImageResource( cardFace.getCardFace( cardValue.getValue(randomCpuCardNum) ) ); break;
                    case 6:
                        card6.setImageResource( cardFace.getCardFace( cardValue.getValue(randomCpuCardNum) ) ); break;
                    case 7:
                        card7.setImageResource( cardFace.getCardFace( cardValue.getValue(randomCpuCardNum) ) ); break;
                    case 8:
                        card8.setImageResource( cardFace.getCardFace( cardValue.getValue(randomCpuCardNum) ) ); break;
                }

                cpuHand[randomCpuCardNum - 5] = true;
                cpuScore.setText( score.addCpuScore( cardValue.getValue(randomCpuCardNum) ) );
                ace.setCpuAce( cardValue.getValue(randomCpuCardNum) );
                if (score.getCpuScoreInt() > maxNum) {
                    if (score.cpuGameOver( ace.useCpuAce() )) {

                            gameOverCheck();

                    } else {
                        cpuScore.setText( score.getCpuScore() );
                    }

                }
                int cpuCards = 0;
                for (int i = 0; i < 4; i++) {
                    if (cpuHand[i]) {
                        cpuCards++;
                    }
                }
                Log.e( TAG, "CPU CARDS: " + String.valueOf( cpuCards ) );
                if (cpuCards == 4) {
                    cpuStand = true;
                    Log.e( TAG, "CPU STAND" );
                }
            }
        }, 1200);
    }

    private void cpuStand() {
        Log.wtf(TAG, "CPU STAND");
        cpuStand = true;
        if (!cpuHand[0]) {
            card5.setImageResource(R.drawable.black);
            cpuHand[0] = true;
        }
        if (!cpuHand[1]) {
            card6.setImageResource(R.drawable.black);
            cpuHand[1] = true;
        }
        if (!cpuHand[2]) {
            card7.setImageResource(R.drawable.black);
            cpuHand[2] = true;
        }
        if (!cpuHand[3]) {
            card8.setImageResource(R.drawable.black);
            cpuHand[3] = true;
        }
    }

    // Used to navigate to the Game Over page
    private void gameOverCheck() {
        if (playerStand && cpuStand) {
            gameOver();
        }
    }

    private void gameOver() {
        Handler handler = new Handler();
        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent( MainActivity.this, GameOverActivity.class );
                int playerScore = score.getPlayerScoreInt();
                intent.putExtra( "playerScore", playerScore );
                int cpuScore = score.getCpuScoreInt();
                intent.putExtra( "cpuScore", cpuScore );
                startActivity( intent );
            }
        }, 1200 );
    }
}
