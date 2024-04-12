package com.futurext.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class adminLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_log);

        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin and admin

        loginbtn.setOnClickListener(view -> {

                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    //correct
                    Intent i = new Intent(this,addBooks.class);
                    startActivity(i);
                }else
                    //incorrect
                    Toast.makeText(adminLog.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();

        });

    }
}