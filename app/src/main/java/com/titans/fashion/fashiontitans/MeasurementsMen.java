package com.titans.fashion.fashiontitans;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

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
    String[] data;

    String un,pw,addressLineOne,addressLineTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measurements_men);

        //get bundled data
        Bundle b = getIntent().getExtras();
        un = b.getString("un");
        pw = b.getString("pw");
        System.out.println("fdsfa");
        System.out.println("aaaa");
        System.out.println(un);
        addressLineOne = b.getString("addressOne");
        addressLineTwo = b.getString("addressTwo");

        sleeves = (EditText)findViewById(R.id.sleeveReg);
        chest = (EditText)findViewById(R.id.chestReg);
        waist = (EditText)findViewById(R.id.waistReg);
        hip = (EditText)findViewById(R.id.hipReg);
        inseam = (EditText)findViewById(R.id.inseamReg);
        saveButton = (Button)findViewById(R.id.saveButtonReg);

        data = new String[9];

        addListenerOnButton();
    }

    public void addListenerOnButton() {



        saveButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                final String sleevesText = sleeves.getText().toString();
                final String chestText = chest.getText().toString();
                final String waistText = waist.getText().toString();
                final String hipText = hip.getText().toString();
                final String inseamText = inseam.getText().toString();

                MeasurementsMen.this.data=  new String[]{un,pw,addressLineOne,addressLineTwo,sleevesText,chestText,waistText,hipText,inseamText};
                new InsertData().execute(new DBConnection());
            }

        });

    }

    private class InsertData extends AsyncTask<DBConnection, Long, String> {

        @Override
        protected String doInBackground(DBConnection... arg0) {
            System.out.println(MeasurementsMen.this.data[0]);
            return arg0[0].saveUser(MeasurementsMen.this.data);
        }


    }
}
