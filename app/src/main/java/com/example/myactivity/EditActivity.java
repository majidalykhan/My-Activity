package com.example.myactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditActivity extends AppCompatActivity {

    TextView titlepage, addtitle, addDesc, addDate;
    EditText editNewActivity, editDesc, editDate;
    ImageButton save, delete;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        titlepage = findViewById(R.id.Apptitle);
        addtitle = findViewById(R.id.addTitle);
        addDesc = findViewById(R.id.addDescription);
        addDate = findViewById(R.id.addDate);
        editNewActivity = findViewById(R.id.titleNewActivity);
        editDesc = findViewById(R.id.titleAddDescription);
        editDate = findViewById(R.id.titleAddDate);
        save = findViewById(R.id.saveBtn);
        delete = findViewById(R.id.deleteBtn);


        //Get values of previous activity
        editNewActivity.setText(getIntent().getStringExtra("titleActivity"));
        editDesc.setText(getIntent().getStringExtra("descActivity"));
        editDate.setText(getIntent().getStringExtra("dateActivity"));

        final String keykeyActivity = getIntent().getStringExtra("keyActivity");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference().child("MyActivityApp")
                        .child("Activity" + keykeyActivity);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("titleActivity").setValue(editNewActivity.getText().toString());
                        dataSnapshot.getRef().child("descActivity").setValue(editDesc.getText().toString());
                        dataSnapshot.getRef().child("dateActivity").setValue(editDate.getText().toString());
                        dataSnapshot.getRef().child("keyActivity").setValue(keykeyActivity);

                        Intent a = new Intent(EditActivity.this, MainActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });
    }
}
