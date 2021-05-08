package com.forbitbd.postdatatofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    Button btnsave, btnpost;
    EditText etname,etroll, etcourse, etduration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.name);
        etcourse = findViewById(R.id.course);
        etroll = findViewById(R.id.roll);
        etduration = findViewById(R.id.duration);
        btnsave = findViewById(R.id.save);
        btnpost = findViewById(R.id.post);
        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etname.getText().toString();
                String roll = etroll.getText().toString();
                String course = etcourse.getText().toString();
                String duration = etduration.getText().toString();

                Student student = new Student(name,course,duration);

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference root = db.getReference("students");
                root.child(roll).setValue(student);

                Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}