package com.example.contactsdbjava13.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsdbjava13.MainActivity;
import com.example.contactsdbjava13.R;
import com.example.contactsdbjava13.db.entity.Contact;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {
//variable
    private Context context;
    private ArrayList<Contact> contactsList;
    private MainActivity mainActivity;
    //my view holder
    public  class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name= itemView.findViewById(R.id.name);
            this.email=itemView.findViewById(R.id.email);
        }

    }

    public ContactsAdapter(Context context, ArrayList<Contact> contactArrayList, MainActivity mainActivity) {
        this.context = context;
        this.contactsList = contactArrayList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View itemView= LayoutInflater.from(parent.getContext()).
              inflate(R.layout.conatct_list,parent,false);
      return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int positions) {
        final Contact contact=contactsList.get(positions);
holder.name.setText(contact.getName());
holder.email.setText(contact.getEmail());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mainActivity.addAndEditContacts(true,contact,positions);
    }
});
    }


    @Override
    public int getItemCount() {
        return contactsList.size();
    }



}
