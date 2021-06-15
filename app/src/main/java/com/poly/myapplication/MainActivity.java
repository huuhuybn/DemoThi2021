package com.poly.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    // tai slide 8, tao du an moi
    // Webview trong android
    // Http request trong android

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);

//        webView.loadUrl("https://vnexpress.net");
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                Toast.makeText(MainActivity.this,url,Toast.LENGTH_LONG).show();
//            }
//        });

        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<p>I am normal</p>\n" +
                "<p style=\"color:red;\">I am red</p>\n" +
                "<p style=\"color:blue;\">I am blue</p>\n" +
                "<p style=\"font-size:50px;\">I am big</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
        webView.loadData(html, "text/html", "utf-8");

        // 1 . khởi tạo 1 thread mới .
        // 2 . Sử dụng AsyncTask
        // 3. Lấy thông tin hiển thị từ InputStream và Scanner
        String url = "https://raw.githubusercontent.com/huuhuybn/BrightLife/master/README.md";
        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    URL url1 = new URL(url);
                    HttpsURLConnection connection = (HttpsURLConnection)
                            url1.openConnection();
                    InputStream inputStream = connection.getInputStream();
                    String data = "";
                    Scanner scanner = new Scanner(inputStream);
                    while (scanner.hasNext()){
                        data += scanner.nextLine();
                    }
                    scanner.close();
                    return data;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                Toast.makeText(MainActivity.this,o.toString(),Toast.LENGTH_LONG).show();

            }
        };
        asyncTask.execute();

    }
}