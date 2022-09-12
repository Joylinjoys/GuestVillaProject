package com.example.guestvillaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class adminLogin extends AppCompatActivity {

    EditText name,userEmail,userPassword;
    Button register;

    private FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        mAuth = FirebaseAuth.getInstance();

        register = findViewById(R.id.btnRegister);

        userEmail = findViewById(R.id.inputEmail);
        userPassword = findViewById(R.id.inputPassword);

        TextView btn=findViewById(R.id.alreadyHaveAccount);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(userEmail.getText().toString(), userPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                FirebaseUser user = null;
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(adminLogin.this, "Registeration Sucessfull", Toast.LENGTH_LONG).show();
                                    user = mAuth.getCurrentUser();
//
                                    Intent intent = new Intent(adminLogin.this, userPage.class);
                                    startActivity(intent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(adminLogin.this, "Authentication failed.", Toast.LENGTH_LONG).show();
//                                        updateUI(user);
                                }
                            }
                        });
            }
        });
    }
}