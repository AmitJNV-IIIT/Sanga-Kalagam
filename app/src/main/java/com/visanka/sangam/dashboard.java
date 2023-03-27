package com.visanka.sangam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboard extends Activity implements View.OnClickListener {
    Button button_1,button_2,button_3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        button_1=findViewById(R.id.button_1);
        button_1.setOnClickListener(this);
        button_2=findViewById(R.id.button_2);
        button_2.setOnClickListener(this);
        button_3=findViewById(R.id.button_3);
        button_3.setOnClickListener(this);

}
    @Override
    public void onClick(View view) {
        if(view==button_1 || view==button_2|| view==button_3){
            Intent i = new Intent(dashboard.this,sangham_details.class);
            startActivity(i);
        }
    }
}
