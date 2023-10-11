package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    Button button;
    private boolean lastButtonWasOperator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadoraa);

        // Inicializa los botones y el EditText
        Button clearButton = findViewById(R.id.Botonborrar);
        Button equalsButton = findViewById(R.id.Botonigual);
        editText = findViewById(R.id.editText);

        // Configura el OnClickListener para los botones
        findViewById(R.id.Botonborrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Limpia el EditText
                editText.setText("");
                lastButtonWasOperator = false;
            }
        });

        findViewById(R.id.Botonigual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calcula el resultado y lo muestra en el EditText
                String expression = editText.getText().toString();
                String result = evaluateExpression(expression);
                editText.setText(result);
                lastButtonWasOperator = false;
            }
        });

        // También configura OnClickListener para otros botones numéricos y de operadores
        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.buttonSum).setOnClickListener(this);
        findViewById(R.id.buttonMen).setOnClickListener(this);
        findViewById(R.id.buttonMul).setOnClickListener(this);
        findViewById(R.id.buttonDiv).setOnClickListener(this);
        findViewById(R.id.buttonPun).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Obtén el texto actual en el EditText
        String currentText = editText.getText().toString();

        String buttonId = getResources().getResourceEntryName(view.getId());

        // Determina cuál botón se ha presionado y realiza la acción correspondiente
        switch (buttonId) {
            case "buttonSum":
            case "buttonMen":
            case "buttonMul":
            case "buttonDiv":
                // Verifica si el último botón fue un operador y no permite operadores duplicados
                if (!lastButtonWasOperator && currentText.length() > 0) {
                    Button button = (Button) view;
                    String buttonText = button.getText().toString();
                    editText.setText(currentText + buttonText);
                    lastButtonWasOperator = true;
                }
                break;
            default:
                // Agrega el texto del botón al EditText
                Button button = (Button) view;
                String buttonText = button.getText().toString();
                editText.setText(currentText + buttonText);
                lastButtonWasOperator = false;
                break;
        }
    }

    // Método para evaluar una expresión matemática dada
    private String evaluateExpression(String expression) {
        try {
            // Divide la expresión en operandos y operadores
            String[] tokens = expression.split("");
            if (tokens.length != 3) {
                return "Error";
            }

            double operand1 = Double.parseDouble(tokens[0]);
            String operator = tokens[1];
            double operand2 = Double.parseDouble(tokens[2]);

            // Realiza la operación correspondiente
            double result = 0.0;
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        return "Error";
                    }
                    break;
                default:
                    return "Error";
            }

            return String.valueOf(result);
        } catch (Exception e) {
            return "Error";
        }
    }
}
