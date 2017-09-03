package com.example.kingching.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by KingChing on 2017/8/31.
 */
public class TitleLayout extends LinearLayout implements View.OnClickListener{

    private Button titleBack;
    private Button titleEdit;

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);

        findViewById();
        setOnClickListener();

    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.title_back:
                ((Activity) getContext()).finish();
                break;
            case R.id.title_edit:
                Toast.makeText(getContext(), "Edit", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void findViewById() {
        titleBack = findViewById(R.id.title_back);
        titleEdit = findViewById(R.id.title_edit);
    }

    private void setOnClickListener() {
        titleBack.setOnClickListener(this);
        titleEdit.setOnClickListener(this);
    }


}
