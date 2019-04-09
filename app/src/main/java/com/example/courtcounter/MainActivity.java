package com.example.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //track the individual team scores
    int teamA = 0;
    int teamB = 0;

    //this is a constant so the value will never change, name is all caps with _ as spaces
    //points
    final int FREE_THROW = 1;
    final int FIELD_GOAL_2 = 2;
    final int FIELD_GOAL_3 = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds appropriate points based on which button called the method
     */
    public void addPoints(View v) {
        switch(v.getId()) {
            case R.id.button_a_3:
                teamA += FIELD_GOAL_3;
                displayForTeamA(teamA);
                break;
            case R.id.button_b_3:
                teamB += FIELD_GOAL_3;
                displayForTeamB(teamB);
                break;
            case R.id.button_a_2:
                teamA += FIELD_GOAL_2;
                displayForTeamA(teamA);
                break;
            case R.id.button_b_2:
                teamB += FIELD_GOAL_2;
                displayForTeamB(teamB);
                break;
            case R.id.button_a_1:
                teamA += FREE_THROW;
                displayForTeamA(teamA);
                break;
            case R.id.button_b_1:
                teamB += FREE_THROW;
                displayForTeamB(teamB);
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }
    }

    /**
     * Clears the scores
     */
    public void resetScores(View v) {
        teamA = 0;
        teamB = 0;
        displayForTeamA(teamA);
        displayForTeamB(teamB);
    }


}
