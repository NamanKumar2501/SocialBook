package com.example.socialbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Naman Kumar", "Hospital Address : Noorpur", "Exp : 5yrs", "Mobile No : 9789869786", "600" },
                    {"Doctor Name : Prashant Kumar", "Hospital Address : Moradabad", "Exp : 2yrs", "Mobile No : 6789834786", "500" },
                    {"Doctor Name : Sumit Sharma", "Hospital Address : Bijnor", "Exp : 1yrs", "Mobile No : 4567869786", "60" },
                    {"Doctor Name : Vinit yadav", "Hospital Address : Noorpur", "Exp : 1yrs", "Mobile No : 9567853486", "50" },
                    {"Doctor Name : Gourav Thakur", "Hospital Address : Delhi", "Exp : 4yrs", "Mobile No : 6789854786", "200" }

            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Naman Kumar", "Hospital Address : Noorpur", "Exp : 5yrs", "Mobile No : 9789869786", "600" },
                    {"Doctor Name : Prashant Kumar", "Hospital Address : Moradabad", "Exp : 2yrs", "Mobile No : 6789834786", "500" },
                    {"Doctor Name : Naman Vanshiwal", "Hospital Address : Bijnor", "Exp : 1yrs", "Mobile No : 4567869786", "60" },
                    {"Doctor Name : Vinit yadav", "Hospital Address : Noorpur", "Exp : 1yrs", "Mobile No : 9567853486", "50" },
                    {"Doctor Name : Kavya singh", "Hospital Address : Delhi", "Exp : 4yrs", "Mobile No : 6789854786", "200" }

            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Kavya singh", "Hospital Address : Noorpur", "Exp : 5yrs", "Mobile No : 9789869786", "600" },
                    {"Doctor Name : Naman Vanshiwal", "Hospital Address : Moradabad", "Exp : 2yrs", "Mobile No : 6789834786", "500" },
                    {"Doctor Name : Komal Yadav", "Hospital Address : Bijnor", "Exp : 1yrs", "Mobile No : 4567869786", "60" },
                    {"Doctor Name : Vinit yadav", "Hospital Address : Noorpur", "Exp : 1yrs", "Mobile No : 9567853486", "50" },
                    {"Doctor Name : Gourav Thakur", "Hospital Address : Delhi", "Exp : 4yrs", "Mobile No : 6789854786", "200" }

            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Kavya singh", "Hospital Address : Noorpur", "Exp : 5yrs", "Mobile No : 9789869786", "600" },
                    {"Doctor Name : Prashant Kumar", "Hospital Address : Moradabad", "Exp : 2yrs", "Mobile No : 6789834786", "500" },
                    {"Doctor Name : Sumit Sharma", "Hospital Address : Bijnor", "Exp : 1yrs", "Mobile No : 4567869786", "60" },
                    {"Doctor Name : Vinit yadav", "Hospital Address : Noorpur", "Exp : 1yrs", "Mobile No : 9567853486", "50" },
                    {"Doctor Name : Naman Vanshiwal", "Hospital Address : Delhi", "Exp : 4yrs", "Mobile No : 6789854786", "200" }

            };

    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Vipul Kumar", "Hospital Address : Noorpur", "Exp : 5yrs", "Mobile No : 9789869786", "600" },
                    {"Doctor Name : kanchana Kumar", "Hospital Address : Moradabad", "Exp : 2yrs", "Mobile No : 6789834786", "500" },
                    {"Doctor Name : Preveen Sharma", "Hospital Address : Bijnor", "Exp : 1yrs", "Mobile No : 4567869786", "60" },
                    {"Doctor Name : Nidhi yadav", "Hospital Address : Noorpur", "Exp : 1yrs", "Mobile No : 9567853486", "50" },
                    {"Doctor Name : Kajal Thakur", "Hospital Address : Delhi", "Exp : 4yrs", "Mobile No : 6789854786", "200" }

            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;

    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        btn = findViewById(R.id.buttonDDBack);

        tv = findViewById(R.id.textViewDDTitle);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

            // First Doctor Details
        if(title.compareTo("Family Physicians") == 0){
            doctor_details = doctor_details1;
        }
        else

            // Second Doctor Details
        if(title.compareTo("Dietician") == 0){
            doctor_details = doctor_details2;
        }
        else

            // Third Doctor Details
        if(title.compareTo("Dentist") == 0){
            doctor_details = doctor_details3;
        }
        else

            // Fourth Doctor Details
        if(title.compareTo("Surgeon") == 0){
            doctor_details = doctor_details4;
        }
        // Fifth Doctor Details
        else
            doctor_details = doctor_details5;



            // Back Button
            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

            list = new ArrayList();
            for (int i = 0; i<doctor_details.length; i++){
                item = new HashMap<String, String>();
                item.put( "line1", doctor_details[i][0]);
                item.put( "line2", doctor_details[i][1]);
                item.put( "line3", doctor_details[i][2]);
                item.put( "line4", doctor_details[i][3]);
                item.put( "line5", "Cons Fees:"+doctor_details[i][4]+"/-");
                list.add( item );
            }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","linw2","linw3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
    }
}