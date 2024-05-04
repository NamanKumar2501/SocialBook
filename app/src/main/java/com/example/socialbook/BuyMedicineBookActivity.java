package com.example.socialbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicineBookActivity extends AppCompatActivity {

    EditText etname,etaddress,etcontact,etpincode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        etname = findViewById(R.id.edittextBMBFullName);
        etaddress = findViewById(R.id.edittextBMBAddress);
        etpincode = findViewById(R.id.edittextBMBPincode);
        etcontact = findViewById(R.id.edittextBMBContactNumber);
        btnBooking = findViewById(R.id.ButtonLTBBooking);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String data = intent.getStringExtra("date");
        // String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();

                Database db = new Database(getApplicationContext(),"socialbook",null,1);
                db.addOrder(username,etname.getText().toString(),
                        etaddress.getText().toString(),
                        etcontact.getText().toString(),
                        Integer.parseInt(etpincode.getText().toString()),
                        data.toString(),"",Float.parseFloat(price[1].toString()),"medicine");

                db.removeCart(username,"medicine");
                Toast.makeText(BuyMedicineBookActivity.this, "Your Booking is done Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BuyMedicineBookActivity.this,HomeActivity.class));
            }
        });

    }
}