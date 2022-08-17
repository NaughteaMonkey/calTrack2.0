package com.example.caltrac20;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class calendar extends AppCompatActivity {
    // String to display date when clicked
    public static String clickedDate;
    public static String dd, mm,yy;
    // Define the variable of CalendarView type
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendar = (CalendarView)
                findViewById(R.id.calendar);

        // Add Listener in calendar
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            // In this Listener have one method
            // and in this method we will
            // get the value of DAYS, MONTH, YEARS
            public void onSelectedDayChange(
                    @NonNull CalendarView view,
                    int year,
                    int month,
                    int dayOfMonth)
            {
                // formatting ints into strings
                dd = "" + dayOfMonth;
                mm = "" + month;
                yy = "" + year;

                setMonth(month+1); // Add 1 in month because month index is 0
                clickedDate
                        = mm + " "
                        + dd + " "
                        + yy;
                Log.d("MM-DD-YYYY", clickedDate);
                startActivity(new Intent(calendar.this, calendar_Data.class));
            }

        });
    }

    public void setMonth(int month)
    {
        switch (month)
        {
            case 1:
                mm = "January";
                break;
            case 2:
                mm = "February";
                break;
            case 3:
                mm = "March";
                break;
            case 4:
                mm = "April";
                break;
            case 5:
                mm = "May";
                break;
            case 6:
                mm = "June";
                break;
            case 7:
                mm = "July";
                break;
            case 8:
                mm = "August";
                break;
            case 9:
                mm = "September";
                break;
            case 10:
                mm = "October";
                break;
            case 11:
                mm = "November";
                break;
            case 12:
                mm = "December";
                break;
            default:
                mm = "ERROR";
                break;
        }

    }

}