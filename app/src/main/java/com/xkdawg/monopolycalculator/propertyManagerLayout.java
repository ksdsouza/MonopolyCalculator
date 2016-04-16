package com.xkdawg.monopolycalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.util.Scanner;

public class propertyManagerLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String prop = intent.getStringExtra("propId");
        String color = intent.getStringExtra("color");
        Util.debug("Monopoly Calculator","Property is: "+prop);
        setContentView(R.layout.activity_property_manager_layout);
        TextView tv = (TextView)findViewById(R.id.TitleColor);
        tv.setBackgroundColor(Color.parseColor(color));
        tv.setText(prop);

        Scanner fileScanner = new Scanner(getResources().openRawResource(R.raw.information));
        while(fileScanner.hasNext()){

            String currentLine = fileScanner.nextLine();
            if(currentLine.equalsIgnoreCase(prop)){
                Util.debug("Monopoly Calculator","Found the line!");
                TextView text = (TextView)findViewById(R.id.rent);
                text.setText("$"+fileScanner.nextLine().substring(6));

                text = (TextView)findViewById(R.id.H1);
                text.setText("$"+fileScanner.nextLine().substring(4));

                text = (TextView)findViewById(R.id.H2);
                text.setText("$"+fileScanner.nextLine().substring(4));

                text= (TextView)findViewById(R.id.H3);
                text.setText("$"+fileScanner.nextLine().substring(4));

                text= (TextView)findViewById(R.id.H4);
                text.setText("$"+fileScanner.nextLine().substring(4));

                text= (TextView)findViewById(R.id.H5);
                text.setText("$"+fileScanner.nextLine().substring(4));

                text=(TextView)findViewById(R.id.mortVal);
                text.setText("$"+fileScanner.nextLine().substring(13));

                text=(TextView)findViewById(R.id.unmortVal);
                text.setText("$"+fileScanner.nextLine().substring(9));

                text=(TextView)findViewById(R.id.houseCost);
                text.setText("$"+fileScanner.nextLine().substring(7));

            }
        }
    }
}
