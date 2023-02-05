package com.soialab.askaruly.loadhrml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView)findViewById(R.id.webview);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/web/contoh.html");
    }
}
