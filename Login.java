package com.ittralee.ie.workflow;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Login extends AppCompatActivity {
    Button btn;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // btn = (Button) findViewById(R.id.login);
       // btn.setOnClickListener(this);
        OracleDAO dbHelper;
        dbHelper = new OracleDAO(this);

        try {
            dbHelper.openDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String username =  findViewById(R.id.name).toString();
        String password = findViewById(R.id.pass).toString();
        user = new User(username,password);

        User user1 = null;
        try {
            user1 = dbHelper.find(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Toast.makeText(this,user1.toString(),Toast.LENGTH_LONG).show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

/*
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                new userLogin().execute("");
                break;
        }
    }
    private class userLogin extends AsyncTask<String, Void, String> {
        User user;
        String s;
        //put call to Database class in here
        @Override
        protected String doInBackground(String... params) {
          UserOracleDAO u = new UserOracleDAO();
            try {
                u.find(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return s;
        }

        @Override
        protected void onPostExecute(String result) {

        }

        @Override
        protected void onPreExecute() {
            String username =  findViewById(R.id.name).toString();
            String password = findViewById(R.id.pass).toString();
             user = new User(username,password);
        }

        @Override
        protected void onProgressUpdate(Void... values) {}

    }
    */
}
