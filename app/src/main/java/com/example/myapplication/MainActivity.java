package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
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
            // Utiliza una pila para evaluar expresiones más largas
            String[] tokens = expression.split(" ");
            Stack<Double> operands = new Stack<>();
            Stack<String> operators = new Stack<>();

            for (String token : tokens) {
                if (isNumeric(token)) {
                    operands.push(Double.parseDouble(token));
                } else if (isOperator(token)) {
                    while (!operators.isEmpty() && hasPrecedence(operators.peek(), token)) {
                        applyOperator(operators.pop(), operands);
                    }
                    operators.push(token);
                }
            }

            while (!operators.isEmpty()) {
                applyOperator(operators.pop(), operands);
            }

            if (operands.size() == 1) {
                return String.valueOf(operands.pop());
            } else {
                return "Error";
            }
        } catch (Exception e) {
            return "Error";
        }
    }

    // Verifica si un token es un número
    private boolean isNumeric(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
    // Verifica si un token es un operador
    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    // Verifica si el operador1 tiene mayor o igual precedencia que operador2
    private boolean hasPrecedence(String operator1, String operator2) {
        int precedence1 = getPrecedence(operator1);
        int precedence2 = getPrecedence(operator2);
        return precedence1 >= precedence2;
    }

    // Determina la precedencia de los operadores
    private int getPrecedence(String operator) {
        if ("+".equals(operator) || "-".equals(operator)) {
            return 1;
        } else if ("*".equals(operator) || "/".equals(operator)) {
            return 2;
        }
        return 0;
    }

    // Aplica un operador a los operandos en la pila
    private void applyOperator(String operator, Stack<Double> operands) {
        if (operands.size() < 2) {
            // Manejar el caso de error aquí
            return;
        }
        double operand2 = operands.pop();
        double operand1 = operands.pop();
        double result = 0;
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
                    // Manejar la división por cero aquí
                    return;
                }
                break;
        }
        operands.push(result);
    }
}
