package com.john.mrclean;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity  {

    View night, day;
    EditText f_Name, u_Name, email, p_Number, password;
    FirebaseAuth mAuth;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        night = findViewById(R.id.night_view);
        day = findViewById(R.id.day_view);
        f_Name = findViewById(R.id.signUp_FullName);
        u_Name = findViewById(R.id.signUp_UserName);
        email = findViewById(R.id.signUp_Email);
        p_Number = findViewById(R.id.signUp_PhoneNumber);
        password = findViewById(R.id.signUp_Password);
        signUp = findViewById(R.id.signUp_SignUp);


        mAuth = FirebaseAuth.getInstance();
    }

    public void sign_up(View v) {
        String signUp_FullName = f_Name.getText().toString().trim();
        String signUp_UserName = u_Name.getText().toString().trim();
        String signUp_Email = email.getText().toString().trim();
        String signUp_PhoneNumber = p_Number.getText().toString().trim();
        String signUp_Password = password.getText().toString().trim();

        if(signUp_FullName.isEmpty()) {
            f_Name.setError("Full name is required!");
            f_Name.requestFocus();
            return;
        }
        if(signUp_UserName.isEmpty()) {
            u_Name.setError("User name is required!");
            u_Name.requestFocus();
            return;
        }
        if(signUp_Email.isEmpty()) {
            email.setError("Email is required!");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(signUp_Email).matches()) {
            email.setError("Please provide valid email!");
            email.requestFocus();
            return;
        }
        if(signUp_PhoneNumber.isEmpty()) {
            p_Number.setError("Contact Number required!");
            p_Number.requestFocus();
            return;
        }
        if(signUp_Password.isEmpty()) {
            password.setError("Password is required!");
            password.requestFocus();
            return;
        }
        if(signUp_Password.length() < 6) {
            password.setError("6 is the minimum length of characters!");
            password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(signUp_Email, signUp_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()) {
                    Client client = new Client(signUp_FullName, signUp_UserName, signUp_Email, signUp_Password, signUp_PhoneNumber);

                    FirebaseDatabase.getInstance().getReference("Clients").child(FirebaseAuth.getInstance()
                            .getCurrentUser().getUid()).setValue(client).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()) {
                                startActivity(new Intent(SignUp.this, SignIn.class));
                                Toast.makeText(SignUp.this, "Client has been registered successfully!", Toast.LENGTH_LONG).show();
                                signUp.setVisibility(View.VISIBLE);
                            }else {
                                Toast.makeText(SignUp.this, "Try again, your not register!", Toast.LENGTH_LONG).show();
                                signUp.setVisibility(View.GONE);
                            }
                        }
                    });
                }else {
                    Toast.makeText(SignUp.this, "Its Failed!", Toast.LENGTH_LONG).show();
                    signUp.setVisibility(View.GONE);
                }
            }
        });
    }
}