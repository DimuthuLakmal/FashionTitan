package com.titans.fashion.fashiontitans;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Dimuthu on 2015-08-08.
 */
public class HomeFashion extends Activity {

    Button btnSignOut , btnMyModel , btnGoShopping;
    //list view to display news feed items
    ListView listView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_fashion); //set user_login.xml

        btnSignOut = (Button) findViewById(R.id.btnSignOut);
        btnMyModel = (Button) findViewById(R.id.btnMyModel);
        btnGoShopping= (Button) findViewById(R.id.btnGoShopping);
        listView = (ListView) findViewById(R.id.listView);

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeFashion.this, UserLogin.class);
                startActivity(intent);
            }
        });

        btnMyModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeFashion.this, MyModel.class);
                startActivity(intent);
            }
        });

        btnGoShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeFashion.this, ShoppingMenu.class);
                startActivity(intent);
            }
        });

        //onclick listener on listview
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //depending on the selection, go to relevant outfit page
            }
        });


    }
}
