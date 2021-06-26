package com.example.android.videocallingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    FirebaseAuth auth;
    EditText emailBox, passwordBox,nameBox;
    Button loginBtn, signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();  //it create an instance with firebase and user create an new account this
        emailBox = findViewById(R.id.emailBox);
        nameBox = findViewById(R.id.nameBox);
        passwordBox = findViewById(R.id.passwordBox);

        loginBtn = findViewById(R.id.logintbtn);
        signupBtn = findViewById(R.id.createbtn);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email ,name  ,pass ;
                email = emailBox.getText().toString();
                name = nameBox.getText().toString();
                pass = passwordBox.getText().toString();

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            // success
                            Toast.makeText(SignupActivity.this,"Account is Created",Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(SignupActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
    }
}