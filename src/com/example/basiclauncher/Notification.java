package com.example.basiclauncher;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by tomer on 19/06/14.
 */
public class Notification extends NotificationListenerService {
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        PackageManager packageManager = getPackageManager();
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        PackageManager packageManager = getPackageManager();

    }
}
