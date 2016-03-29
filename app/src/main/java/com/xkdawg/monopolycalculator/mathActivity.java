package com.xkdawg.monopolycalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class mathActivity extends AppCompatActivity {
    public String num2 = "";
    public String operation = "";
    private TextView operationTV;
    private TextView operand;
    private String money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        Intent intent = getIntent();
        String buttonFrom = intent.getStringExtra("op");
        if (buttonFrom.equalsIgnoreCase("+")) {
            operation = " + ";
        } else {
            operation = " - ";
        }

        money = intent.getStringExtra("$");
        TextView moneyTV = (TextView) findViewById(R.id.money);
        moneyTV.setText(money);


        operationTV = (TextView) findViewById(R.id.operation);
        operand = (TextView) findViewById(R.id.operand);

        operationTV.setText(operation);

    }

    public void clearNum(View v) {
        num2 = "";


        operand.setText(num2);


    }

    public void addOperation(View v) {
        if (operationTV != null) {
            operationTV.setText(" + ");
            operation = " + ";
        }
    }

    public void subtractOperation(View v) {
        if (operationTV != null) {
            operationTV.setText(" - ");
            operation = " - ";
        }
    }

    public void del(View v) {
        if (num2 != null && num2.length() > 0) {
            num2 = num2.substring(0, num2.length() - 1);
        }
        operand.setText(num2);

    }

    public void doMath(View v) {
        Intent resultIntent = new Intent();
        int total = -1;
        money = money.substring(1);
        try {
            if (operation.equals(" + ")) {
                total = Integer.parseInt(money) + Integer.parseInt(num2);
                Util.info("Monopoly Calculator - mathActivity", "" + Integer.parseInt(money.substring(1)));
                money = "";
            } else {
                total = Integer.parseInt(money) - Integer.parseInt(num2);
            }
        } catch (Exception e) {
            Util.error("Monopoly Calculator - mathActivity", e.toString());
        }
        resultIntent.putExtra("Result", total);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void createNum(View v) {
        switch (v.getId()) {
            case R.id.math_1: {
                num2 += "1";
                break;
            }
            case R.id.math_2: {
                num2 += "2";
                break;
            }
            case R.id.math_3: {
                num2 += "3";
                break;
            }
            case R.id.math_4: {
                num2 += "4";
                break;
            }
            case R.id.math_5: {
                num2 += "5";
                break;
            }
            case R.id.math_6: {
                num2 += "6";
                break;
            }
            case R.id.math_7: {
                num2 += "7";
                break;
            }
            case R.id.math_8: {
                num2 += "8";
                break;
            }
            case R.id.math_9: {
                num2 += "9";
                break;
            }
            default:
                num2 += "0";
        }
        TextView textView = (TextView) findViewById(R.id.operand);
        textView.setText(num2); // Update second operand as numbers are punched in
    }
}
