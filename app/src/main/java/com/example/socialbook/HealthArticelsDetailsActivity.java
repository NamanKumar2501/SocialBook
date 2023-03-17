package com.example.socialbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticelsDetailsActivity extends AppCompatActivity {

    TextView tv1;
    ImageView img;

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articels_details);

        btnBack = findViewById(R.id.buttonHABack);
        tv1 = findViewById(R.id.textViewHA);
        img = findViewById(R.id.imageView);

        Intent intent = getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            int resId = bundle.getInt("text2");
            img.setImageResource(resId);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticelsDetailsActivity.this,HealthArticalsActivity.class));
            }
        });
    }
}