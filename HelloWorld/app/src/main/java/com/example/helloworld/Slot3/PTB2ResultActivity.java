package com.example.helloworld.Slot3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;
import com.example.helloworld.Slot2.CalculatorActivity;
import com.example.helloworld.Slot2.ResultActivity;

public class PTB2ResultActivity extends AppCompatActivity {
    TextView tvResult;
    Button btn1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptb2_result);
        tvResult = findViewById(R.id.textView6);
        btn1 = findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PTB2ResultActivity.this, PTB2CalculatorActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intent1 = getIntent();
        int a = Integer.parseInt(intent1.getExtras().getString("hsa"));
        int b = Integer.parseInt(intent1.getExtras().getString("hsb"));
        int c = Integer.parseInt(intent1.getExtras().getString("hsc"));
        int delta = b*b - 4*a*c;
        if(delta < 0){
            tvResult.setText("Phương trình vô nghiệm");
        } else if(delta == 0){
            tvResult.setText("Phương trình có nghiệm kép: \nx1 = x2 = " + (-b)/(2*a));
        } else {
            float x1 = (float) ((-b + Math.sqrt(delta))/(2*a));
            float x2 = (float) ((-b - Math.sqrt(delta))/(2*a));
            tvResult.setText("Phương trình có 2 nghiệm:\nx1 = " + x1 + "\nx2 = " + x2);
        }
    }
}
