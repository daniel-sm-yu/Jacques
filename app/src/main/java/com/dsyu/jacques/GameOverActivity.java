package com.dsyu.jacques;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GameOverActivity extends AppCompatActivity {

    private ImageButton playAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_game_over );

        playAgainButton = findViewById( R.id.playAgainButton );

        playAgainButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(intent);
            }
        } );
    }
}
