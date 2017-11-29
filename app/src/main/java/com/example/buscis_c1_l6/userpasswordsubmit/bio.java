package com.example.buscis_c1_l6.userpasswordsubmit;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class bio extends AppCompatActivity {


    private ImageView imageView2;
    private TextView bioView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bio);

        imageView2 = (ImageView) findViewById(R.id.imageView2);
        bioView = (TextView) findViewById(R.id.bioView);
    }


}
