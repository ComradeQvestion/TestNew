package com.example.testnew;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperProjects extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="projects.db";
    public static final String TABLE_NAME ="projects";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="title";
    public static final String COL_3 ="description";
    public static final String COL_4 ="lookingfor";

    public DatabaseHelperProjects(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE projects (ID INTEGER PRIMARY  KEY AUTOINCREMENT, title TEXT, description TEXT, lookingfor TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long addProject(String title, String description, String lookingfor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title);
        contentValues.put("description",description);
        contentValues.put("lookingfor", lookingfor);
        long res = db.insert("projects",null,contentValues);
        db.close();
        return  res;
    }

}