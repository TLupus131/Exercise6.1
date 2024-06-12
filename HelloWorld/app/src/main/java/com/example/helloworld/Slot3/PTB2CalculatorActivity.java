package com.example.helloworld.Slot3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class PTB2CalculatorActivity extends AppCompatActivity {

    EditText txtA, txtB, txtC;
    Button btn1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        txtA = findViewById(R.id.txt_inputA);
        txtB = findViewById(R.id.txt_inputB);
        txtC = findViewById(R.id.txt_inputC);
        btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    private void sendData(){
        String a = txtA.getText().toString();
        String b = txtB.getText().toString();
        String c = txtC.getText().toString();
        if (Integer.parseInt(a)!=0){
            Intent intent = new Intent(PTB2CalculatorActivity.this, PTB2ResultActivity.class);
            intent.putExtra("hsa",a);
            intent.putExtra("hsb",b);
            intent.putExtra("hsc",c);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Input A cannot be 0! Please input again.", Toast.LENGTH_SHORT).show();
        }
    }
}
