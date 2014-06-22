package com.example.basiclauncher;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.service.notification.StatusBarNotification;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

/**
 * Created by tomer on 21/06/14.
 */
public class NotificationServices extends AccessibilityService {
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(),"opened",100).show();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Toast.makeText(getApplicationContext(), "Shit Just Happened 3", 100).show();
//Code when the event is caught
    }
    @Override
    public void onInterrupt() {
        Toast.makeText(getApplicationContext(), "Shit Just Happened 2", 100).show();

    }

    @Override
    protected void onServiceConnected() {
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.feedbackType = 1;
        info.eventTypes = AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED;
        info.notificationTimeout = 100;
        setServiceInfo(info);
        Toast.makeText(getApplicationContext(), "Shit Just Happened", 100).show();
    }
    public StatusBarNotification[] getActiveNotifications (){
        Toast.makeText(getApplicationContext(),"fuck me hard in my tussi",10000).show();

        return getActiveNotifications();
    }
    public void onNotificationPosted (StatusBarNotification sbn)
    {
    }

}