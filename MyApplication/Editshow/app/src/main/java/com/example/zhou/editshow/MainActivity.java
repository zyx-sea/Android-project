package com.example.zhou.editshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取xml的button组件的id
        Button button = (Button) findViewById(R.id.but_1);
        //设置按钮点击事件监听
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //获取xml的EditText组件的id
                EditText edit = (EditText) findViewById(R.id.edit);
                ////获取xml的EditText输入内容
                CharSequence editvalue = edit.getText();
                ////获取xml的TextView组件的id
                TextView text = (TextView) findViewById(R.id.text);
                //将获取的内容显示在textview中
                text.setText(editvalue);
            }
        });
    }

    }
