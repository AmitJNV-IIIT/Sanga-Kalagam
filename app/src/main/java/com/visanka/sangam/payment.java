package com.visanka.sangam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class payment extends AppCompatActivity implements PaymentResultListener {
    Button btPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btPay=findViewById(R.id.bt_pay);
        String sA="100"; //intia
        int amount= Math.round(Float.parseFloat(sA)*100);

        btPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkout checkout=new Checkout();
                checkout.setKeyID("rzp_test_gyWiJnU56kYhuz");
                checkout.setImage(com.razorpay.R.drawable.rzp_logo);
                JSONObject object=new JSONObject();
                try {
                    object.put("name","amit");
                    object.put("description","membership fee Pay");
                    object.put("theme.color","#0093DD");
                    object.put("currency","INR");
                    object.put("amount",amount);
                    object.put("prefill.contact","6386299717");
                    object.put("prefill.email","amitiiit@gmail.com");
                    checkout.open(payment.this,object);
                }catch (JSONException e){ e.printStackTrace();}
            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Payment successful with Payment ID");
        builder.setMessage(s);
      //  builder.setMessage("");
        builder.show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Cancel", Toast.LENGTH_SHORT).show();
    }
}