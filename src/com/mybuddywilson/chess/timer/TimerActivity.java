package com.mybuddywilson.chess.timer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import com.mybuddywilson.R;

/**
 * @Author: Todd
 * @Since: 9/15/12
 *
 * This is the activity for the Timer.  It is used both to set up the timer initially,
 * and while the timer is counting down.
 *
 */
public class TimerActivity extends Activity {

    private Button playerOneClockButton;
    private Button playerTwoClockButton;

    private ChessTimer playerOneTimer;
    private ChessTimer playerTwoTimer;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        playerOneClockButton = (Button) findViewById(R.id.playerOneTimer);
        playerTwoClockButton = (Button) findViewById(R.id.playerTwoTimer);

        playerOneTimer = new ChessTimer() {
            @Override
            public void onFinish() {
                playerOneClockButton.setBackgroundColor(Color.RED);
                cancel();
            }

            @Override
            public void updateView() {
                playerOneClockButton.setText(getFormattedTimeLeft());
            }
        };
        playerOneTimer.updateView();

        playerTwoTimer = new ChessTimer() {
            @Override
            public void onFinish() {
                playerTwoClockButton.setBackgroundColor(Color.RED);
                cancel();
            }

            @Override
            public void updateView() {
                playerTwoClockButton.setText(getFormattedTimeLeft());
            }
        };
        playerTwoTimer.updateView();
    }


    public void handleClick(View view){
        switch(view.getId()){
            case R.id.playerOneTimer:
                playerOneClick();
                break;
            case R.id.playerTwoTimer:
                playerTwoClick();
                break;
            case R.id.pause:
                if(playerOneTimer.isPaused() || playerTwoTimer.isPaused()){
                    unpause();
                }else {
                    pause();
                }
                break;
            case R.id.restart:
                restart();
                break;
        }
    }

    private void restart(){
        playerOneTimer.cancel();
        playerTwoTimer.cancel();

        playerOneClockButton.setEnabled(true);
        playerOneTimer.setPaused(false);

        playerTwoClockButton.setEnabled(true);
        playerTwoTimer.setPaused(false);

        playerOneTimer.setSecondsLeft(playerOneTimer.getSecondsAtStart());
        playerTwoTimer.setSecondsLeft(playerTwoTimer.getSecondsAtStart());

        playerOneTimer.updateView();
        playerTwoTimer.updateView();
    }

    private void unpause(){
        if(playerOneTimer.isPaused()){
            playerOneTimer.start();
            playerOneTimer.setPaused(false);
        } else if(playerTwoTimer.isPaused()){
            playerTwoTimer.setPaused(false);
            playerTwoTimer.start();
        }
    }

    private void pause() {
        if(playerOneClockButton.isEnabled()){
            playerOneTimer.cancel();
            playerOneTimer.setPaused(true);
            playerOneTimer.updateView();
        } else {
            playerTwoTimer.cancel();
            playerTwoTimer.setPaused(true);
            playerTwoTimer.updateView();
        }
    }

    private void playerOneClick(){
        playerOneClockButton.setEnabled(false);
        playerOneTimer.setPaused(false);
        playerOneTimer.cancel();

        playerTwoClockButton.setEnabled(true);
        playerTwoTimer.start();

    }

    private void playerTwoClick(){
        playerOneClockButton.setEnabled(true);
        playerOneTimer.start();

        playerTwoClockButton.setEnabled(false);
        playerTwoTimer.setPaused(false);
        playerTwoTimer.cancel();

    }
}
