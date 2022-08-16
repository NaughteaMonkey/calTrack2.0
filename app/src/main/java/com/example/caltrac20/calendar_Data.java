package com.example.caltrac20;

import static com.example.caltrac20.calendar.clickedDate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class calendar_Data extends AppCompatActivity{

    TextView selectedDate; // View for selected date
    EditText usrData;
    String data = "Enter Data"; // where usrData would be stored
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_data);

        selectedDate = (TextView)findViewById(R.id.date);
        selectedDate.setText(clickedDate);
        getDocument();

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
        usrData.setText(data);
        Log.d("Data", data);
    }

    //TEST
    // DocumentReference docRef = db.collection("test").document("testDB");
    public void getDocument() {
        // [START get_document]
        auth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("userID").document("userCal");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        //System.out.println("DocumentSnapshot data: " + document.getData());
                        Log.d("userID", "DocumentSnapshot data: " + document.getData());
                    } else {
                        //System.out.println("No such document");
                        Log.d("userID", "No such document");
                    }
                } else {
                    //System.out.println("get failed with " + task.getException());
                    Log.d("userID", "get failed with ", task.getException());
                }

            }
        });
    }

    public void updateData()
    {
        
    }
}