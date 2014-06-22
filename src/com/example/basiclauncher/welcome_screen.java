package com.example.basiclauncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by tomer on 21/06/14.
 */
public class welcome_screen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Button Con = (Button)findViewById(R.id.go);
        Con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), welcome_2.class));
                overridePendingTransition(R.anim.left_right,R.anim.right_left);
            }
        });
    }
}
