package com.example.laba5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Desk.Day;
import Desk.FirstWeek;
import Desk.Lesson;
import Desk.Postpon;
import Desk.PostponLessons;
import Desk.SecondWeek;
import Lectors.Lector;

public class ChangeLesson extends AppCompatActivity {

    String lesson;
    String comment;
    int month = 0;
    int select = 0;
    TextView timechko;
    TextView postpons;
    TextInputLayout less;
    TextInputLayout comm;
    TextInputEditText editless;
    TextInputEditText editcomm;
    private static final String BOOKKEY = "bookname";
    private static final String PRICEKEY = "bookprice";
    private static final String IMGKEY = "iconfromraw";
    Lesson finalLesson;
    private ArrayList<HashMap<String, Object>> myBooks = new ArrayList<>();
    String[] time = {"8:00-9:35", "9:50-11:25", "11:40-13:15", "13:40-15:15", "15:30-17:05", "17:20-18:55","19:10-20:45"};
    int selectedLek=-1;
    int selectedTime=-1;
    int day;
    int tima;
    int muvie;
    String Time;
    String Data;
    String timeTo;

    Lectors.Lector odin = new Lector("Perwyi","1","Memologia",R.drawable.download1);
    Lector dwa = new Lector("Wtoroy","2","Trilliriwanie",R.drawable.download2);
    Lector tri = new Lector("Tretyi","3","Chill",R.drawable.download3);
    Lector chetyre = new Lector("Chetwertyi","4","Prokrastination",R.drawable.download4);
    Lector pyat = new Lector("Pyatyi","5","Design",R.drawable.download5);

    public ArrayList<Lesson> mondayLesson = new ArrayList<>();
    public Day monday = new Day(2,mondayLesson);
    public ArrayList<Lesson> thuesdayLesson = new ArrayList<>();
    public Day thuesday = new Day(3,thuesdayLesson);
    public ArrayList<Lesson> wednesdayLesson = new ArrayList<>();
    public Day wednesday = new Day(4,wednesdayLesson);
    public ArrayList<Lesson> thursdayLesson = new ArrayList<>();
    public Day thursday = new Day(5,thursdayLesson);
    public ArrayList<Lesson> fridayLesson = new ArrayList<>();
    public Day friday = new Day(6,fridayLesson);
    public ArrayList<Lesson> saturdayLesson = new ArrayList<>();
    public Day saturday = new Day(7,saturdayLesson);

    FirstWeek week = new FirstWeek(monday,thuesday,wednesday,thursday,friday,saturday);
    SecondWeek week2 = new SecondWeek(monday,thuesday,wednesday,thursday,friday,saturday);

    public ArrayList<Postpon> postpon = new ArrayList<>();
    public PostponLessons postponLesson =  new PostponLessons(postpon);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_lesson);

        Bundle arguments = getIntent().getExtras();
        month = arguments.getInt("Week");
        day = arguments.getInt("Day");
        tima = arguments.getInt("Time");
        muvie = arguments.getInt("Muvie");

        less = findViewById(R.id.Lesson);
        comm = findViewById(R.id.Comment);
        editless = findViewById(R.id.LessonSet);
        editcomm = findViewById(R.id.PlaseSet);
        timechko = findViewById(R.id.SelectedTime);
        postpons = findViewById(R.id.Postpon);

        if(muvie == 2)
        {
            Data = arguments.getString("DatePerenosa");
        }

        if(month == 0)
        {
            try {
                deserializeListOfObjects1();
                switch(day)
                {
                    case 2:
                        finalLesson = week.monday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week.monday.lesso.remove(tima);
                            serializationToJsonM();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                    case 3:
                        finalLesson = week.tuesday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week.tuesday.lesso.remove(tima);
                            serializationToJsonM();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                    case 4:
                        finalLesson = week.wednesday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week.wednesday.lesso.remove(tima);
                            serializationToJsonM();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                    case 5:
                        finalLesson = week.thursday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week.thursday.lesso.remove(tima);
                            serializationToJsonM();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                    case 6:
                        finalLesson = week.friday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week.friday.lesso.remove(tima);
                            serializationToJsonM();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                    case 7:
                        finalLesson = week.saturday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week.saturday.lesso.remove(tima);
                            serializationToJsonM();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            try {
                deserializeListOfObjects2();
                switch(day)
                {
                    case 2:
                        finalLesson = week2.monday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week2.monday.lesso.remove(tima);
                            serializationToJsonM2();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                    case 3:
                        finalLesson = week2.tuesday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week2.tuesday.lesso.remove(tima);
                            serializationToJsonM2();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                    case 4:
                        finalLesson = week2.wednesday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week2.wednesday.lesso.remove(tima);
                            serializationToJsonM2();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                    case 5:
                        finalLesson = week2.thursday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week2.thursday.lesso.remove(tima);
                            serializationToJsonM2();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                    case 6:
                        finalLesson = week2.friday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week2.friday.lesso.remove(tima);
                            serializationToJsonM2();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                    case 7:
                        finalLesson = week2.saturday.lesso.get(tima);
                        if(muvie == 1)
                        {
                            week2.saturday.lesso.remove(tima);
                            serializationToJsonM2();
                            Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
                            startActivity(intent1);
                        }
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FillIn(finalLesson);
        Spinner Lector = (Spinner) findViewById(R.id.spinner3);
        HashMap<String, Object> hm;
        hm = new HashMap<String, Object>();

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

    }

    public void FillIn(Lesson finalLesson)
    {
        editless.setText(finalLesson.less);
        editcomm.setText(finalLesson.comment);
        timechko.setText(finalLesson.time);
        timeTo=finalLesson.time;
        if(muvie == 2)
        {
            postpons.setText("Date Of Postpon " + Data);
        }
    }

    public void Confirm(View view) throws IOException {
        lesson = less.getEditText().getText().toString();
        comment = comm.getEditText().getText().toString();
        Postpon perenos = new Postpon();

        if(lesson != null && comment != null && selectedLek != -1) {
            Time = time[selectedLek];
            switch (selectedLek)
            {
                case 1:
                    finalLesson =  new Lesson(odin,lesson,timeTo,comment);
                    if(muvie == 2)
                    {
                        perenos = new Postpon(odin,lesson,timeTo,comment,Data);
                    }
                    break;
                case 2:
                    finalLesson =  new Lesson(dwa,lesson,timeTo,comment);
                    if(muvie == 2)
                    {
                        perenos = new Postpon(dwa,lesson,timeTo,comment,Data);
                    }
                    break;
                case 3:
                    finalLesson =  new Lesson(tri,lesson,timeTo,comment);
                    if(muvie == 2)
                    {
                        perenos = new Postpon(tri,lesson,timeTo,comment,Data);
                    }
                    break;
                case 4:
                    finalLesson =  new Lesson(chetyre,lesson,timeTo,comment);
                    if(muvie == 2)
                    {
                        perenos = new Postpon(chetyre,lesson,timeTo,comment,Data);
                    }
                    break;
                case 5:
                    finalLesson =  new Lesson(pyat,lesson,timeTo,comment);
                    if(muvie == 2)
                    {
                        perenos = new Postpon(pyat,lesson,timeTo,comment,Data);
                    }
                    break;
            }

            if(muvie == 2)
            {
                deserializeListOfObjectsPostpon();
                int check = 0;
                for(int i = 0;i<postponLesson.postpon.size();i++)
                {
                    if(perenos.data.equals(postponLesson.postpon.get(i).data))
                    {
                        check++;
                        postponLesson.postpon.set(i,perenos);
                    }
                }
                if(check==0)
                {
                    postponLesson.postpon.add(perenos);
                }
                serializationToJsonPostpon();
            }
            else {
                if (month == 0) {
                    switch (day) {
                        case 2:
                            week.monday.lesso.set(tima, finalLesson);
                            break;
                        case 3:
                            week.tuesday.lesso.set(tima, finalLesson);
                            break;
                        case 4:
                            week.wednesday.lesso.set(tima, finalLesson);
                            break;
                        case 5:
                            week.thursday.lesso.set(tima, finalLesson);
                            break;
                        case 6:
                            week.friday.lesso.set(tima, finalLesson);
                            break;
                        case 7:
                            week.saturday.lesso.set(tima, finalLesson);
                            break;
                    }
                    serializationToJsonM();
                } else {
                    switch (day) {
                        case 2:
                            week2.monday.lesso.set(tima, finalLesson);
                            break;
                        case 3:
                            week2.tuesday.lesso.set(tima, finalLesson);
                            break;
                        case 4:
                            week2.wednesday.lesso.set(tima, finalLesson);
                            break;
                        case 5:
                            week2.thursday.lesso.set(tima, finalLesson);
                            break;
                        case 6:
                            week2.friday.lesso.set(tima, finalLesson);
                            break;
                        case 7:
                            week2.saturday.lesso.set(tima, finalLesson);
                            break;
                    }
                    serializationToJsonM2();
                }
            }
        }
        else
        {
        }
        Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
        startActivity(intent1);
    }

    public void Back(View view)
    {
        Intent intent1 = new Intent(ChangeLesson.this, MainActivity.class);
        startActivity(intent1);
    }

    public void deserializeListOfObjects2() throws IOException {
        final String filename1 = "Week2.json";
        File file = new File(super.getFilesDir(), filename1);

        if (file.exists()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                week2 = mapper.readValue(file, SecondWeek.class);
            }
            catch (Exception e)
            {
                Log.i("Log_json", "Oops, your serialization doesn't work" + e);
            }
        } else {
            file.createNewFile();
        }
    }
    public void deserializeListOfObjects1() throws IOException {
        final String filename1 = "Week1.json";
        File file = new File(super.getFilesDir(), filename1);

        if (file.exists()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                week = mapper.readValue(file, FirstWeek.class);
            }
            catch (Exception e)
            {
                Log.i("Log_json", "Oops, your serialization doesn't work" + e);
            }
        } else {
            file.createNewFile();
        }
    }

    public void serializationToJsonM() throws IOException {
        final String filename1 = "Week1.json";
        File file = new File(super.getFilesDir(), filename1);
        if (file.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,week);
            } catch (IOException e) {
                Log.i("Log_json", "Oops, your serialization doesn't work");
                e.printStackTrace();
            }
        }
        else
        {
            file.createNewFile();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,week);
            } catch (IOException e) {
                Log.i("Log_json", "Oops, your serialization doesn't work" + e);
            }
        }

    }

    public void serializationToJsonM2() throws IOException {
        final String filename1 = "Week2.json";
        File file = new File(super.getFilesDir(), filename1);
        if (file.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,week2);
            } catch (IOException e) {
                Log.i("Log_json", "Oops, your serialization doesn't work");
                e.printStackTrace();
            }
        }
        else
        {
            file.createNewFile();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,week2);
            } catch (IOException e) {
                Log.i("Log_json", "Oops, your serialization doesn't work" + e);
            }
        }

    }
    public void serializationToJsonPostpon() throws IOException {
        final String filename1 = "Postpon.json";
        File file = new File(super.getFilesDir(), filename1);
        if (file.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,postponLesson);
            } catch (IOException e) {
                Log.i("Log_json", "Oops, your serialization doesn't work");
                e.printStackTrace();
            }
        }
        else
        {
            file.createNewFile();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,postponLesson);
            } catch (IOException e) {
                Log.i("Log_json", "Oops, your serialization doesn't work" + e);
            }
        }

    }
    public void deserializeListOfObjectsPostpon() throws IOException {
        final String filename1 = "Postpon.json";
        File file = new File(super.getFilesDir(), filename1);

        if (file.exists()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                postponLesson = mapper.readValue(file, PostponLessons.class);
            }
            catch (Exception e)
            {
                Log.i("Log_json", "Oops, your serialization doesn't work" + e);
            }
        } else {
            file.createNewFile();
        }
    }
}
