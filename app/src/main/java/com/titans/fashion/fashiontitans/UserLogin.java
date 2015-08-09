package com.titans.fashion.fashiontitans;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dimuthu on 2015-08-08.
 */
public class UserLogin extends Activity implements View.OnClickListener{

    EditText userName;
    EditText password;
    Button login;

    private String un,pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login); //set user_login.xml

        //get reference to elements in login screen
        userName = (EditText)findViewById(R.id.usernametext);
        password = (EditText)findViewById(R.id.passwordtext);
        login = (Button)findViewById(R.id.loginbutton);

        //set listner to button
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        un=userName.getText().toString();
        pw = password.getText().toString();
        new GetUserData().execute(new DBConnection());
    }

    private class GetUserData extends AsyncTask<DBConnection,Long,JSONObject> {

        @Override
        protected JSONObject doInBackground(DBConnection... params) {
            return params[0].getUserDetail(un,pw);
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            if(result!=null) {
                try {
                    String user_id = result.getString("id");
                    Toast t = Toast.makeText(getApplicationContext(), "Successfully Logged", Toast.LENGTH_LONG);
                    t.show();
                    Intent home = new Intent(getApplicationContext(),HomeFashion.class);
                    Bundle b = new Bundle();
                    b.putString("un",un);

                    //home.putExtra("un",un);
                    b.putString("pw",pw);
                    b.putString("id",user_id);
                    home.putExtras(b);
                    startActivity(home);
                    UserLogin.this.finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else{

                Toast t = Toast.makeText(getApplicationContext(), "Logging Failed", Toast.LENGTH_LONG);
                t.show();
            }
        }
    }
}
