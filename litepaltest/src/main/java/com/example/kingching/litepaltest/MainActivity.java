package com.example.kingching.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    private Button createData;
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
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        Book book = new Book();

        switch (viewId) {
            case R.id.create_data:
                LitePal.getDatabase();
                break;
            case R.id.add_data:
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknow");
                book.save();
                break;
            case R.id.update_data:
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name = ? and author = ?", "The Da Vinci Code", "Dan Brown");
                break;
            case R.id.delete_data:
                DataSupport.deleteAll(Book.class, "price < ?", "15");
                break;
            case R.id.query_data:
                List<Book> books = DataSupport.findAll(Book.class);
                for (int i = 0; i < books.size(); i++) {
                    Log.d(TAG, books.get(i).getName());
                    Log.d(TAG, books.get(i).getAuthor());
                    Log.d(TAG, books.get(i).getPages() + "");
                    Log.d(TAG, books.get(i).getPrice() + "");
                    Log.d(TAG, books.get(i).getPress());
                }
                break;
            default:
                break;
        }
    }

    private void findViewById() {
        createData = (Button) findViewById(R.id.create_data);
        addData = (Button) findViewById(R.id.add_data);
        updateData = (Button) findViewById(R.id.update_data);
        deleteData = (Button) findViewById(R.id.delete_data);
        queryData = (Button) findViewById(R.id.query_data);
    }

    private void setOnClickListener() {
        createData.setOnClickListener(this);
        addData.setOnClickListener(this);
        updateData.setOnClickListener(this);
        deleteData.setOnClickListener(this);
        queryData.setOnClickListener(this);
    }
}
