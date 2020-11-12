package com.example.laba5;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MyDialogFragment extends AppCompatDialogFragment {
    int Select;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] catNamesArray = {MainActivity.odin.surname + " " + MainActivity.odin.name ,  MainActivity.dwa.surname + " " +  MainActivity.dwa.name,
                MainActivity.tri.surname + " " +  MainActivity.tri.name,  MainActivity.chetyre.surname + " " +  MainActivity.chetyre.name,  MainActivity.pyat.surname + " " +  MainActivity.pyat.name};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите Преподвателя")
                .setItems(catNamesArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),
                                "Выбранный кот: " + catNamesArray[which],
                                Toast.LENGTH_SHORT).show();
                        Select = which;
                        try {
                            serializationToJsonM(which);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        final Activity a = getActivity();
                        Intent intent = new Intent(a, MainActivity.class);
                        a.startActivity(intent);
                    }
                });
        return builder.create();
    }

    public void serializationToJsonM(int in) throws IOException {
        final String filename1 = "Leck.json";
        File file = new File("/data/data/com.example.laba5/files/Leck.json");
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
}
