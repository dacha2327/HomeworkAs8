package com.dacha.homeworkas8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Double oldNumber, newNumber;
    private String operator;
    private Boolean isOperationClick = false;
    private Boolean equal = true;
    private Button btn_go_over;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            textView = findViewById(R.id.text_view);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textView = findViewById(R.id.text_view);
            btn_go_over = findViewById(R.id.click);
            findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    String result = ((TextView) findViewById(R.id.text_view)).getText().toString();
                    intent.putExtra("result", result);
                    startActivity(intent);
                }
            });
        }

        public void onNumberClick(View view) {
            switch (view.getId()) {
                case R.id.btn_zero:
                    if (textView.getText().toString().equals("0")) {
                        textView.setText("0");
                    } else {
                        textView.append("0");
                    }
                    break;
                case R.id.btn_one:
                    setNumber("1");
                    break;
                case R.id.btn_two:
                    setNumber("2");
                    break;
                case R.id.btn_three:
                    setNumber("3");
                    break;
                case R.id.btn_four:
                    setNumber("4");
                    break;
                case R.id.btn_five:
                    setNumber("5");
                    break;
                case R.id.btn_six:
                    setNumber("6");
                    break;
                case R.id.btn_seven:
                    setNumber("7");
                    break;
                case R.id.btn_eight:
                    setNumber("8");
                    break;
                case R.id.btn_nine:
                    setNumber("9");
                    break;
                case R.id.btn_point:
                    if (!textView.getText().toString().contains(".")) {
                        textView.append(".");
                    }
                    break;
                case R.id.btn_clear:
                    textView.setText("0");
                    oldNumber = 0.0;
                    newNumber = 0.0;
                    break;
            }
            btn_go_over.setVisibility(View.INVISIBLE);
            isOperationClick = false;
        }

        private void setNumber(String number) {
            if (textView.getText().toString().equals("0")) {
                textView.setText(number);
            } else if (isOperationClick) {
                textView.setText(number);
            } else {
                textView.append(number);
            }
            isOperationClick = false;
        }


        public void onOperationClick(View view) {

            btn_go_over.setVisibility(View.INVISIBLE);
            switch (view.getId()) {
                case R.id.btn_plus:
                    operator = "+";
                    oldNumber = Double.parseDouble(textView.getText().toString());
                    isOperationClick = true;
                    break;
                case R.id.btn_minus:
                    operator = "-";
                    oldNumber = Double.parseDouble(textView.getText().toString());
                    isOperationClick = true;
                    break;
                case R.id.btn_multiplication:
                    operator = "*";
                    oldNumber = Double.parseDouble(textView.getText().toString());
                    isOperationClick = true;
                    break;
                case R.id.btn_division:
                    operator = "/";
                    oldNumber = Double.parseDouble(textView.getText().toString());
                    isOperationClick = true;
                    break;
                case R.id.btn_percent:
                    operator = "/";
                    oldNumber = Double.parseDouble(textView.getText().toString());
                    Double resullt = Double.valueOf(0);
                    isOperationClick = true;
                    switch (operator) {
                        case "/":
                            resullt = oldNumber / 100;
                            break;
                    }
                    textView.setText(new
                            DecimalFormat("##.#######").format(resullt));
                    break;
                case R.id.btn_plus_or_minus:
                    operator = "+/-";
                    oldNumber = Double.parseDouble(textView.getText().toString());
                    Double resultS = Double.valueOf(0);
                    isOperationClick = true;
                    switch (operator) {
                        case "+/-":
                            resultS = oldNumber *= -1;
                            break;
                    }
                    textView.setText(new DecimalFormat("##.#######").format(resultS));
                    break;
                case R.id.btn_equal:
                    btn_go_over.setVisibility(view.getVisibility());
                    newNumber = Double.parseDouble(textView.getText().toString());
                    Double result = Double.valueOf(0);
                    switch (operator) {
                        case "+":
                            result = oldNumber + newNumber;
                            break;
                        case "-":
                            result = oldNumber - newNumber;
                            break;
                        case "x":
                            result = oldNumber * newNumber;
                            break;
                        case "/":
                            result = oldNumber / newNumber;
                            break;
                        case "//":
                            result = oldNumber / 100;
                            break;
                    }
                    textView.setText(new DecimalFormat("##.#######").format(result));
                    btn_go_over.setVisibility(view.getVisibility());
                    isOperationClick = true;
                    break;}
        }
    }