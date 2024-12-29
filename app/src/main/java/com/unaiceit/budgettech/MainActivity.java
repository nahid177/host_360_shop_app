package com.unaiceit.budgettech;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private ProgressBar progressBar;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);


        // Initialize WebView
        webView = findViewById(R.id.webView);

        // Enable JavaScript (if needed)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); // Enable DOM storage API        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        // Ensure links open within the WebView
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){


            @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if(newProgress < 100 && progressBar.getVisibility() == ProgressBar.GONE){
                progressBar.setVisibility(ProgressBar.VISIBLE);
            }
            progressBar.setProgress(newProgress);
            if(newProgress == 100){
                progressBar.setVisibility(ProgressBar.GONE);
            }
        }
    });

        // Load a responsive website or local HTML file
        webView.loadUrl("https://www.budgettech360.com/"); // Replace with your desired URL
    }
    // Handle back button to navigate within WebView
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        } else{
            super.onBackPressed();
        }
    }

    // Handle WebView layout changes for responsiveness
    @Override
    public void onConfigurationChanged(@NonNull android.content.res.Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        // You can handle specific configuration changes here if needed
    }
}


