package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private QuestionBank mQuestionLibrary = new QuestionBank();
    private TextView mScoreView;
    private TextView mQuestionView;
    private AppCompatButton mButtonChoice1,mButtonChoice2,mButtonChoice3,mButtonChoice4;
    private String mAnswer;
    private  int mScore = 0;
    private  int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        mScoreView =(TextView) findViewById( R.id.score_tv);
        mQuestionView = (TextView) findViewById( R.id.question_tv );
        mButtonChoice1 = (AppCompatButton) findViewById( R.id.choice_1 );
        mButtonChoice2 = (AppCompatButton) findViewById( R.id.choice_2 );
        mButtonChoice3 = (AppCompatButton) findViewById( R.id.choice_3 );
        mButtonChoice4 = (AppCompatButton) findViewById( R.id.choice_4 );
        updateQuestion();
        updateScore(mScore);
    }

    private void updateScore(int point) {
        mScoreView.setText( ""+ mScore+"/"+mQuestionLibrary.getLength() );
    }

    private void updateQuestion(){
        //check if we are not outside array bounds for questions
       if(mQuestionNumber<mQuestionLibrary.getLength()){
           //set the text for new question, and new for alternative to answer on four buttons
           mQuestionView.setText(mQuestionLibrary.getQuestion( mQuestionNumber ));
           mButtonChoice1.setText( mQuestionLibrary.getChoice( mQuestionNumber,1 ) );
           mButtonChoice2.setText( mQuestionLibrary.getChoice( mQuestionNumber,2 ) );
           mButtonChoice3.setText( mQuestionLibrary.getChoice( mQuestionNumber,3 ) );
           mButtonChoice4.setText( mQuestionLibrary.getChoice( mQuestionNumber,4 ) );
           mAnswer = mQuestionLibrary.getCorrectAnswer( mQuestionNumber );
           mQuestionNumber++;
       }else
       {
           Toast.makeText( this, "it was the last question...", Toast.LENGTH_SHORT ).show();
           Intent intent = new Intent(MainActivity.this,HighestScoreActivity.class);
           intent.putExtra( "score", mScore );
           startActivity( intent );

       }
    }

    public void  onClick(View view){
        //all logic for all answer buttons in one method
        Button answer = (Button) view;
        //if the answer is correct, increase the score
        if(answer.getText()==mAnswer){
            mScore = mScore+1;
            Toast.makeText( this, "Correct!", Toast.LENGTH_SHORT ).show();
            updateQuestion();
            updateScore(mScore);
        }else {
            Toast.makeText( this, "Wrong!", Toast.LENGTH_SHORT ).show();
            updateScore(mScore);
            updateQuestion();
        }
    }
}