package com.example.brenda.teatime;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Leena on 3/30/2015.
 */
public class MyService extends Service {

//    private Thread thread;
    protected static boolean isRunning;
//    private static final int NOTIFY_ME_ID = 1337;
    private static Notification.Builder break_note;
    private static Notification.Builder work_note;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        final NotificationManager mgr=(NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        break_note = new Notification.Builder(getApplicationContext());
        work_note = new Notification.Builder(getApplicationContext());
        break_note.setContentTitle("Break Buddy");
        work_note.setContentTitle("Break Buddy");
        break_note.setContentText("Time for your break!");
        work_note.setContentText("Time to work!");
//        break_note.setSmallIcon(R.drawable.ic_launcher);
//        work_note.setSmallIcon(R.drawable.ic_launcher);
        // This pending intent will open after notification click
        PendingIntent i= PendingIntent.getActivity(this, 0,new Intent(this, RateStress.class),0);
        break_note.setContentIntent(i);
        PendingIntent n = PendingIntent.getActivity(this, 0,new Intent(this, MainActivity.class),0);
        isRunning = true;
//        thread.start();
        return START_STICKY;
    }

    public static void breakNotify()
    {
        break_note.setWhen(System.currentTimeMillis());
    }

    public static void workNotify()
    {
        work_note.setWhen(System.currentTimeMillis());
    }
}
