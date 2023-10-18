package com.example.intents;
import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class intentspagina extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
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
                String textToShare = "¡Te saludo desde mi aplicación creada en Android Studio!";
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, textToShare);
                startActivity(Intent.createChooser(shareIntent, "Compartir con"));
            }
        });
        btnImplicit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear un Intent para seleccionar una imagen
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*"); // Filtrar para que solo se muestren imágenes

                int REQUEST_SELECT_IMAGE = 1;
                startActivityForResult(intent, REQUEST_SELECT_IMAGE);
            }
        });


        btnImplicit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "8715653029";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
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
