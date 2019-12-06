package com.example.myactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class AddActivity extends AppCompatActivity {

    TextView titlepage, addtitle, addDesc, addDate;
    EditText editNewActivity, editDesc, editDate;
    ImageButton create, cancel;
    DatabaseReference reference;
    Integer activityNum = new Random().nextInt();
    String keyActivity = Integer.toString(activityNum);

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
        create = findViewById(R.id.createBtn);
        cancel = findViewById(R.id.cancelBtn);


        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel(){
                String myFormat = "dd-MM-yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                editDate.setText(sdf.format(myCalendar.getTime()));
            }
        };

        editDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert to database
                reference = FirebaseDatabase.getInstance().getReference().child("MyActivityApp")
                        .child("Activity" + activityNum);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("titleActivity").setValue(editNewActivity.getText().toString());
                        dataSnapshot.getRef().child("descActivity").setValue(editDesc.getText().toString());
                        dataSnapshot.getRef().child("dateActivity").setValue(editDate.getText().toString());
                        dataSnapshot.getRef().child("keyActivity").setValue(keyActivity);

                        Intent a = new Intent(AddActivity.this, MainActivity.class);
                        startActivity(a);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
