package com.example.test;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.net.sip.SipAudioCall;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

import Comparators.Stusentsomparator;
import Exeption.FileExeption;
import People.Manager;
import People.Pesrson;
import People.Student;


public class MainActivity extends AppCompatActivity {

    public class Staff {
        public int count;
        public String name;
        public Staff(int Count, String Name)
        {
            this.count = Count;
            this.name = Name;
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView firts = findViewById(R.id.di1);
        firts.setText(it.name);
        TextView second = findViewById(R.id.di2);
        second.setText(les.name);
    }
    boolean i1 = false;
    boolean i2 = false;
    Manager badman =  new Manager();
    Staff it = new Staff(10,"IT");
    Staff les = new Staff(20,"LesHoz");
    ArrayList<Student> ITs =  new ArrayList<>();
    ArrayList<Student> Less =  new ArrayList<>();
    ArrayList<String> stringStudIT = new ArrayList<>();
    ArrayList<String> stringStudLes = new ArrayList<>();
    ArrayList<Student> JsonListenerIT = new ArrayList<Student>();


    public void itRan(View view)
    {
        stringStudIT.clear();
        ListView IT = findViewById(R.id.IT);
        badman.make(ITs,it.count);
        for(int i =0;i<it.count;i++) {
            String second_stud = ITs.get(i).toString();
            stringStudIT.add(second_stud);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                Optional<String> opt = Student.SomeData(ITs.get(i));
                if(opt.isPresent())
                {
                    Log.d("Log_02", "Optional test " + opt.get());
                }
            }
        }
        topIT();
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringStudIT);
        IT.setAdapter(adapter2);

    }
    public void itJson(View view) throws FileExeption {
        stringStudIT.clear();
        ListView IT = findViewById(R.id.IT);

        Gson gson = new Gson();

        final String filename = "test.json";
        File file = new File(super.getFilesDir(), filename);

        if(!file.exists())
        {
            throw new FileExeption("The file is not created", filename);
        }
        String line = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
//            Optional<String> lineR = Optional.of(reader.readLine());
//            while (lineR.isPresent()) {
//
//                System.out.println(line);
//                // считываем остальные строки в цикле
//                line = line + lineR;
//                lineR = Optional.of(reader.readLine());
//            }
            String lineR = reader.readLine();
            while (lineR != null) {

                System.out.println(line);
                // считываем остальные строки в цикле
                line = line + lineR;
                lineR = reader.readLine();
            }
            fr.close();
            Log.d("Log_02", file.getAbsolutePath());
        } catch (IOException e) {
            Log.d("Log_02", "File " + filename + " not opened" + e.getMessage());
        }
        Type type = new TypeToken<ArrayList<Student>>(){}.getType();
        ArrayList<Student> read = gson.fromJson(line, type);
        System.out.println(read.toString());
        for(int i =0;i<it.count;i++) {
            String second_stud = read.get(i).toString();
            stringStudIT.add(second_stud);
        }
        ITs = (ArrayList<Student>) read.clone();
        topIT();
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringStudIT);
        IT.setAdapter(adapter2);
    }

    public void leshozRan(View view)
    {
        stringStudLes.clear();
        ListView Les = findViewById(R.id.LesHoz);
        badman.make(Less,les.count);
        for(int i =0;i<les.count;i++) {
            String second_stud = Less.get(i).toString();
            stringStudLes.add(second_stud);
        }
        topLes();
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringStudLes);
        Les.setAdapter(adapter2);
    }

    public void leshozJson(View view)
    {
//        stringStudLes.clear();
//        ListView Les = findViewById(R.id.LesHoz);
//        Gson gson = new Gson();
//        final String filename = "test.json";
//        File file = new File(super.getFilesDir(), filename);
//        String line = "";
//        try {
//            FileReader fr = new FileReader(file);
//            BufferedReader reader = new BufferedReader(fr);
//            // считаем сначала первую строку
//            String lineR = reader.readLine();
//            while (lineR != null) {
//
//                System.out.println(line);
//                // считываем остальные строки в цикле
//                line = line + lineR;
//                lineR = reader.readLine();
//            }
//            fr.close();
//            Log.d("Log_02", file.getAbsolutePath());
//        } catch (IOException e) {
//            Log.d("Log_02", "File " + filename + " not opened" + e.getMessage());
//        }
//        Type type = new TypeToken<ArrayList<Student>>(){}.getType();
//        ArrayList<Student> read = gson.fromJson(line, type);
//        System.out.println(read.toString());
//        for(int i =0;i<les.count;i++) {
//            String second_stud = read.get(i).toString();
//            stringStudLes.add(second_stud);
//        }
//        Less = (ArrayList<Student>) read.clone();
//        topLes();
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringStudLes);
//        Les.setAdapter(adapter2);
    }

    public void markSort(View view) {
        ListView IT = findViewById(R.id.IT);
        ListView LesHoz = findViewById(R.id.LesHoz);

        Comparator ageComparator = new Stusentsomparator();
        if(!ITs.isEmpty()) {
            badman.markSort(ITs,stringStudIT,it.count);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringStudIT);
            IT.setAdapter(adapter1);
        }
        else
        {
            Toast toast = Toast.makeText(this, "Курсы IT пусты", Toast.LENGTH_LONG);
            toast.show();
        }
        if(!Less.isEmpty())
        {
            badman.markSort(Less,stringStudLes,les.count);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringStudLes);
            LesHoz.setAdapter(adapter1);
        }
        else{
            Toast toast = Toast.makeText(this, "Курсы ЛесХоза пусты", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    public void ageSort(View view) {
        ListView IT = findViewById(R.id.IT);
        ListView LesHoz = findViewById(R.id.LesHoz);

        Comparator ageComparator = new Stusentsomparator();
        if(!ITs.isEmpty()) {
            badman.ageSort(ITs,stringStudIT,it.count);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringStudIT);
            IT.setAdapter(adapter1);
        }
        else
        {
            Toast toast = Toast.makeText(this, "Курсы IT пусты", Toast.LENGTH_LONG);
            toast.show();
        }
        if(!Less.isEmpty())
        {
            badman.ageSort(Less,stringStudLes,les.count);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringStudLes);
            LesHoz.setAdapter(adapter1);
        }
        else{
            Toast toast = Toast.makeText(this, "Курсы ЛесХоза пусты", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    public void nameSort(View view) {
        ListView IT = findViewById(R.id.IT);
        ListView LesHoz = findViewById(R.id.LesHoz);

        Comparator ageComparator = new Stusentsomparator();
        if(!ITs.isEmpty()) {
            badman.nameSort(ITs,stringStudIT,it.count);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringStudIT);
            IT.setAdapter(adapter1);
        }
        else
        {
            Toast toast = Toast.makeText(this, "Курсы IT пусты", Toast.LENGTH_LONG);
            toast.show();
        }
        if(!Less.isEmpty())
        {
            badman.nameSort(Less,stringStudLes,les.count);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringStudLes);
            LesHoz.setAdapter(adapter1);
        }
        else{
            Toast toast = Toast.makeText(this, "Курсы ЛесХоза пусты", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    public void topIT()
    {

        ListView IT = findViewById(R.id.ITTop);
        ArrayList<String> itsh = new ArrayList<>();
        ArrayList<String> It = new ArrayList<>();
        itsh.addAll(stringStudIT);
        badman.markSort(ITs,itsh,it.count);
        for(int i = 1; i < 4; i++) {
            It.add(itsh.get(itsh.size()-i));
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, It);
        IT.setAdapter(adapter1);
    }

    public void topLes()
    {
        ListView LesHoz = findViewById(R.id.LesHozTop);
        ArrayList<String> Les = new ArrayList<>();
        ArrayList<String> lesh = new ArrayList<>();
        lesh.addAll(stringStudLes);
        badman.markSort(Less,lesh,les.count);
        for(int i = 1; i < 4; i++) {
            Les.add(lesh.get(lesh.size()-i));
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Les);
        LesHoz.setAdapter(adapter2);
    }
}