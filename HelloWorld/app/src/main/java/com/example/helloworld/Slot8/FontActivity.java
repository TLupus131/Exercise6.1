package com.example.helloworld.Slot8;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class FontActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        textView = findViewById(R.id.tvSlot8);
        Typeface font = Typeface.createFromAsset(getAssets(), "Blazed.ttf");
        textView.setTypeface(font);
    }
}