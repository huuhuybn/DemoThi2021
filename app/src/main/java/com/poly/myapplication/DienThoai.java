package com.poly.myapplication;

public class DienThoai {
    String ID;
    String NAME;
    String PRICE;
    String PRO_ID;

    public DienThoai(String ID, String NAME, String PRICE, String PRO_ID) {
        this.ID = ID;
        this.NAME = NAME;
        this.PRICE = PRICE;
        this.PRO_ID = PRO_ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getPRO_ID() {
        return PRO_ID;
    }

    public void setPRO_ID(String PRO_ID) {
        this.PRO_ID = PRO_ID;
    }
}
