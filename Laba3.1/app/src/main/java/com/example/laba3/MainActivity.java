package com.example.laba3;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Person;
import android.content.Intent;
import android.os.Bundle;

import android.renderscript.Type;
import android.util.Log;
import android.view.View;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import People.Pesrson;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextInputEditText EditName = findViewById(R.id.Name);
        TextInputEditText EditSurname = findViewById(R.id.Surname);
        TextInputEditText EditMiddlename = findViewById(R.id.Middlename);
        EditName.setText(Take().name);
        EditSurname.setText(Take().surname);
        EditMiddlename.setText(Take().middlename);
        Name = findViewById(R.id.InName);
        Surname = findViewById(R.id.InSurname);
        Middlename = findViewById(R.id.InMiddlename);
    }

    TextInputLayout Name ;
    TextInputLayout Surname ;
    TextInputLayout Middlename ;
    Pesrson pers;

    public void NSMEnter(View viev) throws IOException {
        onPause();
        onStop();
        String names = Name.getEditText().getText().toString();
        String surnames = Surname.getEditText().getText().toString();
        String middlenames = Middlename.getEditText().getText().toString();

        if(names != null && surnames != null && middlenames != null) {
            pers = new Pesrson(names, surnames, middlenames, 0);
            Insert(pers);
            Gson gs = new Gson();
            String ser = gs.toJson(pers);
            Intent intent = new Intent(MainActivity.this, ForStudManager.class);
            intent.putExtra("username", ser);
            startActivity(intent);
        }
        else
        {
            Log.d("Log_02", "Fill in all fields");
        }
    }

    public void Insert(Pesrson per) throws IOException {
        Gson gson = new Gson();
        final String filename = "test1.json";
        File file = new File(super.getFilesDir(), filename);
        try {
            file.createNewFile();
            Log.d("Log_02", "Writed");
        }
        catch (Exception e)
        {
            Log.d("Log_02", "Error: " + e);
        }
        try {
            FileWriter fr = new FileWriter(file);
//
            gson.toJson(per, fr);
            fr.close();
            Log.d("Log_02", file.getAbsolutePath() + per.middlename);
        } catch (IOException e) {
            Log.d("Log_02", "File " + filename + " not opened" + e.getMessage());
        }
    }

    public Pesrson Take()
    {
        Gson gson = new Gson();
        final String filename = "test1.json";
        File file = new File(super.getFilesDir(), filename);
        Pesrson man = new Pesrson("","","",0);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String lineR = reader.readLine();
            while (lineR != null) {
                man = gson.fromJson(lineR,Pesrson.class);
                Log.d("Log_02", "Readed " + man.name + " " + man.surname + " " + man.middlename);
                lineR = reader.readLine();
            }
            fr.close();

        } catch (IOException e) {
            Log.d("Log_02", "File " + filename + " not opened" + e.getMessage());
        }
        return man;
    }

}