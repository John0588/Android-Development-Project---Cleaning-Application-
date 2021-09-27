package com.john.mrclean;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignIn extends AppCompatActivity {

    EditText email, password;
    Button logIn;
    FirebaseAuth mAuth;
    Switch switchMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.signIn_Email);
        password = findViewById(R.id.signIn_Password);
        logIn = findViewById(R.id.notification_Button);
        switchMode = findViewById(R.id.day_night_switch);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();


    }
    public void log_in(View v) {

        String signIn_Email = email.getText().toString().trim();
        String signIn_Password = password.getText().toString().trim();

        if(signIn_Email.isEmpty()) {
            email.setError("Email is required!");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(signIn_Email).matches()) {
            email.setError("Please provide valid email!");
            email.requestFocus();
            return;
        }
        if(signIn_Password.isEmpty()) {
            password.setError("Password is required!");
            password.requestFocus();
            return;
        }
        if(signIn_Password.length() < 6) {
            password.setError("6 is the minimum length of characters!");
            password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(signIn_Email, signIn_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()) {
                    FirebaseUser client = FirebaseAuth.getInstance().getCurrentUser();

                    if (client.isEmailVerified()) {
                        startActivity(new Intent(SignIn.this, Home.class));
                    } else {
                        client.sendEmailVerification();
                        Toast.makeText(SignIn.this, "Please check your email to verify your account!", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(SignIn.this, "Failed to LogIn! Please check your credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void create_account(View v) {
        Intent next_to_createAccount = new Intent(this,SignUp.class);
        startActivity(next_to_createAccount);
    }

    public void edit_password(View v) {
        Intent next_to_resetPassword = new Intent(this, Reset_Password.class);
        startActivity(next_to_resetPassword);
    }
}