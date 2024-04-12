package com.futurext.test2;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class bookCRUD {
    private DatabaseReference data;
    public bookCRUD()

    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        data = db.getReference(Book.class.getSimpleName());

    }


    public Task<Void> add(Book a)
    {
        return data.push().setValue(a);

    }
}
