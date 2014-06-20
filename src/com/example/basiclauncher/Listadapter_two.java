package com.example.basiclauncher;

/**
 * Created by tomer on 18/06/14.
 */
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class Listadapter_two extends BaseAdapter{

    List<ApplicationInfo> packageList;
    Activity context;
    PackageManager packageManager;


    public Listadapter_two(Activity context, List <ApplicationInfo> packageList,
                       PackageManager packageManager) {
        super();
        this.context = context;
        this.packageList = packageList;
        this.packageManager = packageManager;

    }

    private class ViewHolder {
        TextView apkName;
    }

    public int getCount() {
        return packageList.size();
    }

    public Object getItem(int position) {
        return packageList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.apkName = (TextView) convertView
                    .findViewById(R.id.textView1);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        ApplicationInfo packageInfo = (ApplicationInfo) getItem(position);

        Drawable appIcon = packageInfo.loadIcon(packageManager);
        String appName = packageInfo.loadLabel(packageManager).toString();
        appIcon.setBounds(0, 0, 150, 150);
        holder.apkName.setCompoundDrawables(appIcon, null, null, null);
        holder.apkName.setCompoundDrawablePadding(15);
        holder.apkName.setText(appName);

        return convertView;

    }


}