package com.example.basiclauncher;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by tomer on 17/06/14.
 */
public class dialog extends Activity {
    Button wallpaper_but,uninstall_but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        wallpaper_but = (Button)findViewById(R.id.wallpaper);
    }
}
