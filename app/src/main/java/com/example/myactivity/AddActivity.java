package com.example.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    TextView titlepage, addtitle, addDesc, addDate;
    EditText editNewActivity, editDesc, editDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        titlepage = findViewById(R.id.Apptitle);
        addtitle = findViewById(R.id.addTitle);
        addDesc = findViewById(R.id.addDescription);
        addDate = findViewById(R.id.addDate);
        editNewActivity = findViewById(R.id.titleNewActivity);
        editDesc = findViewById(R.id.titleAddDescription);
        editDate = findViewById(R.id.titleAddDate);


    }
}
