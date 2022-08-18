package com.example.caltrac20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BMR extends AppCompatActivity {
    private Button bmr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bmr = findViewById(R.id.bmr_button);

        bmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BMR.this,bmr_activity.class);

                startActivity(intent);
            }
        });
    }
}
