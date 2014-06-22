package com.example.basiclauncher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class board extends Activity {

    static URL url;
    static int code = 0;
    static RelativeLayout dynamic;
    static LayoutInflater inflater;
    static ScaleAnimation anim;
    static ArrayList<WebView> arraywebview;
    static int number = 1;
    private boolean opened = false;
    static Thread thread;
    static Context context;
    static Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        context = this;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        arraywebview = new ArrayList<WebView>();
        dynamic = (RelativeLayout) findViewById(R.id.relative);
        anim = new ScaleAnimation(1, 1, 0, 1);
        anim.setDuration(500);
        //inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // setContentView(R.layout.activity_main);
                getcardsfromserver();
            //createTimer();
        Button butt = (Button)findViewById(R.id.buttonnnnn);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),map.class));
            }
        });
    }

       // webView.set



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.main_acitivity_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id==R.id.action_refresh){
            dynamic.removeAllViews();
arraywebview.removeAll(arraywebview);
            number = 1;

                getcardsfromserver();
        }
        else if (id==R.id.action_home){
            RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, 280);
            ScaleAnimation anim2 = new ScaleAnimation(0, 1, 1, 1);
            anim2.setDuration(500);
            for (int i = 0; i<arraywebview.size(); i++){
                if (arraywebview.get(i).getHeight()>500){
                    arraywebview.get(i).setAnimation(anim2);
                    rllp.setMargins(arraywebview.get(i).getPaddingLeft(), i * 312, arraywebview.get(i).getPaddingRight(), arraywebview.get(i).getPaddingBottom());
                    arraywebview.get(i).setLayoutParams(rllp);


                }
                    arraywebview.get(i).setVisibility(View.VISIBLE);
//createTimer();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public static void addcard(URL url, boolean iffirsttime){


            final WebView webView = new WebView(context);
            webView.setClipToPadding(true);
       // webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, 280);
            if(!iffirsttime){
lp.setMargins(webView.getPaddingLeft(), arraywebview.size() * 312, webView.getPaddingRight(), webView.getPaddingBottom());}
            //Log.d("webview id below", String.valueOf(arraywebview.get(arraywebview.size() - 1).getId()));}
            webView.setLayoutParams(lp);
            // webView.setAnimation(anim);
            webView.loadUrl(url.toString());

            webView.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {


                    for (int i = 0; i < arraywebview.size(); i++) {
                        if (arraywebview.get(i) != v) {
                            arraywebview.get(i).setVisibility(View.GONE);
                        }
                    }
                    webView.setAnimation(anim);
                    webView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
                    webView.getSettings().setSupportZoom(true);
                    webView.getSettings().setBuiltInZoomControls(true);
                    webView.setVerticalScrollBarEnabled(true);
                    webView.setHorizontalScrollBarEnabled(true);
                    timer.cancel();
                    return true;
                }
            });

            dynamic.addView(webView);
             arraywebview.add(webView);}

    public static int if404(URL u) {

        try{
        HttpURLConnection huc =  (HttpURLConnection)  u.openConnection ();
        huc.setRequestMethod ("GET");  //OR  huc.setRequestMethod ("HEAD");
        huc.connect () ;
        code = huc.getResponseCode() ;}
        catch (IOException e){
            e.printStackTrace();
        }
        return code;
    }
    public void getcardsfromserver(){
while (number<=20){
            try {
                int testingnumber = 80+number;
                url = new URL("http://appsboard.bugs3.com/Joomla/Administator/component/content/article/77-board/"+testingnumber+"-testing"+number+"?tmpl=component&page=");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        if (if404(url)!=404){
            if (number==2){
                addcard(url, true);}
            else{
                addcard(url, false);}}
        number++;}

    }
    Runnable todo_on_timer=new Runnable(){
        @Override
        public void run() {

            dynamic.removeAllViews();
            arraywebview.removeAll(arraywebview);
            number = 1;

                getcardsfromserver();
        }
    };
    void TimerMethod(){
        this.runOnUiThread(todo_on_timer);
    }
    void createTimer(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethod();
            }
        },0,60000);
    }

    }
