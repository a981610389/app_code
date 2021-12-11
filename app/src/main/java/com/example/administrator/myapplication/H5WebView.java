package com.example.administrator.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;

public class H5WebView  extends Activity {
    private WebView v;

    @SuppressLint({"MissingSuperCall", "JavascriptInterface"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.h5_main);

        WebView v = (WebView)findViewById(R.id.main_web_view);
        v.getSettings().setJavaScriptEnabled(true);
        v.addJavascriptInterface(new JavascriptCloseInterface(), "darren");

        v.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                try{
                    Uri uri = Uri.parse(url);
                    if(uri.getScheme().equals("js")){
                        if(uri.getAuthority().equals("webview")){
                            finish();
                        }
                        return true;
                    }
                }catch (Exception e){
                    Log.i("jw", "err:"+Log.getStackTraceString(e));
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

        });

        String path = "file:///android_asset/dist/index.html";
        v.loadUrl(path);
    }

    private class JavascriptCloseInterface  {
        public String hehe = "231";
        public void goHome(String p){
            finish();
        }
    }
}
