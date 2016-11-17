package com.example.zhou.editshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by zhou on 2016/11/17.
 */

public class ChooseActivity extends AppCompatActivity {
    public String str1;
    public String str2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Button submit= (Button) findViewById(R.id.submit);
        //设置监听
        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                RadioGroup group= (RadioGroup) findViewById(R.id.radiogroup);
                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

                    @Override
                    public void onCheckedChanged(RadioGroup arg0, int arg1) {
                        int radioButtonId=arg0.getCheckedRadioButtonId();
                        RadioButton radiobutton= (RadioButton) ChooseActivity.this.findViewById(radioButtonId);
                        str1="性别为："+radiobutton.getText();
                    }
                });
                str2=str1+"\n爱好是：\n";
                CheckBox checkbox_1= (CheckBox) findViewById(R.id.checkbox_1);
                CheckBox checkbox_2= (CheckBox) findViewById(R.id.checkbox_2);
                CheckBox checkbox_3= (CheckBox) findViewById(R.id.checkbox_3);
                CheckBox checkbox_4= (CheckBox) findViewById(R.id.checkbox_4);
                
                if (checkbox_1.isChecked()){
                    str2=str2+checkbox_1.getText()+"\n";
                }
                if (checkbox_2.isChecked()){
                    str2=str2+checkbox_2.getText()+"\n";
                }if (checkbox_3.isChecked()){
                    str2=str2+checkbox_3.getText()+"\n";
                }if (checkbox_4.isChecked()){
                    str2=str2+checkbox_4.getText()+"\n";
                }
                DisplayToast(str2);
            }

            private void DisplayToast(String str ) {
                Toast.makeText(ChooseActivity.this,str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
