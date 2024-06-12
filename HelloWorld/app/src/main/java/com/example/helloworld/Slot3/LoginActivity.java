package com.example.helloworld.Slot3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class LoginActivity extends AppCompatActivity {
    EditText txt1, txt2;
    Button btn1;

    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        txt1 = findViewById(R.id.txt_Username);
        txt2 = findViewById(R.id.txt_Password);
        btn1 = findViewById(R.id.btn_Login);
        tv1 = findViewById(R.id.textView3);
        tv2 = findViewById(R.id.textView4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        if (txt1.getText().toString().equals("admin") && txt2.getText().toString().equals("123")){
            Toast.makeText(LoginActivity.this, "Login successfull", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(LoginActivity.this, "Wrong username or password!", Toast.LENGTH_SHORT).show();
        }
    }
}
