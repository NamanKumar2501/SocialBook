package com.example.socialbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    TextView tv1 ,tv2, tv3, tv4, tv;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    private Button dateButton , timeButton, btnBook, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        tv1 = findViewById(R.id.edittextBMBFullName);
        tv2 = findViewById(R.id.edittextBMBAddress);
        tv3 = findViewById(R.id.edittextBMBPincode);
        tv4 = findViewById(R.id.edittextBMBContactNumber);
        tv = findViewById(R.id.textViewAppTitle);
        btnBook = findViewById(R.id.buttonBookAppoinment2);
        btnBack = findViewById(R.id.buttonAppBack);
        dateButton = findViewById(R.id.buttonBMCartDate);
        timeButton = findViewById(R.id.buttonCartTimePicker);



        // back button

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookAppointmentActivity.this, FindDoctorActivity.class));
            }
        });

        // ---------------


        tv1.setOnKeyListener(null);
        tv2.setOnKeyListener(null);
        tv3.setOnKeyListener(null);
        tv4.setOnKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");

        tv.setText(title);
        tv1.setText(fullname);
        tv2.setText(address);
        tv3.setText(contact);
        tv4.setText("Cons Fees:"+fees+"/-");


        // call DatePicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        // call TimePicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        // ---------- Button Book Appointment --------------

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db  = new Database(getApplicationContext(),"socialbook",null,1);
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();

                if (db.checkAppointmentExists(username,title+" => "+fullname,address,contact,dateButton.getText().toString(),timeButton.getText().toString())==1){
                    Toast.makeText(BookAppointmentActivity.this, "Appointment already booked", Toast.LENGTH_SHORT).show();
                }else {
                    db.addOrder(username,title+" => "+fullname,address,contact,0,dateButton.getText().toString(),timeButton.getText().toString(),Float.parseFloat(fees),"appointment");
                    Toast.makeText(BookAppointmentActivity.this, "Your Appointment is done successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BookAppointmentActivity.this,HomeActivity.class));
                }

            }
            
        });

        // --------------------------------------------

    }

    // Date Picker
    private  void  initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                 dateButton.setText(dayOfMonth+"/"+month+"/"+year);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);


    }

    // Time Picker

    private  void  initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                  timeButton.setText(hourOfDay+":"+minute);
            }
        };

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);

    }

}