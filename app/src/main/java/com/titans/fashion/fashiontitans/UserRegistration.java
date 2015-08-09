package com.titans.fashion.fashiontitans;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Dimuthu on 2015-08-09.
 */
public class UserRegistration extends Activity{

    EditText userName;
    EditText password;
    EditText rePassword;
    EditText addressLineOne;
    EditText addressLineTwo;
    RadioButton menRadioButton;
    RadioButton femaleRadioButton;
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

    }
}
