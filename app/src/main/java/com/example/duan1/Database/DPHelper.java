package com.example.duan1.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DPHelper extends SQLiteOpenHelper {
    public DPHelper(@Nullable Context context) {

        super(context, "bang", null, 5);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String t="CREATE TABLE KHACHHANG(maKH INTEGER PRIMARY KEY AUTOINCREMENT,NAMSINH TEXT NOT NULL,hoTen TEXT NOT NULL,diaChi TEXT NOT NULL,soDT INTEGER NOT NULL, matKhau TEXT NOT NULL,EMAIL TEXT NOT NULL)";
        sqLiteDatabase.execSQL(t);

        String tt="CREATE TABLE ADMIN(maAD INTEGER PRIMARY KEY AUTOINCREMENT,hoTen TEXT NOT NULL,diaChi TEXT NOT NULL,soDT INTEGER NOT NULL,matKhau TEXT NOT NULL ,EMAIL TEXT NOT NULL)";
        sqLiteDatabase.execSQL(tt);

        String ttt="CREATE TABLE LOAISANPHAM(maLoai INTEGER PRIMARY KEY AUTOINCREMENT,tenLoai TEXT NOT NULL)";
        sqLiteDatabase.execSQL(ttt);

        String tttt="CREATE TABLE SANPHAM(maDU INTEGER PRIMARY KEY AUTOINCREMENT,tenDU TEXT NOT NULL,giaDU INTEGER NOT NULL,thongTin TEXT NOT NULL,maLoai INTEGER REFERENCES LOAISANPHAM(maLoai))";
        sqLiteDatabase.execSQL(tttt);

        String ttttt="CREATE TABLE HOADON(maHD INTEGER PRIMARY KEY AUTOINCREMENT ,maKH TEXT REFERENCES KHACHHANG(maKH),maDH INTEGER REFERENCES DONGHO(maDH),GIA INTEGER NOT NULL,NGAY DATE NOT NULL)";
        sqLiteDatabase.execSQL(ttttt);

        String tttttt="CREATE TABLE CHITIETHOADON(MACTHD INTEGET PRIMARY KEY AUTOINCREMENT,maHD INTEGER REFERENCES HOADON(maHD),maSP INTEGER REFERENCES SANPHAM(maSP),soLuong INTEGER NOT NULL,TONGGIA INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(tttttt);

        String ttttttt="CREATE TABLE DANHGIA(MADG INTEGET PRIMARY KEY AUTOINCREMENT,maSP INTEGER REFERENCES SANPHAM(maSP),maKH INTEGER REFERENCES KHACHHANG(maKH),NOIDUNG TEXT NOT NULL,NGAYTAO DATE NOT NULL)";
        sqLiteDatabase.execSQL(ttttttt);

        String tttttttt="CREATE TABLE GIOHANG(MAGH INTEGET PRIMARY KEY AUTOINCREMENT,maKH INTEGER REFERENCES KHACHHANG(maKH),maSP INTEGER REFERENCES SANPHAM(maSP),soLuong INTEGER NOT NULL,GIA INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(tttttttt);

        String ttttttttt="CREATE TABLE THANHTOAN(MATT INTEGET PRIMARY KEY AUTOINCREMENT,maKH INTEGER REFERENCES KHACHHANG(maKH),maHD INTEGER REFERENCES HOADON(maHD),PHUONGTHUC INTEGER NOT NULL,SOTIEN INTEGER NOT NULL,TRANGTHAI INTEGER NOT NULL,THOIGIAN DATE NOT NULL)";
        sqLiteDatabase.execSQL(ttttttttt);
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
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS THANHTOAN");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS GIOHANG");
               sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DANHGIA");
               onCreate(sqLiteDatabase);
           }
    }
}
