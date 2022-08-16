package com.example.caltrac20;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

//TEST
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.*;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText logEmail;
    TextInputEditText logPassword;
    TextView tvRegister;
    Button btnLogin;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logEmail = findViewById(R.id.logEmail);
        logPassword = findViewById(R.id.logPassword);
        tvRegister = findViewById(R.id.tvRegister);
        btnLogin = findViewById(R.id.btnLogin);

        auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view ->{
            loginUser();
        });
        tvRegister.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

    }

    //TEST for database button... edited activity_login.xml
    // added android:onClick="dbButton" to button android:id="@+id/dbButton"
    public void dbButton(View view)
    {
        Log.d("INSIDE","Inside DB");
        getDocument();
    }

    private void loginUser(){
        String email = logEmail.getText().toString();
        String password = logPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            logEmail.setError("Missing email");
            logEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            logPassword.setError("Missing password");
            logPassword.requestFocus();
        }else{
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this, "Login Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    //TEST
    // DocumentReference docRef = db.collection("test").document("testDB");
    public void getDocument() {
        // [START get_document]
        auth = FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
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
