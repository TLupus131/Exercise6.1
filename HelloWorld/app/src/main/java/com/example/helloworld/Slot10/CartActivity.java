package com.example.helloworld.Slot10;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.helloworld.R;
import com.example.helloworld.Slot9.Product;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView listView;
    private CartAdapter adapter;
    private CartManager manager;
    List<Product> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        listView = findViewById(R.id.lvCardItem);
        manager = CartManager.getInstance();
        items = manager.getCartItems();
        adapter = new CartAdapter(this, items);
        listView.setAdapter(adapter);
    }
}