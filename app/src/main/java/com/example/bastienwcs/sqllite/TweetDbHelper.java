package com.example.bastienwcs.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.bastienwcs.sqllite.DatabaseContract.SQL_CREATE_BELONG;
import static com.example.bastienwcs.sqllite.DatabaseContract.SQL_CREATE_ORGANIZATION;
import static com.example.bastienwcs.sqllite.DatabaseContract.SQL_CREATE_TWEET;
import static com.example.bastienwcs.sqllite.DatabaseContract.SQL_CREATE_USER;
import static com.example.bastienwcs.sqllite.DatabaseContract.SQL_DELETE_BELONG;
import static com.example.bastienwcs.sqllite.DatabaseContract.SQL_DELETE_ORGANIZATION;
import static com.example.bastienwcs.sqllite.DatabaseContract.SQL_DELETE_TWEET;
import static com.example.bastienwcs.sqllite.DatabaseContract.SQL_DELETE_USER;

/**
 * Created by bastienwcs on 03/10/17.
 */

public class TweetDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "Tweet.db";

    public TweetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USER);
        db.execSQL(SQL_CREATE_TWEET);
        db.execSQL(SQL_CREATE_ORGANIZATION);
        db.execSQL(SQL_CREATE_BELONG);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_USER);
        db.execSQL(SQL_DELETE_TWEET);
        db.execSQL(SQL_DELETE_ORGANIZATION);
        db.execSQL(SQL_DELETE_BELONG);
        onCreate(db);
    }
}
