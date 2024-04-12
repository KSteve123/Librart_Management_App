package com.futurext.test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addBooks extends AppCompatActivity {
EditText bookName, bookCat, bookPrice;
Button addBook, ViewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);

        final EditText bookName = findViewById(R.id.txtEmail);
        final EditText bookCat = findViewById(R.id.bookCat);
        final EditText bookPrice = findViewById(R.id.bookPrice);

        Button addBook = findViewById(R.id.btnBuy);
        Button ViewBook = findViewById(R.id.ViewBook);
        bookCRUD b1 = new bookCRUD();



        //insert book info
        addBook.setOnClickListener(view ->
        {
            if(!bookName.getText().toString().isEmpty() & !bookCat.getText().toString().isEmpty() & !bookPrice.getText().toString().isEmpty()) {
                Book book = new Book(bookName.getText().toString(), bookCat.getText().toString(), bookPrice.getText().toString());
                b1.add(book);
                Toast t1 = Toast.makeText(this, "Successfully Added", Toast.LENGTH_LONG);
                t1.show();

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("myCh", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager = getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }


                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(this, "myCh")
                                .setSmallIcon(R.drawable.abc)
                                .setContentTitle("New Book is Available")
                                .setContentText(bookName.getText().toString())
                                .setAutoCancel(true);


                Intent notificationIntent = new Intent(this, addBooks.class);
                notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);

                // Add as notification
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0, builder.build());
            }
            else
                {
                    Toast t2 = Toast.makeText(this, "Check Entered Values", Toast.LENGTH_LONG);
                    t2.show();
                }
        });

            //Redirect to Showbook activity
            ViewBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v1) {
                    Intent i = new Intent(addBooks.this, ShowBooks.class);
                    startActivity(i);
                }
            });

    }
}