package com.app.recyclerview_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GroceryDBHelper extends SQLiteOpenHelper {

    public static final String DATABSE_NAME = "grocerylist.db";
    public static final int DATABASE_VERSION = 1;

    public GroceryDBHelper(@Nullable Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_GROCERYLIST_TABLE = "CREATE TABLE " +
                GroceryContract.GroceryEntry.TABLE_NAME + " (" +
                GroceryContract.GroceryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GroceryContract.GroceryEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                GroceryContract.GroceryEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                GroceryContract.GroceryEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP);";
        sqLiteDatabase.execSQL(SQL_CREATE_GROCERYLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GroceryContract.GroceryEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
