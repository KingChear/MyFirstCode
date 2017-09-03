package com.example.kingching.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;

//    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
//            "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"};
    private List<Fruit> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        setOnClickListener();

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
//        listView.setAdapter(adapter);

        initData();
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, listData);
        listView.setAdapter(fruitAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, listData.get(i).getName().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId) {
            default:
                break;
        }
    }

    private void findViewById() {
        listView = (ListView) findViewById(R.id.list_view);
    }

    private void setOnClickListener() {

    }

    private void initData() {
        Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
        listData.add(apple);
        Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
        listData.add(banana);
        Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
        listData.add(cherry);
        Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
        listData.add(grape);
        Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
        listData.add(mango);

    }
}
