package com.example.zhou.editshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 2016/11/17.
 */

public class ArrayActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        ListView listview;
        List<String> data;
        int i=1;
        ArrayAdapter adapter;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //初始化ListView
        listview = (ListView) findViewById(R.id.list_item);
        //step1:构造列表所需的数据
        data=new ArrayList<String>();
        for(;i<5;i++){
            data.add("列表"+i);
        }
        data.add("列表1");
        //step2:构建适配器
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        //step3:设置适配器
        listview.setAdapter(adapter);
    }
}
