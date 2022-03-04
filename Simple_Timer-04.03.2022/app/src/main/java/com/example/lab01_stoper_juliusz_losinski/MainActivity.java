package com.example.lab01_stoper_juliusz_losinski;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // DESC:
    /*
        Firstly the onCreate method is called and current state is passed.
        By this we can read the previous state and set the fields/ data.
        After reading the package, thread/ handler is created and it's working in the background.
        The main flag is called "running", by using this we can control the thread.
    */

    // REGION: FIELDS. ----------------------------------]
    int seconds=0;     // Number of seconds.
    boolean running=false; // Is currently running?
    boolean before=false;  // Was it running before?
    // --------------------------------------------------]

    // REGION: METHODS ----------------------------------]
    // TARGET: Doing the start operations.
    @Override
    protected void onCreate(Bundle pack)
    {
        // 1. Saving the package.
        super.onCreate(pack);

        // 2. Setting the content view.
        setContentView(R.layout.activity_main);

        // 3. Reading the context of package if there's something.
        // 3.1 If pack is not empty, read it.
        if(pack!=null)
        {
            // 3.1 Getting the number of seconds.
            seconds=pack.getInt("seconds");

            // 3.2 Getting the status/ running.
            running=pack.getBoolean("running");

            // 3.3 Getting the status: Was is running before?
            before=pack.getBoolean("before");
        }

        // 4. Starting the timer.
        StartTimer();
    }

    // TARGET: Stating the timer.
    private void StartTimer()
    {
        // 1. Getting the display.
        TextView display = findViewById(R.id.id_display);

        // 2. Setting the handler.
        final Handler handler=new Handler();
        handler.post(
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        // 2.1 Converting data.
                        int hours=(seconds/3600);
                        int minutes=(seconds/3600)/60;
                        int sec=(seconds)%60;
                        String time=String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, sec);

                        // 2.2 Setting the text.
                        display.setText(time);

                        // 2.3 Checking if is it still working.
                        if(running)
                        {
                            seconds++;
                        }

                        // 2.4 Adding post.
                        handler.postDelayed(this, 1000);
                    }
                }
        );
    }

    // TARGET: Pause the timer.
    @Override
    protected void onPause()
    {
        // 1. Calling the parent method.
        super.onPause();

        // 2. Setting the fields.
        before=running;
        running=false;

        // 3. Printing the log.
        Log.v("kom.2", "onPause is called!");
    }

    // TARGET: Resume the timer.
    protected void onResume()
    {
        // 1. Calling the parent method.
        super.onResume();

        // 2. Checking if was running before.
        if(before)
        {
            // 2.1 Setting running to be true.
            running=true;
        }

        // 3. Printing the log.
        Log.v("kom.1", "onResume is called!");
    }

    // TARGET: Run timer.
    public void Start(View v)
    {
        // 1. Setting the flag.
        running=true;
    }

    // TARGET: Stop timer.
    public void Stop(View v)
    {
        // 1. Setting the flag.
        running=false;
    }

    // TARGET: Restart timer.
    public void Restart(View v)
    {
        // 1. Setting the flag.
        running=false;

        // 2. Reset seconds.
        seconds=0;
    }

    // TARGET: Saving the current state of activity.
    @Override
    protected void onSaveInstanceState(Bundle pack)
    {
        // 1. Saving the package.
        super.onSaveInstanceState(pack);

        // 2. Putting the number of seconds to package.
        pack.putInt("seconds", seconds);

        // 3. Putting the current status/ running to pack.
        pack.putBoolean("running", running);
    }
    // --------------------------------------------------]
}