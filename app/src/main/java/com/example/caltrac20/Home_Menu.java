package com.example.caltrac20;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public abstract class Home_Menu extends AppCompatActivity {

    Button b;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_menu);

       // b() = (Button) findViewById(R.id.btnLogin);

        b.setOnClickListener((v) -> { startActivity(new Intent(Home_Menu.this,MainActivity.class));});



    }




}
