package com.example.laba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.StringReader;

import Organization.Organizations;
import People.Manager;
import People.Pesrson;
import People.Student;

public class YourChoise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_choise);

        chuse =  getIntent().getExtras().getInt("userClass");
        role =  getIntent().getExtras().getInt("userUnik");
        String des = getIntent().getExtras().getString("userName");
        Gson gs = new Gson();
        persona = gs.fromJson(des, Pesrson.class);
        Out();
    }

    Pesrson persona;
    int chuse;
    int role;
    Student stud;
    Manager manager;
    public void Out()
    {
        switch (chuse) {
            case 1:
                if(role == 0)
                {
                    stud = new Student(persona.name,persona.surname,persona.middlename,persona.age,0, Organizations.BSTU);
                    Print(persona.name,persona.surname,persona.middlename,Organizations.BSTU,"Student");
                }
                if(role == 2)
                {
                    stud = new Student(persona.name,persona.surname,persona.middlename,persona.age,0, Organizations.BSU);
                    Print(persona.name,persona.surname,persona.middlename,Organizations.PED,"Student");
                }
                if(role == 1)
                {
                    stud = new Student(persona.name,persona.surname,persona.middlename,persona.age,0, Organizations.PED);
                    Print(persona.name,persona.surname,persona.middlename,Organizations.BSU,"Student");
                }
                Log.d("Log_02", "Student " + stud.toString());
                break;
            case 0:
                if(role == 0)
                {
                    manager = new Manager(persona.name,persona.surname,persona.middlename,persona.age, Organizations.BSTU);
                    Print(manager.name,manager.surname,manager.middlename,Organizations.BSTU,"Manager");
                }
                if(role == 2)
                {
                    manager = new Manager(persona.name,persona.surname,persona.middlename,persona.age, Organizations.BSU);
                    Print(manager.name,manager.surname,manager.middlename,Organizations.PED,"Manager");
                }
                if(role == 1)
                {
                    manager = new Manager(persona.name,persona.surname,persona.middlename,persona.age, Organizations.PED);
                    Print(manager.name,manager.surname,manager.middlename,Organizations.BSU,"Manager");
                }
                Log.d("Log_02", "Student " + manager.toString());
                break;
            case 2:
                Log.d("Log_02", "WTF?????");
                break;
        }
    }

    public void Print(String name,String surname,String middlename, Organizations org, String clas)
    {
        TextView Name = findViewById(R.id.selectedName);
        TextView Surname = findViewById(R.id.selectedSurname);
        TextView Middlename = findViewById(R.id.selectedMIddlename);
        TextView Org = findViewById(R.id.selectedOrganization);
        TextView Role = findViewById(R.id.selectedRole);
        Name.setText(name);
        Surname.setText(surname);
        Middlename.setText(middlename);
        Org.setText(org.getOrg());
        Role.setText(clas);

    }
    public void Back(View view)
    {
        Intent intent = new Intent(YourChoise.this, LastPage.class);
        Gson gs = new Gson();
        String ser = gs.toJson(persona);
        intent.putExtra("username", ser);
        intent.putExtra("class", chuse);
        startActivity(intent);
    }
    public void Next(View view)
    {
        switch (chuse) {
            case 1:
                Gson gs = new Gson();
                String ser = gs.toJson(stud);
                Intent intent = new Intent(YourChoise.this, Out.class);
                intent.putExtra("userName", ser);
                intent.putExtra("userClass", chuse);
                startActivity(intent);
                break;
            case 0:
                Gson gss = new Gson();
                String sers = gss.toJson(manager);
                Intent intents = new Intent(YourChoise.this, Out.class);
                intents.putExtra("userName", sers);
                intents.putExtra("userClass", chuse);
                startActivity(intents);
                break;
        }
    }
}