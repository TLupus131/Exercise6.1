package com.example.helloworld.Slot3;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class LoadDataActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        listView = findViewById(R.id.activity5Lv);
        getDataToListView();
    }

    private void getDataToListView(){
        String[] arr = new String[]{
                "Java for Beginner",
                "Computer science introduction",
                "Mobile programing",
                "Cross-platform with .Net",
                "Javascript Introduction"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(adapter);
    }
}
