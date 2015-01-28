package supenta.florent.testapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by florent on 28/01/15.
 * This class recieve a notification when an application is installed, updated or removed
 */
public class AppEventReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("E", intent.getAction());
    }
}
