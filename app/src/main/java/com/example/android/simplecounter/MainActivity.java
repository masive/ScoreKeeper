package com.example.android.simplecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BasketballTeam teamA = new TeamA();
    private BasketballTeam teamB = new TeamB();

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
        setContentView(R.layout.choose_sport);
        TextView messageTextView = (TextView) findViewById(R.id.hello_message_view);
        String message = String.format("Dear %s, please choose a sport event!", currentUser.getName());
        messageTextView.setText(message);
    }


    public void nextScreen(View view) {
        showSportScreen();
    }

    public void basketballScreen(View view) {
        setContentView(R.layout.basketball_layout);

    }

    public void addPointsTeamA(View view) {

        Button treePointsButton = (Button) findViewById(R.id.tree_points_button_teamA);
        Button twoPointsButton = (Button) findViewById(R.id.two_points_button_teamA);
        Button onePointsButton = (Button) findViewById(R.id.one_points_button_teamA);

        if(treePointsButton.isPressed()) {
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

        if(treePointsButton.isPressed()) {
            this.teamB.addTreePoints();
        } else if (twoPointsButton.isPressed()) {
            this.teamB.addTwoPoints();
        } else if (onePointsButton.isPressed()) {
            this.teamB.addOnePoints();
        }

        TextView pointsViewTeamB = (TextView) findViewById(R.id.pointsB_text_view);
        pointsViewTeamB.setText(this.teamB.toString());

    }

    public void resetPoints(View view) {
        int score = 0;
        this.teamA.setScore(score);
        this.teamB.setScore(score);

        TextView pointsViewTeamA = (TextView) findViewById(R.id.pointsA_text_view);
        pointsViewTeamA.setText(this.teamA.toString());

        TextView pointsViewTeamB = (TextView) findViewById(R.id.pointsB_text_view);
        pointsViewTeamB.setText(this.teamB.toString());

    }


    public void previousScreen(View view) {
        setContentView(R.layout.activity_main);
    }

}
