package com.example.gato;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GatoActivity extends AppCompatActivity {

    private Button[] buttons = new Button[9];
    private boolean playerX = true;
    private int[] gameState = new int[9];
    private int xScore = 0;
    private int oScore = 0;
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gatoactivity);

        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);
        buttons[6] = findViewById(R.id.button7);
        buttons[7] = findViewById(R.id.button8);
        buttons[8] = findViewById(R.id.button9);

        scoreTextView = findViewById(R.id.scoreTextView);

        for (int i = 0; i < 9; i++) {
            gameState[i] = 0;
        }
    }

    public void onButtonClick(View view) {
        Button clickedButton = (Button) view;
        int tag = Integer.parseInt(clickedButton.getTag().toString());

        if (gameState[tag] == 0) {
            if (playerX) {
                clickedButton.setText("X");
                gameState[tag] = 1;
            } else {
                clickedButton.setText("O");
                gameState[tag] = 2;
            }

            if (checkForWinner()) {
                if (playerX) {
                    xScore++;
                    showWinner("X");
                } else {
                    oScore++;
                    showWinner("O");
                }
                updateScore();
            } else {
                playerX = !playerX;
            }
        }
    }

    private boolean checkForWinner() {
        // Implementa la lógica para verificar si hay un ganador
        // Añade tu lógica aquí
        return false; // Reemplaza esto con tu lógica real
    }

    private void showWinner(String winner) {
        // Muestra al ganador en una nueva actividad
        Intent intent = new Intent(GatoActivity.this, FinalActivity.class);
        intent.putExtra("winner", winner);
        startActivity(intent);
    }

    private void updateScore() {
        scoreTextView.setText("Marcador: X - " + xScore + " | O - " + oScore);
    }
}
