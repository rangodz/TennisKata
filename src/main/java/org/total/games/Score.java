package org.total.games;

import org.total.games.model.GameStat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Score<P> {

    protected final P playerOneScore;
    protected final P playerTwoScore;

    private GameStat gameStat;

    protected abstract String displayScore();

    @Override
    public String toString() {
        return this.displayScore();
    }

    public void finishGame(GameStat stat) {
        this.gameStat = stat;
    }

    public boolean isGameFinished() {
        return GameStat.FINISHED.equals(gameStat);
    }
}

