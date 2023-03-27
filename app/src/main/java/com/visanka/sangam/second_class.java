package com.visanka.sangam;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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


public class second_class extends Activity implements View.OnClickListener {



    private Button submit_2;
    private RadioButton user,superadmin,admin,manager;
    private RadioGroup radiogroup;
    EditText username,userpass;
    ProgressDialog ProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
        submit_2=findViewById(R.id.submit_2);
        submit_2.setOnClickListener(this);
        user=findViewById(R.id.user);
        superadmin=findViewById(R.id.superadmin);
        username=findViewById(R.id.username);
        userpass=findViewById(R.id.userpass);
        admin=findViewById(R.id.admin);
        manager=findViewById(R.id.manager);
        radiogroup=findViewById(R.id.radiogroup);
        ProgressDialog = new ProgressDialog(this);


    }
    private void register() {

        String inputname = username.getText().toString();
        String inputemail = userpass.getText().toString();

        if (inputname.length()==0 && inputemail.length()==0) {
            Toast.makeText(getApplicationContext(), "please enter username and password", Toast.LENGTH_LONG).show();

        }
        else if (inputemail.length()<8){
            Toast.makeText(getApplicationContext(), "password must be of 8 or more characters", Toast.LENGTH_LONG).show();
        }

        else {


            ProgressDialog.setMessage("regestering user...");
            ProgressDialog.show();

            StringRequest stringrequest = new StringRequest(Request.Method.POST, params.LOGIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response)  {
                            ProgressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"logined As "+inputname, Toast.LENGTH_LONG).show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    ProgressDialog.hide();
                    Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();

                }
            }){
                @Override
                public Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("inputname",inputname);
                    params.put("inputemail",inputemail);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringrequest);

            Intent i = new Intent(second_class.this,dashboard.class);
            startActivity(i);
        }

    }






    public void checksa(){
        String inputname = username.getText().toString();
        String inputemail = userpass.getText().toString();
        if (inputname.length()==0 && inputemail.length()==0) {
            Toast.makeText(getApplicationContext(), "please enter username and password", Toast.LENGTH_LONG).show();
        }
        else if (inputemail.length()<8){
            Toast.makeText(getApplicationContext(), "password must be of 8 or more characters", Toast.LENGTH_LONG).show();
        }

        else{
            Intent i = new Intent(second_class.this, SuperAdmin.class);
            startActivity(i);
        }
    }
    public void checka(){
        String inputname = username.getText().toString();
        String inputemail = userpass.getText().toString();
        if (inputname.length()==0 && inputemail.length()==0) {
            Toast.makeText(getApplicationContext(), "please enter username and password", Toast.LENGTH_LONG).show();
        }
        else if (inputemail.length()<8){
            Toast.makeText(getApplicationContext(), "password must be of 8 or more characters", Toast.LENGTH_LONG).show();
        }else{Intent i = new Intent(second_class.this, AdminActivity2.class);
            startActivity(i);}
    }
    public void checkm(){
        String inputname = username.getText().toString();
        String inputemail = userpass.getText().toString();
        if (inputname.length()==0 && inputemail.length()==0) {
            Toast.makeText(getApplicationContext(), "please enter username and password", Toast.LENGTH_LONG).show();
        }
        else if (inputemail.length()<8){
            Toast.makeText(getApplicationContext(), "password must be of 8 or more characters", Toast.LENGTH_LONG).show();
        }
        else{Intent i = new Intent(second_class.this, manager.class);
            startActivity(i);}
    }
    public void onClick(View view) {

        if (user.isChecked() && view==submit_2) {

            register();


        } else if (superadmin.isChecked()) {
            checksa();
        } else if (admin.isChecked()) {
            checka();
        } else if (manager.isChecked()) {
            checkm();

}
    }
}