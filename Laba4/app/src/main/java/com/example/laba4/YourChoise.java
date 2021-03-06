package com.example.laba4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.InputStream;

import Organization.Organizations;
import People.Manager;
import People.Pesrson;
import People.Student;

public class YourChoise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_choise);
        imageView = (ImageView) findViewById(R.id.Image);
        chuse =  getIntent().getExtras().getInt("userClass");
        role =  getIntent().getExtras().getInt("userUnik");
        image = getIntent().getParcelableExtra("img");
        String des = getIntent().getExtras().getString("userName");
        Gson gs = new Gson();
        persona = gs.fromJson(des, Pesrson.class);
        Out();
    }
    public ImageView imageView;
    Pesrson persona;
    int chuse;
    int role;
    Student stud;
    Manager manager;
    public Uri image;
    public String Strime;
    public void Out()
    {
        Strime = image.toString();
        switch (chuse) {
            case 1:
                if(role == 0)
                {
                    stud = new Student(persona.name,persona.surname,persona.middlename,persona.age,0, Organizations.BSTU,persona.email,persona.number,Strime);
                    Print(persona.name,persona.surname,persona.middlename,Organizations.BSTU,"Student",persona.email,persona.number);
                }
                if(role == 2)
                {
                    stud = new Student(persona.name,persona.surname,persona.middlename,persona.age,0, Organizations.BSU,persona.email,persona.number,Strime);
                    Print(persona.name,persona.surname,persona.middlename,Organizations.BSU,"Student",persona.email,persona.number);
                }
                if(role == 1)
                {
                    stud = new Student(persona.name,persona.surname,persona.middlename,persona.age,0, Organizations.PED,persona.email,persona.number,Strime);
                    Print(persona.name,persona.surname,persona.middlename,Organizations.PED,"Student",persona.email,persona.number);
                }
                Log.d("Log_02", "Student " + stud.toString());
                break;
            case 0:
                if(role == 0)
                {
                    manager = new Manager(persona.name,persona.surname,persona.middlename,persona.age, Organizations.BSTU,persona.email,persona.number,Strime);
                    Print(manager.name,manager.surname,manager.middlename,Organizations.BSTU,"Manager",manager.email,manager.number);
                }
                if(role == 2)
                {
                    manager = new Manager(persona.name,persona.surname,persona.middlename,persona.age, Organizations.BSU,persona.email,persona.number,Strime);
                    Print(manager.name,manager.surname,manager.middlename,Organizations.BSU,"Manager",persona.email,manager.number);
                }
                if(role == 1)
                {
                    manager = new Manager(persona.name,persona.surname,persona.middlename,persona.age, Organizations.PED,persona.email,persona.number,Strime);
                    Print(manager.name,manager.surname,manager.middlename,Organizations.PED,"Manager",persona.email,manager.number);
                }
                Log.d("Log_02", "Student " + manager.toString());
                break;
            case 2:
                Log.d("Log_02", "WTF?????");
                break;
        }
        try {

            final Uri imageUri = image;
            final InputStream imageStream = getContentResolver().openInputStream(imageUri);
            final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            imageView.setImageBitmap(selectedImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Print(String name,String surname,String middlename, Organizations org, String clas,String Email,String Number)
    {
        TextView Name = findViewById(R.id.selectedName);
        TextView Surname = findViewById(R.id.selectedSurname);
        TextView Middlename = findViewById(R.id.selectedMIddlename);
        TextView Org = findViewById(R.id.selectedOrganization);
        TextView Role = findViewById(R.id.selectedRole);
        TextView Emails = findViewById(R.id.selectedEmail);
        TextView Numbers = findViewById(R.id.selectedNumber);
        Name.setText(name);
        Surname.setText(surname);
        Middlename.setText(middlename);
        Org.setText(org.getOrg());
        Role.setText(clas);
        Emails.setText(Email);
        Numbers.setText(Number);
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
                int page = 0;
                Gson gs = new Gson();
                String ser = gs.toJson(stud);
                Intent intent = new Intent(YourChoise.this, Out.class);
                intent.putExtra("userName", ser);
                intent.putExtra("userClass", chuse);
                intent.putExtra("Page", page);
                startActivity(intent);
                break;
            case 0:
                int pages = 0;
                Gson gss = new Gson();
                String sers = gss.toJson(manager);
                Intent intents = new Intent(YourChoise.this, Out.class);
                intents.putExtra("userName", sers);
                intents.putExtra("userClass", chuse);
                intents.putExtra("Page", pages);
                startActivity(intents);
                break;
        }
    }
}