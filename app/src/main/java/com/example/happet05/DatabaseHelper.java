package com.example.happet05;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String userTable = "test";
        db.execSQL("create table if not exists " + userTable + " ("
                + " _id integer PRIMARY KEY autoincrement, "
                + " userId text, "
                + " password text);");

        String userSubjectTable = "test2";
        db.execSQL("create table if not exists " + userSubjectTable + " ("
                + " _id integer PRIMARY KEY autoincrement, "
                + " userId text, "
                + " password text, "
                + " name text, "
                + " phone text, "
                + " email text, "
                + " FOREIGN KEY (userId) REFERENCES test (userId));");

        String foodTable = "food";
        db.execSQL("create table if not exists " + foodTable + " ("
                + " _id integer PRIMARY KEY autoincrement, "
                + " name text, "
                + " protein text, "
                + " fat text, "
                + " calcium text, "
                + " compoment text);");

        String snackTable = "snack";
        db.execSQL("create table if not exists " + snackTable + " ("
                + " _id integer PRIMARY KEY autoincrement, "
                + " name text, "
                + " type text, "
                + " compoment text);");

        String toyTable = "toy";
        db.execSQL("create table if not exists " + toyTable + " ("
                + " _id integer PRIMARY KEY autoincrement, "
                + " name text, "
                + " type text, "
                + " compoment text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}