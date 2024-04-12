package com.futurext.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Purchase extends AppCompatActivity {
    Button btn1;
    EditText txtEmail, cardNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        btn1 = findViewById(R.id.btnBuy);
        txtEmail = findViewById(R.id.txtEmail);
        cardNum = findViewById(R.id.cardNum);

        btn1.setOnClickListener(view -> {

            if(!txtEmail.getText().toString().isEmpty() & cardNum.getText().toString().length() == 16){
                //correct
                Toast.makeText(Purchase.this,"PDF Sent",Toast.LENGTH_LONG).show();
            }else
                //incorrect
                Toast.makeText(Purchase.this,"Check email and card number",Toast.LENGTH_LONG).show();

        });
    }
}