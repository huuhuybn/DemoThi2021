package com.poly.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MySqliteHelper extends SQLiteOpenHelper {
    // String ID;
//   String NAME;
//   String PRICE;
//   String PRO_ID;
    String table_phone = "" +
            "create table phone(ID interger primary Key " +
            ",NAME varchar, PRICE FLOAT,PRO_ID VARCHAR)";

    Context mContext;

    public MySqliteHelper(Context context) {
        super(context, "data.abc", null, 1);
        mContext = context;
    }

    public void themP(DienThoai dienThoai) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", dienThoai.ID);
        values.put("NAME", dienThoai.NAME);
        values.put("PRICE", dienThoai.PRICE);
        values.put("PRO_ID", dienThoai.PRO_ID);
        long kq = database.insert("phone", null, values);
        if (kq > 0) {
            Toast.makeText(mContext, "THANH CONG", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mContext, "KHONG THANH CONG", Toast.LENGTH_LONG).show();
        }
    }

    public void sua(DienThoai dienThoai) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put("ID", dienThoai.ID);
        values.put("NAME", dienThoai.NAME);
        values.put("PRICE", dienThoai.PRICE);
        values.put("PRO_ID", dienThoai.PRO_ID);
        long kq = database.update("phone", values, "ID=?",
                new String[]{dienThoai.ID});
        if (kq > 0) {
            Toast.makeText(mContext, "THANH CONG", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mContext, "KHONG THANH CONG", Toast.LENGTH_LONG).show();
        }
    }

    public void xoa(DienThoai dienThoai) {
        SQLiteDatabase database = getWritableDatabase();
        long kq = database.delete("phone", "ID=?",
                new String[]{dienThoai.ID});
        if (kq > 0) {
            Toast.makeText(mContext, "THANH CONG", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mContext, "KHONG THANH CONG", Toast.LENGTH_LONG).show();
        }
    }

    public ArrayList<DienThoai> danhSachPhone() {
        ArrayList<DienThoai> dienThoais = new ArrayList<>();
        String getAll = "select * from phone";
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery(getAll, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String ID = cursor.getString(0);
                String NAME = cursor.getString(1);
                String PRICE = cursor.getString(2);
                String PRO_ID = cursor.getString(3);

                DienThoai dienThoai = new DienThoai(ID,
                        NAME,
                        PRICE,
                        PRO_ID);
                dienThoais.add(dienThoai);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return dienThoais;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_phone);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
