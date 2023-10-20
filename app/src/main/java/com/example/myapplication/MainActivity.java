package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private StringBuilder input = new StringBuilder();
    private double result = 0;
    private char lastOperator = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadoraa);

        editText = findViewById(R.id.editText);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        input.append(buttonText);
        editText.setText(input.toString());
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        char newOperator = button.getText().toString().charAt(0);

        if (input.length() > 0) {
            if (lastOperator != ' ') {
                // Si ya hay un operador anterior, realiza la operación actual
                calculateResult();
            }
            lastOperator = newOperator;
            input.append(newOperator);
            editText.setText(input.toString());
        }
    }

    public void onEqualsClick(View view) {
        if (input.length() > 0 && lastOperator != ' ') {
            calculateResult();
            lastOperator = ' ';
        }
    }

    public void onClearClick(View view) {
        editText.setText("");
        input.setLength(0);
        result = 0;
        lastOperator = ' ';
    }

    private void calculateResult() {
        String[] parts = input.toString().split("[" + lastOperator + "]");
        if (parts.length == 2) {
            double num1 = Double.parseDouble(parts[0]);
            double num2 = Double.parseDouble(parts[1]);
            switch (lastOperator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        editText.setText("Error");
                        return;
                    }
                    break;
            }
            input.setLength(0);
            input.append(result);
            editText.setText(String.valueOf(result));
        }
    }
}