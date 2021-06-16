package com.poly.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PhoneAdapter extends BaseAdapter {

    ArrayList<DienThoai> dienThoais;

    public PhoneAdapter(ArrayList<DienThoai> dienThoais) {
        this.dienThoais = dienThoais;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from
                (parent.getContext()).inflate(R.layout.row, parent, false);
        Button xoa;
        TextView textView;
        xoa = view.findViewById(R.id.xoa);
        textView = view.findViewById(R.id.textView);
        DienThoai dienThoai = dienThoais.get(position);
        String thongtin = dienThoai.ID + " : " + dienThoai.NAME
                + " : " + dienThoai.PRICE + " : " + dienThoai.PRO_ID;
        textView.setText(thongtin);
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySqliteHelper mySqliteHelper = new MySqliteHelper(parent.getContext());
                mySqliteHelper.xoa(dienThoai);
                dienThoais.remove(dienThoai);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    @Override
    public int getCount() {
        return dienThoais.size();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
