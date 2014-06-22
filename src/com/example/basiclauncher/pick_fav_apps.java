package com.example.basiclauncher;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tomer on 21/06/14.
 */
public class pick_fav_apps extends Activity {
    PackageManager packageManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        packageManager = getPackageManager();
        AlertDialog.Builder app_dialog = new AlertDialog.Builder(pick_fav_apps.this);
        final ListView apps = new ListView(getApplicationContext());
        final PackageManager packageManager = getPackageManager();
        final Intent mainIntent = new Intent(Intent.ACTION_MAIN,null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        final List <ApplicationInfo> applicationInfoList = getAllInstalledApplications(getApplicationContext());
        final SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this).edit();




        ListAdapter Adapter = new Listadapter_two(this,applicationInfoList,packageManager);
        apps.setAdapter(Adapter);
        apps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ApplicationInfo PackInfo = applicationInfoList.get(position);
                String packagename = PackInfo.packageName;
                edit.putString("packagename_1", packagename);
                edit.putBoolean("initialized",true);
                edit.commit();
                startActivity(new Intent(getApplicationContext(),pick_fav_apps_2.class));
                finish();
            }
        });
        app_dialog.setTitle("Pick your favorite app");
        app_dialog.setView(apps);
        app_dialog.show();


    }


    public  List<ApplicationInfo> getAllInstalledApplications(Context context) {
        int i;
        List<ApplicationInfo> installedApps = context.getPackageManager().getInstalledApplications(PackageManager.PERMISSION_GRANTED);
        List<ApplicationInfo> launchableInstalledApps = new ArrayList<ApplicationInfo>();

        for( i=0; i<installedApps.size(); i++){
            if(context.getPackageManager().getLaunchIntentForPackage(installedApps.get(i).packageName) != null){
                //If you're here, then this is a launch-able app
                launchableInstalledApps.add(installedApps.get(i));
            }
        }
        List<ApplicationInfo> apps = launchableInstalledApps;
        Collections.sort(apps, new ApplicationInfo.DisplayNameComparator(packageManager));


        return apps;
    }

}
