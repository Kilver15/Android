package com.example.conversiongrados;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.conversiongrados.models.Celsius;
import com.example.conversiongrados.models.Fahrenheit;
import com.example.conversiongrados.models.Kelvin;
import com.example.conversiongrados.models.Grado;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private EditText editText;
    private Button botonConvertir;
    private TextView celsiusText, fahrenheitText, kelvinText;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         botonConvertir = findViewById(R.id.botonconvertir);
         celsiusText = findViewById(R.id.celsiustext);
         fahrenheitText = findViewById(R.id.fahrenheittext);
         kelvinText = findViewById(R.id.kelvintext);
         editText = findViewById(R.id.editText);

        botonConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String seleccion = spinner.getSelectedItem().toString();
                    String valor = editText.getText().toString();

                    if (!valor.isEmpty()) {
                        double grados = Double.parseDouble(valor);

                        if (seleccion.equals("Celsius")) {
                            Celsius celsius = new Celsius(grados, "C");
                            Fahrenheit fahrenheit = celsius.CtoFahrenheit();
                            Kelvin kelvin = celsius.CtoKelvin();

                            celsiusText.setText("Celsius: " + celsius.getValor());
                            fahrenheitText.setText("Fahrenheit: " + fahrenheit.getValor());
                            kelvinText.setText("Kelvin: " + kelvin.getValor());
                        } else if (seleccion.equals("Fahrenheit")) {
                            Fahrenheit fahrenheit = new Fahrenheit(grados, "F");
                            Celsius celsius = fahrenheit.FtoCelsius();
                            Kelvin kelvin = fahrenheit.FtoKelvin();

                            celsiusText.setText("Celsius: " + celsius.getValor());
                            fahrenheitText.setText("Fahrenheit: " + fahrenheit.getValor());
                            kelvinText.setText("Kelvin: " + kelvin.getValor());
                        } else if (seleccion.equals("Kelvin")) {
                            Kelvin kelvin = new Kelvin(grados, "K");
                            Celsius celsius = kelvin.KtoCelsius();
                            Fahrenheit fahrenheit = kelvin.KtoFahrenheit();

                            celsiusText.setText("Celsius: " + celsius.getValor());
                            fahrenheitText.setText("Fahrenheit: " + fahrenheit.getValor());
                            kelvinText.setText("Kelvin: " + kelvin.getValor());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Ocurrió un error durante la conversión", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
