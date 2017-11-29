package com.example.buscis_c1_l6.userpasswordsubmit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;


public class ThirdPage extends AppCompatActivity {
    private RatingBar ratingBar;
    private TextView txtRatingValue;
    private Button btnSubmit;
    private Button appButton;
    private Button thankYouButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_page);

        appButton       = (Button) findViewById(R.id.appButton);
        thankYouButton  = (Button) findViewById(R.id.thankYouButton);

                addListenerOnRatingBar();
        addListenerOnButton();

        appButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                    Intent i;
                    i = new Intent(ThirdPage.this, bio.class);
                    startActivity(i);

            }


        });

        thankYouButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent i;
                i = new Intent(ThirdPage.this, bio.class);
                startActivity(i);

            }


        });


    }

    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                txtRatingValue.setText(String.valueOf(rating));

            }
        });
    }

    public void addListenerOnButton() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //if click on me, then display the current rating value.
        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(ThirdPage.this,
                        String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();

            }

        });

    }
}