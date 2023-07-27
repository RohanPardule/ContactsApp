package com.example.contactsdbjava13.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.contactsdbjava13.db.entity.Contact;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactsAppDatabase extends RoomDatabase {
    //Linking DAO
    public abstract ContactDAO getContactDAO();



}
