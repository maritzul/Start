package com.example.start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setTime(View view) {
        Intent intent = new Intent(this, TimesUp.class);
        Button button = (Button) findViewById(R.id.button);
        startActivity(intent);
    }
}
