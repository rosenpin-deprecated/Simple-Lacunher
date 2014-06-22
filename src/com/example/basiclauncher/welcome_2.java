package com.example.basiclauncher;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by tomer on 21/06/14.
 */
public class welcome_2 extends Activity {
    CheckBox choose_fav;
    CheckBox event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_2);
        choose_fav = (CheckBox)findViewById(R.id.choose_fav_apps);
        event = (CheckBox)findViewById(R.id.enable_smart_event);
        Button but = (Button)findViewById(R.id.go);
        final SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(welcome_2.this).edit();

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choose_fav.isChecked()){
                    startActivity(new Intent(getApplicationContext(),pick_fav_apps.class));
                    overridePendingTransition(R.anim.left_right, R.anim.right_left);
                }
                else {
                    startActivity(new Intent(getApplicationContext(),Main.class));
                    edit.putBoolean("initialized",true).commit();
                }
                if(event.isChecked()){
                    edit.putBoolean("event",true).commit();
                }
                else {
                    edit.putBoolean("event", false).commit();
                }
            }
        });

    }
}
