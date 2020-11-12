package com.example.laba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import People.JManager;
import People.JStudent;
import People.Manager;
import People.Student;

public class Out extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out);

        chuse =  getIntent().getExtras().getInt("userClass");
        String des = getIntent().getExtras().getString("userName");
        Gson gs = new Gson();
        switch (chuse) {
            case 1:
                stud = gs.fromJson(des, Student.class);
                break;
            case 0:
                manager = gs.fromJson(des, Manager.class);
                break;
        }
        try {
            feel();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    ArrayList<Student> Students =  new ArrayList<>();
    ArrayList<Manager> Managers =  new ArrayList<>();
    ArrayList<String> FinalOut = new ArrayList<>();
    JStudent stu = new JStudent(Students);
    JManager man = new JManager(Managers);
    int chuse;
    Student stud;
    Manager manager;

    public void feel() throws IOException {
        stu.persrs.clear();
        man.persrs.clear();
        FinalOut.clear();
        ListView IT = findViewById(R.id.Out);


        final String filename1 = "stud1.json";
        File file1 = new File(super.getFilesDir(), filename1);
        //TakeSt(Students,file1,FinalOut);
        deserializeListOfObjectsS(file1);
        final String filename2 = "manager1.json";
        File file2 = new File(super.getFilesDir(), filename2);
        //TakeMan(Managers,file2,FinalOut);
        deserializeListOfObjectsM(file2);

        switch (chuse) {
            case 1:
//                String second_stud =stud.toString();
//                FinalOut.add(second_stud);
                stu.persrs.add(stud);
                break;
            case 0:
                man.persrs.add(manager);
//                String second_stud1 =manager.toString();
//                FinalOut.add(second_stud1);
                break;
        }

        if (!stu.persrs.isEmpty()) {
            for (int i = 0; i < stu.persrs.size(); i++) {
                String second_stud = stu.persrs.get(i).toString();
                FinalOut.add(second_stud);
            }
        }

        if (!man.persrs.isEmpty()) {
            for (int i = 0; i < man.persrs.size(); i++) {
                String second_stud = man.persrs.get(i).toString();
                FinalOut.add(second_stud);
            }
        }

        file1.createNewFile();
        file2.createNewFile();
        if(!stu.persrs.isEmpty()) {
            serializationToJsonS(file1, stu);
        }
        if(!man.persrs.isEmpty()) {
            serializationToJsonM(file2, man);
        }

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, FinalOut);
        IT.setAdapter(adapter2);
    }


    public void deserializeListOfObjectsM(File file) throws IOException {
        if (file.exists()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                man = mapper.readValue(file, JManager.class);
            }
            catch (Exception e)
            {
                Log.i("Log_json", "Oops, your serialization doesn't work" + e);
            }
        } else {
            file.createNewFile();
        }
    }


    public void deserializeListOfObjectsS(File file) throws IOException {
        if (file.exists()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                stu = mapper.readValue(file, JStudent.class);
            }
           catch (Exception e)
           {
               Log.i("Log_json", "Oops, your serialization doesn't work" + e);
           }
        } else {
            file.createNewFile();
        }
    }

    public void serializationToJsonM(File file, JManager person) throws IOException {
        if (file.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,person);
            } catch (IOException e) {
                Log.i("Log_json", "Oops, your serialization doesn't work");
            }
        }
        else
        {
            file.createNewFile();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,person);
            } catch (IOException e) {
                Log.i("Log_json", "Oops, your serialization doesn't work");
            }
        }

    }
    public void serializationToJsonS(File file, JStudent person) throws IOException {
        if (file.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,person);
            } catch (IOException e) {
                Log.i("Log_json", "Oops, your serialization doesn't work");
            }
        }
        else
        {
            file.createNewFile();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,person);
            } catch (IOException e) {
                Log.i("Log_json", "Oops, your serialization doesn't work");
            }
        }

    }

    public void New(View view)
    {
        String filename1 = "test1.json";
        File file1 = new File(super.getFilesDir(), filename1);
        String filename2 = "test3.txt";
        File file2 = new File(super.getFilesDir(), filename2);
        final String filename3 = "test4.txt";
        File file3 = new File(super.getFilesDir(), filename3);
        try {
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(Out.this, MainActivity.class);
        startActivity(intent);
    }
}