package com.example.buscis_c1_l6.userpasswordsubmit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity
implements OnEditorActionListener {

    private TextView User;
    private TextView TextPwNv;
    private TextView Submit;
    private EditText VisUsername;
    private EditText InvisPass;

    public void onClick(View view)
    {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User = (TextView) findViewById(R.id.User);
        TextPwNv = (TextView) findViewById(R.id.TextPwNv);
        Submit = (TextView) findViewById(R.id.Submit);
        VisUsername = (EditText) findViewById(R.id.VisUsername);
        InvisPass = (EditText) findViewById(R.id.InvisPass);

        InvisPass.setOnEditorActionListener(this);

        String usernameString=VisUsername.getText().toString();
        String passwordString=InvisPass.getText().toString();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            String EnteredUser = VisUsername.getText().toString();
            String EnteredPass = InvisPass.getText().toString();

           switch (v.getId()) {
               case R.id.VisUsername:
                   if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED)

                       Submit.setText("Success");

               case R.id.InvisPass:
                   if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED)

                   {
                       if (EnteredUser.equalsIgnoreCase("Chris") && EnteredPass.equalsIgnoreCase("Merlin"))
                       {
                           Intent i = new Intent(this, Login.class);
                           startActivity(i);
                       }

                       else Submit.setText("Wrong!");
                   }
           }
        }
        return false;
    }
}
