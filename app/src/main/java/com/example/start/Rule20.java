package com.example.start;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Rule20 extends AppCompatActivity {

    private TextView cdownText;
    private Button cdownButton;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 1200000;
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule20);

        cdownText = (TextView) findViewById(R.id.cDown_text);
        cdownButton = (Button) findViewById(R.id.cDown_button);

        cdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });

        updateTimer();
    }

    public void startStop() {
        if (timerRunning) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = 1;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        cdownButton.setText("PAUSE");
        timerRunning = true;
    }

    public void stopTimer() {
        countDownTimer.cancel();
        cdownButton.setText("STOP");
        timerRunning = false;
    }

    public void updateTimer() {
        int min = (int) timeLeftInMillis / 60000;
        int sec = (int) timeLeftInMillis % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + min;
        timeLeftText += ":";
        if (sec < 10) timeLeftText += "0";
        timeLeftText += sec;

        cdownText.setText(timeLeftText);
    }
}
