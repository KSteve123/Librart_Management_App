package com.futurext.test2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Book> mList;
    Context context;


    public MyAdapter(Context context , ArrayList<Book> mList){

        this.mList = mList;
        this.context = context;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item , parent ,false);
        return new MyViewHolder(v);

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Book model = mList.get(position);
        holder.name.setText(model.getBookName());
        holder.category.setText(model.getCategory());
        holder.price.setText(model.getPrice());
        holder.itemView.findViewById(R.id.bBuy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Purchase.class);
                context.startActivity(i);

            }
        });
    }




    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name , category , price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.bName);
            category = itemView.findViewById(R.id.bCat);
            price = itemView.findViewById(R.id.bPrice);



        }


    }


}
