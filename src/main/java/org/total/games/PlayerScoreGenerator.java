package org.total.games;

@FunctionalInterface
public interface PlayerScoreGenerator<S> {

    S generatePlayerScore(S playerOneScore, S playerTwoScore);
}