package com.soialab.askaruly.pdfviewer_usage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PDFView pdfView = (PDFView)findViewById(R.id.pdfView);

        pdfView.fromAsset("aa.pdf").load();
    }
}
