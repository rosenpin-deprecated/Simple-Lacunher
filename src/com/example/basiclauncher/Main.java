package com.example.basiclauncher;

import android.app.*;
import android.bluetooth.BluetoothAdapter;
import android.content.*;
import android.content.pm.*;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.speech.RecognizerIntent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.*;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.animation.*;
import android.widget.*;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main extends Activity {
    protected static final int RESULT_SPEECH = 1;
    DrawerAdapter drawerAdapterObject;
    BounceScrollView drawerGrid;
    RelativeLayout homeView, container;
    int idd, number;
    class Pac{
        Drawable icon;
        String name;
        String packageName;
        String label;
    }
    RelativeLayout back;
    Spinner theme;
    float curBrightnessValue = 5;
    boolean notification = true;
    boolean light = false;
    Pac[] pacs;
    ScrollView settings_back;
    PackageManager pm;
    boolean save;
    ViewPager myPager;
    Button app_drawer,mic,refresh,short_one,short_two,short_three,short_four,short_five,short_six,short_seven,short_eight;
    AudioManager am;
    Timer myTimer;
    ImageView wifi,mobile_data,gps,rotate,airplane,bluetooth,flash,battery_saver;
    String packagename;
    String packagename_1,packagename_2,packagename_3,packagename_4,packagename_5,packagename_6,packagename_7,packagename_8,open_app;
    SharedPreferences sharedPreferences;
    PackageManager pack;
    SharedPreferences.Editor edit;
    SeekBar brightness_sb,volume;
    ScrollView left;
    Button recent1,recent2,recent3,recent4;
    View view;
    public static String most;
    public static ArrayList<String> list = new ArrayList<String>();
    public static ArrayList<Integer> list_int  = new ArrayList<Integer>();

    public static PackageManager packageManager;
    public static List<ApplicationInfo> getAllInstalledApplications(Context context) {
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
    public void shortclick(final View view) {
        idd = view.getId();
        switch (idd){
            case R.id.short_1:
                number = 1;
                break;
            case R.id.short_2:
                number = 2;
                break;
            case R.id.short_3:
                number = 3;
                break;
            case R.id.short_4:
                number = 4;
                break;
            case R.id.short_5:
                number = 5;
                break;
            case R.id.short_6:
                number = 6;
                break;
            case R.id.short_7:
                number = 7;
                break;
            case R.id.short_8:
                number = 8;
                break;
        }
        AlertDialog.Builder app_dialog = new AlertDialog.Builder(Main.this);
        ListView apps = new ListView(getApplicationContext());
        final PackageManager packageManager = getPackageManager();
        final Intent mainIntent = new Intent(Intent.ACTION_MAIN,null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        final List <ApplicationInfo> applicationInfoList = getAllInstalledApplications(getApplicationContext());




        ListAdapter Adapter = new Listadapter_two(this,applicationInfoList,packageManager);
        apps.setAdapter(Adapter);

        apps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ApplicationInfo PackInfo = applicationInfoList.get(position);
                packagename = PackInfo.packageName;
                switch (number){

                    case 1:
                        try {
                            short_one.setBackground(packageManager.getApplicationIcon(packagename));
                            edit.putString("packagename_1", packagename);
                            finish();
                            startActivity(new Intent(getApplicationContext(),Main.class));
                            short_one.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename);
                                    startActivity(LaunchIntent);
                                }
                            });
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"failed",100).show();

                        }
                        break;
                    case 2:
                        try {
                            short_two.setBackground(packageManager.getApplicationIcon(packagename));
                            edit.putString("packagename_2", packagename);
                            finish();
                            startActivity(new Intent(getApplicationContext(),Main.class));
                            short_two.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename);
                                    startActivity(LaunchIntent);
                                }
                            });
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            short_three.setBackground(packageManager.getApplicationIcon(packagename));
                            edit.putString("packagename_3", packagename);
                            finish();
                            startActivity(new Intent(getApplicationContext(),Main.class));
                            short_three.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename);
                                    startActivity(LaunchIntent);
                                }
                            });
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            short_four.setBackground(packageManager.getApplicationIcon(packagename));
                            edit.putString("packagename_4", packagename);
                            finish();
                            startActivity(new Intent(getApplicationContext(),Main.class));
                            short_four.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename);
                                    startActivity(LaunchIntent);
                                }
                            });
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            short_five.setBackground(packageManager.getApplicationIcon(packagename));
                            edit.putString("packagename_5", packagename);
                            finish();
                            startActivity(new Intent(getApplicationContext(),Main.class));
                            short_five.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename);
                                    startActivity(LaunchIntent);

                                }
                            });
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            short_six.setBackground(packageManager.getApplicationIcon(packagename));
                            edit.putString("packagename_6", packagename);
                            finish();
                            startActivity(new Intent(getApplicationContext(),Main.class));
                            short_six.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename);
                                    startActivity(LaunchIntent);
                                }
                            });
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            short_seven.setBackground(packageManager.getApplicationIcon(packagename));
                            edit.putString("packagename_7", packagename);
                            finish();
                            startActivity(new Intent(getApplicationContext(),Main.class));
                            short_seven.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename);
                                    startActivity(LaunchIntent);
                                }
                            });
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 8:
                        try {
                            short_eight.setBackground(packageManager.getApplicationIcon(packagename));
                            edit.putString("packagename_8", packagename);
                            finish();
                            startActivity(new Intent(getApplicationContext(),Main.class));
                            short_eight.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename);
                                    startActivity(LaunchIntent);

                                }
                            });
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                }
                edit.commit();
                finish();
                startActivity(new Intent(getApplicationContext(),Main.class));
            }
        });
        app_dialog.setView(apps);
        app_dialog.show();

    }
    void invert(){
        wifi.setImageResource(R.drawable.ic_action_network_wifi_inverted);
        mobile_data.setImageResource(R.drawable.ic_action_mobile_data_inverted);
        gps.setImageResource(R.drawable.ic_qs_location_on_inverted);
        rotate.setImageResource(R.drawable.ic_action_rotate_right_inverted);
        airplane.setImageResource(R.drawable.ic_action_airplane_mode_inverted);
        bluetooth.setImageResource(R.drawable.ic_action_bluetooth_inverted);
        flash.setImageResource(R.drawable.ic_action_flash_on_inverted);
        battery_saver.setImageResource(R.drawable.save_battery_inverted);
    }
    void uninvert(){
        wifi.setImageResource(R.drawable.ic_action_network_wifi);
        mobile_data.setImageResource(R.drawable.ic_action_mobile_data);
        gps.setImageResource(R.drawable.ic_qs_location_on);
        rotate.setImageResource(R.drawable.ic_action_rotate_right);
        airplane.setImageResource(R.drawable.ic_action_airplane_mode_off);
        bluetooth.setImageResource(R.drawable.ic_action_bluetooth);
        flash.setImageResource(R.drawable.ic_action_flash_on);
        battery_saver.setImageResource(R.drawable.save_battery);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        edit = sharedPreferences.edit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        edit = sharedPreferences.edit();
        pack = getPackageManager();
        startService(new Intent(getApplicationContext(),Notification.class));
        displayNotificationOne();
        CustomPageAdapter adapter = new CustomPageAdapter();
        myPager = (ViewPager) findViewById(R.id.customviewpager);
        myPager.setAdapter(adapter);
        myPager.setCurrentItem(1);
        myPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                   if (myPager.getCurrentItem() == 1){
                       initMainScreen();
                       createTimerForTime();
                       homeView = (RelativeLayout) findViewById(R.id.home_view);
                       onactivityswiper activitySwipeDetector = new onactivityswiper(Main.this);
                       homeView.setOnTouchListener(activitySwipeDetector);
                   }
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        init();
                        inittwo();
                        createTimer();
                        left = (ScrollView) findViewById(R.id.right_drawer);
                        if (light) {
                            left.setBackgroundColor(Color.parseColor("#80FFFFFF"));
                            uninvert();
                            theme.setSelection(0);

                        } else {
                            left.setBackgroundColor(Color.parseColor("#80000000"));
                            invert();
                            theme.setSelection(1);

                        }

                        break;
                    case 1:
                        initMainScreen();
                        createTimerForTime();
                        homeView = (RelativeLayout) findViewById(R.id.home_view);
                        onactivityswiper activitySwipeDetector = new onactivityswiper(Main.this);
                        homeView.setOnTouchListener(activitySwipeDetector);

                        break;
                    case 2:

                        drawerGrid = (BounceScrollView) findViewById(R.id.content);
                        homeView = (RelativeLayout) findViewById(R.id.home_view);

                        pm = getPackageManager();
                        set_pacs();
                        if (light) {
                            drawerGrid.setBackgroundColor(Color.parseColor("#80FFFFFF"));
                        } else {
                            drawerGrid.setBackgroundColor(Color.parseColor("#80000000"));
                        }
                        IntentFilter filter = new IntentFilter();
                        filter.addAction(Intent.ACTION_PACKAGE_ADDED);
                        filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
                        filter.addAction(Intent.ACTION_PACKAGE_CHANGED);
                        filter.addDataScheme("package");
                        registerReceiver(new PacReceiver(), filter);
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(),map.class));
                        overridePendingTransition(R.anim.left_right,R.anim.right_left);
                   }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (myPager.getCurrentItem() == 1){
                    initMainScreen();
                    init_time();
                    if (sharedPreferences.contains("light")) {
                        light = sharedPreferences.getBoolean("light", true);
                        homeView = (RelativeLayout) findViewById(R.id.home_view);
                        onactivityswiper activitySwipeDetector = new onactivityswiper(Main.this);
                        homeView.setOnTouchListener(activitySwipeDetector);
                    }
                }


            }
        });
        if (sharedPreferences.contains("light")) {
            light = sharedPreferences.getBoolean("light", true);
        }


        packageManager = getPackageManager();
// Turn off LED

    }

    @Override
    protected void onStop()
    {
        super.onStop();
        myPager.setCurrentItem(1);

        // insert here your instructions
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    open_app = (text.get(0)).toLowerCase();
                    Toast.makeText(getApplicationContext(),open_app,100).show();
                    List<ApplicationInfo> packages = getAllInstalledApplications(getApplicationContext());
                    for (ApplicationInfo packageInfo : packages) {
                        if (packageInfo.loadLabel(getPackageManager()).toString().replace("-"," ").toLowerCase().equals(open_app)) {
                            Intent LaunchIntent = packageManager.getLaunchIntentForPackage(packageInfo.packageName);
                            startActivity(LaunchIntent);
                        }
                    }
                    break;
                }

            }
        }
    }
    void initMainScreen()  {
        app_drawer = (Button)findViewById(R.id.app_drawer);
        app_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPager.setCurrentItem(2);
            }
        });
        createTimerForTime();
        back = (RelativeLayout)findViewById(R.id.home_view);

        back.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActivity(new Intent(getApplicationContext(), dialog.class));

                return false;
            }
        });
        refresh = (Button)findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(),Main.class));
            }
        });
        init_time();
        init_buttons_main();
        mic = (Button)findViewById(R.id.mic);
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say the app name you would like to open");

                try {
                    startActivityForResult(intent, RESULT_SPEECH);

                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Opps! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
            });



        try {
            if (sharedPreferences.contains("packagename_1")) {
                packagename_1 = sharedPreferences.getString("packagename_1","");
                short_one.setBackground(pack.getApplicationIcon(packagename_1));
                short_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename_1);
                        startActivity(LaunchIntent);
                        overridePendingTransition(R.anim.left_right,R.anim.right_left);

                    }
                });
                short_one.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder alert_delete = new AlertDialog.Builder(Main.this);
                        alert_delete.setTitle("Remove from favorites");
                        alert_delete.setMessage("Do you want to remove this app from your favorites?");
                        alert_delete.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edit.remove("packagename_1");
                                edit.commit();
                                finish();
                                startActivity(new Intent(getApplicationContext(),Main.class));
                            }
                        });
                        alert_delete.setNegativeButton("Nevermind..",null);
                        alert_delete.show();
                        return false;
                    }
                });
            }
            if (sharedPreferences.contains("packagename_2")) {
                packagename_2 = sharedPreferences.getString("packagename_2", "");
                short_two.setBackground(pack.getApplicationIcon(packagename_2));
                short_two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename_2);
                        startActivity(LaunchIntent);
                        overridePendingTransition(R.anim.open_app_animation,R.anim.open_app_animation);
                    }
                });
                short_two.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder alert_delete = new AlertDialog.Builder(Main.this);
                        alert_delete.setTitle("Remove from favorites");
                        alert_delete.setMessage("Do you want to remove this app from your favorites?");
                        alert_delete.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edit.remove("packagename_2");
                                edit.commit();
                                finish();
                                startActivity(new Intent(getApplicationContext(),Main.class));
                            }
                        });
                        alert_delete.setNegativeButton("Nevermind..",null);
                        alert_delete.show();
                        return false;
                    }
                });

            }
            if (sharedPreferences.contains("packagename_3")) {
                packagename_3 = sharedPreferences.getString("packagename_3", "");
                short_three.setBackground(pack.getApplicationIcon(packagename_3));
                short_three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename_3);
                        startActivity(LaunchIntent);
                        overridePendingTransition(R.anim.open_app_animation,R.anim.open_app_animation);
                    }
                });
                short_three.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder alert_delete = new AlertDialog.Builder(Main.this);
                        alert_delete.setTitle("Remove from favorites");
                        alert_delete.setMessage("Do you want to remove this app from your favorites?");
                        alert_delete.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edit.remove("packagename_3");
                                edit.commit();
                                finish();
                                startActivity(new Intent(getApplicationContext(),Main.class));
                            }
                        });
                        alert_delete.setNegativeButton("Nevermind..",null);
                        alert_delete.show();
                        return false;
                    }
                });
            }
            if (sharedPreferences.contains("packagename_4")) {
                packagename_4 = sharedPreferences.getString("packagename_4", "");
                short_four.setBackground(pack.getApplicationIcon(packagename_4));
                short_four.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename_4);
                        startActivity(LaunchIntent);
                        overridePendingTransition(R.anim.open_app_animation,R.anim.open_app_animation);
                    }
                });
                short_four.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder alert_delete = new AlertDialog.Builder(Main.this);
                        alert_delete.setTitle("Remove from favorites");
                        alert_delete.setMessage("Do you want to remove this app from your favorites?");
                        alert_delete.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edit.remove("packagename_4");
                                edit.commit();
                                finish();
                                startActivity(new Intent(getApplicationContext(),Main.class));
                            }
                        });
                        alert_delete.setNegativeButton("Nevermind..",null);
                        alert_delete.show();
                        return false;
                    }
                });
            }
            if (sharedPreferences.contains("packagename_5")) {
                packagename_5 = sharedPreferences.getString("packagename_5", "");
                short_five.setBackground(pack.getApplicationIcon(packagename_5));
                short_five.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename_5);
                        startActivity(LaunchIntent);
                        overridePendingTransition(R.anim.open_app_animation,R.anim.open_app_animation);
                    }
                });
                short_five.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder alert_delete = new AlertDialog.Builder(Main.this);
                        alert_delete.setTitle("Remove from favorites");
                        alert_delete.setMessage("Do you want to remove this app from your favorites?");
                        alert_delete.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edit.remove("packagename_5");
                                edit.commit();
                                finish();
                                startActivity(new Intent(getApplicationContext(), Main.class));
                            }
                        });
                        alert_delete.setNegativeButton("Nevermind..", null);
                        alert_delete.show();
                        return false;
                    }
                });
            }
            if (sharedPreferences.contains("packagename_6")) {
                packagename_6 = sharedPreferences.getString("packagename_6", "");
                short_six.setBackground(pack.getApplicationIcon(packagename_6));
                short_six.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename_6);
                        startActivity(LaunchIntent);
                        overridePendingTransition(R.anim.open_app_animation,R.anim.open_app_animation);
                    }
                });
                short_six.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder alert_delete = new AlertDialog.Builder(Main.this);
                        alert_delete.setTitle("Remove from favorites");
                        alert_delete.setMessage("Do you want to remove this app from your favorites?");
                        alert_delete.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edit.remove("packagename_6");
                                edit.commit();
                                finish();
                                startActivity(new Intent(getApplicationContext(), Main.class));
                            }
                        });
                        alert_delete.setNegativeButton("Nevermind..", null);
                        alert_delete.show();
                        return false;
                    }
                });
            }
            if (sharedPreferences.contains("packagename_7")) {
                packagename_7 = sharedPreferences.getString("packagename_7", "");
                short_seven.setBackground(pack.getApplicationIcon(packagename_7));
                short_seven.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename_7);
                        startActivity(LaunchIntent);
                        overridePendingTransition(R.anim.open_app_animation,R.anim.open_app_animation);
                    }
                });
                short_seven.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder alert_delete = new AlertDialog.Builder(Main.this);
                        alert_delete.setTitle("Remove from favorites");
                        alert_delete.setMessage("Do you want to remove this app from your favorites?");
                        alert_delete.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edit.remove("packagename_7");
                                edit.commit();
                                finish();
                                startActivity(new Intent(getApplicationContext(), Main.class));
                            }
                        });
                        alert_delete.setNegativeButton("Nevermind..", null);
                        alert_delete.show();
                        return false;
                    }
                });
            }
            if (sharedPreferences.contains("packagename_8")) {
                packagename_8 = sharedPreferences.getString("packagename_8", "");
                short_eight.setBackground(pack.getApplicationIcon(packagename_8));
                short_eight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(packagename_8);
                        startActivity(LaunchIntent);
                        overridePendingTransition(R.anim.open_app_animation,R.anim.open_app_animation);
                    }
                });
                short_eight.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder alert_delete = new AlertDialog.Builder(Main.this);
                        alert_delete.setTitle("Remove from favorites");
                        alert_delete.setMessage("Do you want to remove this app from your favorites?");
                        alert_delete.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edit.remove("packagename_8");
                                edit.commit();
                                finish();
                                startActivity(new Intent(getApplicationContext(),Main.class));
                                overridePendingTransition(R.anim.open_app_animation,R.anim.open_app_animation);
                            }
                        });
                        alert_delete.setNegativeButton("Nevermind..",null);
                        alert_delete.show();
                        return false;
                    }
                });
            }
        }
        catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
    }
    private void TimerMethod()
    {
        this.runOnUiThread(Timer_Tick);
    }

    private Runnable Timer_Tick = new Runnable() {
        public void run() {
                inittwo();
        }
    };


    private void TimerMethodForTime()
    {
        this.runOnUiThread(Timer_Tick_For_Time);
    }

    private Runnable Timer_Tick_For_Time = new Runnable() {
        public void run() {
            if (myPager.getCurrentItem() == 1) {
                init_time();
            }
        }
    };
    void createTimer(){
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethod();
            }

        }, 0, 1000);
    }
    void createTimerForTime(){
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethodForTime();
            }
        }, 0, 1000);
    }
    void init_buttons_main(){
        short_one = (Button) findViewById(R.id.short_1);
        short_two = (Button) findViewById(R.id.short_2);
        short_three = (Button) findViewById(R.id.short_3);
        short_four = (Button) findViewById(R.id.short_4);
        short_five = (Button) findViewById(R.id.short_5);
        short_six = (Button) findViewById(R.id.short_6);
        short_seven = (Button) findViewById(R.id.short_7);
        short_eight = (Button) findViewById(R.id.short_8);


    }
    void init_time(){
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        String minute = String .valueOf(c.get(Calendar.MINUTE));
        int day_int = c.get(Calendar.DAY_OF_WEEK);
        String day = "";
        switch (day_int){
            case 1:
                day = "SUNDAY";
                break;
            case 2:
                day = "MONDAY";
                break;
            case 3:
                day = "TUESDAY";
                break;
            case 4:
                day = "WEDNESDAY";
                break;
            case 5:
                day = "THURSDAY";
                break;
            case 6:
                day = "FRIDAY";
                break;
            case 7:
                day = "SATURDAY";
                break;

        }
        if (Integer.valueOf(minute) < 10){
            minute = "0"+minute;
        }
        TextView time = (TextView)findViewById(R.id.time);
        TextView date = (TextView)findViewById(R.id.date);
        date.setText(day);
        time.setText(String.valueOf(hour) + ":" + String.valueOf(minute));
    }

    void dark(){

        settings_back.setBackgroundColor(Color.parseColor("#80000000"));
    }
    void light(){
        settings_back.setBackgroundColor(Color.parseColor("#80FFFFFF"));
    }
    void init(){
        recent1 = (Button)findViewById(R.id.recent1);
        recent2 = (Button)findViewById(R.id.recent2);
        recent3 = (Button)findViewById(R.id.recent3);
        recent4 = (Button)findViewById(R.id.recent4);
        settings_back = (ScrollView)findViewById(R.id.right_drawer);
        theme = (Spinner)findViewById(R.id.theme);
        theme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        light();
                        light = true;
                        uninvert();
                        edit.putBoolean("light", true).commit();
                        break;
                    case 1:
                        dark();
                        light = false;
                        invert();
                        edit.putBoolean("light",false).commit();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        container = (RelativeLayout)findViewById(R.id.recent_containers);
        airplane = (ImageView)findViewById(R.id.airplane);
        rotate = (ImageView)findViewById(R.id.rotate);
        gps = (ImageView)findViewById(R.id.gps);
        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(viewIntent);
            }
        });
        wifi= (ImageView)findViewById(R.id.wifi);
        mobile_data = (ImageView)findViewById(R.id.mobile_data);
        airplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
            }
        });
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.provider.Settings.System.getInt(getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 0) == 1){
                    rotate.setImageResource(R.drawable.ic_action_rotate_right_enabled);
                    setAutoOrientationEnabled(getContentResolver(),false);
                }
                else{
                    rotate.setImageResource(R.drawable.ic_action_rotate_right);
                    setAutoOrientationEnabled(getContentResolver(),true);
                }
            }
        });
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
                if (wifiManager.isWifiEnabled()){
                    wifiManager.setWifiEnabled(false);
                    wifi.setImageResource(R.drawable.ic_action_network_wifi);

                }
                else{
                    wifiManager.setWifiEnabled(true);
                    wifi.setImageResource(R.drawable.ic_action_network_wifi_enabled);

                }
            }
        });

        mobile_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isMobileDataEnabled()){
                    mobile_data.setImageResource(R.drawable.ic_action_mobile_data_enabled);
                    try {
                        setMobileDataEnabled(getApplicationContext(),false);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    mobile_data.setImageResource(R.drawable.ic_action_mobile_data);
                    try {
                        setMobileDataEnabled(getApplicationContext(),true);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        battery_saver = (ImageView)findViewById(R.id.power_save);
        battery_saver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!save) {
                    battery_saver.setImageResource(R.drawable.save_battery_enabled);
                    try {
                        setMobileDataEnabled(getApplicationContext(), false);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                    setAutoOrientationEnabled(getContentResolver(), false);
                    WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                    if (wifiManager.isWifiEnabled()) {
                        wifiManager.setWifiEnabled(false);
                        if(light) {
                            wifi.setImageResource(R.drawable.ic_action_network_wifi);
                        }
                        else{
                            wifi.setImageResource(R.drawable.ic_action_network_wifi_inverted);
                        }
                    }
                    dark();
                    try {
                        curBrightnessValue=android.provider.Settings.System.getInt(
                                getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
                        brightness_sb.setProgress(Integer.valueOf(Math.round(1)));
                    }catch (NullPointerException e){
                        e.printStackTrace();
                    }
                    catch (Settings.SettingNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    save = true;
                    if(light) {
                        theme.setSelection(1);
                    }
                }
                else{
                    if(light) {
                        battery_saver.setImageResource(R.drawable.save_battery);
                    }
                    else {
                        battery_saver.setImageResource(R.drawable.save_battery_inverted);
                    }
                    if (light) {
                        light();
                    }
                    try {
                        curBrightnessValue=android.provider.Settings.System.getInt(
                                getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
                        brightness_sb.setProgress(Integer.valueOf(Math.round(20)));
                    }catch (NullPointerException e){
                        e.printStackTrace();
                    }
                    catch (Settings.SettingNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    if(light) {
                        theme.setSelection(0);
                    }
                    save = false;
                }
            }

        });
    }
    void inittwo(){
        try {
            recent1.setBackground(getPackageManager().getApplicationIcon(Main.list.get(0)));
            recent2.setBackground(getPackageManager().getApplicationIcon(Main.list.get(1)));
            recent3.setBackground(getPackageManager().getApplicationIcon(Main.list.get(2)));
            recent4.setBackground(getPackageManager().getApplicationIcon(Main.list.get(3)));

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        recent1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    activityManager.killBackgroundProcesses(Main.list.get(0));
                    recent1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down));
                    Toast.makeText(getApplicationContext(), "pressed", 100).show();
                    list.remove(0);
                    boolean x = false;
                    while (!x) {
                        if (recent1.getAnimation() != null) {
                            x = true;
                            recent1.setVisibility(100);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        recent2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    activityManager.killBackgroundProcesses(Main.list.get(1));
                    recent2.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down));
                    Toast.makeText(getApplicationContext(), "pressed", 100).show();
                    list.remove(1);
                    boolean x = false;
                    while (!x) {
                        if (recent2.getAnimation() != null) {
                            x = true;
                            recent2.setVisibility(100);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        recent3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    activityManager.killBackgroundProcesses(Main.list.get(2));
                    recent3.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down));
                    Toast.makeText(getApplicationContext(), "pressed", 100).show();
                    list.remove(2);
                    recent3.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    recent4.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        recent4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    activityManager.killBackgroundProcesses(Main.list.get(3));
                    recent4.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down));
                    Toast.makeText(getApplicationContext(), "pressed", 100).show();
                    list.remove(3);
                    recent4.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        try {
            flash = (ImageView) findViewById(R.id.flash);
            flash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


            BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetooth = (ImageView) findViewById(R.id.bluetooth);
            bluetooth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (mBluetoothAdapter == null) {
                        // Device does not support Bluetooth
                    } else {
                        if (!mBluetoothAdapter.isEnabled()) {
                            mBluetoothAdapter.enable();
                        } else {
                            mBluetoothAdapter.disable();
                        }
                    }
                }
            });
            am = (AudioManager) getSystemService(AUDIO_SERVICE);
            int volume_level = am.getStreamVolume(AudioManager.STREAM_RING);
            volume = (SeekBar) findViewById(R.id.volume_slider);
            volume.setProgress(volume_level);
            volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    am.setStreamVolume(AudioManager.STREAM_RING, progress, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            brightness_sb = (SeekBar) findViewById(R.id.brightness_slider);
            brightness_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    android.provider.Settings.System.putInt(getContentResolver(),
                            android.provider.Settings.System.SCREEN_BRIGHTNESS, progress * 3);
                    curBrightnessValue = progress;
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            try {
                curBrightnessValue = android.provider.Settings.System.getInt(
                        getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
                brightness_sb.setProgress(Integer.valueOf(Math.round(curBrightnessValue / 3)));
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Settings.SettingNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (mBluetoothAdapter.isEnabled()) {
                bluetooth.setImageResource(R.drawable.ic_action_bluetooth_enabled);
            } else {
                if(light){
                bluetooth.setImageResource(R.drawable.ic_action_bluetooth);
                }
                else {
                    bluetooth.setImageResource(R.drawable.ic_action_bluetooth_inverted);
                }
            }
            WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            if (wifiManager.isWifiEnabled()) {
                wifi.setImageResource(R.drawable.ic_action_network_wifi_enabled);
            } else {
                if(light){
                    wifi.setImageResource(R.drawable.ic_action_network_wifi);
                }
                else {
                    wifi.setImageResource(R.drawable.ic_action_network_wifi_inverted);
                }
            }
            if (isMobileDataEnabled()) {
                mobile_data.setImageResource(R.drawable.ic_action_mobile_data_enabled);
            } else {
                if(light){
                    mobile_data.setImageResource(R.drawable.ic_action_mobile_data);
                }
                else {
                    mobile_data.setImageResource(R.drawable.ic_action_mobile_data_inverted);
                }            }
            if (android.provider.Settings.System.getInt(getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 0) == 1) {
                rotate.setImageResource(R.drawable.ic_action_rotate_right_enabled);
            } else {
                if(light){
                    rotate.setImageResource(R.drawable.ic_action_rotate_right);
                }
                else {
                    rotate.setImageResource(R.drawable.ic_action_rotate_right_inverted);
                }            }
            if (isAirplaneModeOn(getApplicationContext())) {
                airplane.setImageResource(R.drawable.ic_action_airplane_mode_off_enabled);
            } else {
                if(light){
                    airplane.setImageResource(R.drawable.ic_action_airplane_mode_off);
                }
                else {
                    airplane.setImageResource(R.drawable.ic_action_airplane_mode_inverted);
                }                 }
            LocationManager mlocManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
            if(save){
                battery_saver.setImageResource(R.drawable.save_battery_enabled);
            }
            boolean gps_enabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            if(gps_enabled){
                gps.setImageResource(R.drawable.ic_qs_location_on_enabled);
            }
            else {
                if(light){
                    gps.setImageResource(R.drawable.ic_qs_location_on);
                }
                else {
                    gps.setImageResource(R.drawable.ic_qs_location_on_inverted);
                }                 }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    private static boolean isAirplaneModeOn(Context context) {

        return Settings.System.getInt(context.getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0) != 0;

    }

    public void setAutoOrientationEnabled(ContentResolver resolver, boolean enabled)
    {
        Settings.System.putInt(Main.this.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, enabled ? 1 : 0);
    }

    private void setMobileDataEnabled(Context context, boolean enabled) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        final ConnectivityManager conman = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final Class conmanClass = Class.forName(conman.getClass().getName());
        final Field connectivityManagerField = conmanClass.getDeclaredField("mService");
        connectivityManagerField.setAccessible(true);
        final Object connectivityManager = connectivityManagerField.get(conman);
        final Class connectivityManagerClass =  Class.forName(connectivityManager.getClass().getName());
        final Method setMobileDataEnabledMethod = connectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
        setMobileDataEnabledMethod.setAccessible(true);

        setMobileDataEnabledMethod.invoke(connectivityManager, enabled);
    }

    public Boolean isMobileDataEnabled(){
        Object connectivityService = getSystemService(CONNECTIVITY_SERVICE);
        ConnectivityManager cm = (ConnectivityManager) connectivityService;

        try {
            Class<?> c = Class.forName(cm.getClass().getName());
            Method m = c.getDeclaredMethod("getMobileDataEnabled");
            m.setAccessible(true);
            return (Boolean)m.invoke(cm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    void displayNotificationOne() {
        if (notification) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                Intent resultIntent = new Intent(getApplicationContext(),Main.class);
                PendingIntent resultPendingIntent =
                        PendingIntent.getActivity(
                                this,
                                0,
                                resultIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.drawable.ic_launcher)
                                .setContentTitle("Simple Launcher")
                                .setOngoing(true)
                                .setContentText("Won't be closed");
                int mNotificationId = 001;
                NotificationManager mNotifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mBuilder.setContentIntent(resultPendingIntent);
                mNotifyMgr.notify(mNotificationId, mBuilder.build());

            }
        }

    }

    public void set_pacs(){
        final Intent mainIntent = new Intent(Intent.ACTION_MAIN,null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pacsList = pm.queryIntentActivities(mainIntent, 0);
        pacs = new Pac[pacsList.size()];
        for(int I=0;I<pacsList.size();I++){
            pacs[I]= new Pac();
            pacs[I].icon=pacsList.get(I).loadIcon(pm);
            pacs[I].packageName=pacsList.get(I).activityInfo.packageName;
            pacs[I].name=pacsList.get(I).activityInfo.name;
            pacs[I].label=pacsList.get(I).loadLabel(pm).toString();
        }
        new SortApps().exchange_sort(pacs);
        drawerAdapterObject = new DrawerAdapter(this, pacs);
        drawerGrid.setAdapter(drawerAdapterObject);
        drawerGrid.setOnItemClickListener(new DrawerClickListener(this, pacs, pm));
        drawerGrid.setOnItemLongClickListener(new DrawerLongClickListener(this, null, homeView, pacs));

    }
    public class PacReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            set_pacs();
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            myPager.setCurrentItem(1);
        }return false;
        }

    @Override
    protected void onResume() {
        super.onResume();
        myPager.setCurrentItem(1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(R.anim.open_app_animation,R.anim.open_app_animation);
    }
    class onactivityswiper implements View.OnTouchListener {
        static final String logTag = "ActivitySwipeDetector";
        private Activity activity;
        static final int MIN_DISTANCE = 100;
        private float downX, downY, upX, upY;

        public onactivityswiper(Activity activity){
            this.activity = activity;
        }

        public void onRightToLeftSwipe() {
            Log.i(logTag, "RightToLeftSwipe!");
        }

        public void onLeftToRightSwipe() {
            Log.i(logTag, "LeftToRightSwipe!");
        }

        public void onTopToBottomSwipe() {
            Log.i(logTag, "onTopToBottomSwipe!");
            Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.googlequicksearchbox");
            startActivity(LaunchIntent);
        }

        public void onBottomToTopSwipe() {
            Log.i(logTag, "onBottomToTopSwipe!");
        }

        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    downX = event.getX();
                    downY = event.getY();
                    return true;
                }
                case MotionEvent.ACTION_UP: {
                    upX = event.getX();
                    upY = event.getY();

                    float deltaX = downX - upX;
                    float deltaY = downY - upY;

                    // swipe horizontal?
                    if (Math.abs(deltaX) > Math.abs(deltaY)) {
                        if (Math.abs(deltaX) > MIN_DISTANCE) {
                            // left or right
                            if (deltaX < 0) {
                                this.onLeftToRightSwipe();
                                return true;
                            }
                            if (deltaX > 0) {
                                this.onRightToLeftSwipe();
                                return true;
                            }
                        } else {
                            Log.i(logTag, "Horizontal Swipe was only " + Math.abs(deltaX) + " long, need at least " + MIN_DISTANCE);
                            return false; // We don't consume the event
                        }
                    }
                    // swipe vertical?
                    else {
                        if (Math.abs(deltaY) > MIN_DISTANCE) {
                            // top or down
                            if (deltaY < 0) {
                                this.onTopToBottomSwipe();
                                return true;
                            }
                            if (deltaY > 0) {
                                this.onBottomToTopSwipe();
                                return true;
                            }
                        } else {
                            Log.i(logTag, "Vertical Swipe was only " + Math.abs(deltaX) + " long, need at least " + MIN_DISTANCE);
                            return false; // We don't consume the event
                        }
                    }

                    return true;
                }
            }
            return false;
        }
    }
}
