package com.example.caltrac20;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class workout_activty extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_activity);

        Intent intent = getIntent();
    }
}
