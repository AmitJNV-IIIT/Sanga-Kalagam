package com.visanka.sangam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sangham_details extends Activity {
    private Button fee;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sangham_details);
        fee = findViewById(R.id.fee);
        fee.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View view){
        if (view == fee){
            Intent i = new Intent(sangham_details.this,payment.class);
            startActivity(i);
        }

    }

}