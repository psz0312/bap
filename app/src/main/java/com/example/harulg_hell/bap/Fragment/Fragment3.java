package com.example.harulg_hell.bap.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.harulg_hell.bap.R;

import static com.example.harulg_hell.bap.R.id.webView;

public class Fragment3 extends Fragment {

    public static WebView myWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);

        myWebView = (WebView) rootView.findViewById(webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.loadUrl("https://dgucoop.dongguk.edu:44649/store/store.php?w=4&l=1");


        return rootView;

    }

}
