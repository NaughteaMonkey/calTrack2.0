package com.example.caltrac20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class goal extends AppCompatActivity {

    private CheckBox checkwaterBox, checkstepBox, checkcalorieBox, checkworkoutBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal);

        Intent intent = getIntent();

       checkwaterBox = findViewById(R.id.waterbox);

        checkstepBox = findViewById(R.id.stepbox);

        checkcalorieBox = findViewById(R.id.caloriebox);
        checkworkoutBox = findViewById(R.id.workoutbox);




    }
    }
