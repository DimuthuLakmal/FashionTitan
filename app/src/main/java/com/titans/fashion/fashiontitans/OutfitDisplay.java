package com.titans.fashion.fashiontitans;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class OutfitDisplay extends ActionBarActivity {

    Button btnBack, btnSeeComments , btnBuyNow, btnViewSimilar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit_display);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnSeeComments = (Button) findViewById(R.id.btnSeeComments); //get comments on that dress.
        btnBuyNow = (Button) findViewById(R.id.btnBuyNow);//have to connect to a payment gateway
        btnViewSimilar = (Button) findViewById(R.id.btnViewSimilar); //depending on the database and recent searches

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_outfit_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
