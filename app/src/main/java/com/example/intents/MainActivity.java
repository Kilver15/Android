package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private TextView countdownTextView;
    private int countdownValue = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownTextView = findViewById(R.id.Cuenta);

        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                countdownTextView.setText(String.valueOf(countdownValue));
                countdownValue--;
            }

            public void onFinish() {
                countdownTextView.setText("0");
                Intent intent = new Intent(MainActivity.this, intentspagina.class);
                startActivity(intent);
            }
        }.start();
    }
}