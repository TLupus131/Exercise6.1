package com.example.helloworld.Slot2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class ResultActivity extends AppCompatActivity {

    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView tv2 = findViewById(R.id.tv2);

        double result = getIntent().getDoubleExtra("result", 0.0);
        tv2.setText(String.valueOf(result));
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, CalculatorActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
