package org.total.games.tennis;

import org.total.games.Score;
import org.total.games.tennis.model.TennisScorePlayer;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class TennisGameScore extends Score<TennisScorePlayer> {


    private TennisGameScore(TennisScorePlayer playerOneScore,
            TennisScorePlayer playerTwoScore) {
        super(playerOneScore, playerTwoScore);
    }

    public static TennisGameScore of(TennisScorePlayer firstPlayerScoreValue,
            TennisScorePlayer secondPlayerScoreValue) {
        return new TennisGameScore(firstPlayerScoreValue, secondPlayerScoreValue);
    }

    @Override
    public String displayScore() {

        return playerOneScore.equals(playerTwoScore) ? TennisScorePlayer.DEUCE.name()
                : playerOneScore + ":" + playerTwoScore;
    }
}
