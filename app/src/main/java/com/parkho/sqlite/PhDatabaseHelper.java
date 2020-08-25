package com.parkho.sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.parkho.sqlite.PhDatabaseContract.StudentEntry;

public class PhDatabaseHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "student.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + StudentEntry.TABLE_NAME + " (" +
                    StudentEntry._ID + " INTEGER PRIMARY KEY," +
                    StudentEntry.GRADE + " INTEGER," +
                    StudentEntry.NUMBER + " INTEGER," +
                    StudentEntry.NAME + " TEXT," +
                    StudentEntry.AGE + " INTEGER)";

    public PhDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase a_db, int a_oldVersion, int a_newVersion) {
        try {
            if (a_oldVersion < 2) {
                updateAgeColumn(a_db);
            }

        } catch (SQLException e) {
            a_db.execSQL("DROP TABLE IF EXISTS " + StudentEntry.TABLE_NAME);
            onCreate(a_db);
        }
    }

    /**
     * 나이 column 추가
     */
    private void updateAgeColumn(SQLiteDatabase a_db) {
        a_db.execSQL("ALTER TABLE " + StudentEntry.TABLE_NAME + " " + "ADD COLUMN " + StudentEntry.AGE + " " + "INTEGER DEFAULT " + 0);
    }
}