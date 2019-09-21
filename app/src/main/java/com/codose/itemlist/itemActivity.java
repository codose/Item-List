package com.codose.itemlist;

import android.content.Intent;
import android.os.Bundle;

import com.flutterwave.raveandroid.RaveConstants;
import com.flutterwave.raveandroid.RavePayActivity;
import com.flutterwave.raveandroid.RavePayManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class itemActivity extends AppCompatActivity {

    ImageView productPic;
    TextView productName;
    TextView productPrice;
    private String publicKey = "FLWPUBK_TEST-4583eb80130c13c020233e93434952cf-X";
    private String encryptionKey = "FLWSECK_TEST37cdf79a9883";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        productPic = findViewById(R.id.productPic);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        Intent intent = getIntent();
        final String price = intent.getExtras().getString("itemPrice");
        productPrice.setText(price);
        String name = intent.getExtras().getString("itemName");
        productName.setText(name);
        int pic = intent.getExtras().getInt("itemPic");
        productPic.setImageResource(pic);
        final Double fPrice = Double.parseDouble(price);

        getSupportActionBar().setTitle(name);

        View btnbuy = findViewById(R.id.buybtn);
        btnbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RavePayManager(itemActivity.this)
                        .setAmount(fPrice)
                        .setCountry("NG")
                        .setCurrency("NGN")
                        .setEmail("osemwingieoshodin@gmail.com")
                        .setfName("Osemwingie")
                        .setlName("Oshodin")
                        .setNarration("Narration")
                        .setPublicKey(publicKey)
                        .setEncryptionKey(encryptionKey)
                        .showStagingLabel(false)
                        .shouldDisplayFee(true)
                        .setTxRef("Transaction reference")
                        .acceptCardPayments(true)
                        .acceptMpesaPayments(false)
                        .acceptGHMobileMoneyPayments(false)
                        .acceptAccountPayments(true)
                        .initialize();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RaveConstants.RAVE_REQUEST_CODE && data != null) {
            if (resultCode == RavePayActivity.RESULT_SUCCESS) {
                Toast.makeText(this, "Payment Successfully made ", Toast.LENGTH_LONG).show();
            } else if (resultCode == RavePayActivity.RESULT_ERROR) {
                Toast.makeText(this, "Transaction Error ", Toast.LENGTH_LONG).show();
            } else if (resultCode == RavePayActivity.RESULT_CANCELLED) {
                Toast.makeText(this, "Transaction Cancelled ", Toast.LENGTH_LONG).show();
            }
        }
    }

}
