package com.visanka.sangam;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.AuthFailureError;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    private EditText name,email,pass,address,phone;
    private Button submit,login;
    private ProgressDialog ProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);


        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);


        ProgressDialog = new ProgressDialog(this);

    }

    private void register() {
        final String inputname = name.getText().toString().trim();
        final String inputemail = email.getText().toString().trim();
        final String inputpass = pass.getText().toString().trim();
        final String inputaddress = address.getText().toString().trim();
        final String inputphone = phone.getText().toString().trim();
        if (inputname.length() == 0 && inputemail.length() == 0 && inputpass.length() == 0 && inputaddress.length() == 0 && inputphone.length() == 0) {
            Toast.makeText(getApplicationContext(), "please enter username and password", Toast.LENGTH_LONG).show();
        } else if (inputpass.length() < 8) {
            Toast.makeText(getApplicationContext(), "password must be of 8 or more characters", Toast.LENGTH_LONG).show();
        } else {
            ProgressDialog.setMessage("regestering user...");
            ProgressDialog.show();

            StringRequest stringrequest = new StringRequest(Request.Method.POST, params.FILE_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            ProgressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "registered", Toast.LENGTH_LONG).show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    ProgressDialog.hide();
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

                }
            }) {
                @Override
                public Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("inputname", inputname);
                    params.put("inputemail", inputemail);
                    params.put("inputpass", inputpass);
                    params.put("inputaddress", inputaddress);
                    params.put("inputphone", inputphone);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringrequest);

        }
    }



    public void onClick(View view){
        if(view == submit){
            register();
        }
        else if (view == login){
            Intent i = new Intent(MainActivity.this,push_notificationActivity.class);
            startActivity(i);
        }

    }

}