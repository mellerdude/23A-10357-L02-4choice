package dev.tomco.a23a_10357_l02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

public class TimerActivity extends AppCompatActivity {

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

    final Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this,DELAY); //do it again in a second.
            updateTimerUI();
        }
    };

    private void updateTimerUI() {
        Log.d("TimerCount",""+System.currentTimeMillis());
        long millis = System.currentTimeMillis() - startTime;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        int hours = minutes / 60;
        minutes = minutes % 60;
        hours %= 24;

        timer_LBL_time.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }


    private void initViews() {
        timer_FAB_start.setOnClickListener(v -> startTimer());
        timer_FAB_stop.setOnClickListener(v -> stopTimer());
    }

    private void stopTimer() {
        handler.removeCallbacks(runnable);
    }

    private void startTimer() {
        startTime = System.currentTimeMillis();
        handler.postDelayed(runnable,DELAY);
    }

    private void findViews() {
        timer_FAB_stop = findViewById(R.id.timer_FAB_stop);
        timer_FAB_start = findViewById(R.id.timer_FAB_start);
        timer_LBL_time = findViewById(R.id.timer_LBL_time);
    }
}