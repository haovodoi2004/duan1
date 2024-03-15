package com.example.duan1.signin_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan1.Dao.Khachhangdao;
import com.example.duan1.Model.Khachhang;
import com.example.duan1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class dangky extends AppCompatActivity {
TextInputEditText eduser,edmk,edmk2,edname,ednamsinh,eddiachi,edsdt;
Button btok,bthuy;
Khachhangdao khachhangdao;
int o=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        eduser=findViewById(R.id.user);
        edmk=findViewById(R.id.edmk);
        edmk2=findViewById(R.id.edmk2);
        edname=findViewById(R.id.edname);
        ednamsinh=findViewById(R.id.eddate);
        eddiachi=findViewById(R.id.ediachi);
        edsdt=findViewById(R.id.edphone);
        btok=findViewById(R.id.button3);
        bthuy=findViewById(R.id.button4);
        khachhangdao=new Khachhangdao(dangky.this);
        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edname.getText().length()==0||eddiachi.getText().length()==0||edmk.getText().length()==0||edmk2.getText().length()==0||edsdt.getText().length()==0||ednamsinh.getText().length()==0||eduser.getText().length()==0){
                    Toast.makeText(dangky.this, "bạn bắt buộc phải nhập đủ tất cả trường dữ liệu", Toast.LENGTH_SHORT).show();
                }else{
                    if(!edmk.getText().toString().equals(edmk2.getText().toString())){
                        Toast.makeText(dangky.this, "mật khẩu nhập lại không trùng khớp", Toast.LENGTH_SHORT).show();
                    }else{
                        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
                        String t=ednamsinh.getText().toString();
                        Khachhang khachhang=new Khachhang();
                        khachhang.name=eduser.getText().toString();
                        khachhang.user=eduser.getText().toString();
                        khachhang.mk=edmk.getText().toString();
                        khachhang.phone=Integer.parseInt(edsdt.getText().toString());
                        khachhang.address=eddiachi.getText().toString();
                        try {
                            khachhang.date=dateFormat.parse(t);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        khachhangdao.insert(khachhang);
                        o++;
                        Toast.makeText(dangky.this, "gia tri la "+o, Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });

    }

}