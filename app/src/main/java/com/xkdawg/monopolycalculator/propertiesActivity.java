package com.xkdawg.monopolycalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;

public class propertiesActivity extends AppCompatActivity{
    ImageButton button2;
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
    final int[] propIds = {R.id.Mediterranean, R.id.Baltic
            , R.id.Oriental, R.id.Vermont, R.id.Connecticut
            , R.id.StCharles, R.id.States, R.id.Virginia
            , R.id.StJames, R.id.Tennessee, R.id.NewYork
            , R.id.Indiana, R.id.Kentucky, R.id.Illinois
            , R.id.Ventnor, R.id.Atlantic, R.id.Marvin
            , R.id.Pacific, R.id.NCarolina, R.id.Pennsylvania
            , R.id.Park, R.id.Boardwalk};
    Intent propertiesIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        propertiesIntent = new Intent(this, propertyManagerLayout.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Properties");
        LinearLayout main = (LinearLayout) findViewById(R.id.properties);
        for (int i = 0; i < 22; i++) {
            final SwipeLayout swipe = new SwipeLayout(this);
            swipe.setId(propIds[i]);

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


            button2 = new ImageButton(this);
            button2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                    .WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
            button2.setImageDrawable(getResources().getDrawable(R.drawable.ic_store_mall_directory_black));
            button2.setId(i);
            button2.setOnClickListener(myOnlyhandler);

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
    View.OnClickListener myOnlyhandler = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()){
                case(0):
                    propertiesIntent.putExtra("propId", propNames[0]);
                    propertiesIntent.putExtra("color", color[0]);
                    break;
                case(1):
                    propertiesIntent.putExtra("propId",propNames[1]);
                    propertiesIntent.putExtra("color", color[1]);
                    break;
                case(2):
                    propertiesIntent.putExtra("propId",propNames[2]);
                    propertiesIntent.putExtra("color", color[2]);
                    break;
                case(3):
                    propertiesIntent.putExtra("propId",propNames[3]);
                    propertiesIntent.putExtra("color", color[3]);
                    break;
                case(4):
                    propertiesIntent.putExtra("propId",propNames[4]);
                    propertiesIntent.putExtra("color", color[4]);
                    break;
                case(5):
                    propertiesIntent.putExtra("propId",propNames[5]);
                    propertiesIntent.putExtra("color", color[5]);
                    break;
                case(6):
                    propertiesIntent.putExtra("propId",propNames[6]);
                    propertiesIntent.putExtra("color", color[6]);
                    break;
                case(7):
                    propertiesIntent.putExtra("propId",propNames[7]);
                    propertiesIntent.putExtra("color", color[7]);
                    break;
                case(8):
                    propertiesIntent.putExtra("propId",propNames[8]);
                    propertiesIntent.putExtra("color", color[8]);
                    break;
                case(9):
                    propertiesIntent.putExtra("propId",propNames[9]);
                    propertiesIntent.putExtra("color", color[9]);
                    break;
                case(10):
                    propertiesIntent.putExtra("propId",propNames[10]);
                    propertiesIntent.putExtra("color", color[10]);
                    break;
                case(11):
                    propertiesIntent.putExtra("propId",propNames[11]);
                    propertiesIntent.putExtra("color", color[11]);
                    break;
                case(12):
                    propertiesIntent.putExtra("propId",propNames[12]);
                    propertiesIntent.putExtra("color", color[12]);
                    break;
                case(13):
                    propertiesIntent.putExtra("propId",propNames[13]);
                    propertiesIntent.putExtra("color", color[13]);
                    break;
                case(14):
                    propertiesIntent.putExtra("propId",propNames[14]);
                    propertiesIntent.putExtra("color", color[14]);
                    break;
                case(15):
                    propertiesIntent.putExtra("propId",propNames[15]);
                    propertiesIntent.putExtra("color", color[15]);
                    break;
                case(16):
                    propertiesIntent.putExtra("propId",propNames[16]);
                    propertiesIntent.putExtra("color", color[16]);
                    break;
                case(17):
                    propertiesIntent.putExtra("propId",propNames[17]);
                    propertiesIntent.putExtra("color", color[17]);
                    break;
                case(18):
                    propertiesIntent.putExtra("propId",propNames[18]);
                    propertiesIntent.putExtra("color", color[18]);
                    break;
                case(19):
                    propertiesIntent.putExtra("propId",propNames[19]);
                    propertiesIntent.putExtra("color", color[19]);
                    break;
                case(20):
                    propertiesIntent.putExtra("propId",propNames[20]);
                    propertiesIntent.putExtra("color", color[20]);
                    break;
                case(21):
                    propertiesIntent.putExtra("propId",propNames[21]);
                    propertiesIntent.putExtra("color", color[21]);
                    break;
            }
            startActivity(propertiesIntent);
        }
    };
}
