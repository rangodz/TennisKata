package org.total.games;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.total.games.tennis.model.TennisScorePlayer.LOVE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.total.games.model.Player;
import org.total.games.tennis.Tennis;
import org.total.games.tennis.TennisGameScore;
import org.total.games.tennis.model.TennisScorePlayer;

@DisplayName("Tennis game test")
class TennisGameIT {

    @Test
    @DisplayName("When game start then Score equals LOVE:LOVE and Game is not finished")
    void testStartTennisGame() {

        TennisGameScore newGame = Tennis.startGame();

        assertEquals(LOVE, newGame.getPlayerOneScore());
        assertEquals(LOVE, newGame.getPlayerTwoScore());
        assertFalse(newGame.isGameFinished());
    }

    @Test
    @DisplayName(
            "When Gamer1:15,Gamer1:30,Gamer1:40,Gamer2:15,Gamer2:30,Gamer1:WIN then Score WIN:THIRTY and Game is Finished")
    void testFortyToWinTennisGame() {
        TennisGameScore game = Tennis.startGame();
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        assertEquals(TennisScorePlayer.WIN + ":" + TennisScorePlayer.THIRTY, game.displayScore());
        assertTrue(game.isGameFinished());
    }

    @Test
    @DisplayName(
            "When Gamer1:15,Gamer1:30,Gamer1:40,Gamer2:15,Gamer2:30,Gamer2:40,Gamer1:ADVANTAGE,Gamer1:WIN then Score WIN:FORTY and Game is Finished")
    void testAdvantageToWinTennisGame() {
        TennisGameScore game = Tennis.startGame();
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        assertEquals(TennisScorePlayer.WIN + ":" + TennisScorePlayer.FORTY, game.displayScore());
        assertTrue(game.isGameFinished());
    }

    @Test
    @DisplayName(
            "When Gamer1:15,Gamer1:30,Gamer1:40,Gamer2:15,Gamer2:30,Gamer2:40,Gamer1:ADVANTAGE,Gamer1:WIN then Score WIN:FORTY and Game is Finished")
    void testAdvantageTennisGame() {
        TennisGameScore game = Tennis.startGame();
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);

        assertEquals(TennisScorePlayer.DEUCE.name(), game.displayScore());
        assertFalse(game.isGameFinished());
    }

    @Test
    @DisplayName(
            "When Game:15-0,30-0,40-0,40-15,40-30,40-40,ADVANTAGE-40,40-40 then Score DEUCE")
    void testAdvantageToDeuceTennisGame() {
        TennisGameScore game = Tennis.startGame();
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        assertEquals(TennisScorePlayer.DEUCE.name(), game.displayScore());
        assertFalse(game.isGameFinished());
    }

    @Test
    @DisplayName("When Game:15-0,30-0,40-0,40-15,40-30,40-40, then Score DEUCE")
    void testDeuceTennisGame() {
        TennisGameScore game = Tennis.startGame();
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_ONE);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        game = Tennis.updateScore(game, Player.PLAYER_TWO);
        assertEquals(TennisScorePlayer.DEUCE.name(), game.displayScore());
        assertFalse(game.isGameFinished());
    }
}
