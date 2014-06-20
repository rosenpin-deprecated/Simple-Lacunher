package com.example.basiclauncher;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SlidingDrawer;
import android.widget.TextView;


public class DrawerLongClickListener implements OnItemLongClickListener {

    Context mContext;
    RelativeLayout homeViewForAdapter;
    Main.Pac[] pacsForListener;
    public static String pn = null;

    public DrawerLongClickListener(Context ctxt, SlidingDrawer slidingDrawer, RelativeLayout homeView,Main.Pac[] pacs ){
        mContext = ctxt;
        homeViewForAdapter =homeView;
        pacsForListener = pacs;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View item, int pos,
                                   long arg3) {

        pn = pacsForListener[pos].packageName;
        Log.d("package name", pn);
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:"+pn));
        mContext.startActivity(intent);
        return false;
    }

}
