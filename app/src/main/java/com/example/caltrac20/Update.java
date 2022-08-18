package com.example.caltrac20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {

    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        update = findViewById(R.id.update_button);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Update.this,update_activity.class);

                startActivity(intent);
            }
        });
    }

    }
