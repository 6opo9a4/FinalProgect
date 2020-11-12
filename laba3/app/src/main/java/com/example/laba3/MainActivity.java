package com.example.laba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Readd = findViewById(R.id.Read);
        Absoluted = findViewById(R.id.Absolute);
        Pathd = findViewById(R.id.Path);
        Externald = findViewById(R.id.External);
        Named = findViewById(R.id.Name);
    }


    TextView Readd;
    TextView Absoluted;
    TextView Pathd;
    TextView Externald;
    TextView Named;



    public void GETEXTERNALSTORAGEDIRECTORY(View view) {

        String absolute =  Environment.getExternalStorageDirectory().getAbsolutePath();
        String name =  Environment.getExternalStorageDirectory().getName();
        String pahth =  Environment.getExternalStorageDirectory().getPath();
        boolean read =  Environment.getExternalStorageDirectory().canRead();
        ContextWrapper c = new ContextWrapper(this);
        String readT = "";
        String writeT = "";
        if(read == true)
        {
           readT = "yes";
        }
        else
        {
            readT = "nope";
        }
        boolean write =  Environment.getExternalStorageDirectory().canWrite();
        if(write == true)
        {
            writeT = "yes";
        }
        else
        {
            writeT = "nope";
        }
       // String external =  Environment.getExternalStorageDirectory().getEnternalStorageState();

        Readd.setText("Read/Write: " + readT +"/" + writeT );
        Absoluted.setText("Absolute: " + absolute );
        Pathd.setText("Path: " + pahth );
        Externald.setText(Environment.getExternalStorageState());
        //External.setText("External: " + external );
        Named.setText("Name: " + name );
    }

    public void GETFILESDIR(View view) {
        ContextWrapper c = new ContextWrapper(this);
        String absolute =  c.getFilesDir().getAbsolutePath();
        String name =  c.getFilesDir().getName();
        String pahth =  c.getFilesDir().getPath();
        boolean read =  c.getFilesDir().canRead();
        String readT = "";
        String writeT = "";
        if(read == true)
        {
            readT = "yes";
        }
        else
        {
            readT = "nope";
        }
        boolean write =  c.getFilesDir().canWrite();
        if(write == true)
        {
            writeT = "yes";
        }
        else
        {
            writeT = "nope";
        }
        Readd.setText("Read/Write: " + read +"/" + write );
        Absoluted.setText("Absolute: " + absolute );
        Pathd.setText("Path: " + pahth );
        Externald.setText(Environment.getExternalStorageState());
        //External.setText("External: " + external );
        Named.setText("Name: " + name );
    }

    public void GETEXTERNALCACHEDIR(View view) {


//        TextView absolute = findViewById(R.id.textView7);
//        TextView name = findViewById(R.id.textView9);
//        TextView path = findViewById(R.id.textView10);
//        TextView readWrite = findViewById(R.id.textView11);
//        TextView external = findViewById(R.id.textView12);

        File dir =super.getExternalCacheDir();
        Absoluted.setText(dir.getAbsolutePath());
        Named.setText(dir.getName());
        Pathd.setText(dir.getPath());
        String readWriteStr = dir.canRead() + "/" + dir.canWrite();
        Readd.setText(readWriteStr);
        Externald.setText(Environment.getExternalStorageState());
//
//
//
//        ContextWrapper c = new ContextWrapper(this);
//        String absolute =  c.getExternalCacheDir().getAbsolutePath();
//        String name =  c.getExternalCacheDir().getName();
//        String pahth =  c.getExternalCacheDir().getPath();
//        boolean read =  c.getExternalCacheDir().canRead();
//        String readT = "";
//        String writeT = "";
//        if(read == true)
//        {
//            readT = "yes";
//        }
//        else
//        {
//            readT = "nope";
//        }
//        boolean write =  c.getExternalCacheDir().canWrite();
//        if(write == true)
//        {
//            writeT = "yes";
//        }
//        else
//        {
//            writeT = "nope";
//        }

//        Readd.setText("Read/Write: " + read +"/" + write );
//        Absoluted.setText("Absolute: " + absolute );
//        Pathd.setText("Path: " + pahth );
//        External.setText("External: " + external );
//        Named.setText("Name: " + name );
    }

   public void GETEXTERNALFILESDIR(View view) {
        ContextWrapper c = new ContextWrapper(this);
        String absolute =  c.getExternalFilesDir("").getAbsolutePath();
        String name =  c.getExternalFilesDir("").getName();
        String pahth =  c.getExternalFilesDir("").getPath();
        boolean read =  c.getExternalFilesDir("").canRead();
       String readT = "";
       String writeT = "";
       if(read == true)
       {
           readT = "yes";
       }
       else
       {
           readT = "nope";
       }
       boolean write =  Environment.getExternalStorageDirectory().canWrite();
       if(write == true)
       {
           writeT = "yes";
       }
       else
       {
           writeT = "nope";
       }
       Readd.setText("Read/Write: " + readT +"/" + writeT );
       Absoluted.setText("Absolute: " + absolute );
       Pathd.setText("Path: " + pahth );
       Externald.setText(Environment.getExternalStorageState());
       //External.setText("External: " + external );
       Named.setText("Name: " + name );
   }

    public void GETCACHEDIR(View view) {

        ContextWrapper c = new ContextWrapper(this);


        String absolute =  c.getCacheDir().getAbsolutePath();
        String name =  c.getCacheDir().getName();
        String pahth =  c.getCacheDir().getPath();
        boolean read =  c.getCacheDir().canRead();
        String readT = "";
        String writeT = "";
        if(read == true)
        {
            readT = "yes";
        }
        else
        {
            readT = "nope";
        }
        boolean write =  c.getCacheDir().canWrite();
        if(write == true)
        {
            writeT = "yes";
        }
        else
        {
            writeT = "nope";
        }
        Readd.setText("Read/Write: " + readT +"/" + writeT );
        Absoluted.setText("Absolute: " + absolute );
        Pathd.setText("Path: " + pahth );
        Externald.setText(Environment.getExternalStorageState());
        //External.setText("External: " + external );
        Named.setText("Name: " + name );
    }

    public void GETEXTERNALSTORAGEPUBLICDIRECTORY(View view) {
        String absolute =  Environment.getExternalStoragePublicDirectory("").getAbsolutePath();
        String name =  Environment.getExternalStoragePublicDirectory("").getName();
        String pahth =  Environment.getExternalStoragePublicDirectory("").getPath();
        boolean read =  Environment.getExternalStoragePublicDirectory("").canRead();
        String readT = "";
        String writeT = "";
        if(read == true)
        {
            readT = "yes";
        }
        else
        {
            readT = "nope";
        }
        boolean write =  Environment.getExternalStorageDirectory().canWrite();
        if(write == true)
        {
            writeT = "yes";
        }
        else
        {
            writeT = "nope";
        }
        Readd.setText("Read/Write: " + readT +"/" + writeT );
        Absoluted.setText("Absolute: " + absolute );
        Pathd.setText("Path: " + pahth );
        Externald.setText(Environment.getExternalStorageState());
        //External.setText("External: " + external );
        Named.setText("Name: " + name );
   }
}