package com.example.android.simplecounter;


public abstract class Team implements AddPoints{
    private static final int DEFAULT_SCORE = 0;

    private int score;

    Team() {
        this.score = DEFAULT_SCORE;
    }

    void setScore(int score) {
        this.score = score;
    }

    protected int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getScore());
    }
}
