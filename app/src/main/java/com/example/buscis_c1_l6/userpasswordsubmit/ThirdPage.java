package com.example.buscis_c1_l6.userpasswordsubmit;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.provider.MediaStore;
import android.widget.Toast;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ThirdPage extends AppCompatActivity {
    private RatingBar ratingBar;
    private TextView bioView;
    private Button btnSubmit;
    private Button thankYouButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_page);

        bioView = (TextView) findViewById(R.id.bioView);
        thankYouButton  = (Button) findViewById(R.id.thankYouButton);

        addListenerOnRatingBar();
        addListenerOnButton();

        //String mailto = "mailto:abmukarram@gmail.com" + "&subject=" + Uri.encode("Hello") + "&body =" + Uri.encode("Are you there");


        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);


        emailIntent.setData(Uri.parse("mailto:"));
        String [] to = {"cmata@gmail.com"};
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT," Sent from my app!");
        emailIntent.putExtra(Intent.EXTRA_TEXT," Thank you for attending and checking out my app!");
        emailIntent.setType("message/rfc822");


        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No Mail App", Toast.LENGTH_LONG).show();
            System.out.println("Mail Not there");
        }
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://google.com"));

        try
        { startActivity(intent);}
        catch (ActivityNotFoundException e)
        {Toast.makeText(this, "Cannot Open Browser", Toast.LENGTH_LONG).show();}





    }

    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);


        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {



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