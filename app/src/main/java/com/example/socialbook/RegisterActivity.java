package com.example.socialbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUserName ,edEmail , edPassword, edConfirmPassword;
    TextView textView;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUserName = findViewById(R.id.edittextLTBFullName);
        edEmail = findViewById(R.id.edittextLTBAddress);
        edPassword = findViewById(R.id.edittextLTBPincode);
        edConfirmPassword = findViewById(R.id.edittextLTBContactNumber);

        textView = findViewById(R.id.tvAlredyRegister);
        btn = findViewById(R.id.ButtonLTBBooking);


        //   ---------------------------------------------------------

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        // ------------------------------------------------------------


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUserName.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String confirm = edConfirmPassword.getText().toString();

                Database db = new Database(getApplicationContext(), "SocialBook", null, 1);

                if (username.length() == 0 || email.length() == 0 || password.length()==0  || confirm.length() == 0){
                    Toast.makeText(RegisterActivity.this, "Please Fill All Details ", Toast.LENGTH_SHORT).show();
                }else{
                    if (password.compareTo(confirm) == 0){
                        if (password.length()<6){
                            Toast.makeText(RegisterActivity.this, "Password must contain at least 8 characters :", Toast.LENGTH_SHORT).show();
                        }else{

                            db.register(username,email,password);

                            Toast.makeText(RegisterActivity.this, "Register Successful :", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Password and ConfirmPassword didn't  match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

//    public  static boolean isValid(String passwordhere){
//        int f1 = 0, f2 = 0, f3 = 0;
//        if(passwordhere.length() < 8){
//            return false;
//        }else {
//            for (int p =0; p < passwordhere.length(); p++){
//                if (Character.isLetter(passwordhere.charAt(p))){
//                    f1 = 1;
//                }
//            }
//
//            for (int r =0; r < passwordhere.length(); r++){
//                if (Character.isDigit(passwordhere.charAt(r))){
//                    f2 = 1;
//                }
//            }
//
//            for (int s =0; s < passwordhere.length(); s++){
//                char c = passwordhere.charAt(s);
//                    if (c >= 33 && c <= 46 && c == 64){
//                    f3 = 1;
//                }
//            }
//
//            if(f1 == 1 && f2 == 1 && f3 == 1)
//                return true;
//
//            return false;
//
//        }
//    }

}