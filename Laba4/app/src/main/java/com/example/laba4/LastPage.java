package com.example.laba4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import People.Pesrson;

public class LastPage extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);

        Bstu = (RadioButton)findViewById(R.id.SelectBsu);
        Bstu.setOnClickListener(radioButtonClickListener);

        Bsu = (RadioButton)findViewById(R.id.SelectBstu);
        Bsu.setOnClickListener(radioButtonClickListener);

        Ped = (RadioButton)findViewById(R.id.SelectPed);
        Ped.setOnClickListener(radioButtonClickListener);

        chuse =  getIntent().getExtras().getInt("class");
        String des = getIntent().getExtras().getString("username");
        Gson gs = new Gson();
        persona = gs.fromJson(des, Pesrson.class);
        Take();
        Log.d("Log_02", "Succes " + persona.toString() + " " + Take());

        imageView = (ImageView) findViewById(R.id.Image);

        Button button = (Button) findViewById(R.id.Aply);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, Pick_image);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);


        switch (requestCode) {
            case Pick_image:
                if (resultCode == RESULT_OK) {
                    try {

                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);
                        image = imageUri;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    RadioButton Bstu;
    RadioButton Bsu;
    RadioButton Ped;
    Pesrson persona;
    int chuse;
    int unik;
    Uri image;
    public ImageView imageView;
    private final int Pick_image = 1;

    public void Chuse(String  some)
    {
        Gson gson = new Gson();
        final String filename = "test4.txt";
        File file = new File(super.getFilesDir(), filename);
        final String filename1 = "test5.txt";
        File file1 = new File(super.getFilesDir(), filename1);
        try {
            file.createNewFile();
            file1.createNewFile();
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

//            FileWriter fr1 = new FileWriter(file1);
//            String aaa =String.valueOf(image);
//
//            fr1.write(aaa);
//            fr1.flush();
//            fr1.close();
//            Uri rez = gson.fromJson(gson.toJson(aaa),Uri.class);
        } catch (IOException e) {
            Log.d("Log_02", "File " + filename + " not opened" + e.getMessage());
        }
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            switch (rb.getId()) {
                case R.id.SelectBstu: Chuse("1");
                    break;
                case R.id.SelectBsu: Chuse("0");
                    break;
                case R.id.SelectPed: Chuse("2");
                    break;
                default:
                    break;
            }
        }
    };

    public void Next(View view)
    {
        Gson gs = new Gson();
        String ser = gs.toJson(persona);
        Intent intent = new Intent(LastPage.this, YourChoise.class);
        intent.putExtra("userName", ser);
        intent.putExtra("userClass", chuse);
        intent.putExtra("userUnik", unik);
        intent.putExtra("img", image);
        startActivity(intent);
    }

    public void Back(View view)
    {
        Gson gs = new Gson();
        String ser = gs.toJson(persona);
        Intent intent = new Intent(LastPage.this,ForStudManager.class);
        intent.putExtra("username", ser);
        startActivity(intent);
    }

    public String Take()
    {
        Gson gson = new Gson();
        final String filename = "test4.txt";
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
                            Bstu.isActivated();
                            Bstu.isChecked();
                            Bstu.toggle();
                            unik = 0;
                            break;
                        case 1:
                            Bsu.isActivated();
                            Bsu.isChecked();
                            Bsu.toggle();
                            unik = 1;
                            break;
                        case 2:
                            Ped.isActivated();
                            Ped.isChecked();
                            Ped.toggle();
                            unik = 2;
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