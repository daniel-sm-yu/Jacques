package com.dsyu.jacques;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    private ImageButton playAgainButton;
    private TextView cpuScoreTextView;
    private TextView resultsTextView;
    private TextView playerScoreTextView;
    private int playerScore, cpuScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_game_over );

        Intent intent = getIntent();
        cpuScore = intent.getIntExtra( "cpuScore", 0 );
        playerScore = intent.getIntExtra( "playerScore", 0 );

        playAgainButton = findViewById( R.id.playAgainButton );
        cpuScoreTextView = findViewById( R.id.cpuScoreTextView );
        resultsTextView = findViewById( R.id.resultsTextView );
        playerScoreTextView = findViewById( R.id.playerScoreTextView );

        if (playerScore < 22 && (cpuScore > 21 || playerScore > cpuScore)) {
            resultsTextView.setText( "You Win." );
        }

        cpuScoreTextView.setText( String.valueOf(cpuScore) );
        playerScoreTextView.setText( String.valueOf(playerScore) );

        playAgainButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(intent);
            }
        } );
    }
}
