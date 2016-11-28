package com.example.zhou.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDialogActivity extends AppCompatActivity {
    private Button button;
    private AlertDialog.Builder builder;
    private LayoutInflater inflater;
    private View loginView;


    public LoginDialogActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_list);
        button = (Button) findViewById(R.id.button);
        //创建监听器并注册给控件
        BtClickListener listener = new BtClickListener();
        button.setOnClickListener(listener);
    }

    public void createLoginDialog() {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("用户登录");
        builder.setIcon(android.R.drawable.ic_menu_myplaces);

        inflater = LayoutInflater.from(this);
        loginView = inflater.inflate(R.layout.login_dialog_activity, null);
        final EditText name;
        final EditText password;
        name = (EditText) loginView.findViewById(R.id.login_name);
        password = (EditText) loginView.findViewById(R.id.login_password);
        builder.setView(loginView);
        builder.setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String n = name.getText().toString();
                        String p = password.getText().toString();
                        Toast.makeText(LoginDialogActivity.this, "登录信息：" + n + "" + p, Toast.LENGTH_SHORT).show();
                    }
                }
        );
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        });
        builder.show();
    }

    private class BtClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId()==R.id.button) {
                //创建自定义布局对话框
                createLoginDialog();
            }
        }
    }
}
