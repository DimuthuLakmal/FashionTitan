package com.titans.fashion.fashiontitans;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View.OnClickListener;
import android.view.View;

/**
 * Created by Dimuthu on 2015-08-09.
 */
public class UserRegistration extends Activity{

    EditText userName;
    EditText password;
    EditText rePassword;
    EditText addressLineOne;
    EditText addressLineTwo;
    RadioButton selectedRadioButton;
    RadioGroup radioGroup;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration);

        userName = (EditText)findViewById(R.id.userNameReg);
        password = (EditText)findViewById(R.id.passwordReg);
        rePassword = (EditText)findViewById(R.id.reenterPasswordReg);
        addressLineOne = (EditText)findViewById(R.id.addressLineOneReg);
        addressLineTwo = (EditText)findViewById(R.id.addressLineTwoReg);
        nextButton = (Button)findViewById(R.id.nextButtonReg);

        //add listener to nextButton
        addListenerOnButton();
    }



    public void addListenerOnButton() {



        radioGroup = (RadioGroup) findViewById(R.id.radioSexReg);

        nextButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String userNameText = userName.getText().toString();
                String passwordText = password.getText().toString();
                String rePasswordText = rePassword.getText().toString();
                String addressLineOneText = addressLineOne.getText().toString();
                String addressLineTwoText = addressLineTwo.getText().toString();
                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                selectedRadioButton = (RadioButton) findViewById(selectedId);

                if(rePasswordText.equals(passwordText)) {
                    if (selectedRadioButton.getText().equals("Male")) {

                        Intent measurementsMen = new Intent(getApplicationContext(), MeasurementsMen.class);
                        Bundle b = new Bundle();
                        b.putString("un", userNameText);

                        //home.putExtra("un",un);
                        b.putString("pw", passwordText);
                        b.putString("addressOne", addressLineOneText);
                        b.putString("addressTwo", addressLineTwoText);


                        measurementsMen.putExtras(b);
                        startActivity(measurementsMen);
                        UserRegistration.this.finish();
                    }
                }

            }

        });

    }
}
