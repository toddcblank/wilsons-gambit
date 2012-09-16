package com.mybuddywilson.chess.timer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DigitalClock;
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

    private Button playerOneClock;
    private Button playerTwoClock;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        playerOneClock = (Button) findViewById(R.id.playerOneTimer);
//        playerOneClock.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                handleClick(view);
//            }
//        });
        playerTwoClock = (Button) findViewById(R.id.playerTwoTimer);
//        playerTwoClock.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                handleClick(view);
//            }
//        });
    }


    public void handleClick(View view){
        switch(view.getId()){
            case R.id.playerOneTimer:
                playerOneClick();
                break;
            case R.id.playerTwoTimer:
                playerTwoClick();
                break;
        }
    }

    private void playerOneClick(){
        playerOneClock.setEnabled(false);
        playerTwoClock.setEnabled(true);
        playerTwoClock.setText("ENABLED");
        playerOneClock.setText("");


    }
    private void playerTwoClick(){
        playerOneClock.setEnabled(true);
        playerTwoClock.setEnabled(false);

        playerTwoClock.setText("");
        playerOneClock.setText("ENABLED");
    }
}
