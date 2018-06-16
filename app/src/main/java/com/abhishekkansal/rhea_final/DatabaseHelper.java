package com.abhishekkansal.rhea_final;

/**
 * Created by Abhishek on 4/20/2018.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "rheafinal.db";
    public static final String USERS_TABLE_NAME = "Users";
    public static final String USERS_COLUMN_ID = "id";
    public static final String USERS_COLUMN_NAME = "name";
    public static final String USERS_COLUMN_EMAIL = "email";
    public static final String USERS_COLUMN_COURSE = "course";
    public static final String USERS_COLUMN_SEM = "sem";
    public static final String USERS_COLUMN_PASSWORD = "password";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ USERS_TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, course TEXT, sem TEXT, password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ USERS_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUser(String name, String email, String course, String sem, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_COLUMN_NAME, name);
        contentValues.put(USERS_COLUMN_EMAIL, email);
        contentValues.put(USERS_COLUMN_COURSE, course);
        contentValues.put(USERS_COLUMN_SEM,sem);
        contentValues.put(USERS_COLUMN_PASSWORD, password);
        long result = db.insert(USERS_TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor checkUser(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String enteredUname = username;
        String enteredPassw = password;
        String query = ("SELECT * FROM " + USERS_TABLE_NAME + " WHERE email = '"+enteredUname + "' AND password = '" + enteredPassw+"'");
        Cursor res = db.rawQuery(query, null);
        return res;
    }
}
