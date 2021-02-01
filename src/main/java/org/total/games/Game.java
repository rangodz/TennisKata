package org.total.games;

@FunctionalInterface
public interface Game<T extends Score> {

    T startGame();
}
