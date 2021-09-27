package com.john.mrclean;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class Reset_Password extends AppCompatActivity {

    EditText resetPassword;
    Button resetButton;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset__password);

        resetPassword = findViewById(R.id.reset_PasswordEmail);
        resetButton = findViewById(R.id.button_ResetPassword);

        auth = FirebaseAuth.getInstance();
    }
    public void reset_button (View v) {

        String reset_PasswordEmail = resetPassword.getText().toString().trim();

        if(reset_PasswordEmail.isEmpty()) {
            resetPassword.setError("Email is required!");
            resetPassword.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(reset_PasswordEmail).matches()) {
            resetPassword.setError("Please provide valid email!");
            resetPassword.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(reset_PasswordEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void>task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Reset_Password.this, "Check your email and reset your password!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Reset_Password.this, "Something wrong, please double check!", Toast.LENGTH_LONG).show();
                }
             }
        });
    }
}