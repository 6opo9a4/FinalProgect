package com.example.laba5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.HashMap;

import Desk.Lesson;
import Lectors.Lector;

public class LessonForm extends AppCompatActivity {
    String lesson;
    String comment;
    int month = 0;
    int select = 0;
    TextInputLayout less;
    TextInputLayout comm;
    private static final String BOOKKEY = "bookname";
    private static final String PRICEKEY = "bookprice";
    private static final String IMGKEY = "iconfromraw";
    Lesson finalLesson;
    private ArrayList<HashMap<String, Object>> myBooks = new ArrayList<>();
    String[] time = {"8:00-9:35", "9:50-11:25", "11:40-13:15", "13:40-15:15", "15:30-17:05", "17:20-18:55","19:10-20:45"};
    int selectedLek=-1;
    int selectedTime=-1;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_form);
        Bundle arguments = getIntent().getExtras();
        month = arguments.getInt("Layout");
        day = arguments.getInt("Day");
        less = findViewById(R.id.Lesson);
        comm = findViewById(R.id.Comment);

        Spinner Lector = (Spinner) findViewById(R.id.spinner3);
        Spinner Time = (Spinner) findViewById(R.id.spinner4);
        HashMap<String, Object> hm;
        hm = new HashMap<String, Object>();

        Lector odin = new Lector("Perwyi","1","Memologia",R.drawable.download1);
        Lector dwa = new Lector("Wtoroy","2","Trilliriwanie",R.drawable.download2);
        Lector tri = new Lector("Tretyi","3","Chill",R.drawable.download3);
        Lector chetyre = new Lector("Chetwertyi","4","Prokrastination",R.drawable.download4);
        Lector pyat = new Lector("Pyatyi","5","Design",R.drawable.download5);

        hm.put(BOOKKEY, odin.name);
        hm.put(PRICEKEY, odin.surname);
        hm.put(IMGKEY,  odin.photo);
        myBooks.add(hm);
        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, dwa.name);
        hm.put(PRICEKEY, dwa.surname);
        hm.put(IMGKEY,  dwa.photo);
        myBooks.add(hm);
        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, tri.name);
        hm.put(PRICEKEY, tri.surname);
        hm.put(IMGKEY,  tri.photo);
        myBooks.add(hm);
        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, chetyre.name);
        hm.put(PRICEKEY, chetyre.surname);
        hm.put(IMGKEY,  chetyre.photo);
        myBooks.add(hm);
        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, pyat.name);
        hm.put(PRICEKEY, pyat.surname);
        hm.put(IMGKEY,  pyat.photo);
        myBooks.add(hm);

        SimpleAdapter adapter = new SimpleAdapter(this, myBooks,R.layout.list, new String[]{BOOKKEY,PRICEKEY,IMGKEY}, new int[]{R.id.text1, R.id.text2, R.id.img});
        Lector.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, time);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Time.setAdapter(adapter2);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLek = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        Lector.setOnItemSelectedListener(itemSelectedListener);

        AdapterView.OnItemSelectedListener itemSelectedListener2 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTime = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        Time.setOnItemSelectedListener(itemSelectedListener2);
    }


    public void Confirm(View view)
    {
        lesson = less.getEditText().getText().toString();
        comment = comm.getEditText().getText().toString();

        if(lesson != null && comment != null && selectedLek != -1 && selectedTime != -1) {

            switch (month) {
                case 1:
                    Intent intent1 = new Intent(LessonForm.this, AddDesk1Week.class);
                    intent1.putExtra("Lector", selectedLek);
                    intent1.putExtra("Lesson", lesson);
                    intent1.putExtra("Time", selectedTime);
                    intent1.putExtra("Comment", comment);
                    intent1.putExtra("Day", day);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(LessonForm.this, AddDesk2Week.class);
                    intent2.putExtra("Lector", selectedLek);
                    intent2.putExtra("Lesson", lesson);
                    intent2.putExtra("Time", selectedTime);
                    intent2.putExtra("Comment", comment);
                    intent2.putExtra("Day", day);
                    startActivity(intent2);
                    break;
            }
        }
        else
        {
        }
    }

    public void Back(View view)
    {
        switch (month)
        {
            case 1:
                Intent intent1 = new Intent(LessonForm.this, AddDesk1Week.class);
                intent1.putExtra("Day", 0);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(LessonForm.this, AddDesk2Week.class);
                intent2.putExtra("Day", 0);
                startActivity(intent2);
                break;
        }
    }
}