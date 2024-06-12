package com.example.helloworld.Slot6;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtId, txtName, txtQuantity;
    Button btnLoad, btnInsert, btnDelete, btnUpdate;
    ListView listView;
    ProductDao productDao;
    ArrayAdapter<String> arrayAdapter;
    List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Mapping();
    }

    private void LoadContent(){
        list.clear();
        list = productDao.getAllProductToString();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
    }

    private void Mapping(){
        txtId = findViewById(R.id.txtProductId);
        txtName = findViewById(R.id.txtProductName);
        txtQuantity = findViewById(R.id.txtQuantity);
        btnLoad = findViewById(R.id.btnLoad);
        btnInsert = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        listView = findViewById(R.id.lvProduct);
        productDao = new ProductDao(this);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadContent();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product p = new Product();
                p.setProductId(txtId.getText().toString());
                p.setProductName(txtName.getText().toString());
                p.setQuantity(Integer.parseInt(txtQuantity.getText().toString()));
                int result = productDao.insertProduct(p);
                if (result == -1){
                    Toast.makeText(getApplicationContext(), "Insert failed!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Insert successful!", Toast.LENGTH_SHORT).show();
                    LoadContent();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = productDao.deleteProduct(txtId.getText().toString());
                if (result == -1){
                    Toast.makeText(getApplicationContext(), "Delete failed!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Delete successful!", Toast.LENGTH_SHORT).show();
                    LoadContent();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product p = new Product();
                p.setProductId(txtId.getText().toString());
                p.setProductName(txtName.getText().toString());
                p.setQuantity(Integer.parseInt(txtQuantity.getText().toString()));
                int result = productDao.updateProduct(p);
                if (result == -1){
                    Toast.makeText(getApplicationContext(), "Update failed!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Update successful!", Toast.LENGTH_SHORT).show();
                    LoadContent();
                }
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String item = list.get(position);
            String[] parts = item.split(" - ");
            if (parts.length == 3) {
                txtId.setText(parts[0]);
                txtName.setText(parts[1]);
                txtQuantity.setText(parts[2]);
            } else {
                Toast.makeText(getApplicationContext(), "Error parsing item data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}