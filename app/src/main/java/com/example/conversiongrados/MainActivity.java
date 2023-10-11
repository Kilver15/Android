package com.example.conversiongrados;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.conversiongrados.models.Celsius;
import com.example.conversiongrados.models.Fahrenheit;
import com.example.conversiongrados.models.Kelvin;

public class MainActivity extends AppCompatActivity {
    private EditText editTextCelsius;
    private Button buttonConvert;
    private TextView textViewFahrenheit, textViewKelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewFahrenheit = findViewById(R.id.textViewFahrenheit);
        textViewKelvin = findViewById(R.id.textViewKelvin);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String celsiusStr = editTextCelsius.getText().toString();

                if (!celsiusStr.isEmpty()) {
                    double celsius = Double.parseDouble(celsiusStr);
                    Celsius celsiusInstance = new Celsius(celsius, "C");
                    Fahrenheit fahrenheit = celsiusInstance.parseF(celsiusInstance);
                    Kelvin kelvin = celsiusInstance.parseK(celsiusInstance);
                    textViewFahrenheit.setText("Fahrenheit: " + fahrenheit.getValor());
                    textViewKelvin.setText("Kelvin: " + kelvin.getValor());
                }
            }
        });
    }
}
