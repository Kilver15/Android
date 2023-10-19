package com.example.gato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class GatoActivity extends AppCompatActivity {

    private Button[] buttons = new Button[9];
    private boolean playerX = true;
    private int[] gameState = new int[9];
    private int xScore = 0;
    private int oScore = 0;
    private TextView scoreTextView;

    private static final int[][] WINNING_COMBINATIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  // Líneas horizontales
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  // Líneas verticales
            {0, 4, 8}, {2, 4, 6}              // Líneas diagonales
    };
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Debes terminar la partida", Toast.LENGTH_SHORT).show();

        // O simplemente no hacer nada
        super.onBackPressed();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gatoactivity);
        scoreTextView = findViewById(R.id.scoreTextView);
        SharedPreferences prefs = getSharedPreferences("Puntuaciones", MODE_PRIVATE);
        xScore = prefs.getInt("xScore", 0);
        oScore = prefs.getInt("oScore", 0);


        // Actualizar el marcador en la interfaz de usuario
        scoreTextView.setText("X - " + xScore + " /// " + oScore + " - O");
        for (int i = 1; i <= 9; i++) {
            int resID = getResources().getIdentifier("button" + i, "id", getPackageName());
            final Button button = findViewById(resID);
            buttons[i - 1] = button;  // Guardar los botones en un arreglo

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String buttonText = button.getText().toString();
                    if (buttonText.isEmpty()) {
                        if (playerX) {
                            button.setText("x");
                            int buttonPosition = Arrays.asList(buttons).indexOf(button);
                            gameState[buttonPosition] = 1;  // Marcar la casilla como "x"
                            playerX = false;
                        } else {
                            button.setText("o");
                            int buttonPosition = Arrays.asList(buttons).indexOf(button);
                            gameState[buttonPosition] = 2;  // Marcar la casilla como "o"
                            playerX = true;
                        }

                        // Verificar si hay un ganador después de cada movimiento
                        checkForWinner();
                    }
                }
            });
        }
    }

    private void checkForWinner() {
        for (int[] combination : WINNING_COMBINATIONS) {
            int pos1 = combination[0];
            int pos2 = combination[1];
            int pos3 = combination[2];

            if (gameState[pos1] == gameState[pos2] && gameState[pos2] == gameState[pos3] && gameState[pos1] != 0) {
                // Hay un ganador
                int winner = gameState[pos1];
                if (winner == 1) {
                    xScore++;
                } else {
                    oScore++;
                }

                // Actualizar el marcador en la interfaz de usuario
                scoreTextView.setText("X - " + xScore + " /// " + oScore + " - O");

                // Guardar el marcador en SharedPreferences
                SharedPreferences prefs = getSharedPreferences("Puntuaciones", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("xScore", xScore);
                editor.putInt("oScore", oScore);
                editor.apply();
                Intent intent = new Intent(GatoActivity.this, FinalActivity.class);

                if (winner == 1) {
                    intent.putExtra("winner", "x");
                } else {
                    intent.putExtra("winner", "o");
                }
                startActivity(intent);
            }
        }
    }

}
