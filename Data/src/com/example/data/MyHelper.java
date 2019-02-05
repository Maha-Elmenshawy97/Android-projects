package com.example.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyHelper extends SQLiteOpenHelper {
	
	public static final String DB_NAME ="people_db";
    public static final String TABLE_NAME ="friends_table";
    public static final String COL_ID ="_id";
    public static final String COL_NAME="_name";
    public static final String COL_PHONE="_phone";
    public static final int DB_VERSION=2;
    
    public MyHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+TABLE_NAME+" ( "+COL_ID+" integer primary key autoincrement, "+COL_NAME+" text, "+COL_PHONE+" text )" ;
        Log.i("tag",sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql ="drop table "+TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }
   
   
}

