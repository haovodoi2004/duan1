package com.example.duan1.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.Database.DPHelper;
import com.example.duan1.Model.Khachhang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Khachhangdao {
    Context context;
    DPHelper dpHelper;
    SQLiteDatabase sqLiteDatabase;

    public Khachhangdao(Context context) {
        this.context = context;
        dpHelper=new DPHelper(context);
        sqLiteDatabase=dpHelper.getWritableDatabase();
    }
    public void insert(Khachhang khachhang){
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        ContentValues values=new ContentValues();
        values.put("maKH",khachhang.makh+"");
        values.put("NAMSINH",dateFormat.format(khachhang.date));
        values.put("EMAIL",khachhang.email);
        values.put("hoTen",khachhang.name);
        values.put("diaChi",khachhang.address);
        values.put("soDT",khachhang.phone+"");
        values.put("matKhau",khachhang.mk);
        sqLiteDatabase.insert("KHACHHANG",null,values);
    }
    public void update(Khachhang khachhang){
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        ContentValues values=new ContentValues();
        values.put("NAMSINH",dateFormat.format(khachhang.date));
        values.put("EMAIL",khachhang.email);
        values.put("hoTen",khachhang.name);
        values.put("diaChi",khachhang.address);
        values.put("soDT",khachhang.phone+"");
        values.put("matKhau",khachhang.mk);
        sqLiteDatabase.update("KHACHHANG",values,"maKH=?",new String[]{khachhang.makh+""});
    }
    public void delete(String t){
        sqLiteDatabase.delete("KHACHHANG",t,new String[]{t});
    }

    public ArrayList<Khachhang> getall(){
        String t="select * form KHACHHANG";
        return getdata(t);
    }

    public void getid(String tt){
        String t="select * form KHACHHANG where maKH=?";
        ArrayList<Khachhang> khachhangArrayList=getdata(t,tt);
    }

    public ArrayList<Khachhang> getdata(String sql, String...AStrings){
        ArrayList<Khachhang> khachhangArrayList=new ArrayList<>();
        Cursor cursor=sqLiteDatabase.rawQuery(sql,AStrings);
        while (cursor.moveToNext()){
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            String t= cursor.getString(cursor.getColumnIndex("NAMSINH"));
            Khachhang khachhang=new Khachhang();
            khachhang.makh=Integer.parseInt(cursor.getString(cursor.getColumnIndex("maKH")));
            khachhang.name=cursor.getString(cursor.getColumnIndex("hoTen"));
            khachhang.address=cursor.getString(cursor.getColumnIndex("diaChi"));
            khachhang.email=cursor.getString(cursor.getColumnIndex("EMAIL"));
            khachhang.phone=Integer.parseInt(cursor.getString(cursor.getColumnIndex("soDT")));
            khachhang.mk=cursor.getString(cursor.getColumnIndex("matKhau"));
            try {
                khachhang.date=dateFormat.parse(t);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            khachhangArrayList.add(khachhang);
        }
        return khachhangArrayList;
    }
    public boolean chechlogin(String t,String tt){
            Cursor cursor=sqLiteDatabase.rawQuery("select * from KHACHHANG where USERNAME=? and matKhau=?",new String[]{t,tt});
            return cursor.getCount()>0;

    }
}
