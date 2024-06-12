package com.example.helloworld.Slot4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private DemoBaseAdapter adapter;
    private List<Student> studentList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.studentListView);
        studentList.add(new Student("Nguyen Van A","18",R.drawable.android));
        studentList.add(new Student("Tran Van B","19",R.drawable.apple));
        studentList.add(new Student("Vu Van C","20",R.drawable.blogger));
        studentList.add(new Student("Nguyen Van D","22",R.drawable.hp));
        studentList.add(new Student("Hoang Van E","18",R.drawable.chrome));
        studentList.add(new Student("Nguyen Van Y","17",R.drawable.ic_launcher_background));
        studentList.add(new Student("Nguyen Van X","19",R.drawable.dell));
        studentList.add(new Student("Nguyen Van G","21",R.drawable.facebook));
        studentList.add(new Student("Nguyen Van Z","23",R.drawable.hancock));
        adapter = new DemoBaseAdapter(this, studentList);
        listView.setAdapter(adapter);
    }
}
