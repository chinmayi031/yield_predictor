package com.example.ne.yield_predictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class getresult extends AppCompatActivity{
TextView cond,height;
Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getresult);

        height = findViewById(R.id.height);

        String str1= getIntent().getExtras().getString("keys");
        height.setText(str1);


        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotologoutpage();
            }
        });


    }
    private void  gotologoutpage()
    {
        Intent intent = new Intent(getresult.this,resultpage.class);
        startActivity(intent);
    }


}
