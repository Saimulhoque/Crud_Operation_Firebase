package com.forbitbd.postdatatofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditActivity extends AppCompatActivity {

    Button btnupdate;
    EditText etname, etroll, etcourse, etduration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

//        databaseReference = FirebaseDatabase.getInstance().getReference("students");
//        etname = findViewById(R.id.name);
//        etcourse = findViewById(R.id.course);
//        etduration = findViewById(R.id.duration);
//        btnupdate = findViewById(R.id.update);
//
//        etname.setText(getIntent().getStringExtra("name"));
//        etcourse.setText(getIntent().getStringExtra("course"));
//        etduration.setText(getIntent().getStringExtra("duration"));
    }
}