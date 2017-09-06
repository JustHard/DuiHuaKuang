package com.example.mymsi.duihuakuang;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) this.findViewById(R.id.alterButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这只是一个提示对话框")//显示的消息内容
                        .setTitle("提示对话框");//对话框标题
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });
        Button btn2 = (Button) findViewById(R.id.loginButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();
                  final View dialogview = inflater.inflate(R.layout.login_dialog, null);
                builder.setView(dialogview)
                        .setTitle("Login")
                        // Add action buttons
                        .setPositiveButton("login", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // login
                                EditText userName = (EditText)dialogview.findViewById(R.id.editTextUserId);
                                String username = userName.getText().toString();
                                EditText passWord = (EditText)dialogview.findViewById(R.id.editTextPwd);
                                String password = passWord.getText().toString();
                                if(username.equals("abc") && password.equals("123")){
                                    Toast.makeText(MainActivity.this, "登入成功！", Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "登入错误！", Toast.LENGTH_LONG).show();
                                }
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cancel
                            }
                        });

                builder.show();
            }
        });

    }
}
