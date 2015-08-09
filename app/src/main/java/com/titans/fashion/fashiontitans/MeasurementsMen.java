package com.titans.fashion.fashiontitans;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Dimuthu on 2015-08-09.
 */
public class MeasurementsMen extends Activity {


    EditText sleeves;
    EditText chest;
    EditText waist;
    EditText hip;
    EditText inseam;
    Button saveButton;

    String un,pw,addressLineOne,addressLineTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measurements_men);

        //get bundled data
        Bundle b = getIntent().getExtras();
        un = b.getString("un");
        pw = b.getString("pw");
        addressLineOne = b.getString("addressOne");
        addressLineTwo = b.getString("addressTwo");

        sleeves = (EditText)findViewById(R.id.sleeveReg);
        chest = (EditText)findViewById(R.id.chestReg);
        waist = (EditText)findViewById(R.id.waistReg);
        hip = (EditText)findViewById(R.id.hipReg);
        inseam = (EditText)findViewById(R.id.inseamReg);
        saveButton = (Button)findViewById(R.id.saveButtonReg);

    }

    public void addListenerOnButton() {

        final String userNameText = userName.getText().toString();
        final String passwordText = password.getText().toString();
        final String rePasswordText = rePassword.getText().toString();
        final String addressLineOneText = addressLineOne.getText().toString();
        final String addressLineTwoText = addressLineTwo.getText().toString();

        radioGroup = (RadioGroup) findViewById(R.id.radioSexReg);

        nextButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

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
