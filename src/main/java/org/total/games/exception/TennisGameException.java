package org.total.games.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TennisGameException extends RuntimeException {

    public final String message;
    public final String code;
    public final int type;

}
