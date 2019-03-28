package com.example.android.webbrowser;

import android.app.Activity;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends Activity {

    WebView mwebView;
    EditText mAddressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent sentIntent = getIntent();
        String action = sentIntent.getAction();

        mwebView = findViewById(R.id.wv_web_content);
        mAddressBar = findViewById(R.id.et_address_bar);

        mwebView.setWebViewClient( new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });



        WebSettings webSettings = mwebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        if (Build.VERSION.SDK_INT >= 19)
        {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

        mwebView.loadUrl("https://www.google.com");
        mAddressBar.setText(mwebView.getUrl());
        if(action != null)
        {
            String url = sentIntent.getData().toString();
            mwebView.loadUrl(url);
            mAddressBar.setText(mwebView.getUrl());
        }
    }
}
