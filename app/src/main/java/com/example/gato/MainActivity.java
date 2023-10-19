package com.example.gato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
        Intent intent = getIntent();
        String contador = intent.getStringExtra("ganador");
        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                countdownTextView.setText(String.valueOf(countdown));
                countdown--;
            }

            public void onFinish() {
                // Iniciar el juego
                Intent intent = new Intent(MainActivity.this, GatoActivity.class);
                if(contador == "ganoX")
                {
                    intent.putExtra("contador","X+");
                } else if (contador == "ganoO") {
                    intent.putExtra("contador","O+");
                }
                SharedPreferences prefs = getSharedPreferences("Puntuaciones", MODE_PRIVATE);
                int xScore = prefs.getInt("xScore", 0);
                int oScore = prefs.getInt("oScore", 0);

                startActivity(intent);
            }
        }.start();
    }
}
