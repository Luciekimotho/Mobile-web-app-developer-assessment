package com.luciekimotho.intellisoft;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatientsFragment extends Fragment {
    String name, contact, address, nextOfKin;


        public PatientsFragment() {
            // Required empty public constructor
        }


    @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_patients, container, false);
        final EditText et_name, et_contact, et_address, et_next;
        Button btn_save;



        et_name = root.findViewById(R.id.etName);
        et_contact = root.findViewById(R.id.etContact);
        et_address = root.findViewById(R.id.etAddress);
        et_next= root.findViewById(R.id.etNextOfKin);

        btn_save = root.findViewById(R.id.btnSave);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = et_name.getText().toString();
                contact = et_contact.getText().toString();
                address = et_address.getText().toString();
                nextOfKin = et_next.getText().toString();

                Context mContext;
                mContext = getActivity();

                String fileName = "Patients";
                Log.d("Patients", name + contact + address + nextOfKin);

                try {
                    File file = File.createTempFile(fileName, null, mContext.getCacheDir());
                    FileOutputStream outputStream = new FileOutputStream(file);
                    outputStream.write(name.getBytes());
//                    outputStream.write(contact.getBytes());
//                    outputStream.write(address.getBytes());
//                    outputStream.write(nextOfKin.getBytes());
                    outputStream.flush();
                    outputStream.close();
                    Log.d("Patients", file.toString());
                    Intent i = new Intent(getActivity(), NextActivity.class);
                    startActivity(i);


                } catch (IOException e) {
                    Log.d("Patients", e.getMessage());
                }

            }
        });

    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_patients, container, false);
}
    public void createTemporaryFile(View view) {
            Context mContext;
            mContext = getActivity();
        try {
            String fileName = "couponstemp";
            String coupons = "Get upto 50% off shoes @ xyx shop \n Get upto 80% off on shirts @ yuu shop";

            File file = File.createTempFile(fileName, null, mContext.getCacheDir());

            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(coupons.getBytes());
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
        }
    }
}
