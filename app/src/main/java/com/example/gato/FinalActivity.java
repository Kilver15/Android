package com.example.gato;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class FinalActivity extends AppCompatActivity {

    private TextView winnerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalactivity);

        winnerTextView = findViewById(R.id.winnerTextView);

        // Recibe el ganador a través de un Intent
        Intent intent = getIntent();
        String winner = intent.getStringExtra("winner");
        winnerTextView.setText("El ganador es: " + winner);
    }

    public void onRestartGameClick(View view) {
        // Volver a la pantalla de bienvenida
        Intent intent = new Intent(FinalActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
