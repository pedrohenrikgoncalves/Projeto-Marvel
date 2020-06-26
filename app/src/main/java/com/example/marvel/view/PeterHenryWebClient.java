package com.example.marvel.view;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PeterHenryWebClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
