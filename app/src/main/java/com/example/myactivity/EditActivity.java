package com.example.myactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

        reference = FirebaseDatabase.getInstance().getReference().child("MyActivityApp")
                .child("Activity" + keykeyActivity);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("titleActivity").setValue(editNewActivity.getText().toString());
                        dataSnapshot.getRef().child("descActivity").setValue(editDesc.getText().toString());
                        dataSnapshot.getRef().child("dateActivity").setValue(editDate.getText().toString());

                        Intent a = new Intent(EditActivity.this, MainActivity.class);
                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent a =  new Intent(EditActivity.this, MainActivity.class);
                            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(a);
                        }
                        else{
                            Toast.makeText(EditActivity.this,"Unable to delete",Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });


    }
}
