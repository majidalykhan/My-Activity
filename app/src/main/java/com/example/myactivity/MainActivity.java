package com.example.myactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView appTitle, finishTasks, nomoreTasks;

    DatabaseReference reference;
    RecyclerView ourActivities;
    ArrayList<MyActivity> list;
    ActivityAdapter activityAdapter;

    ImageButton newActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        appTitle = findViewById(R.id.Apptitle);
        finishTasks = findViewById(R.id.finishTasks);
        nomoreTasks = findViewById(R.id.nomoretasks);
        newActivity = findViewById(R.id.addBtn);


        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a =  new Intent(MainActivity.this, AddActivity.class);
                startActivity(a);
            }
        });


        //Work with Data
        ourActivities = findViewById(R.id.ourActvities);
        ourActivities.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MyActivity>();

        //Fetch data from firebase
        reference = FirebaseDatabase.getInstance().getReference().child("MyActivityApp");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //To fetch data and replace layout
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    MyActivity p = dataSnapshot1.getValue(MyActivity.class);
                    list.add(p);
                }
                activityAdapter = new ActivityAdapter(MainActivity.this, list);
                ourActivities.setAdapter(activityAdapter);
                activityAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //To show error
                Toast.makeText(MainActivity.this,"No Data",Toast.LENGTH_LONG).show();

            }
        });


    }
}
