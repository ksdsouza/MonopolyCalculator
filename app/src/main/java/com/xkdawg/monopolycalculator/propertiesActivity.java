package com.xkdawg.monopolycalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;

public class propertiesActivity extends AppCompatActivity {
    final String[] propNames = {"Mediterranean Ave.", "Baltic Ave."
            , "Oriental Ave.", "Vermont Ave.", "Connecticut Ave."
            , "St. Charles Place", "States Ave.", "Virginia Ave."
            , "St. James Place", "Tennessee Ave.", "New York Ave."
            , "Indiana Ave.", "Kentucky Ave.", "Illinois Ave."
            , "Ventnor Ave.", "Atlantic Ave.", "Marvin Gardens"
            , "Pacific Ave.", "No. Carolina Ave.", "Pennsylvania Ave."
            , "Park Place", "Boardwalk"};
    final String[] color = {"#8c1c9c", "#8c1c9c"
            , "#04bcfc", "#04bcfc", "#04bcfc"
            , "#cc56ae", "#cc56ae", "#cc56ae"
            , "#fcc404", "#fcc404", "#fcc404"
            , "#e40404", "#e40404", "#e40404"
            , "#f4f404", "#f4f404", "#f4f404"
            , "#04d404", "#04d404", "#04d404"
            , "#04449c", "#04449c"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Properties");
        LinearLayout main = (LinearLayout) findViewById(R.id.properties);
        for (int i = 0; i < 22; i++) {
            SwipeLayout swipe = new SwipeLayout(this);

            LinearLayout bottomView = new LinearLayout(this);
            bottomView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                    .WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
            bottomView.setBackgroundColor(getResources().getColor(R.color.colorAccentDark));
            bottomView.setOrientation(LinearLayout.HORIZONTAL);
            bottomView.setGravity(Gravity.CENTER);

            ImageButton button1 = new ImageButton(this);
            button1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                    .WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
            button1.setImageDrawable(getResources().getDrawable(R.drawable.ic_grade_black));

            ImageButton button2 = new ImageButton(this);
            button2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                    .WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
            button2.setImageDrawable(getResources().getDrawable(R.drawable.ic_store_mall_directory_black));

            ImageButton button3 = new ImageButton(this);
            button3.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                    .WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
            button3.setImageDrawable(getResources().getDrawable(R.drawable.ic_highlight_off_black));


            bottomView.addView(button1);
            bottomView.addView(button2);
            bottomView.addView(button3);

            LinearLayout surface = new LinearLayout(this);
            surface.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                    .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            surface.setBackgroundColor(Color.parseColor(color[i]));
            surface.setPadding(Util.dpToPx(this, 10), Util.dpToPx(this, 10), Util.dpToPx(this, 10), Util.dpToPx(this, 10));


            TextView propName = new TextView(this);
            propName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                    .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            if ((i >= 8 && i <= 10) || (i >= 14 && i <= 16)) {
                propName.setTextColor(getResources().getColor(R.color.background));
            } else {
                propName.setTextColor(Color.parseColor("#FFFFFF"));
            }
            propName.setTextSize(34);
            propName.setGravity(Gravity.CENTER);
            propName.setText(propNames[i]);

            surface.addView(propName);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, Util.dpToPx(this, 20), 0, 0);
            swipe.setLayoutParams(params);
            swipe.addView(bottomView);
            swipe.addView(surface);

            main.addView(swipe);

        }
    }

}
