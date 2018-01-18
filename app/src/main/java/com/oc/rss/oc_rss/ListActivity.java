package com.oc.rss.oc_rss;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oc.rss.oc_rss.adapter.MyAdapter;

public class ListActivity extends Activity {

    RecyclerView recyclerViewList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);
        recyclerViewList = (RecyclerView)findViewById(R.id.rvList);

        recyclerViewList.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter();
        recyclerViewList.setAdapter(myAdapter);

    }
}
