package com.mybuddywilson.chess.timer;

import android.app.Activity;
import android.os.Bundle;
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
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);


    }
}
