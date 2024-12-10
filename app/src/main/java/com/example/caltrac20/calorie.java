package com.example.caltrac20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class calorie extends AppCompatActivity {

    private Button cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = findViewById(R.id.intake_button);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(calorie.this,calorie_activity.class);

                startActivity(intent);
            }
        });
    }
}

