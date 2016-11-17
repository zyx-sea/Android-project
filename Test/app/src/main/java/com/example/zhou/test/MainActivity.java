package com.example.zhou.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText phoneText;
    private EditText contentText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
        phoneText=(EditText)  this.findViewById(R.id.phone);
        contentText=(EditText) this.findViewById(R.id.content);
        Button button=(Button) this.findViewById(R.id.button);
        button.setOnClickListener(new ButtonClickListener());
}
    private final class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String phone=phoneText.getText().toString();
            String content=contentText.getText().toString();
            SmsManager manager=SmsManager.getDefault();
            ArrayList<String> texts=manager.divideMessage(content);
            for (String text:texts){
                manager.sendTextMessage(phone,null,text,null,null);
            }
            Toast.makeText(MainActivity.this,R.string.success,Toast.LENGTH_LONG).show();
        }
    }
}
