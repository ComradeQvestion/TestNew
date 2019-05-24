package com.example.testnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProjectActivity extends AppCompatActivity {
    DatabaseHelperProjects db;
    EditText mTextTitle;
    EditText mTextDescription;
    EditText mTextLookingFor;
    Button mButtonCreate;
    Button mButtonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        db = new DatabaseHelperProjects(this);
        mTextTitle = (EditText)findViewById(R.id.edittext_title);
        mTextDescription = (EditText)findViewById(R.id.edittext_description);
        mTextLookingFor = (EditText)findViewById(R.id.edittext_lookingfor);
        mButtonCreate = (Button)findViewById(R.id.button_create);
        mButtonCancel = (Button) findViewById(R.id.button_cancel);

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent homeIntent = new Intent(ProjectActivity.this,HomeActivity.class);
                startActivity(homeIntent);
            }
        });

        mButtonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mTextTitle.getText().toString().trim();
                String description = mTextDescription.getText().toString().trim();
                String lookingfor = mTextLookingFor.getText().toString().trim();


                Intent homeIntent = new Intent(ProjectActivity.this,HomeActivity.class);
                startActivity(homeIntent);



            }
        });
    }
}