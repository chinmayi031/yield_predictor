package com.example.ne.yield_predictor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class selectitype extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectitype);

        Button changelang = findViewById(R.id.change);

        changelang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });
    }
    private void showChangeLanguageDialog() {

        final String[] listItems = {"Hybrid methi red soil","Hybrid methi black soil","Methi red soil","Methi black soil"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(selectitype.this);
        mBuilder.setTitle("Choose type of methi");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0){
                    Intent i = new Intent(selectitype.this,HMRS.class);
                    startActivity(i);
                    recreate();
                }
                else if(which == 1) {
                    Intent i = new Intent(selectitype.this,HMBS.class);
                    startActivity(i);
                    recreate();
                }
                else if(which == 2){
                    Intent i = new Intent(selectitype.this,MRS.class);
                    startActivity(i);
                    recreate();

                }
                else if(which == 3) {
                    Intent i = new Intent(selectitype.this,MBS.class);
                    startActivity(i);
                    recreate();
                }

                dialog.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }
}
