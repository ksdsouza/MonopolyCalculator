package com.xkdawg.monopolycalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.logging.Logger;

public class overviewActivity extends AppCompatActivity {
    private TextView money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        getSupportActionBar().setTitle("Monopoly Calculator");
    }
    public void goToMath(View v){
        Intent intent = new Intent(this, mathActivity.class);
        money = (TextView)findViewById(R.id.playerMoney);
        if(v.getId()==R.id.add){
            intent.putExtra("op","+");
        }
        else{
            intent.putExtra("op","-");
        }
        intent.putExtra("$",money.getText());
        Util.info("Monopoly Calculator",money.getText().toString());
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                money.setText("$"+data.getIntExtra("Result", -1));
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Util.info("Monopoly Calculator - overviewActivity","Something weird happened!?");
            }
        }
    }


}
