package com.monkey.ListAndRecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListVew;
    private SecondAdapter mSecondAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<String> mDatas;
    private InfoAdapter mInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initListView();
        //initRecyclerView();
    }
    private void initData() {
        mDatas = new ArrayList<String>();
        for(int i=0;i<100;i++){
            mDatas.add("测试数据000"+i);
        }
    }
    private void initRecyclerView() {
        mRecyclerView = (RecyclerView)findViewById(R.id.rcv);
        mInfoAdapter = new InfoAdapter(mDatas,this);
        mRecyclerView.setAdapter(mInfoAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }


    private void initListView() {
        mListVew = (ListView) findViewById(R.id.lv);
        mSecondAdapter = new SecondAdapter(mDatas,this);
        mListVew.setAdapter(mSecondAdapter);
    }
}
