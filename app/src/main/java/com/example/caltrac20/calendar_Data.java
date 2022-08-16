package com.example.caltrac20;

import static com.example.caltrac20.calendar.clickedDate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class calendar_Data extends AppCompatActivity{

    TextView selectedDate; // View for selected date
    EditText usrData;
    String data; // where usrData would be stored

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_data);

        selectedDate = (TextView)findViewById(R.id.date);
        selectedDate.setText(clickedDate);

    }
    public void updateButton(View view) // updates data
    {
        usrData = (EditText)findViewById(R.id.data);
        data = usrData.getText().toString();
        Log.d("Data", data);
    }
    public void cancelButton(View view) // does not update data
    {
        usrData = (EditText)findViewById(R.id.data);
        usrData.setText("Enter Data");
        Log.d("Data", data);
    }
}