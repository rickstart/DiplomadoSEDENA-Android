package com.mobintum.crmlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 *
 * Created by Rick on 20/08/15.
 * All right are reserved for Rick
 *
 */
public class DatabaseAdapter {

    private static DatabaseHelper mDbHelper;
    private static SQLiteDatabase mDb;
    private static Context context;

    public DatabaseAdapter(Context context) {
        this.context = context;
    }

    public static boolean openDB(Context context){
        if(mDbHelper != null)
            mDbHelper.close();
        mDbHelper = new DatabaseHelper(context);

        try {
            mDb = mDbHelper.getWritableDatabase();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static SQLiteDatabase getDB(Context context){

        if(mDb == null)
            openDB(context);

        return mDb;

    }

}
