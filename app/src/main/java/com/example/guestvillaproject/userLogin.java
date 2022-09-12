package com.example.guestvillaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class userLogin extends AppCompatActivity {
    EditText uname, password;
    Button Login;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        uname = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Login = findViewById(R.id.loginbtn);

        mAuth = FirebaseAuth.getInstance();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(uname.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful() ) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(userLogin.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                } else {


                                    Toast.makeText(userLogin.this, "Logined in", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(userLogin.this, userPage.class);
                                    startActivity(intent);
                                    FirebaseUser user = mAuth.getCurrentUser();
                                }
                            }
                        });


            }
        });
    }
}