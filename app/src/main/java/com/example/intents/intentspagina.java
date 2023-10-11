package com.example.intents;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class intentspagina extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentspagina);

        // Botones para intents implícitos
        Button btnImplicit1 = findViewById(R.id.btnImplicit1);
        Button btnImplicit2 = findViewById(R.id.btnImplicit2);
        Button btnImplicit3 = findViewById(R.id.btnImplicit3);
        Button btnImplicit4 = findViewById(R.id.btnImplicit4);

        // Botones para intents explícitos
        Button btnExplicit1 = findViewById(R.id.btnExplicit1);
        Button btnExplicit2 = findViewById(R.id.btnExplicit2);
        Button btnExplicit3 = findViewById(R.id.btnExplicit3);
        Button btnExplicit4 = findViewById(R.id.btnExplicit4);

        // Configurar OnClickListener para los botones de intents implícitos
        btnImplicit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent implícito para abrir https://uttorreon.mx/
                Uri webpage = Uri.parse("https://uttorreon.mx/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        btnImplicit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent implícito para abrir https://moodle.uttcampus.edu.mx/login/index.php
                Uri webpage = Uri.parse("https://moodle.uttcampus.edu.mx/login/index.php");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        btnImplicit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent implícito para abrir https://www.facebook.com/
                Uri webpage = Uri.parse("https://www.facebook.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        btnImplicit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent implícito para abrir https://www.google.com/sky/
                Uri webpage = Uri.parse("https://www.google.com/sky/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        // Configurar OnClickListener para los botones de intents explícitos
        btnExplicit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent explícito para ir a Activity1
                Intent intent = new Intent(intentspagina.this, activity1.class);
                startActivity(intent);
            }
        });

        btnExplicit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent explícito para ir a Activity2
                Intent intent = new Intent(intentspagina.this, activity2.class);
                startActivity(intent);
            }
        });

        btnExplicit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent explícito para ir a Activity3
                Intent intent = new Intent(intentspagina.this, activity3.class);
                startActivity(intent);
            }
        });

        btnExplicit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent explícito para ir a Activity4
                Intent intent = new Intent(intentspagina.this, activity4.class);
                startActivity(intent);
            }
        });
    }
}
