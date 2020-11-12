package com.example.laba5;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import Desk.Day;
import Desk.FirstWeek;
import Desk.Lesson;
import Desk.Postpon;
import Desk.PostponLessons;
import Desk.SecondWeek;
import Lectors.Lector;


public class MainActivity extends AppCompatActivity {

    private static final String BOOKKEY = "bookname";
    private static final String PRICEKEY = "bookprice";
    private static final String IMGKEY = "iconfromraw";
    private static final String WHEREKEY = "wherekabinet";
    private final int Pick_image = 1;
    ListView listView;
    CalendarView but;
    ImageView im;

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

    public ArrayList<Lesson> mondayLesson2 = new ArrayList<>();
    public Day monday2 = new Day(2,mondayLesson2);
    public ArrayList<Lesson> thuesdayLesson2 = new ArrayList<>();
    public Day thuesday2 = new Day(3,thuesdayLesson2);
    public ArrayList<Lesson> wednesdayLesson2 = new ArrayList<>();
    public Day wednesday2 = new Day(4,wednesdayLesson2);
    public ArrayList<Lesson> thursdayLesson2 = new ArrayList<>();
    public Day thursday2 = new Day(5,thursdayLesson2);
    public ArrayList<Lesson> fridayLesson2 = new ArrayList<>();
    public Day friday2 = new Day(6,fridayLesson2);
    public ArrayList<Lesson> saturdayLesson2 = new ArrayList<>();
    public Day saturday2 = new Day(7,saturdayLesson2);

    public FirstWeek week = new FirstWeek(monday,thuesday,wednesday,thursday,friday,saturday);
    public SecondWeek week2 = new SecondWeek(monday2,thuesday2,wednesday2,thursday2,friday2,saturday2);

    public ArrayList<Postpon> postpon = new ArrayList<>();
    public PostponLessons postponLesson =  new PostponLessons(postpon);

    static Lector odin = new Lector("Perwyi","1","Memologia",R.drawable.download1);
    static Lector dwa = new Lector("Wtoroy","2","Trilliriwanie",R.drawable.download2);
    static Lector tri = new Lector("Tretyi","3","Chill",R.drawable.download3);
    static Lector chetyre = new Lector("Chetwertyi","4","Prokrastination",R.drawable.download4);
    static Lector pyat = new Lector("Pyatyi","5","Design",R.drawable.download5);
    public static int SelectedLecto;

    int Day;
    int Week;
    String curDate;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        im = findViewById(R.id.img);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but = findViewById(R.id.Calendar);
        listView = (ListView)findViewById(R.id.list);
        registerForContextMenu(listView);
        try {
            deserializeListOfObjects1();
            deserializeListOfObjects2();
            deserializeListOfObjectslec();
            deserializeListOfObjectsPostpon();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(SelectedLecto == 99) {

            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
            Calendar date = Calendar.getInstance();
            curDate = dateFormat.format(date.getTime());

            int i = date.get(Calendar.DAY_OF_WEEK);
            int i2 = date.get(Calendar.WEEK_OF_MONTH) % 2;
            Day = i;
            Week = i2;
            if (i == 2) {
                Log.i("Log_json", "Selected Day " + "Mon");
                addIma(1, i2);
            } else if (i == 3) {
                Log.i("Log_json", "Selected Day " + "Tue");
                addIma(2, i2);
            } else if (i == 4) {
                Log.i("Log_json", "Selected Day " + "Wed");
                addIma(3, i2);
            } else if (i == 5) {
                Log.i("Log_json", "Selected Day " + "Thurs");
                addIma(4, i2);
            } else if (i == 6) {
                Log.i("Log_json", "Selected Day " + "Fri");
                addIma(5, i2);
            } else if (i == 7) {
                Log.i("Log_json", "Selected Day " + "Sat");
                addIma(6, i2);
            } else if (i == 1) {
                Log.i("Log_json", "Selected Day " + "San");
                addIma(7, i2);
            }
        }

        but.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                curDate = dayOfMonth + "." + month + "." + year;
                TimeZone timezone = TimeZone.getDefault();
                Calendar calendar = new GregorianCalendar(timezone);
                calendar.set(year, month, dayOfMonth);
                int i = calendar.get(Calendar.DAY_OF_WEEK);
                int i2 = calendar.get(Calendar.WEEK_OF_MONTH) % 2 ;
                Day = i;
                Week = i2;
                if(i == 2){
                    Log.i("Log_json","Selected Day " + "Mon");
                    addIma(1,i2);
                } else if (i==3){
                    Log.i("Log_json","Selected Day " + "Tue");
                    addIma(2,i2);
                } else if (i==4){
                    Log.i("Log_json","Selected Day " + "Wed");
                    addIma(3,i2);
                } else if (i==5){
                    Log.i("Log_json","Selected Day " + "Thurs");
                    addIma(4,i2);
                } else if (i==6){
                    Log.i("Log_json","Selected Day " + "Fri");
                    addIma(5,i2);
                } else if (i==7){
                    Log.i("Log_json","Selected Day " + "Sat");
                    addIma(6,i2);
                } else if (i==1){
                    Log.i("Log_json","Selected Day " + "San");
                    addIma(7,i2);
                }
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit:
                Intent intent1 = new Intent(MainActivity.this, ChangeLesson.class);
                intent1.putExtra("Muvie", 0);
                intent1.putExtra("Week", Week);
                intent1.putExtra("Day", Day);
                intent1.putExtra("Time", ((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position);
                startActivity(intent1);
                return true;
            case R.id.delete:
                Intent intent2 = new Intent(MainActivity.this, ChangeLesson.class);
                intent2.putExtra("Muvie", 1);
                intent2.putExtra("Week", Week);
                intent2.putExtra("Day", Day);
                intent2.putExtra("Time", ((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position);
                startActivity(intent2);
                return true;
            case R.id.postpon:
                Intent intent3 = new Intent(MainActivity.this, ChangeLesson.class);
                intent3.putExtra("Muvie", 2);
                intent3.putExtra("DatePerenosa", curDate);
                intent3.putExtra("Week", Week);
                intent3.putExtra("Day", Day);
                intent3.putExtra("Time", ((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position);
                startActivity(intent3);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    public void addIma(int day, int number)
    {
        ArrayList <HashMap<String, Object>> myBooks = new ArrayList<HashMap<String,Object>>();;
        HashMap<String, Object> hm;

            if(number == 0) {
                switch (day) {
                    case 1:
                        int check = 0;
                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                if(postponLesson.postpon.get(p).data.equals(curDate))
                                {check ++;}
                                else {}
                            }
                            if(check == 0) {
                                for (int i = 0; i < week.monday.lesso.size(); i++) {
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week.monday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week.monday.lesso.get(i).less);
                                    hm.put(IMGKEY, week.monday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week.monday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                            else {
                                ArrayList<Integer> check2 = new ArrayList<>();
                                for (int i = 0; i < week.monday.lesso.size(); i++) {
                                    for(int p = 0;p<postponLesson.postpon.size();p++) {
                                        if (postponLesson.postpon.get(p).time.equals(week.monday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.monday.lesso.get(i).less)) {
                                            if(check2.size()>0) {
                                                int check3=0;
                                                for(int c=0;c<check2.size();c++) {
                                                    if(check2.get(c).equals(i))
                                                    {check3++;}
                                                }
                                                if(check3==0) {check2.add(i);}
                                            }
                                            else{check2.add(i);}
                                        }
                                    }
                                }
                                for (int i = 0; i < week.monday.lesso.size(); i++) {
                                    some:{
                                        for (int z = 0; z < check2.size(); z++) {
                                            if (i == check2.get(z)) {
                                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                    if (postponLesson.postpon.get(p).time.equals(week.monday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.monday.lesso.get(i).less)) {
                                                        hm = new HashMap<String, Object>();
                                                        hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                        hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                        hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                        hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                        myBooks.add(hm);
                                                    }

                                                }
                                                i++;
                                                break some;
                                            }
                                        }
                                        hm = new HashMap<String, Object>();
                                        hm.put(BOOKKEY, week.monday.lesso.get(i).time);
                                        hm.put(PRICEKEY, week.monday.lesso.get(i).less);
                                        hm.put(IMGKEY, week.monday.lesso.get(i).lek.photo);
                                        hm.put(WHEREKEY, week.monday.lesso.get(i).comment);
                                        myBooks.add(hm);
                                    }
                                }
                            }
                        break;
                    case 2:
                        check = 0;
                        for(int p = 0;p<postponLesson.postpon.size();p++) {
                            if(postponLesson.postpon.get(p).data.equals(curDate))
                            {check ++;}
                            else {}
                        }
                        if(check == 0) {
                            for (int i = 0; i < week.tuesday.lesso.size(); i++) {
                                hm = new HashMap<String, Object>();
                                hm.put(BOOKKEY, week.tuesday.lesso.get(i).time);
                                hm.put(PRICEKEY, week.tuesday.lesso.get(i).less);
                                hm.put(IMGKEY, week.tuesday.lesso.get(i).lek.photo);
                                hm.put(WHEREKEY, week.tuesday.lesso.get(i).comment);
                                myBooks.add(hm);
                            }
                        }
                        else {
                            ArrayList<Integer> check2 = new ArrayList<>();
                            for (int i = 0; i < week.tuesday.lesso.size(); i++) {
                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                    if (postponLesson.postpon.get(p).time.equals(week.tuesday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.tuesday.lesso.get(i).less)) {
                                        if(check2.size()>0) {
                                            int check3=0;
                                            for(int c=0;c<check2.size();c++) {
                                                if(check2.get(c).equals(i))
                                                {check3++;}
                                            }
                                            if(check3==0) {check2.add(i);}
                                        }
                                        else{check2.add(i);}
                                    }
                                }
                            }
                            for (int i = 0; i < week.tuesday.lesso.size(); i++) {
                                some:{
                                    for (int z = 0; z < check2.size(); z++) {
                                        if (i == check2.get(z)) {
                                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                if (postponLesson.postpon.get(p).time.equals(week.tuesday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.tuesday.lesso.get(i).less)) {
                                                    hm = new HashMap<String, Object>();
                                                    hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                    hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                    hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                    hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                    myBooks.add(hm);
                                                }
                                            }
                                            i++;
                                            break some;
                                        }
                                    }
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week.tuesday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week.tuesday.lesso.get(i).less);
                                    hm.put(IMGKEY, week.tuesday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week.tuesday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                        }
                        break;
                    case 3:
                        check = 0;
                        for(int p = 0;p<postponLesson.postpon.size();p++) {
                            if(postponLesson.postpon.get(p).data.equals(curDate))
                            {check ++;}
                            else {}
                        }
                        if(check == 0)
                        {
                            for (int i = 0; i < week.wednesday.lesso.size(); i++) {
                                hm = new HashMap<String, Object>();
                                hm.put(BOOKKEY, week.wednesday.lesso.get(i).time);
                                hm.put(PRICEKEY, week.wednesday.lesso.get(i).less);
                                hm.put(IMGKEY, week.wednesday.lesso.get(i).lek.photo);
                                hm.put(WHEREKEY, week.wednesday.lesso.get(i).comment);
                                myBooks.add(hm);
                            }
                        }
                        else
                        {
                            ArrayList<Integer> check2 = new ArrayList<>();
                            for (int i = 0; i < week.wednesday.lesso.size(); i++) {
                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                    if (postponLesson.postpon.get(p).time.equals(week.wednesday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.wednesday.lesso.get(i).less))
                                    {
                                        if(check2.size()>0)
                                        {
                                            int check3=0;
                                            for(int c=0;c<check2.size();c++)
                                            {
                                                if(check2.get(c).equals(i))
                                                {check3++;}
                                            }
                                            if(check3==0) {check2.add(i);}
                                        }
                                        else{check2.add(i);}
                                    }
                                }
                            }
                            for (int i = 0; i < week.wednesday.lesso.size(); i++)
                            {
                                some:
                                {
                                    for (int z = 0; z < check2.size(); z++) {
                                        if (i == check2.get(z)) {
                                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                if (postponLesson.postpon.get(p).time.equals(week.wednesday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.wednesday.lesso.get(i).less)) {
                                                    hm = new HashMap<String, Object>();
                                                    hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                    hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                    hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                    hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                    myBooks.add(hm);
                                                }
                                            }
                                            i++;
                                            break some;
                                        }
                                    }
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week.wednesday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week.wednesday.lesso.get(i).less);
                                    hm.put(IMGKEY, week.wednesday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week.wednesday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                        }
                        break;
                    case 4:
                        check = 0;
                        for(int p = 0;p<postponLesson.postpon.size();p++) {
                            if(postponLesson.postpon.get(p).data.equals(curDate))
                            {check ++;}
                            else {}
                        }
                        if(check == 0)
                        {
                            for (int i = 0; i < week.thursday.lesso.size(); i++) {
                                hm = new HashMap<String, Object>();
                                hm.put(BOOKKEY, week.thursday.lesso.get(i).time);
                                hm.put(PRICEKEY, week.thursday.lesso.get(i).less);
                                hm.put(IMGKEY, week.thursday.lesso.get(i).lek.photo);
                                hm.put(WHEREKEY, week.thursday.lesso.get(i).comment);
                                myBooks.add(hm);
                            }
                        }
                        else
                        {
                            ArrayList<Integer> check2 = new ArrayList<>();
                            for (int i = 0; i < week.wednesday.lesso.size(); i++) {
                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                    if (postponLesson.postpon.get(p).time.equals(week.thursday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.thursday.lesso.get(i).less))
                                    {
                                        if(check2.size()>0)
                                        {
                                            int check3=0;
                                            for(int c=0;c<check2.size();c++)
                                            {
                                                if(check2.get(c).equals(i))
                                                {check3++;}
                                            }
                                            if(check3==0) {check2.add(i);}
                                        }
                                        else{check2.add(i);}
                                    }
                                }
                            }
                            for (int i = 0; i < week.thursday.lesso.size(); i++)
                            {
                                some:
                                {
                                    for (int z = 0; z < check2.size(); z++) {
                                        if (i == check2.get(z)) {
                                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                if (postponLesson.postpon.get(p).time.equals(week.thursday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.thursday.lesso.get(i).less)) {
                                                    hm = new HashMap<String, Object>();
                                                    hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                    hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                    hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                    hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                    myBooks.add(hm);
                                                }
                                            }
                                            i++;
                                            break some;
                                        }
                                    }
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week.thursday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week.thursday.lesso.get(i).less);
                                    hm.put(IMGKEY, week.thursday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week.thursday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                        }
                        break;
                    case 5:
                        check = 0;
                        for(int p = 0;p<postponLesson.postpon.size();p++) {
                            if(postponLesson.postpon.get(p).data.equals(curDate))
                            {check ++;}
                            else {}
                        }
                        if(check == 0)
                        {
                            for (int i = 0; i < week.friday.lesso.size(); i++) {
                                hm = new HashMap<String, Object>();
                                hm.put(BOOKKEY, week.friday.lesso.get(i).time);
                                hm.put(PRICEKEY, week.friday.lesso.get(i).less);
                                hm.put(IMGKEY, week.friday.lesso.get(i).lek.photo);
                                hm.put(WHEREKEY, week.friday.lesso.get(i).comment);
                                myBooks.add(hm);
                            }
                        }
                        else
                        {
                            ArrayList<Integer> check2 = new ArrayList<>();
                            for (int i = 0; i < week.friday.lesso.size(); i++) {
                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                    if (postponLesson.postpon.get(p).time.equals(week.friday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.friday.lesso.get(i).less))
                                    {
                                        if(check2.size()>0)
                                        {
                                            int check3=0;
                                            for(int c=0;c<check2.size();c++)
                                            {
                                                if(check2.get(c).equals(i))
                                                {check3++;}
                                            }
                                            if(check3==0) {check2.add(i);}
                                        }
                                        else{check2.add(i);}
                                    }
                                }
                            }
                            for (int i = 0; i < week.friday.lesso.size(); i++)
                            {
                                some:
                                {
                                    for (int z = 0; z < check2.size(); z++) {
                                        if (i == check2.get(z)) {
                                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                if (postponLesson.postpon.get(p).time.equals(week.friday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.friday.lesso.get(i).less)) {
                                                    hm = new HashMap<String, Object>();
                                                    hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                    hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                    hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                    hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                    myBooks.add(hm);
                                                }
                                            }
                                            i++;
                                            break some;
                                        }
                                    }
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week.friday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week.friday.lesso.get(i).less);
                                    hm.put(IMGKEY, week.friday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week.friday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                        }
                        break;
                    case 6:
                        check = 0;
                        for(int p = 0;p<postponLesson.postpon.size();p++) {
                            if(postponLesson.postpon.get(p).data.equals(curDate))
                            {check ++;}
                            else {}
                        }
                        if(check == 0)
                        {
                            for (int i = 0; i < week.saturday.lesso.size(); i++) {
                                hm = new HashMap<String, Object>();
                                hm.put(BOOKKEY, week.saturday.lesso.get(i).time);
                                hm.put(PRICEKEY, week.saturday.lesso.get(i).less);
                                hm.put(IMGKEY, week.saturday.lesso.get(i).lek.photo);
                                hm.put(WHEREKEY, week.saturday.lesso.get(i).comment);
                                myBooks.add(hm);
                            }
                        }
                        else
                        {
                            ArrayList<Integer> check2 = new ArrayList<>();
                            for (int i = 0; i < week.saturday.lesso.size(); i++) {
                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                    if (postponLesson.postpon.get(p).time.equals(week.saturday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.saturday.lesso.get(i).less))
                                    {
                                        if(check2.size()>0)
                                        {
                                            int check3=0;
                                            for(int c=0;c<check2.size();c++)
                                            {
                                                if(check2.get(c).equals(i))
                                                {check3++;}
                                            }
                                            if(check3==0) {check2.add(i);}
                                        }
                                        else{check2.add(i);}
                                    }
                                }
                            }
                            for (int i = 0; i < week.saturday.lesso.size(); i++)
                            {
                                some:
                                {
                                    for (int z = 0; z < check2.size(); z++) {
                                        if (i == check2.get(z)) {
                                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                if (postponLesson.postpon.get(p).time.equals(week.saturday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week.saturday.lesso.get(i).less)) {
                                                    hm = new HashMap<String, Object>();
                                                    hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                    hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                    hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                    hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                    myBooks.add(hm);
                                                }
                                            }
                                            i++;
                                            break some;
                                        }
                                    }
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week.saturday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week.saturday.lesso.get(i).less);
                                    hm.put(IMGKEY, week.saturday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week.saturday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                        }
                        for (int i = 0; i < week.saturday.lesso.size(); i++) {
                        }
                        break;
                    case 7:
                        break;

                }
            }
            else
            {
                switch (day)
                {
                    case 1:
                        int check = 0;
                        for(int p = 0;p<postponLesson.postpon.size();p++) {
                            if(postponLesson.postpon.get(p).data.equals(curDate))
                            {check ++;}
                            else {}
                        }
                        if(check == 0) {
                            for (int i = 0; i < week2.monday.lesso.size(); i++) {
                                hm = new HashMap<String, Object>();
                                hm.put(BOOKKEY, week2.monday.lesso.get(i).time);
                                hm.put(PRICEKEY, week2.monday.lesso.get(i).less);
                                hm.put(IMGKEY, week2.monday.lesso.get(i).lek.photo);
                                hm.put(WHEREKEY, week2.monday.lesso.get(i).comment);
                                myBooks.add(hm);
                            }
                        }
                        else {
                            ArrayList<Integer> check2 = new ArrayList<>();
                            for (int i = 0; i < week2.monday.lesso.size(); i++) {
                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                    if (postponLesson.postpon.get(p).time.equals(week2.monday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.monday.lesso.get(i).less)) {
                                        if(check2.size()>0) {
                                            int check3=0;
                                            for(int c=0;c<check2.size();c++) {
                                                if(check2.get(c).equals(i))
                                                {check3++;}
                                            }
                                            if(check3==0) {check2.add(i);}
                                        }
                                        else{check2.add(i);}
                                    }
                                }
                            }
                            for (int i = 0; i < week2.monday.lesso.size(); i++) {
                                some:{
                                    for (int z = 0; z < check2.size(); z++) {
                                        if (i == check2.get(z)) {
                                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                if (postponLesson.postpon.get(p).time.equals(week2.monday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.monday.lesso.get(i).less)) {
                                                    hm = new HashMap<String, Object>();
                                                    hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                    hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                    hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                    hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                    myBooks.add(hm);
                                                }

                                            }
                                            i++;
                                            break some;
                                        }
                                    }
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week2.monday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week2.monday.lesso.get(i).less);
                                    hm.put(IMGKEY, week2.monday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week2.monday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                        }
                        break;
                    case 2:
                        check = 0;
                        for(int p = 0;p<postponLesson.postpon.size();p++) {
                            if(postponLesson.postpon.get(p).data.equals(curDate))
                            {check ++;}
                            else {}
                        }
                        if(check == 0) {
                            for (int i = 0; i < week2.tuesday.lesso.size(); i++) {
                                hm = new HashMap<String, Object>();
                                hm.put(BOOKKEY, week2.tuesday.lesso.get(i).time);
                                hm.put(PRICEKEY, week2.tuesday.lesso.get(i).less);
                                hm.put(IMGKEY, week2.tuesday.lesso.get(i).lek.photo);
                                hm.put(WHEREKEY, week2.tuesday.lesso.get(i).comment);
                                myBooks.add(hm);
                            }
                        }
                        else {
                            ArrayList<Integer> check2 = new ArrayList<>();
                            for (int i = 0; i < week2.tuesday.lesso.size(); i++) {
                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                    if (postponLesson.postpon.get(p).time.equals(week2.tuesday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.tuesday.lesso.get(i).less)) {
                                        if(check2.size()>0) {
                                            int check3=0;
                                            for(int c=0;c<check2.size();c++) {
                                                if(check2.get(c).equals(i))
                                                {check3++;}
                                            }
                                            if(check3==0) {check2.add(i);}
                                        }
                                        else{check2.add(i);}
                                    }
                                }
                            }
                            for (int i = 0; i < week2.tuesday.lesso.size(); i++) {
                                some:{
                                    for (int z = 0; z < check2.size(); z++) {
                                        if (i == check2.get(z)) {
                                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                if (postponLesson.postpon.get(p).time.equals(week2.tuesday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.tuesday.lesso.get(i).less)) {
                                                    hm = new HashMap<String, Object>();
                                                    hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                    hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                    hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                    hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                    myBooks.add(hm);
                                                }
                                            }
                                            i++;
                                            break some;
                                        }
                                    }
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week2.tuesday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week2.tuesday.lesso.get(i).less);
                                    hm.put(IMGKEY, week2.tuesday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week2.tuesday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                        }
                        break;
                    case 3:
                        check = 0;
                        for(int p = 0;p<postponLesson.postpon.size();p++) {
                            if(postponLesson.postpon.get(p).data.equals(curDate))
                            {check ++;}
                            else {}
                        }
                        if(check == 0)
                        {
                            for (int i = 0; i < week2.wednesday.lesso.size(); i++) {
                                hm = new HashMap<String, Object>();
                                hm.put(BOOKKEY, week2.wednesday.lesso.get(i).time);
                                hm.put(PRICEKEY, week2.wednesday.lesso.get(i).less);
                                hm.put(IMGKEY, week2.wednesday.lesso.get(i).lek.photo);
                                hm.put(WHEREKEY, week2.wednesday.lesso.get(i).comment);
                                myBooks.add(hm);
                            }
                        }
                        else
                        {
                            ArrayList<Integer> check2 = new ArrayList<>();
                            for (int i = 0; i < week2.wednesday.lesso.size(); i++) {
                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                    if (postponLesson.postpon.get(p).time.equals(week2.wednesday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.wednesday.lesso.get(i).less))
                                    {
                                        if(check2.size()>0)
                                        {
                                            int check3=0;
                                            for(int c=0;c<check2.size();c++)
                                            {
                                                if(check2.get(c).equals(i))
                                                {check3++;}
                                            }
                                            if(check3==0) {check2.add(i);}
                                        }
                                        else{check2.add(i);}
                                    }
                                }
                            }
                            for (int i = 0; i < week2.wednesday.lesso.size(); i++)
                            {
                                some:
                                {
                                    for (int z = 0; z < check2.size(); z++) {
                                        if (i == check2.get(z)) {
                                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                if (postponLesson.postpon.get(p).time.equals(week2.wednesday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.wednesday.lesso.get(i).less)) {
                                                    hm = new HashMap<String, Object>();
                                                    hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                    hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                    hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                    hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                    myBooks.add(hm);
                                                }
                                            }
                                            i++;
                                            break some;
                                        }
                                    }
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week2.wednesday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week2.wednesday.lesso.get(i).less);
                                    hm.put(IMGKEY, week2.wednesday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week2.wednesday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                        }
                        break;
                    case 4:
                        check = 0;
                        for(int p = 0;p<postponLesson.postpon.size();p++) {
                            if(postponLesson.postpon.get(p).data.equals(curDate))
                            {check ++;}
                            else {}
                        }
                        if(check == 0)
                        {
                            for (int i = 0; i < week2.thursday.lesso.size(); i++) {
                                hm = new HashMap<String, Object>();
                                hm.put(BOOKKEY, week2.thursday.lesso.get(i).time);
                                hm.put(PRICEKEY, week2.thursday.lesso.get(i).less);
                                hm.put(IMGKEY, week2.thursday.lesso.get(i).lek.photo);
                                hm.put(WHEREKEY, week2.thursday.lesso.get(i).comment);
                                myBooks.add(hm);
                            }
                        }
                        else
                        {
                            ArrayList<Integer> check2 = new ArrayList<>();
                            for (int i = 0; i < week2.wednesday.lesso.size(); i++) {
                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                    if (postponLesson.postpon.get(p).time.equals(week2.thursday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.thursday.lesso.get(i).less))
                                    {
                                        if(check2.size()>0)
                                        {
                                            int check3=0;
                                            for(int c=0;c<check2.size();c++)
                                            {
                                                if(check2.get(c).equals(i))
                                                {check3++;}
                                            }
                                            if(check3==0) {check2.add(i);}
                                        }
                                        else{check2.add(i);}
                                    }
                                }
                            }
                            for (int i = 0; i < week2.thursday.lesso.size(); i++)
                            {
                                some:
                                {
                                    for (int z = 0; z < check2.size(); z++) {
                                        if (i == check2.get(z)) {
                                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                if (postponLesson.postpon.get(p).time.equals(week2.thursday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.thursday.lesso.get(i).less)) {
                                                    hm = new HashMap<String, Object>();
                                                    hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                    hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                    hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                    hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                    myBooks.add(hm);
                                                }
                                            }
                                            i++;
                                            break some;
                                        }
                                    }
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week2.thursday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week2.thursday.lesso.get(i).less);
                                    hm.put(IMGKEY, week2.thursday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week2.thursday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                        }
                        break;
                    case 5:
                        check = 0;
                        for(int p = 0;p<postponLesson.postpon.size();p++) {
                            if(postponLesson.postpon.get(p).data.equals(curDate))
                            {check ++;}
                            else {}
                        }
                        if(check == 0)
                        {
                            for (int i = 0; i < week2.friday.lesso.size(); i++) {
                                hm = new HashMap<String, Object>();
                                hm.put(BOOKKEY, week2.friday.lesso.get(i).time);
                                hm.put(PRICEKEY, week2.friday.lesso.get(i).less);
                                hm.put(IMGKEY, week2.friday.lesso.get(i).lek.photo);
                                hm.put(WHEREKEY, week2.friday.lesso.get(i).comment);
                                myBooks.add(hm);
                            }
                        }
                        else
                        {
                            ArrayList<Integer> check2 = new ArrayList<>();
                            for (int i = 0; i < week2.friday.lesso.size(); i++) {
                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                    if (postponLesson.postpon.get(p).time.equals(week2.friday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.friday.lesso.get(i).less))
                                    {
                                        if(check2.size()>0)
                                        {
                                            int check3=0;
                                            for(int c=0;c<check2.size();c++)
                                            {
                                                if(check2.get(c).equals(i))
                                                {check3++;}
                                            }
                                            if(check3==0) {check2.add(i);}
                                        }
                                        else{check2.add(i);}
                                    }
                                }
                            }
                            for (int i = 0; i < week2.friday.lesso.size(); i++)
                            {
                                some:
                                {
                                    for (int z = 0; z < check2.size(); z++) {
                                        if (i == check2.get(z)) {
                                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                if (postponLesson.postpon.get(p).time.equals(week2.friday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.friday.lesso.get(i).less)) {
                                                    hm = new HashMap<String, Object>();
                                                    hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                    hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                    hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                    hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                    myBooks.add(hm);
                                                }
                                            }
                                            i++;
                                            break some;
                                        }
                                    }
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week2.friday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week2.friday.lesso.get(i).less);
                                    hm.put(IMGKEY, week2.friday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week2.friday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                        }
                        break;
                    case 6:
                        check = 0;
                        for(int p = 0;p<postponLesson.postpon.size();p++) {
                            if(postponLesson.postpon.get(p).data.equals(curDate))
                            {check ++;}
                            else {}
                        }
                        if(check == 0)
                        {
                            for (int i = 0; i < week2.saturday.lesso.size(); i++) {
                                hm = new HashMap<String, Object>();
                                hm.put(BOOKKEY, week2.saturday.lesso.get(i).time);
                                hm.put(PRICEKEY, week2.saturday.lesso.get(i).less);
                                hm.put(IMGKEY, week2.saturday.lesso.get(i).lek.photo);
                                hm.put(WHEREKEY, week2.saturday.lesso.get(i).comment);
                                myBooks.add(hm);
                            }
                        }
                        else
                        {
                            ArrayList<Integer> check2 = new ArrayList<>();
                            for (int i = 0; i < week2.saturday.lesso.size(); i++) {
                                for(int p = 0;p<postponLesson.postpon.size();p++) {
                                    if (postponLesson.postpon.get(p).time.equals(week2.saturday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.saturday.lesso.get(i).less))
                                    {
                                        if(check2.size()>0)
                                        {
                                            int check3=0;
                                            for(int c=0;c<check2.size();c++)
                                            {
                                                if(check2.get(c).equals(i))
                                                {check3++;}
                                            }
                                            if(check3==0) {check2.add(i);}
                                        }
                                        else{check2.add(i);}
                                    }
                                }
                            }
                            for (int i = 0; i < week2.saturday.lesso.size(); i++)
                            {
                                some:
                                {
                                    for (int z = 0; z < check2.size(); z++) {
                                        if (i == check2.get(z)) {
                                            for(int p = 0;p<postponLesson.postpon.size();p++) {
                                                if (postponLesson.postpon.get(p).time.equals(week2.saturday.lesso.get(i).time) && postponLesson.postpon.get(p).less.equals(week2.saturday.lesso.get(i).less)) {
                                                    hm = new HashMap<String, Object>();
                                                    hm.put(BOOKKEY, postponLesson.postpon.get(p).time);
                                                    hm.put(PRICEKEY, postponLesson.postpon.get(p).less);
                                                    hm.put(IMGKEY, postponLesson.postpon.get(p).lek.photo);
                                                    hm.put(WHEREKEY, postponLesson.postpon.get(p).comment);
                                                    myBooks.add(hm);
                                                }
                                            }
                                            i++;
                                            break some;
                                        }
                                    }
                                    hm = new HashMap<String, Object>();
                                    hm.put(BOOKKEY, week2.saturday.lesso.get(i).time);
                                    hm.put(PRICEKEY, week2.saturday.lesso.get(i).less);
                                    hm.put(IMGKEY, week2.saturday.lesso.get(i).lek.photo);
                                    hm.put(WHEREKEY, week2.saturday.lesso.get(i).comment);
                                    myBooks.add(hm);
                                }
                            }
                        }
                        for (int i = 0; i < week2.saturday.lesso.size(); i++) {
                        }
                        break;
                    case 7:
                        break;
                }
            }

        SimpleAdapter adapter = new SimpleAdapter(this, myBooks,R.layout.list, new String[]{BOOKKEY,PRICEKEY,IMGKEY,WHEREKEY}, new int[]{R.id.text1, R.id.text2, R.id.img,R.id.Where});
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.New:
                Intent intent1 = new Intent(MainActivity.this, AddDesk1Week.class);
                intent1.putExtra("Day", 0);
                startActivity(intent1);
                break;
            case R.id.LectorFind:
                FragmentManager manager = getSupportFragmentManager();
                MyDialogFragment myDialogFragment = new MyDialogFragment();
                myDialogFragment.show(manager, "myDialog");

                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    public void Swich(int SelectedLecto)
    {
        switch (SelectedLecto)
        {
            case 0:
                FindLectos(odin);
                break;
            case 1:
                FindLectos(dwa);
                break;
            case 2:
                FindLectos(tri);
                break;
            case 3:
                FindLectos(chetyre);
                break;
            case 4:
                FindLectos(pyat);
                break;
        }
    }
    public void FindLectos(Lector lecho)
    {
        ArrayList <HashMap<String, Object>> myBooks = new ArrayList<HashMap<String,Object>>();;
        HashMap<String, Object> hm;

        for (int i = 0; i < week.monday.lesso.size(); i++) {
            if(lecho.surname.equals(week.monday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Monday " + week.monday.lesso.get(i).time);
                hm.put(PRICEKEY, week.monday.lesso.get(i).less);
                hm.put(IMGKEY, week.monday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week.monday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }
        for (int i = 0; i < week.tuesday.lesso.size(); i++) {
            if(lecho.surname.equals(week.tuesday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Tuesday " + week.tuesday.lesso.get(i).time);
                hm.put(PRICEKEY, week.tuesday.lesso.get(i).less);
                hm.put(IMGKEY, week.tuesday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week.tuesday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }
        for (int i = 0; i < week.wednesday.lesso.size(); i++) {
            if(lecho.surname.equals(week.wednesday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Wednesday " + week.wednesday.lesso.get(i).time);
                hm.put(PRICEKEY, week.wednesday.lesso.get(i).less);
                hm.put(IMGKEY, week.wednesday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week.wednesday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }
        for (int i = 0; i < week.thursday.lesso.size(); i++) {
            if(lecho.surname.equals(week.thursday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Thursday " + week.thursday.lesso.get(i).time);
                hm.put(PRICEKEY, week.thursday.lesso.get(i).less);
                hm.put(IMGKEY, week.thursday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week.thursday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }
        for (int i = 0; i < week.friday.lesso.size(); i++) {
            if(lecho.surname.equals(week.friday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Friday " + week.friday.lesso.get(i).time);
                hm.put(PRICEKEY, week.friday.lesso.get(i).less);
                hm.put(IMGKEY, week.friday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week.friday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }
        for (int i = 0; i < week.saturday.lesso.size(); i++) {
            if(lecho.surname.equals(week.saturday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Saturday " + week.saturday.lesso.get(i).time);
                hm.put(PRICEKEY, week.saturday.lesso.get(i).less);
                hm.put(IMGKEY, week.saturday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week.saturday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }

        hm = new HashMap<String, Object>();
        hm.put(BOOKKEY, "--------------Second Week--------------");
        hm.put(PRICEKEY, "");
        hm.put(IMGKEY, R.drawable.download); //тут мы её добавляем для отображения
        myBooks.add(hm);

        for (int i = 0; i < week2.monday.lesso.size(); i++) {
            if(lecho.surname.equals(week2.monday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Monday " + week2.monday.lesso.get(i).time);
                hm.put(PRICEKEY, week2.monday.lesso.get(i).less);
                hm.put(IMGKEY, week2.monday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week2.monday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }
        for (int i = 0; i < week2.tuesday.lesso.size(); i++) {
            if(lecho.surname.equals(week2.tuesday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Tuesday " + week2.tuesday.lesso.get(i).time);
                hm.put(PRICEKEY, week2.tuesday.lesso.get(i).less);
                hm.put(IMGKEY, week2.tuesday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week2.thursday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }
        for (int i = 0; i < week2.wednesday.lesso.size(); i++) {
            if(lecho.surname.equals(week2.wednesday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Wednesday " + week2.wednesday.lesso.get(i).time);
                hm.put(PRICEKEY, week2.wednesday.lesso.get(i).less);
                hm.put(IMGKEY, week2.wednesday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week2.wednesday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }
        for (int i = 0; i < week2.thursday.lesso.size(); i++) {
            if(lecho.surname.equals(week2.thursday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Thursday " + week2.thursday.lesso.get(i).time);
                hm.put(PRICEKEY, week2.thursday.lesso.get(i).less);
                hm.put(IMGKEY, week2.thursday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week2.thursday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }
        for (int i = 0; i < week2.friday.lesso.size(); i++) {
            if(lecho.surname.equals(week2.friday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Friday " + week2.friday.lesso.get(i).time);
                hm.put(PRICEKEY, week2.friday.lesso.get(i).less);
                hm.put(IMGKEY, week2.friday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week2.friday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }
        for (int i = 0; i < week2.saturday.lesso.size(); i++) {
            if(lecho.surname.equals(week2.saturday.lesso.get(i).lek.surname)) {
                hm = new HashMap<String, Object>();
                hm.put(BOOKKEY,"Saturday " + week2.saturday.lesso.get(i).time);
                hm.put(PRICEKEY, week2.saturday.lesso.get(i).less);
                hm.put(IMGKEY, week2.saturday.lesso.get(i).lek.photo);
                hm.put(WHEREKEY, week2.saturday.lesso.get(i).comment);
                myBooks.add(hm);
            }
        }

        SimpleAdapter adapter = new SimpleAdapter(this, myBooks,R.layout.list, new String[]{BOOKKEY,PRICEKEY,IMGKEY,WHEREKEY}, new int[]{R.id.text1, R.id.text2, R.id.img,R.id.Where});
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
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

    public void deserializeListOfObjectslec() throws IOException {
        final String filename1 = "Leck.json";
        File file = new File(super.getFilesDir(), filename1);

        if (file.exists()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                SelectedLecto = mapper.readValue(file, Integer.class);
                Swich(SelectedLecto);
            }
            catch (Exception e)
            {
                Log.i("Log_json", "Oops, your serialization doesn't work" + e);
            }
            serializationToJsonM(99);
        } else {
            file.createNewFile();
        }
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
    public void serializationToJsonM(int in) throws IOException {
        final String filename1 = "Leck.json";
        File file = new File(super.getFilesDir(), filename1);
        if (file.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,in);
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
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,in);
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