package com.futurext.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button btn1Submit;
    Button btn2Submit, btnYoutube, btnMap, btnFB;
    TextView title;
    CallbackManager callbackManager;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);


        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pagesmb/"));
                        startActivity(i);
                    }

                    @Override
                    public void onCancel() {

                        Intent i = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(i);
                        Toast t1 = Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG);
                        t1.show();

                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Intent i = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(i);
                        Toast t1 = Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG);
                        t1.show();
                    }
                });


        Button btn1Submit = findViewById(R.id.btn1Submit);

        btn1Submit.setOnClickListener(view -> {
            Intent i = new Intent( this,adminLog.class);
            startActivity(i);

        });

        Button btn2Submit = findViewById(R.id.btn2Submit);

        btn2Submit.setOnClickListener(view -> {
            Intent i = new Intent(this, ShowBooks.class);
            startActivity(i);

        });

        Button btnYoutube = findViewById(R.id.btnYoutube);

        btnYoutube.setOnClickListener(view -> {
            Intent i = new Intent( this,Youtube.class);
            startActivity(i);

        });

        Button btnMap = findViewById(R.id.gMap);

        btnMap.setOnClickListener(view -> {
            Intent i = new Intent( this,GMap.class);
            startActivity(i);

        });

        btnFB = findViewById(R.id.btnFB);

        btnFB.setOnClickListener(view -> {
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));

        });






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}