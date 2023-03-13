package com.example.socialbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Uprise-03 1000IU Capsule", "", "", "", "50" },
                    {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},
                    {"Vitamin B Complex Capsule", "", "", "", "488"},
                    {"Inlife Vitamin E Wheat Ggrem Oil Capsule", "", "", "", "536"},
                    {"Dolo 650 Tablet", "", "", "", "50"},
                    {"Crocin 650 Advance Tablate", "", "", "", "505"},
                    {"Strepsile Medicated Lozenges for Sore Throat", "", "", "", "405"},
                    {"Tata 1mg Calcium + Vitamin D3", "", "", "", "40"},
                    {"Fronia -XT Tablet", "", "", "", "150"},
            };

    private String[] package_detail = {
            "Bulding and keeping the bones & teeth strong\n" +
                    "Reducing Fatigue/stress and musculer pains\n" +
                    "Boosting immunity and increasing resistance against infection",
            "Chromium is an essential trace mineral that plays an important role in helping insulin regulated",
            "Provides relief from vitamin B deficiencies\n" +
                    "Helps in formation of red bood cells\n" +
                    "Maintains healthy nervous system",
            "It promotes health as well as skin benefit.\n" +
                    "It helps reduce skin blemish and pigmentation.\n" +
                    "It act as safeguard the skin from the harsh UVS and UVB sun rays.",
            "Dolo 650 Tablet helps relieve pain and fever by blocking the release of certain chemical ",
            "Helps relive fever and bring down a high temperature\n" +
                    "Suitable for people with a heart Condition or high blood pressure",
            "Relieves the symptoms of a bacterial throat infection and soothes the recovery process\n" +
                    "Provide a warm and comforting feeling during sere throat",
            "Reduce the risk of calcium deficiency, Rickets, and Osteoporosis\n" +
                    "Promotes mobility and flexibility of joints",
            "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
    }
}