package com.example.caltrac20;

import static android.content.ContentValues.TAG;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.*;

public class DB_Test extends AppCompatActivity{
    FirebaseFirestore db = FirebaseFirestore.getInstance();
   // DocumentReference docRef = db.collection("test").document("testDB");

    public void getDocument() {
        // [START get_document]
        DocumentReference docRef = db.collection("test").document("testDB");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        //System.out.println("DocumentSnapshot data: " + document.getData());
                        Log.d("BRYN", "DocumentSnapshot data: " + document.getData());
                    } else {
                        //System.out.println("No such document");
                        Log.d("BRYN", "No such document");
                    }
                } else {
                    //System.out.println("get failed with " + task.getException());
                    Log.d("BRYN", "get failed with ", task.getException());
                }

            }
        });
    }
}
