package com.example.gato;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private TextView winnerTextView;
    private Button button;
    private int contadorX;
    private int contadorO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalactivity);

        winnerTextView = findViewById(R.id.winnerTextView);
        button = findViewById(R.id.restartButton);

        Intent intent = getIntent();
        String winner = intent.getStringExtra("winner"); // Recuperar la cadena "winner"

        if (winner != null) {
            if (winner.equals("x")) {
                winnerTextView.setText("El ganador es: X");
                contadorX = 1;
            } else if (winner.equals("o")) {
                winnerTextView.setText("El ganador es: O");
                contadorO = 1;
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalActivity.this, MainActivity.class);
                if (winner.equals("x")) {
                    intent.putExtra("ganador","ganoX");
                }
                else {
                    intent.putExtra("ganador","GanoO");
                }
                SharedPreferences prefs = getSharedPreferences("Puntuaciones", MODE_PRIVATE);
                int xScore = prefs.getInt("xScore", 0);
                int oScore = prefs.getInt("oScore", 0);
                startActivity(intent);
            }
        });
    }
}
