package com.mybuddywilson.chess.timer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Todd
 * @Since: 9/15/12
 *
 * This class keeps track of a timer per player.
 *
 * The user can optionally set an amount of seconds to be granted
 * for each move, so you can play a 5/5 or 3/5 game, in addition
 * to the usual 5 minute blitz.
 *
 */
public class ChessTimer {
    private final int secondsAtStart;
    private final int secondsPerMove;
    private AtomicInteger secondsLeft;

    public ChessTimer(int secondsAtStart) {
        this(secondsAtStart, 0);
    }

    public ChessTimer(int secondsAtStart, int secondsPerMove) {
        this.secondsAtStart = secondsAtStart;
        this.secondsPerMove = secondsPerMove;
        this.secondsLeft = new AtomicInteger(secondsAtStart);
    }

    public int getSecondsLeft() {
        return secondsLeft.intValue();
    }

    public int decrementSecondsLeft(){
        return secondsLeft.decrementAndGet();
    }

    public void setSecondsLeft(int seconds){
        secondsLeft.set(seconds);
    }

    public int getSecondsAtStart() {
        return secondsAtStart;
    }

    public int getSecondsPerMove() {
        return secondsPerMove;
    }
}
