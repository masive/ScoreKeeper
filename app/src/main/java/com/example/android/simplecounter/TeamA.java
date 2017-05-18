package com.example.android.simplecounter;


public class TeamA extends Team implements AddPoints{

    public TeamA() {
        super();
    }

    @Override
    public int getScore() {
        return super.getScore();
    }

    @Override
    public void addTreePoints() {
        int score = super.getScore();
        score += 3;
        super.setScore(score);
    }

    @Override
    public void addTwoPoints() {
        int score = super.getScore();
        score += 2;
        super.setScore(score);
    }

    @Override
    public void addOnePoints() {
        int score = super.getScore();
        score += 1;
        super.setScore(score);
    }

}
