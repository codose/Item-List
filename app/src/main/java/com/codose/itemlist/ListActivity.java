package com.codose.itemlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity {

    ArrayList<String> itemNames = new ArrayList<>(Arrays.asList("Puff Puff", "Egg Roll", "Chin Chin", "Fish Roll","Small Chops", "Cookies","Bread","Pizza"));
    ArrayList<String> itemPrice = new ArrayList<>(Arrays.asList("50","150","200","150","550","450","350","2500"));
    ArrayList<Integer> itemImage = new ArrayList<>(Arrays.asList(R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image));


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
