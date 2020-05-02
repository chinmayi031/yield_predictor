package com.example.ne.yield_predictor;

import android.content.Intent;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MRS extends AppCompatActivity{
    EditText pH, an, aph, apk, ect, ech;
    Button analyse,upl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mrs);

        pH = (EditText) findViewById(R.id.ph);
        an = (EditText) findViewById(R.id.nitrogen);
        aph = (EditText) findViewById(R.id.phosphorus);
        apk = (EditText) findViewById(R.id.potassium);
        ect = (EditText) findViewById(R.id.temperature);
        ech = (EditText) findViewById(R.id.humidity);
        analyse = (Button) findViewById(R.id.analyse);
        upl =  (Button)findViewById(R.id.np);

        upl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotouploadpage();
            }
        });

        analyse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                analyseresult();
            }
        });
    }

    private  void gotouploadpage(){
        Intent i = new Intent(MRS.this,upload_activity.class);
        startActivity(i);
    }

    private void analyseresult() {
        Double nph = Double.parseDouble(pH.getText().toString().trim());
        Double nan = Double.parseDouble(an.getText().toString().trim());
        Double naph = Double.parseDouble(aph.getText().toString().trim());
        Double napk = Double.parseDouble(apk.getText().toString().trim());
        Double temp = Double.parseDouble(ect.getText().toString().trim());
        Double hum = Double.parseDouble(ech.getText().toString().trim());

        int flagph = 0;
        int flagn = 0;
        int flagpho = 0;
        int flagpk = 0;
        int flagtemp = 0;
        int flaghumi = 0;

        if (nph < 6.5 || nph > 8.0) {
            flagph = 1;
        }
        if (nan < 8.0 || nan > 13.0) {
            flagn = 1;
        }
        if (naph < 9.0 || naph > 15.0) {
            flagpho = 1;
        }
        if (napk < 10.0 || napk > 14.0) {
            flagpk = 1;
        }
        if (temp < 25 || temp > 30) {
            flagtemp = 1;
        }
        if (hum < 87 || hum > 90) {
            flaghumi = 1;
        }

        if (flagn == 0 && flaghumi == 0 && flagph == 0 && flagpho == 0 && flagpk == 0 && flagtemp == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), " Environmental Condition is good to grow plant", Toast.LENGTH_SHORT);
            toast.setMargin(100, 100);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();

           /* String str="  Environmental Condition is good to grow plant";
            Intent i = new Intent(HMBS.this, getresult.class);
            i.putExtra("key1",str);

            startActivity(i);*/
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Environmental Condition is not appropriate to grow plant", Toast.LENGTH_LONG);
            toast.setMargin(100, 100);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();


            /*String str=" Environmental Condition is not appropriate to grow plant";
            Intent i = new Intent(HMBS.this, getresult.class);
            i.putExtra("key1",str);

            startActivity(i);*/
        }
    }
}
