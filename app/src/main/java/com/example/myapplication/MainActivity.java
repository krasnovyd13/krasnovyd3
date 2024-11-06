package com.example.myapplication;





import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private EditText txtDisplay;

    private double valueOne, valueTwo;

    private String operator;

    private boolean isOperatorPressed;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        txtDisplay = findViewById(R.id.txtDisplay);



        // Attach button listeners

        findViewById(R.id.btn1).setOnClickListener(this::onNumberClick);

        findViewById(R.id.btnPlus).setOnClickListener(this::onOperatorClick);

        findViewById(R.id.btnEquals).setOnClickListener(this::onEqualsClick);

        findViewById(R.id.btnC).setOnClickListener(this::onClearClick);

        findViewById(R.id.btnBackspace).setOnClickListener(this::onBackspaceClick);

    }



    public void onNumberClick(View view) {

        Button btn = (Button) view;

        if (isOperatorPressed) {

            txtDisplay.setText("");

            isOperatorPressed = false;

        }

        txtDisplay.append(btn.getText().toString());

    }



    public void onOperatorClick(View view) {

        Button btn = (Button) view;

        valueOne = Double.parseDouble(txtDisplay.getText().toString());

        operator = btn.getText().toString();

        isOperatorPressed = true;

    }



    public void onEqualsClick(View view) {

        valueTwo = Double.parseDouble(txtDisplay.getText().toString());

        double result = 0;



        switch (operator) {

            case "+":

                result = valueOne + valueTwo;

                break;

            case "-":

                result = valueOne - valueTwo;

                break;

            case "*":

                result = valueOne * valueTwo;

                break;

            case "/":

                if (valueTwo != 0) {

                    result = valueOne / valueTwo;

                } else {

                    txtDisplay.setText("Error");

                    return;

                }

                break;

        }

        txtDisplay.setText(String.valueOf(result));

    }



    public void onClearClick(View view) {

        txtDisplay.setText("");

        valueOne = 0;

        valueTwo = 0;

        operator = null;

    }



    public void onBackspaceClick(View view) {

        String text = txtDisplay.getText().toString();

        if (!text.isEmpty()) {

            txtDisplay.setText(text.substring(0, text.length() - 1));

        }

    }

}
