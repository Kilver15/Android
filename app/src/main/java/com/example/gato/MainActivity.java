package com.example.gato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView countdownTextView;
    private int countdown = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownTextView = findViewById(R.id.countdownTextView);

        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                countdownTextView.setText(String.valueOf(countdown));
                countdown--;
            }

            public void onFinish() {
                // Iniciar el juego
                Intent intent = new Intent(MainActivity.this, GatoActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}
