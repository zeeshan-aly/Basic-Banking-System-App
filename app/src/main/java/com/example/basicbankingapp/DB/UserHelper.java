package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7859,'S M Zeeshan Ali', 'asaraswat21@gmail.com','7584','8494845715', 4000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8652,'Gulam Mazid', 'gulamidz0@gmail.com','1258','9856641238', 6000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8795,'Shehnaz Choudhary', 'shehnazcc@gmail.com','8896','8565645896', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2158,'Hina Khan', 'khanhina32@gmail.com','7752','6775640038', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Shivam kumar', 'shivamkm666@gmail.com','3669','8085648962', 5500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Priyank Gangal', 'prigangs10@gmail.com','9985','8745640238', 7000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Yoshita Dutta', 'yodutta98@gmail.com','1207','8245640215', 14500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Salman Ali', 'syedsalman@gmail.com','4522','9665021539', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Roshan Ara', 'aararoshan@gmail.com','6582','9859565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Nanda Reddy', 'reddynada00@gmail.com','5450','9995691201', 19900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Anupam Singh', 'anusinghpam12@gmail.com','2656','8015641200', 8800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Raj Verma', 'rajvarma@gmail.com','1203','9525641999', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1562,'Naman Mathur', 'naman0mathur@gmail.com','5566','9229541001', 15800)");
        db.execSQL("insert into " + TABLE_NAME + " values(7892,'Yash Soni', 'soniyash87@gmail.com','2236','6114642205', 13500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3570,'Tanmay Singhania', 'singhaniatan@gmail.com','6692','9874541266', 11500)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}