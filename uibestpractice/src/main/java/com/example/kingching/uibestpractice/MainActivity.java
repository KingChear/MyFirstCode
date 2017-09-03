package com.example.kingching.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView msgRecyclerView;
    private EditText inputText;
    private Button send;

    private List<Msg> msgList = new ArrayList<>();
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        setOnClickListener();

        initMsgs();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        msgAdapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(msgAdapter);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.send:
                String content = inputText.getText().toString();
                Msg msg = new Msg(content, Msg.TYPE_SENT);
                msgList.add(msg);
                msgAdapter.notifyItemInserted(msgList.size() - 1);
                msgRecyclerView.scrollToPosition(msgList.size() - 1);
                inputText.setText("");
                break;
            default:
                break;
        }
    }

    private void findViewById() {
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
    }

    private void setOnClickListener() {
        send.setOnClickListener(this);
    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello guy", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
    }
}
