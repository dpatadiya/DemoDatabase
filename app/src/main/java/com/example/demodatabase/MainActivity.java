package com.example.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText edtname, edtsurname;
    Button edtmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        edtname = findViewById(R.id.edtname);
        edtsurname = findViewById(R.id.edtsurname);
        edtmark = findViewById(R.id.btn);

    }

    public void saverecord(View view) {

        String valname, valsurname, valmark;

        valname = edtname.getText().toString();
        valsurname = edtsurname.getText().toString();
        valmark = edtmark.getText().toString();
        // Add Validation
        // Database Operation
       if(databaseHelper.insertdata(valname, valsurname, valmark)){
           Toast.makeText(this,"Data Insert Sucessfully",Toast.LENGTH_SHORT).show();
       }
    }

}