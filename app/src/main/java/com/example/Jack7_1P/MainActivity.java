package com.example.Jack7_1P;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button showButton, createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButton = findViewById(R.id.createButton);
        showButton = findViewById(R.id.showButton);

        Intent ShowAdverts = new Intent(this, ShowAdvert.class);
        Intent CreateAdverts= new Intent(this, CreateAdvert.class);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(CreateAdverts);
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ShowAdverts);
            }
        });
    }
}