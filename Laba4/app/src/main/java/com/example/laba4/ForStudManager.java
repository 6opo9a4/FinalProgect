package com.example.laba4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import People.Pesrson;

public class ForStudManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_stud_manager);

        manager = (RadioButton)findViewById(R.id.SelectBsu);
        manager.setOnClickListener(radioButtonClickListener);

        student = (RadioButton)findViewById(R.id.SelectBstu);
        student.setOnClickListener(radioButtonClickListener);
        String des = getIntent().getExtras() == null ? "" : getIntent().getExtras().getString("username");
        Gson gs = new Gson();
        persona = gs.fromJson(des, Pesrson.class);
        Take();
        Log.d("Log_02", "Succes " + persona.toString() + " " + Take());
    }
    RadioButton manager;
    RadioButton student;
    Pesrson persona;
    int chuse;

    public void Chuse(String  some)
    {
        Gson gson = new Gson();
        final String filename = "test3.txt";
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
            fr.write(some);
            fr.flush();
            fr.close();
            Log.d("Log_02", file.getAbsolutePath() + gson.toJson(some));
        } catch (IOException e) {
            Log.d("Log_02", "File " + filename + " not opened" + e.getMessage());
        }
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            switch (rb.getId()) {
                case R.id.SelectBstu: Chuse("0");
                    break;
                case R.id.SelectBsu: Chuse("1");
                    break;
                default:
                    break;
            }
        }
    };

    public void Next(View view)
    {
        Intent intent = new Intent(ForStudManager.this, LastPage.class);
        Gson gs = new Gson();
        String ser = gs.toJson(persona);
        intent.putExtra("username", ser);
        intent.putExtra("class", chuse);
        startActivity(intent);
    }

    public void Back(View view)
    {
        Intent intent = new Intent(ForStudManager.this, MainActivity.class);
        startActivity(intent);
    }

    public String Take()
    {
        Gson gson = new Gson();
        final String filename = "test3.txt";
        File file = new File(super.getFilesDir(), filename);
        String man = "";
        if(file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String lineR = reader.readLine();
                while (lineR != null) {
                    man = lineR;
                    Log.d("Log_02", "Readed " + man);
                    int i = Integer.parseInt(man.trim());

                    switch (i) {
                        case 0:
                            student.isActivated();
                            student.isChecked();
                            student.toggle();
                            chuse=0;
                            break;
                        case 1:
                            manager.isActivated();
                            manager.isChecked();
                            manager.toggle();
                            chuse=1;
                            break;
                    }
                    lineR = reader.readLine();
                }
                fr.close();

            } catch (IOException e) {
                Log.d("Log_02", "File " + filename + " not opened" + e.getMessage());
            }
        }
        return man;
    }
}