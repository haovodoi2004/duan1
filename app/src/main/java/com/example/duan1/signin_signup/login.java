package com.example.duan1.signin_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.duan1.Dao.Khachhangdao;
import com.example.duan1.MainActivity;
import com.example.duan1.R;
import com.google.android.material.textfield.TextInputEditText;

public class login extends AppCompatActivity {

    Button btdn,btdk;
    TextInputEditText eduser,edpass;
    Khachhangdao khachhangdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        btdn=findViewById(R.id.button);
        btdk=findViewById(R.id.button2);
        eduser=findViewById(R.id.user);
        edpass=findViewById(R.id.pass);
        khachhangdao=new Khachhangdao(login.this);
        btdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login.this, dangky.class);
                startActivity(intent);
                finish();
            }
        });
        btdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t=eduser.getText().toString();
                String tt=edpass.getText().toString();
                Boolean ttt=khachhangdao.chechlogin(t,tt);
                if(eduser.getText().length()==0||edpass.getText().length()==0){
                    Toast.makeText(login.this, "phải nhập đủ tất cả các trường dữ liệu", Toast.LENGTH_SHORT).show();
                }else{
                   if(ttt==true){
                       Intent intent1=new Intent(login.this, MainActivity.class);
                       startActivity(intent1);
                       finish();
                       Toast.makeText(login.this, "bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                   }else{
                       Toast.makeText(login.this, "mật khẩu hoặc tên đăng nhập sai ", Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });
    }
}