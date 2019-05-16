package com.luciekimotho.intellisoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PatientsActivity extends AppCompatActivity {
    EditText et_name, et_contact, et_address, et_next;
    Button btn_save;
    String name, contact, address, nextOfKin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        et_name = findViewById(R.id.etName);
        et_contact = findViewById(R.id.etContact);
        et_address = findViewById(R.id.etAddress);
        et_next= findViewById(R.id.etNextOfKin);

        btn_save = findViewById(R.id.btnSave);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_name.getText().toString();
                contact = et_contact.getText().toString();
                address = et_address.getText().toString();
                nextOfKin = et_next.getText().toString();


                String fileName = "Patients";
                Log.d("Patients", name + contact + address + nextOfKin);

                try {
                    File file = File.createTempFile(fileName, null, getCacheDir());
                    FileOutputStream outputStream = new FileOutputStream(file);
                    outputStream.write(name.getBytes());
//                    outputStream.write(contact.getBytes());
//                    outputStream.write(address.getBytes());
//                    outputStream.write(nextOfKin.getBytes());
                    outputStream.flush();
                    outputStream.close();
                    Log.d("Patients", file.toString());

                } catch (IOException e) {
                    Log.d("Patients", e.getMessage());
                }

                JSONObject jsonObj = new JSONObject();
                try {
                    jsonObj.put("Name", name);
                    jsonObj.put("Contact", contact);
                    jsonObj.put("address", address);
                    jsonObj.put("nextOfKin", nextOfKin);
                    Log.d("Patients", jsonObj.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                String fileName2 = "Jsonfile";
                File jsonFile = new File(getFilesDir(), fileName2);
                FileWriter fileWriter = null;
                BufferedWriter bufferedWriter = null;
                FileReader fileReader = null;

                if (!jsonFile.exists()){
                    try {
                        jsonFile.createNewFile();
                        fileWriter = new FileWriter(jsonFile.getAbsoluteFile());
                        bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write("{}");
                        bufferedWriter.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }

            }
        });
    }
}
