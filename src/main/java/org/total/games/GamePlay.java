package org.total.games;

import org.total.games.model.Player;

@FunctionalInterface
public interface GamePlay<S extends Score> {

    S updateScore(S score, Player player);
}
