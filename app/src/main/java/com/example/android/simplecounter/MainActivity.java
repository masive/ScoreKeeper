package com.example.android.simplecounter;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Team teamA = new TeamA();
    private Team teamB = new TeamB();
    private long timeWhenStoppedPlayerA = 0;
    private long timeWhenStoppedPlayerB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Person createPerson() {
        EditText inputUserName = (EditText) findViewById(R.id.username_editText_view);
        String username = inputUserName.getText().toString();
        Person person = new Person(username);
        return person;
    }

    private void showSportScreen() {
        Person currentUser = createPerson();
        setContentView(R.layout.sports);
        TextView messageTextView = (TextView) findViewById(R.id.hello_message_view);
        String message = String.format("Hi %s, please select a sport event!", currentUser.getName());
        messageTextView.setText(message);
    }


    public void nextScreen(View view) {
        showSportScreen();
    }

    public void basketballScreen(View view) {
        setContentView(R.layout.basketball_layout);

    }

    public void footballScreen(View view) {
        setContentView(R.layout.football);
    }

    public void runScreen(View view) {
        setContentView(R.layout.run);
    }

    public void addPointsTeamA(View view) {

        Button treePointsButton = (Button) findViewById(R.id.tree_points_button_teamA);
        Button twoPointsButton = (Button) findViewById(R.id.two_points_button_teamA);
        Button onePointsButton = (Button) findViewById(R.id.one_points_button_teamA);

        if (treePointsButton.isPressed()) {
            this.teamA.addTreePoints();
        } else if (twoPointsButton.isPressed()) {
            this.teamA.addTwoPoints();
        } else if (onePointsButton.isPressed()) {
            this.teamA.addOnePoints();
        }

        TextView pointsViewTeamA = (TextView) findViewById(R.id.pointsA_text_view);
        pointsViewTeamA.setText(this.teamA.toString());

    }

    public void addPointsTeamB(View view) {

        Button treePointsButton = (Button) findViewById(R.id.tree_points_button_teamB);
        Button twoPointsButton = (Button) findViewById(R.id.two_points_button_teamB);
        Button onePointsButton = (Button) findViewById(R.id.one_points_button_teamB);

        if (treePointsButton.isPressed()) {
            this.teamB.addTreePoints();
        } else if (twoPointsButton.isPressed()) {
            this.teamB.addTwoPoints();
        } else if (onePointsButton.isPressed()) {
            this.teamB.addOnePoints();
        }

        TextView pointsViewTeamB = (TextView) findViewById(R.id.pointsB_text_view);
        pointsViewTeamB.setText(this.teamB.toString());

    }


    public void addGoalTemaA(View view) {
        this.teamA.addOnePoints();
        TextView teamAGoals = (TextView) findViewById(R.id.footballTeamAScore_text_view);
        teamAGoals.setText(this.teamA.toString());
    }

    public void addGoalTemaB(View view) {
        this.teamB.addOnePoints();
        TextView teamAGoals = (TextView) findViewById(R.id.footballTeamBScore_text_view);
        teamAGoals.setText(this.teamB.toString());
    }


    public void basketballResetPoints(View view) {
        int score = 0;
        this.teamA.setScore(score);
        this.teamB.setScore(score);

        TextView pointsViewTeamA = (TextView) findViewById(R.id.pointsA_text_view);
        pointsViewTeamA.setText(this.teamA.toString());

        TextView pointsViewTeamB = (TextView) findViewById(R.id.pointsB_text_view);
        pointsViewTeamB.setText(this.teamB.toString());

    }


    public void footballResetGoals(View view) {
        int score = 0;
        this.teamA.setScore(score);
        this.teamB.setScore(score);

        TextView pointsViewTeamA = (TextView) findViewById(R.id.footballTeamAScore_text_view);
        pointsViewTeamA.setText(this.teamA.toString());

        TextView pointsViewTeamB = (TextView) findViewById(R.id.footballTeamBScore_text_view);
        pointsViewTeamB.setText(this.teamB.toString());

    }

    public void startTimeA(View view) {
        Chronometer chronometer = (Chronometer) findViewById(R.id.playerA_chronometer_view);
        chronometer.setBase(SystemClock.elapsedRealtime() + this.timeWhenStoppedPlayerA);
        chronometer.start();
    }

    public void stopTimeA(View view) {
        Chronometer chronometer = (Chronometer) findViewById(R.id.playerA_chronometer_view);
        this.timeWhenStoppedPlayerA = chronometer.getBase() - SystemClock.elapsedRealtime();
        chronometer.stop();
    }

    public void resetTimeA(View view) {
        Chronometer chronometer = (Chronometer) findViewById(R.id.playerA_chronometer_view);
        chronometer.setBase(SystemClock.elapsedRealtime());
        this.timeWhenStoppedPlayerA = 0;
    }

    public void startTimeB(View view) {
        Chronometer chronometer = (Chronometer) findViewById(R.id.playerB_chronometer_view);
        chronometer.setBase(SystemClock.elapsedRealtime() + this.timeWhenStoppedPlayerB);
        chronometer.start();
    }

    public void stopTimeB(View view) {
        Chronometer chronometer = (Chronometer) findViewById(R.id.playerB_chronometer_view);
        this.timeWhenStoppedPlayerB = chronometer.getBase() - SystemClock.elapsedRealtime();
        chronometer.stop();
    }

    public void resetTimeB(View view) {
        Chronometer chronometer = (Chronometer) findViewById(R.id.playerB_chronometer_view);
        chronometer.setBase(SystemClock.elapsedRealtime());
        this.timeWhenStoppedPlayerB = 0;
    }


    public void goToSportsScreen(View view) {
        setContentView(R.layout.sports);
    }

    public void goToHomeScreen(View view) {
        setContentView(R.layout.activity_main);
    }

}
