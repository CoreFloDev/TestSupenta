package supenta.florent.testapplication.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import supenta.florent.testapplication.MainActivity;
import supenta.florent.testapplication.R;

/**
 * Created by florent on 28/01/15.
 */
public class AppEventService extends Service {

    public static boolean IS_RUNNING = false;

    private NotificationManager mNM;
    private int NOTIFICATION = R.string.app_event_service_started;

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        // Display a notification about us starting.  We put an icon in the status bar.
        showNotification();
        IS_RUNNING = true;
    }


    @Override
    public void onDestroy() {
        // Cancel the persistent notification.
        mNM.cancel(NOTIFICATION);

        // Tell the user we stopped.
        Toast.makeText(this, R.string.app_event_service_stopped, Toast.LENGTH_SHORT).show();
        IS_RUNNING = false;
    }


    /**
     * Show a notification while this service is running.
     */
    private void showNotification() {
        // In this sample, we'll use the same text for the ticker and the expanded notification
        CharSequence text = getText(R.string.app_event_service_started);

        // Set the icon, scrolling text and timestamp
        Notification notification = new Notification(R.drawable.ic_launcher, text,
                System.currentTimeMillis());

        // The PendingIntent to launch our activity if the user selects this notification
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);

        // Set the info for the views that show in the notification panel.
        notification.setLatestEventInfo(this, getText(R.string.app_event_service_label),
                text, contentIntent);

        // Send the notification.
        mNM.notify(NOTIFICATION, notification);
    }

}
