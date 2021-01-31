package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HighestScoreActivity extends AppCompatActivity {
    AppCompatButton TryAgainBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_highest_score );

        TextView txtScore = (TextView) findViewById( R.id.textScore );
        TextView txtHeighScore = (TextView) findViewById( R.id.textHighScore );
            TryAgainBtn = (AppCompatButton) findViewById( R.id.try_again_btn );
        Intent intent = getIntent();
        int score = intent.getIntExtra( "score", 0 );
        txtScore.setText( "Your Score: "+score);
// use  Shared Preferences to save the best score.
        SharedPreferences myPref = getPreferences( MODE_PRIVATE );
        int highscore = myPref.getInt( "highscore",0 );
        if(highscore>=score){
            txtHeighScore.setText( "High Score: "+ highscore );
        }else{
            txtHeighScore.setText( "New High Score: "+ score );
            SharedPreferences.Editor editor = myPref.edit();
            editor.putInt( "highscore",score );
            editor.commit();
        }

        TryAgainBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HighestScoreActivity.this,MainActivity.class);
                startActivity( intent1 );
                finish();
            }
        } );
    }


}