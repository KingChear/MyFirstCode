package com.example.kingching.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    private MyDatabaseHelper myDatabaseHelper;

    private Button createDatabase;
    private Button addData;
    private Button updateData;
    private Button deleteData;
    private Button queryData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        setOnClickListener();

        myDatabaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (viewId) {
            case R.id.create_database:
                myDatabaseHelper.getWritableDatabase();
                break;
            case R.id.add_data:
                contentValues.put("name", "The Da Vinci Code");
                contentValues.put("author", "Dan Brown");
                contentValues.put("pages", 454);
                contentValues.put("price", 16.96);
                sqLiteDatabase.insert("Book", null, contentValues);

                contentValues.clear();

                contentValues.put("name", "The Lost Symbol");
                contentValues.put("author", "Dan Brown");
                contentValues.put("pages", 510);
                contentValues.put("price", 19.95);
                sqLiteDatabase.insert("Book", null, contentValues);
                break;
            case R.id.update_data:
                contentValues.put("price", 10.99);
                sqLiteDatabase.update("Book", contentValues, "name = ?", new String[]{"The Da Vinci Code"});
                break;
            case R.id.delete_data:
                sqLiteDatabase.delete("Book", "pages > ?", new String[]{"500"});
                break;
            case R.id.query_data:
                Cursor cursor = sqLiteDatabase.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));

                        Log.d(TAG, name);
                        Log.d(TAG, author);
                        Log.d(TAG, pages + "");
                        Log.d(TAG, price + "");

                    } while (cursor.moveToNext());
                }
                cursor.close();
                break;
            default:
                break;
        }
    }

    private void findViewById() {
        createDatabase = (Button) findViewById(R.id.create_database);
        addData = (Button) findViewById(R.id.add_data);
        updateData = (Button) findViewById(R.id.update_data);
        deleteData = (Button) findViewById(R.id.delete_data);
        queryData = (Button) findViewById(R.id.query_data);
    }

    private void setOnClickListener() {
        createDatabase.setOnClickListener(this);
        addData.setOnClickListener(this);
        updateData.setOnClickListener(this);
        deleteData.setOnClickListener(this);
        queryData.setOnClickListener(this);
    }
}
