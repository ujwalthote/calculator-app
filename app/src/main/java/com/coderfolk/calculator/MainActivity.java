package com.coderfolk.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button add, sub, mul, div = null;
    TextView answer = null;
    EditText value1, value2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        answer = (TextView) findViewById(R.id.textView);
        value1 = (EditText) findViewById(R.id.editText);
        value2 = (EditText) findViewById(R.id.editText2);
        value1.setText("");
        value2.setText("");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidekeyboard();              //to hide keyboard after clicking on button
                if (value1.getText().toString().equals("")) {
                    answer.setText(R.string.warning);
                    answer.setTextColor(Color.RED);
                } else if (value2.getText().toString().equals("")) {
                    answer.setText(R.string.warning);
                    answer.setTextColor(Color.RED);
                } else {
                    double number1 = Double.parseDouble(value1.getText().toString());
                    double number2 = Double.parseDouble(value2.getText().toString());
                    double number3 = number1 + number2;
                    answer.setText(String.valueOf(number3));
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidekeyboard();
                if (value1.getText().toString().equals("")) {
                    answer.setText(R.string.warning);
                    answer.setTextColor(Color.RED);
                } else if (value2.getText().toString().equals("")) {
                    answer.setText(R.string.warning);
                    answer.setTextColor(Color.RED);
                } else {
                    double number1 = Double.parseDouble(value1.getText().toString());
                    double number2 = Double.parseDouble(value2.getText().toString());
                    double number3 = number1 - number2;
                    answer.setText(String.valueOf(number3));
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidekeyboard();
                if (value1.getText().toString().equals("")) {
                    answer.setText(R.string.warning);
                    answer.setTextColor(Color.RED);
                } else if (value2.getText().toString().equals("")) {
                    answer.setText(R.string.warning);
                    answer.setTextColor(Color.RED);
                } else {
                    double number1 = Double.parseDouble(value1.getText().toString());
                    double number2 = Double.parseDouble(value2.getText().toString());
                    double number3 = number1 * number2;
                    answer.setText(String.valueOf(number3));
                }

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidekeyboard();
                if (value1.getText().toString().equals("")) {
                    answer.setText(R.string.warning);
                    answer.setTextColor(Color.RED);
                } else if (value2.getText().toString().equals("")) {
                    answer.setText(R.string.warning);
                    answer.setTextColor(Color.RED);
                } else {
                    double number3 = 0;
                    try {
                        double number1 = Double.parseDouble(value1.getText().toString());
                        double number2 = Double.parseDouble(value2.getText().toString());
                        number3 = number1 / number2;
                        answer.setText(String.valueOf(number3));
                    } catch (ArithmeticException e) {
                        e.printStackTrace();
                        answer.setTextColor(Color.RED);
                        answer.setText("You should not divide any number by zero");
                    }
                    answer.setText(String.valueOf(number3));
                }
            }
        });
    }

    private void hidekeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
}
