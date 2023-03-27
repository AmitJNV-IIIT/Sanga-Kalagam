package com.visanka.sangam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class SuperAdmin extends AppCompatActivity implements View.OnClickListener {

    TextView superadmintxt;
    EditText superadmininput;
    ProgressDialog ProgressDialog;
    Button superadminbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.super_admin);
        superadmininput = findViewById(R.id.superadmininput);
        superadminbutton = findViewById(R.id.superadminbutton);
        superadminbutton.setOnClickListener(this);
        ProgressDialog = new ProgressDialog(this);
    }

    private void register() {
        final String username = superadmininput.getText().toString();


            ProgressDialog.setMessage("Restricting Admin...");
            ProgressDialog.show();

            StringRequest stringrequest = new StringRequest(Request.Method.POST, params.SUPERADMIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            ProgressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Admin Restricted", Toast.LENGTH_LONG).show();
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
                    params.put("managerentry",username);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringrequest);

        }

    @Override
    public void onClick(View view) {
        if(view == superadminbutton ){
            register();
        }
    }
}

