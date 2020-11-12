package com.example.laba4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import Organization.Organizations;
import People.JManager;
import People.JStudent;
import People.Manager;
import People.Student;
import lombok.SneakyThrows;

public class YourFinal extends AppCompatActivity {

    @SneakyThrows
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        imageView = (ImageView) findViewById(R.id.Image);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_final);
        position =  getIntent().getExtras().getInt("Element");
        feel();
    }
    public ImageView imageView;
    int position;
    ArrayList<Student> Students =  new ArrayList<>();
    ArrayList<Manager> Managers =  new ArrayList<>();
    ArrayList<String> FinalOut = new ArrayList<>();
    JStudent stu = new JStudent(Students);
    JManager man = new JManager(Managers);
    public Uri myUri;

    public void feel() throws IOException, URISyntaxException {
        stu.persrs.clear();
        man.persrs.clear();

        final String filename1 = "stud1.json";
        File file1 = new File(super.getFilesDir(), filename1);
        deserializeListOfObjectsS(file1);
        final String filename2 = "manager1.json";
        File file2 = new File(super.getFilesDir(), filename2);
        deserializeListOfObjectsM(file2);


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


        if(position<=stu.persrs.size())
        {
            Student stud = stu.persrs.get(position-1);
            myUri = Uri.parse(stud.url);
            Print(stud.name,stud.surname,stud.middlename,Organizations.BSTU,"Student",stud.email,stud.number);
        }
        else
        {
            Student manager = stu.persrs.get(position - 2);
            myUri = Uri.parse(manager.url);
            Print(manager.name, manager.surname,manager.middlename,Organizations.BSTU,"Manager",manager.email,manager.number);
        }
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

    public void Print(String name, String surname, String middlename, Organizations org, String clas, final String Email, final String Number)
    {
        TextView Name = findViewById(R.id.selectedName);
        TextView Surname = findViewById(R.id.selectedSurname);
        TextView Middlename = findViewById(R.id.selectedMIddlename);
        TextView Org = findViewById(R.id.selectedOrganization);
        TextView Role = findViewById(R.id.selectedRole);
        final TextView Emails = findViewById(R.id.selectedEmail);
        TextView Numbers = findViewById(R.id.selectedNumber);
        Name.setText(name);
        Surname.setText(surname);
        Middlename.setText(middlename);
        Org.setText(org.getOrg());
        Role.setText(clas);
        Emails.setText(Email);
        Numbers.setText(Number);
       ImageView vi = findViewById(R.id.Image);
        Numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + Uri.encode(Number)));
                startActivity(intent);
            }
        });
        Emails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+Email));
                startActivity(intent);
            }
        });
        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
            }
        });
    }

    public void Back(View view)
    {
        int pages = 1;
        Intent intents = new Intent(YourFinal.this, Out.class);
        intents.putExtra("Page", pages);
        startActivity(intents);
    }

}