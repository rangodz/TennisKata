package org.total.games.tennis;

import static org.total.games.tennis.model.TennisScorePlayer.ADVANTAGE;
import static org.total.games.tennis.model.TennisScorePlayer.FIFTEEN;
import static org.total.games.tennis.model.TennisScorePlayer.FORTY;
import static org.total.games.tennis.model.TennisScorePlayer.THIRTY;
import static org.total.games.tennis.model.TennisScorePlayer.WIN;

import org.total.games.Game;
import org.total.games.exception.TennisGameException;
import org.total.games.model.Player;
import org.total.games.tennis.model.TennisScorePlayer;

public class TennisScoringDefinition {

    public final static TennisGamePlay TENNIS_GAME = (score, player) -> {

        return calculateNextScoreForPlayer(score.getPlayerOneScore(), score.getPlayerTwoScore(), player);
    };

    /**
     * Return the next score based on players scores for the first player
     *
     * @param playerOne the score of the first player
     * @param playerTwo the score of the second player
     * @param player player hwo have scored
     * @return TennisScorePlayer
     */
    private static TennisGameScore calculateNextScoreForPlayer(TennisScorePlayer playerOne,
            TennisScorePlayer playerTwo, Player player) {

        TennisScorePlayer nextScore;
        TennisScorePlayer scoringPlayer;
        TennisScorePlayer secondPlayerScore;
        if (player.equals(Player.PLAYER_ONE)) {
            scoringPlayer = playerOne;
            secondPlayerScore = playerTwo;
        } else {
            scoringPlayer = playerTwo;
            secondPlayerScore = playerOne;
        }

        switch (scoringPlayer) {
        case LOVE:
            nextScore = FIFTEEN;
            break;
        case FIFTEEN:
            nextScore = THIRTY;
            break;
        case THIRTY:
            nextScore = FORTY;
            break;
        case FORTY:
            if (FORTY.equals(secondPlayerScore)) {
                nextScore = ADVANTAGE;
            } else if (ADVANTAGE.equals(secondPlayerScore)) {
                return TennisGameScore.of(FORTY, FORTY);
            } else {
                nextScore = WIN;
            }
            break;
        case ADVANTAGE:
            nextScore = WIN;
            break;
        default: throw new TennisGameException("Unexpected value: " + scoringPlayer, "unexpected.value", 400);
        }

        if (player.equals(Player.PLAYER_ONE)) {
            return TennisGameScore.of(nextScore, secondPlayerScore);
        } else {
            return TennisGameScore.of(secondPlayerScore, nextScore);
        }
    }

    public static final Game<TennisGameScore>
            GAME = () -> TennisGameScore.of(TennisScorePlayer.LOVE, TennisScorePlayer.LOVE);
}
