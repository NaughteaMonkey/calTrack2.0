package com.example.caltrac20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Daily_goals extends AppCompatActivity {

    private Button daily_goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daily_goal = findViewById(R.id.goals_button);

        daily_goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Daily_goals.this,goal.class);

                startActivity(intent);
            }
        });
    }

}
