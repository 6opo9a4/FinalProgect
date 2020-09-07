package com.example.laba13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import Persons.Student;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView IT = findViewById(R.id.IT);
        ListView LesHoz = findViewById(R.id.LesHoz);
        ArrayList<Student> stud = new ArrayList<Student>();
        String[] names= new String[]{"1","2","3","4","5"};
        String[] surnames = new String[]{"1","2","3","4","5"};
    }
}