package com.example.mymusicplayer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class UserDatabaseManager {
    private DatabaseHelper dbhelper;
    private SQLiteDatabase db;

    public UserDatabaseManager(Context context){
        this.dbhelper = new DatabaseHelper(context);
    }

    public void open(){
        db = dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public long insertUser(String userName, String name, String email, String password, String gender){
        ContentValues content = new ContentValues();
        content.put("username", userName);
        content.put("name", name);
        content.put("email", email);
        content.put("gender", gender);
        content.put("password", password);
        return db.insert("users", null, content);
    }

    public void logAllUsers() {
        // Define the columns you want to retrieve
        String[] columns = { "id", "username", "name", "email", "gender", "password" };

        // Query the database
        Cursor cursor = db.query(
                "users",    // The table to query
                columns,    // The columns to return
                null,       // The columns for the WHERE clause
                null,       // The values for the WHERE clause
                null,       // Group the rows
                null,       // Filter by row groups
                null        // The sort order
        );

        // Move to the first row in the result set
        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Retrieve each column value
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                String gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"));
                String password = cursor.getString(cursor.getColumnIndexOrThrow("password"));

                // Log the user details
                Log.d("UserLog", "ID: " + id + ", Username: " + username + ", Name: " + name +
                        ", Email: " + email + ", Gender: " + gender + ", Password: " + password);
            } while (cursor.moveToNext()); // Move to the next row
        }

        // Close the cursor
        if (cursor != null) {
            cursor.close();
        }
    }


    public String getPassword(String username){
        String password = null;
        Cursor cursor = null;
        try{
            String[] columns = {"password"};
            String selection = "username = ?";
            String[] selectionArgs = { username};

            cursor =  db.query("users", columns, selection, selectionArgs, null, null, null);
            if(cursor!=null && cursor.moveToFirst()){
                password = cursor.getString(cursor.getColumnIndexOrThrow("password"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(cursor!= null){
                cursor.close();
            }
        }
        return password;
    }
}
