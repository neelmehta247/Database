package com.tikotapps.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by neel on 24/06/15.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final int VERSION_NUMBER = 1;

    public static final String DATABASE_NAME = "TryingDatabases.db";

    public static final String TABLE_NAME = "DatabaseTry";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_LANGUAGE = "language";

    public static DbHelper singleton = null;

    public static DbHelper getInstance(Context context) {
        if (singleton == null)
            singleton = new DbHelper(context.getApplicationContext());
        return singleton;
    }

    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, " + COLUMN_AGE + " INTEGER, " + COLUMN_LANGUAGE + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
