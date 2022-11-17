package dev.tomco.a23a_10357_l02;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity2 extends AppCompatActivity {

    final int DELAY = 1000;

    MaterialTextView timer_LBL_time;
    ExtendedFloatingActionButton timer_FAB_start;
    ExtendedFloatingActionButton timer_FAB_stop;
    long startTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        findViews();
        initViews();
    }

    private void updateTimerUI() {
        long millis = System.currentTimeMillis() - startTime;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        int hours = minutes / 60;
        minutes = minutes % 60;
        hours %= 24;

        timer_LBL_time.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    private void stopTimer() {
        timer.cancel();
    }

    private Timer timer = new Timer();

    private void startTimer() {
        startTime = System.currentTimeMillis();
        timer = new Timer();
        timer.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        Log.d("TimerCount A:", Thread.currentThread().getName() + " " + System.currentTimeMillis());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.d("TimerCount B:", Thread.currentThread().getName() + " " + System.currentTimeMillis());
                                TimerActivity2.this.updateTimerUI();
                            }
                        });
                    }
                }
                , DELAY, DELAY);
    }

    private void findViews() {
        timer_FAB_stop = findViewById(R.id.timer_FAB_stop);
        timer_FAB_start = findViewById(R.id.timer_FAB_start);
        timer_LBL_time = findViewById(R.id.timer_LBL_time);
    }

    private void initViews() {
        timer_FAB_start.setOnClickListener(v -> startTimer());
        timer_FAB_stop.setOnClickListener(v -> stopTimer());
    }
}