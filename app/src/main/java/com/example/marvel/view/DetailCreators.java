package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.example.marvel.R;
import com.example.marvel.model.creators.ResultsCreators;

public class DetailCreators extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creators_detail);

        progressBar = findViewById(R.id.progressBar);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.detailColor));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.detailColor));

        if (getIntent() != null) {
            ResultsCreators.Data.Creators creators = getIntent().getExtras().getParcelable("Creator");
            WebView webView = findViewById(R.id.webview);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new PeterHenryWebClient());
            webView.setWebChromeClient(new WebChromeClient(){
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    if(newProgress < 100 && progressBar.getVisibility() == ProgressBar.GONE){
                        progressBar.setVisibility(ProgressBar.VISIBLE);
                    }
                    progressBar.setProgress(newProgress);
                    if(newProgress == 100) {
                        progressBar.setVisibility(ProgressBar.GONE);
                    }
                }
            });
            webView.loadUrl(creators.getUrls().get(0).getUrl());
        }
    }
}