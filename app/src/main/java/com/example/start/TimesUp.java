package com.example.start;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TimesUp extends AppCompatActivity {

    private TextView textView20, textViewDrink, textViewExe;
    private TextView textView1, textView2, textView3;

    private Switch aSwitch20, aSwitchDrink, aSwitchExe;

    String switchOn = "Reminder is ON";
    String switchOff = "";

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds20 = 120000;
    private long timeLeftInMillisecondsD = 60000;
    private long timeLeftInMillisecondsE = 120000;
    private boolean timerRunning = false;
    private boolean timerDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times_up);

        textView20 = (TextView) findViewById(R.id.textView20);
        textViewDrink = (TextView) findViewById(R.id.textViewDrink);
        textViewExe = (TextView) findViewById(R.id.textViewExe);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        aSwitch20 = (Switch) findViewById(R.id.switch1);
        aSwitchDrink = (Switch) findViewById(R.id.switch2);
        aSwitchExe = (Switch) findViewById(R.id.switch3);

        aSwitch20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView1.setText(switchOn);
                    bReaction20();
                } else {
                    textView1.setText(switchOff);
                }
            }
        });

        if (aSwitch20.isChecked()) {
            textView1.setText(switchOn);
        } else {
            textView1.setText(switchOff);
        }

        aSwitchDrink.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView2.setText(switchOn);
                    bReactionD();
                } else {
                    textView2.setText(switchOff);
                }
            }
        });

        if (aSwitchDrink.isChecked()) {
            textView2.setText(switchOn);
        } else {
            textView2.setText(switchOff);
        }

        aSwitchExe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView3.setText(switchOn);
                    bReactionE();
                } else {
                    textView3.setText(switchOff);
                }
            }
        });

        if (aSwitchExe.isChecked()) {
            textView3.setText(switchOn);
        } else {
            textView3.setText(switchOff);
        }
    }

    public void bReaction20() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(TimesUp.this);
                builder.setSmallIcon(R.drawable.ic_alarm);
                builder.setContentTitle("Hey! It's been 20 minutes!");
                builder.setContentText("Time to have a break from your phone!");
                Notification notification = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(1, notification);
            }
        }, 1000);
    }

    public void bReactionD() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(TimesUp.this);
                builder.setSmallIcon(R.drawable.ic_alarm);
                builder.setContentTitle("Hey! Don't forget to have a drink!");
                builder.setContentText("You need to have 2 liters of water a day!");
                Notification notification = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(2, notification);
            }
        }, 7200000);
    }

    public void bReactionE() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(TimesUp.this);
                builder.setSmallIcon(R.drawable.ic_alarm);
                builder.setContentTitle("Hey! Relax your muscles!!");
                builder.setContentText("Time to do some stretching!");
                Notification notification = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(3, notification);
            }
        }, 21600000);
    }
}
