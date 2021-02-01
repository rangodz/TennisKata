package org.total.games.tennis;

import org.total.games.model.GameStat;
import org.total.games.model.Player;
import org.total.games.tennis.model.TennisScorePlayer;

public class Tennis {

    public static TennisGameScore startGame() {
        return TennisScoringDefinition.GAME.startGame();
    }

    public static TennisGameScore updateScore(TennisGameScore actualScore, Player currentPlayer) {
        TennisGameScore tennisGameScore = TennisScoringDefinition.TENNIS_GAME.updateScore(actualScore, currentPlayer);
        if (tennisGameScore.getPlayerOneScore() == TennisScorePlayer.WIN
                || tennisGameScore.getPlayerTwoScore() == TennisScorePlayer.WIN) {
            tennisGameScore.finishGame(GameStat.FINISHED);
            return tennisGameScore;
        }
        return tennisGameScore;
    }
}
