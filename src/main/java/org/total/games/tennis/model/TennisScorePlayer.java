package org.total.games.tennis.model;

public enum TennisScorePlayer {

    WIN("WIN"),
    DEUCE("DEUCE"),
    ADVANTAGE("A"),
    FORTY("40"),
    THIRTY("30"),
    FIFTEEN("15"),
    LOVE("0");

    private String stringScore;

    TennisScorePlayer(String stringScore) {
        this.stringScore = stringScore;
    }

    @Override
    public String toString() {
        return stringScore;
    }
}
