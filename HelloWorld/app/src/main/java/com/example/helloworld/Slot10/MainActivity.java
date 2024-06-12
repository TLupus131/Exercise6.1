package com.example.helloworld.Slot10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.helloworld.R;
import com.example.helloworld.Slot9.Product;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private TextView tvStyleId, tvBrand, tvPrice, tvInfo;
    private ImageView imageView;
    Button btnAddToCart;
    Intent intent;
    Product product;
    private CartManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        imageView = findViewById(R.id.Slot10_image_view_1);
        tvStyleId = findViewById(R.id.Slot10_tvStyleId);
        tvBrand = findViewById(R.id.Slot10_tvBrand);
        tvPrice = findViewById(R.id.Slot10_tvPrice);
        tvInfo = findViewById(R.id.Slot10_tvInfo);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        manager = CartManager.getInstance();
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCart();
            }
        });
        intent = getIntent();
        product = intent.getParcelableExtra("PRODUCT");
        if (product != null) {
            Picasso.get().load(product.getSearchImage()).into(imageView);
            tvStyleId.setText(product.getStyleId());
            tvBrand.setText(product.getBrand());
            tvPrice.setText(product.getPrice());
            tvInfo.setText(product.getInfo());
        }
    }

    private void showCart() {
        Intent intent1 = getIntent();
        Product product1 = intent1.getParcelableExtra("PRODUCT");
        if (product1 != null) {
            manager.addProductToCart(product1);
            Intent intent2 = new Intent(this, CartActivity.class);
            startActivity(intent2);
        }
    }
}