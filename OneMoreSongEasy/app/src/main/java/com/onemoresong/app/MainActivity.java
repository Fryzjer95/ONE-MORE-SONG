package com.onemoresong.app;
import android.Manifest;import android.app.Activity;import android.content.Intent;import android.content.pm.PackageManager;import android.graphics.Color;import android.os.*;import android.webkit.*;
public class MainActivity extends Activity{
 public static WebView web;
 @Override public void onCreate(Bundle b){super.onCreate(b);getWindow().setStatusBarColor(Color.rgb(5,3,10));getWindow().setNavigationBarColor(Color.rgb(5,3,10));web=new WebView(this);WebSettings s=web.getSettings();s.setJavaScriptEnabled(true);s.setDomStorageEnabled(true);s.setMediaPlaybackRequiresUserGesture(false);CookieManager.getInstance().setAcceptCookie(true);CookieManager.getInstance().setAcceptThirdPartyCookies(web,true);web.setWebViewClient(new WebViewClient());web.setWebChromeClient(new WebChromeClient());setContentView(web);web.loadUrl("file:///android_asset/index.html");if(Build.VERSION.SDK_INT>=33&&checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)!=PackageManager.PERMISSION_GRANTED)requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS},1);Intent i=new Intent(this,MusicService.class);if(Build.VERSION.SDK_INT>=26)startForegroundService(i);else startService(i);}
 @Override public void onBackPressed(){if(web!=null&&web.canGoBack())web.goBack();else super.onBackPressed();}
}
