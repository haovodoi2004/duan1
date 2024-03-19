package com.example.duan1.Model;

import java.util.Date;

public class Khachhang {
    public int makh;
    public Date date;
    public String name;
    public String address;
    public String email;
    public String mk;
    public int phone;

    public Khachhang() {
    }

    public Khachhang(int makh, Date date, String name, String address, String email, String mk, int phone) {
        this.makh = makh;
        this.date = date;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mk = mk;
        this.phone = phone;
    }
}
