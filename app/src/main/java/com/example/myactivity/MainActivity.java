package com.example.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView appTitle, finishTasks, nomoreTasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        appTitle = findViewById(R.id.Apptitle);
        finishTasks = findViewById(R.id.finishTasks);
        nomoreTasks = findViewById(R.id.nomoretasks);


    }
}
