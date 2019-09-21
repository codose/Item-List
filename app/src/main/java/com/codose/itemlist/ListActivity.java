package com.codose.itemlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity {

    ArrayList<String> itemNames = new ArrayList<>(Arrays.asList("Samsung Galaxy A10", "Samsung Galaxy A20", "iPhone X", "Samsung Galaxy S10","Samsung Galaxy Note 10", "iPhone XS","iPhone XS Max","Samsung Galaxy A80"));
    ArrayList<String> itemPrice = new ArrayList<>(Arrays.asList("45000","54000","350000","480000","520000","520000","540000","120000"));
    ArrayList<Integer> itemImage = new ArrayList<>(Arrays.asList(R.drawable.a10,R.drawable.a20,R.drawable.iphonex,R.drawable.s10,R.drawable.note10,R.drawable.iphonexs,R.drawable.iphonexsm,R.drawable.a80));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = findViewById(R.id.item_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        final ListAdapter listAdapter = new ListAdapter(ListActivity.this,itemNames,itemPrice,itemImage);
        recyclerView.setAdapter(listAdapter);


    }

}
