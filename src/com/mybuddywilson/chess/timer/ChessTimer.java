package com.mybuddywilson.chess.timer;

import android.os.CountDownTimer;
import android.view.View;

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
 * unfortunately CountDownTimer doesn't have the facility for adding time =(
 *
 */
public abstract class ChessTimer extends CountDownTimer {

    private final int secondsAtStart;
    private final int secondsPerMove;
    private AtomicInteger secondsLeft;
    private boolean paused = false;

    public ChessTimer() {
        this(60 * 5);
    }

    public ChessTimer(int secondsAtStart) {
        this(secondsAtStart, 0);
    }

    public ChessTimer(int secondsAtStart, int secondsPerMove) {
        super(Long.MAX_VALUE, 1000);
        this.secondsAtStart = secondsAtStart;
        this.secondsPerMove = secondsPerMove;
        this.secondsLeft = new AtomicInteger(secondsAtStart);
    }

    @Override
    public void onTick(long l) {
        secondsLeft.decrementAndGet();
        updateView();
        if(secondsLeft.get() < 1){
            onFinish();
        }
    }

    public abstract void updateView();

    public int getSecondsLeft() {
        return secondsLeft.intValue();
    }

    public int increaseSecondsLeftForMove(){
        return secondsLeft.addAndGet(secondsPerMove);
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

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public String getFormattedTimeLeft(){
        int minutesLeft = (secondsLeft.get()/60);
        int seconds = (secondsLeft.get() - minutesLeft * 60);
        String separator = seconds < 10 ? ":0" : ":";
        String pauseStatus = paused ? " (Paused)" : "";
        return  minutesLeft + separator + seconds + pauseStatus;
    }
}
