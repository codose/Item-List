package com.codose.itemlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    ImageView productPic;
    TextView productName;
    TextView productPrice;
    private String publicKey;
    private String encryptionKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
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

        Button btnbuy = findViewById(R.id.buybtn);
        btnbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* new RavePayManager(CheckoutActivity.this)
                        .setAmount(price)
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
                        .initialize(); */
            }
        });
    }
}
