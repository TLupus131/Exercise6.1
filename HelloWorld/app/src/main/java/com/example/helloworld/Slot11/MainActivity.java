package com.example.helloworld.Slot11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.helloworld.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3;
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        edt1 = findViewById(R.id.slot11_edtName);
        edt2 = findViewById(R.id.slot11_edtPrice);
        edt3 = findViewById(R.id.slot11_edtDescription);
        tv = findViewById(R.id.slot11_tv);
        btn = findViewById(R.id.slot11_btnInsert);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt1.getText().toString();
                double price = Double.parseDouble(edt2.getText().toString());
                String description = edt3.getText().toString();
                ProductResponse productResponse = new ProductResponse(name, price, description);
                insert(productResponse);
            }
        });
    }

    private void insert(ProductResponse productResponse) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + IPConfig.IPv4 + ":8080")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        InterfaceProduct interfaceProduct = retrofit.create(InterfaceProduct.class);
        Call<ProductResponse> call = interfaceProduct.insert(productResponse);
        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                ProductResponse response1 = response.body();
                tv.setText(response1.getMessage());
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                tv.setText(t.getMessage());            }
        });
    }
}