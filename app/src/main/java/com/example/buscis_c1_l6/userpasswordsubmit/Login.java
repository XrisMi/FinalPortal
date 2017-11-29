package com.example.buscis_c1_l6.userpasswordsubmit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Date;

public class Login extends AppCompatActivity {

    private RadioGroup languageSelectors;
    private RadioButton rb1,rb2;
    private String languagePreference;
    private TextView questionString;
    private TextView cityPrompt;
    private TextView statePrompt;
    private TextView languagePreferencePrompt;
    private EditText cityField;
    private EditText stateField;
    private Button submitButton;
    private Spinner spinner;
    private ArrayAdapter<CharSequence> spinnerAdapter;
    private UserInfo userInfo;
    private EditText emailField;
    private TextView emailQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        languageSelectors = (RadioGroup) findViewById(R.id.languageSelectors);
        rb1= (RadioButton) findViewById(R.id.radioButton1 );
        rb2= (RadioButton) findViewById(R.id.radioButton2 );
        questionString = (TextView) findViewById(R.id.questionString);
        cityPrompt = (TextView) findViewById(R.id.cityQuestion);
        statePrompt = (TextView) findViewById(R.id.stateQuestion);
        languagePreferencePrompt = (TextView) findViewById(R.id.langPrefText);
        cityField = (EditText) findViewById(R.id.cityField);
        stateField = (EditText) findViewById(R.id.stateField);
        submitButton = (Button) findViewById(R.id.submitButton);
        spinner = (Spinner) findViewById(R.id.spinner);
        emailField = (EditText) findViewById(R.id.emailField);
        emailQuestion = (TextView) findViewById(R.id.emailQuestion);

        init();
    }


    private void init() {


        userInfo = new UserInfo();

        rb1.setChecked(true);
        // Create an ArrayAdapter using the string array and a default spinner layout
        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.question_array_english, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(spinnerAdapter);

        languageSelectors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioGroup.getCheckedRadioButtonId() == rb1.getId()) {
                    languagePreference = "English";
                    setStringsToEnglish();

                } else if (radioGroup.getCheckedRadioButtonId() == rb2.getId()) {
                    languagePreference = "Spanish";
                    setStringsToSpanish();

                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUserInfoWithEnteredData();
                Intent i;
                i = new Intent(Login.this, ThirdPage.class);
                startActivity(i);

            }


        });
    }

    private void setStringsToEnglish() {

        questionString.setText(getResources().getString(R.string.question_english));
        languagePreferencePrompt.setText(getResources().getString(R.string.lang_pref_english));
        cityPrompt.setText(getResources().getString(R.string.city_prompt_english));
        statePrompt.setText(getResources().getString(R.string.state_prompt_english));

        //Set spinner data again
        spinnerAdapter = ArrayAdapter.createFromResource(Login.this, R.array.question_array_english, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    private void setStringsToSpanish() {

        questionString.setText(getResources().getString(R.string.question_spanish));
        languagePreferencePrompt.setText(getResources().getString(R.string.lang_pref_spanish));
        cityPrompt.setText(getResources().getString(R.string.city_prompt_spanish));
        statePrompt.setText(getResources().getString(R.string.state_prompt_spanish));
        emailQuestion.setText(getResources().getString(R.string.email_prompt_spanish));

        //Set spinner data again
        spinnerAdapter = ArrayAdapter.createFromResource(Login.this, R.array.question_array_spanish, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    private void setUserInfoWithEnteredData() {
        String memberStatus = spinner.getSelectedItem().toString();
        userInfo.setInfo(languagePreference, memberStatus, cityField.getText().toString(), stateField.getText().toString(), emailField.getText().toString());
        userInfo.print();
    }

    //We save all the information that was entered in into this object when you click the submit button.
    private class UserInfo {

        String languagePreference;
        String memberStatus;
        String city;
        String state;
        Date currentDate;
        String email;

        public UserInfo() {

            //Sets the current date to "right now" based on phone's internal clock
            currentDate = new Date();

            //Default values
            languagePreference = "English";
            memberStatus = "Student";
            city = "Sacramento";
            state = "CA";
            email = "email";
        }

        void setInfo(String preference, String languagePreference, String memberStatus, String city, String state) {
            this.languagePreference = languagePreference;
            this.memberStatus = memberStatus;
            this.city = city;
            this.state = state;
            this.email = email;
        }


        //For debugging purposes
        void print()  {
            Log.d("Filter", "Info "+languagePreference+" "+memberStatus+" "+city+" "+state+" "+ currentDate.toString());
        }
    }

}
