
package com.example.autostring;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.Arrays;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "users";
    private static final int DB_VER = 1;
    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE users(id VARCHAR(10) PRIMARY KEY, name TEXT, email TEXT, age INT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        onCreate(sqLiteDatabase);
    }

    public boolean registerUser (String fname, String lname, String housebox, String citybox,String statebox,String pinbox,String modelbox,String yearbox,String manubox) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("FirstName", fname);
            contentValues.put("LastName", lname);
            contentValues.put("HouseName", housebox);
            contentValues.put("CityName", citybox);
            contentValues.put("StateName", statebox);
            contentValues.put("PinCode", Integer.parseInt(pinbox));
            contentValues.put("ModelName", modelbox);
            contentValues.put("Year", Integer.parseInt(yearbox));
            contentValues.put("ManufacturerName", manubox);
            sqLiteDatabase.insert("users", null, contentValues);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            sqLiteDatabase.close();
        }
    }

    public boolean verifyUser (String phonebox, String emailbox) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("Phone Number", Integer.parseInt(phonebox));
            contentValues.put("Email Id", emailbox);
            sqLiteDatabase.insert("users", null, contentValues);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            sqLiteDatabase.close();
        }
    }

    public String getUsers () {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        StringBuilder res = new StringBuilder();
        try {
            final Cursor cursor = sqLiteDatabase.query("users", null, null, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    res.append("[").append(
                            cursor.getString(cursor.getColumnIndexOrThrow("firstname")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("lastname")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("housename")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("city")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("state")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("pincode")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("modelname")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("year")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("manufacturername")) + ", " +
                                    cursor.getInt(cursor.getColumnIndexOrThrow("Phone No.")) + ", " +
                                    cursor.getString(cursor.getColumnIndexOrThrow("Email Id"))+ ", " +
                            cursor.getInt(cursor.getColumnIndexOrThrow("OTP"))

                    ).append("]").append("\n");
                }
                cursor.close();
            }
            return res.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            sqLiteDatabase.close();
        }
    }

}



