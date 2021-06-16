package com.poly.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private EditText id;
    private EditText name;
    private EditText price;
    private EditText product;
    private Button them;
    private Button sua;
    private ListView livList;

    ArrayList<DienThoai> dienThoais = new ArrayList<>();
    PhoneAdapter phoneAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySqliteHelper mySqliteHelper = new MySqliteHelper(MainActivity.this);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        product = findViewById(R.id.product);
        them = findViewById(R.id.them);
        sua = findViewById(R.id.sua);
        livList = findViewById(R.id.livList);

        dienThoais = mySqliteHelper.danhSachPhone();
        phoneAdapter = new PhoneAdapter(dienThoais);
        livList.setAdapter(phoneAdapter);

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = id.getText().toString();
                String NAME = name.getText().toString();
                String PRICE = price.getText().toString();
                String PRO_ID = product.getText().toString();
                DienThoai dienThoai = new DienThoai(ID,
                        NAME,
                        PRICE,
                        PRO_ID);
                mySqliteHelper.sua(dienThoai);
                dienThoais = new ArrayList<>();
                dienThoais = mySqliteHelper.danhSachPhone();
                phoneAdapter = new PhoneAdapter(dienThoais);
                livList.setAdapter(phoneAdapter);
            }
        });

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = id.getText().toString();
                String NAME = name.getText().toString();
                String PRICE = price.getText().toString();
                String PRO_ID = product.getText().toString();

                DienThoai dienThoai = new DienThoai(ID,
                        NAME,
                        PRICE,
                        PRO_ID);
                mySqliteHelper.themP(dienThoai);
                dienThoais = new ArrayList<>();
                dienThoais = mySqliteHelper.danhSachPhone();
                phoneAdapter = new PhoneAdapter(dienThoais);
                livList.setAdapter(phoneAdapter);

            }
        });


    }
}