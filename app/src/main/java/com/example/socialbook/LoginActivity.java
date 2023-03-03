package com.example.socialbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edUserName , edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName = findViewById(R.id.editTextLoginUserName);
        edPassword = findViewById(R.id.editTextTextPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                /*

                String username = edUserName.getText().toString();
                String password = edPassword.getText().toString();

                Database db = new Database(getApplicationContext(), "SocialBook", null, 1);

                if(username.length() == 0 || password.length()==0){
                    Toast.makeText(LoginActivity.this, "Please fill all Details", Toast.LENGTH_SHORT).show();
                }else {
                   if (db.login(username, password) == 1){
                       Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                       // SharedPreferences
                       SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                       SharedPreferences.Editor editor  =sharedPreferences.edit();
                       editor.putString("username", username);
                       // to save out data with key and value.
                       editor.apply();

                       startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                   }else {
                       Toast.makeText(LoginActivity.this, "Invalid UserName and Password", Toast.LENGTH_SHORT).show();
                   }
                }

                */

            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}