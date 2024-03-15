package com.example.duan1.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DPHelper extends SQLiteOpenHelper {
    public DPHelper(@Nullable Context context) {

        super(context, "bang", null, 4);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String t="CREATE TABLE KHACHHANG(maKH INTEGER PRIMARY KEY AUTOINCREMENT,NAMSINH TEXT NOT NULL,USERNAME TEXT NOT NULL,hoTen TEXT NOT NULL,diaChi TEXT NOT NULL,soDT INTEGER NOT NULL, matKhau TEXT NOT NULL)";
        sqLiteDatabase.execSQL(t);

        String tt="CREATE TABLE ADMIN(maAD INTEGER PRIMARY KEY AUTOINCREMENT,NAMSINH TEXT NOT NULL,USERNAME TEXT NOT NULL,hoTen TEXT NOT NULL,diaChi TEXT NOT NULL,soDT INTEGER NOT NULL,matKhau TEXT NOT NULL )";
        sqLiteDatabase.execSQL(tt);

        String ttt="CREATE TABLE LOAIDOUONG(maLoai INTEGER PRIMARY KEY AUTOINCREMENT,tenLoai TEXT NOT NULL)";
        sqLiteDatabase.execSQL(ttt);

        String tttt="CREATE TABLE DOUONG(maDU INTEGER PRIMARY KEY AUTOINCREMENT,tenDU TEXT NOT NULL,CHATLIEU TEXT NOT NULL,giaDU INTEGER NOT NULL,thongTin TEXT NOT NULL,maLoai INTEGER REFERENCES LOAIDONGHO(maLoai))";
        sqLiteDatabase.execSQL(tttt);

        String ttttt="CREATE TABLE HOADON(maHD INTEGER PRIMARY KEY AUTOINCREMENT ,maAD TEXT REFERENCES ADMIN(maAD),maDH INTEGER REFERENCES DONGHO(maDH),tenDONGHO TEXT NOT NULL,gia INTEGER NOT NULL,ngay DATE NOT NULL,TRANGTHAI TEXT NOT NULL)";
        sqLiteDatabase.execSQL(ttttt);

        String tttttt="CREATE TABLE CHITIETDONHANG(maHD INTEGER REFERENCES HOADON(maHD),maAD INTEGER REFERENCES ADMIN(maAD),maKH INTEGER REFERENCES KHACHHANG(maKH),THONGTIN TEXT NOT NULL,giaDH INTEGER NOT NULL,soDT INTEGER NOT NULL,trangThai TEXT NOT NULL,soLuong INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(tttttt);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
           if(i!=i1){
              sqLiteDatabase.execSQL("DROP TABLE IF EXISTS KHACHHANG");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ADMIN");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOAIDOUONG");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DOUONG");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS HOADON");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CHITIETDONHANG");
               onCreate(sqLiteDatabase);
           }
    }
}
