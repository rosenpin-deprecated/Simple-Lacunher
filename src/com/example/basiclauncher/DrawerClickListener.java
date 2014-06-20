package com.example.basiclauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class DrawerClickListener implements OnItemClickListener {

    public static String lastopenedapp;
	Context mContext;
    Main.Pac[] pacsForAdapter;
	PackageManager pmForListener;
	
	public DrawerClickListener(Context c, Main.Pac[] pacs, PackageManager pm){
		mContext=c;
		pacsForAdapter=pacs;
		pmForListener = pm;
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
			Intent launchIntent = new Intent(Intent.ACTION_MAIN);
			launchIntent.addCategory(Intent.CATEGORY_LAUNCHER);
			//ComponentName cp = new ComponentName(pacsForAdapter[pos].packageName, pacsForAdapter[pos].name);
			//launchIntent.setComponent(cp);
            lastopenedapp = pacsForAdapter[pos].packageName;
            Intent LaunchIntent = Main.packageManager.getLaunchIntentForPackage(pacsForAdapter[pos].packageName);
            mContext.startActivity(LaunchIntent);
            Main.most = pacsForAdapter[pos].packageName;
        try {
            if (!Main.list.contains(pacsForAdapter[pos].packageName)) {
                Main.list.add(0, Main.most);
                Main.list_int.add(0, Main.list.size());
                System.out.println("most used is " + Main.list + String.valueOf(Main.list_int));
            }
            else{
                Main.list.remove(pacsForAdapter[pos].packageName);
                Main.list.add(0, Main.most);
                Main.list_int.add(0, Main.list.size());
                System.out.println("most used is " + Main.list + String.valueOf(Main.list_int));
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
	}

}
