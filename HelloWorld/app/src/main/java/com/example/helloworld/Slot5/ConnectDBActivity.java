package com.example.helloworld.Slot5;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class ConnectDBActivity extends AppCompatActivity {
    ListView listView;
    Adapter adapter;
    List<Product> list = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.studentListView);
//        SqliteHelper helper = new SqliteHelper(this);
//        SQLiteDatabase db = helper.getReadableDatabase();
        ProductDao productDao = new ProductDao(this);
//        Product product = new Product("3", "Product 3", 123, 0);
//        int result = productDao.insertProduct(product);
        list = productDao.getAll();
        adapter = new Adapter(list, this);
        listView.setAdapter(adapter);
    }
}
