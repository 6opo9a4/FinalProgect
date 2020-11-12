package com.example.laba5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Desk.Day;
import Desk.Lesson;
import Desk.SecondWeek;
import Lectors.Lector;

public class AddDesk2Week extends AppCompatActivity {
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

    String lesson;
    String comment;
    String Time;
    int leck;
    int time;
    int day;
    Lesson less;
    String[] times = {"8:00-9:35", "9:50-11:25", "11:40-13:15", "13:40-15:15", "15:30-17:05", "17:20-18:55","19:10-20:45"};

    ListView mon;
    ListView tue;
    ListView wed;
    ListView thur;
    ListView fri;
    ListView sat;

    private ArrayList <HashMap<String, Object>> Monday = new ArrayList<>();
    private ArrayList <HashMap<String, Object>> Tuesday = new ArrayList<>();
    private ArrayList <HashMap<String, Object>> Wednesday = new ArrayList<>();
    private ArrayList <HashMap<String, Object>> Thursday = new ArrayList<>();
    private ArrayList <HashMap<String, Object>> Friday = new ArrayList<>();
    private ArrayList <HashMap<String, Object>> Saturday = new ArrayList<>();
    private static final String BOOKKEY = "bookname";
    private static final String PRICEKEY = "bookprice";
    private static final String IMGKEY = "iconfromraw";
    private static final String WHEREKEY = "wherekabinet";

    SecondWeek week = new SecondWeek(monday,thuesday,wednesday,thursday,friday,saturday);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_desk);

        Lector odin = new Lector("Perwyi","1","Memologia",R.drawable.download1);
        Lector dwa = new Lector("Wtoroy","2","Trilliriwanie",R.drawable.download2);
        Lector tri = new Lector("Tretyi","3","Chill",R.drawable.download3);
        Lector chetyre = new Lector("Chetwertyi","4","Prokrastination",R.drawable.download4);
        Lector pyat = new Lector("Pyatyi","5","Design",R.drawable.download5);

        mon = findViewById(R.id.MondayList);
        tue = findViewById(R.id.TuesdayList);
        wed = findViewById(R.id.WednesdayList);
        thur= findViewById(R.id.ThursdayList);
        fri = findViewById(R.id.FridayList);
        sat = findViewById(R.id.SaturdayList);

        Bundle arguments = getIntent().getExtras();
        day = arguments.getInt("Day");

        try {
            deserializeListOfObjectsM();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(day != 0)
        {
            lesson = arguments.getString("Lesson");
            comment = arguments.getString("Comment");
            leck = arguments.getInt("Lector");
            time = arguments.getInt("Time");
            switch (leck)
            {
                case 1:
                    Time = times[time];
                    less =  new Lesson(odin,lesson,Time,comment);
                    break;
                case 2:
                    Time = times[time];
                    less =  new Lesson(dwa,lesson,Time,comment);
                    break;
                case 3:
                    Time = times[time];
                    less =  new Lesson(tri,lesson,Time,comment);
                    break;
                case 4:
                    Time = times[time];
                    less =  new Lesson(chetyre,lesson,Time,comment);
                    break;
                case 5:
                    Time = times[time];
                    less =  new Lesson(pyat,lesson,Time,comment);
                    break;
            }

            switch (day)
            {
                case 1:
                    if(!week.monday.lesso.isEmpty())
                    {
                        int z = 0;
                        for(int i=0;i<week.monday.lesso.size();i++)
                        {
                            if(week.monday.lesso.get(i).time.equals(less.time))
                            {
                                week.monday.lesso.set(i,less);
                                z++;
                            }
                        }
                        if(z==0)
                        {
                            week.monday.lesso.add(less);
                        }
                    }
                    else
                    {
                        week.monday.lesso.add(less);
                    }
                    break;
                case 2:
                    if(!week.tuesday.lesso.isEmpty())
                    {
                        int z = 0;
                        for(int i=0;i<week.tuesday.lesso.size();i++)
                        {
                            if(week.tuesday.lesso.get(i).time.equals(less.time))
                            {
                                week.tuesday.lesso.set(i,less);
                                z++;
                            }
                        }
                        if(z==0)
                        {
                            week.tuesday.lesso.add(less);
                        }
                    }
                    else
                    {
                        week.tuesday.lesso.add(less);
                    }
                    break;
                case 3:
                    if(!week.wednesday.lesso.isEmpty())
                    {
                        int z = 0;
                        for(int i=0;i<week.wednesday.lesso.size();i++)
                        {
                            if(week.wednesday.lesso.get(i).time.equals(less.time))
                            {
                                week.wednesday.lesso.set(i,less);
                                z++;
                            }
                        }
                        if(z==0)
                        {
                            week.wednesday.lesso.add(less);
                        }
                    }
                    else
                    {
                        week.wednesday.lesso.add(less);
                    }
                    break;
                case 4:
                    if(!week.thursday.lesso.isEmpty())
                    {
                        int z = 0;
                        for(int i=0;i<week.thursday.lesso.size();i++)
                        {
                            if(week.thursday.lesso.get(i).time.equals(less.time))
                            {
                                week.thursday.lesso.set(i,less);
                                z++;
                            }
                        }
                        if(z==0)
                        {
                            week.thursday.lesso.add(less);
                        }
                    }
                    else
                    {
                        week.thursday.lesso.add(less);
                    }
                    break;
                case 5:
                    if(!week.friday.lesso.isEmpty())
                    {
                        int z = 0;
                        for(int i=0;i<week.friday.lesso.size();i++)
                        {
                            if(week.friday.lesso.get(i).time.equals(less.time))
                            {
                                week.friday.lesso.set(i,less);
                                z++;
                            }
                        }
                        if(z==0)
                        {
                            week.friday.lesso.add(less);
                        }
                    }
                    else
                    {
                        week.friday.lesso.add(less);
                    }
                    break;
                case 6:
                    if(!week.saturday.lesso.isEmpty())
                    {
                        int z = 0;
                        for(int i=0;i<week.saturday.lesso.size();i++)
                        {
                            if(week.saturday.lesso.get(i).time.equals(less.time))
                            {
                                week.saturday.lesso.set(i,less);
                                z++;
                            }
                        }
                        if(z==0)
                        {
                            week.saturday.lesso.add(less);
                        }
                    }
                    else
                    {
                        week.saturday.lesso.add(less);
                    }
                    break;
            }
        }
        try {
            serializationToJsonM();
        } catch (IOException e) {
            e.printStackTrace();
        }
        adapter(week.monday,mon,Monday);
        adapter(week.tuesday,tue,Tuesday);
        adapter(week.wednesday,wed,Wednesday);
        adapter(week.thursday,thur,Thursday);
        adapter(week.friday,fri,Friday);
        adapter(week.saturday,sat,Saturday);
    }

    public void adapter(Day day,ListView list,ArrayList <HashMap<String, Object>> dayOfMonth)
    {
        HashMap<String, Object> hm;
        if(!day.lesso.isEmpty()) {
            for (int i = 0; i < day.lesso.size(); i++) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY, day.lesso.get(i).time);
                hm.put(PRICEKEY, day.lesso.get(i).less);
                hm.put(IMGKEY, day.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, day.lesso.get(i).comment);
                dayOfMonth.add(hm);
            }
            SimpleAdapter adapter = new SimpleAdapter(this, dayOfMonth, R.layout.list, new String[]{BOOKKEY, PRICEKEY, IMGKEY,WHEREKEY}, new int[]{R.id.text1, R.id.text2, R.id.img,R.id.Where});
            list.setAdapter(adapter);
            list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    public void Next(View view)
    {
        Intent intent1 = new Intent(AddDesk2Week.this, MainActivity.class);
        startActivity(intent1);
    }

    public void Back(View view)
    {
        Intent intent1 = new Intent(AddDesk2Week.this, AddDesk1Week.class);
        intent1.putExtra("Day", 0);
        startActivity(intent1);
    }

    public void MondayAdd(View view)
    {
        Intent intent1 = new Intent(AddDesk2Week.this, LessonForm.class);
        intent1.putExtra("Layout", 2);
        intent1.putExtra("Day", 1);
        startActivity(intent1);
    }

    public void ThuesdayAdd(View view)
    {
        Intent intent1 = new Intent(AddDesk2Week.this, LessonForm.class);
        intent1.putExtra("Layout", 1);
        intent1.putExtra("Day", 2);
        startActivity(intent1);
    }

    public void WednesdayAdd(View view)
    {
        Intent intent1 = new Intent(AddDesk2Week.this, LessonForm.class);
        intent1.putExtra("Layout", 2);
        intent1.putExtra("Day", 3);
        startActivity(intent1);
    }

    public void ThursdayAdd(View view)
    {
        Intent intent1 = new Intent(AddDesk2Week.this, LessonForm.class);
        intent1.putExtra("Layout", 2);
        intent1.putExtra("Day", 4);
        startActivity(intent1);
    }

    public void FridayAdd(View view)
    {
        Intent intent1 = new Intent(AddDesk2Week.this, LessonForm.class);
        intent1.putExtra("Layout", 2);
        intent1.putExtra("Day", 5);
        startActivity(intent1);
    }

    public void SaturdayAdd(View view)
    {
        Intent intent1 = new Intent(AddDesk2Week.this, LessonForm.class);
        intent1.putExtra("Layout", 2);
        intent1.putExtra("Day", 6);
        startActivity(intent1);
    }

    public void deserializeListOfObjectsM() throws IOException {
        final String filename1 = "Week2.json";
        File file = new File(super.getFilesDir(), filename1);

        if (file.exists()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                week = mapper.readValue(file, SecondWeek.class);
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
        final String filename1 = "Week2.json";
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

}