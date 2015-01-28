package supenta.florent.testapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import supenta.florent.testapplication.model.LogEntry;
import supenta.florent.testapplication.model.LogModel;
import supenta.florent.testapplication.service.AppEventService;

/**
 * Created by florent on 28/01/15.
 * This class receive a notification when an application is installed, updated or removed
 */
public class AppEventReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null) {
            if(AppEventService.IS_RUNNING) {
                // log events to the model
                String packageName = intent.getDataString();
                switch (intent.getAction()) {
                    case Intent.ACTION_PACKAGE_ADDED:
                        LogModel.getInstance().addLog(LogEntry.Type.APP_INSTALLED, packageName);
                        break;

                    case Intent.ACTION_PACKAGE_REMOVED:
                        LogModel.getInstance().addLog(LogEntry.Type.APP_REMOVED, packageName);
                        break;

                    case Intent.ACTION_PACKAGE_REPLACED:
                        LogModel.getInstance().addLog(LogEntry.Type.APP_UPDATED, packageName);
                        break;
                }
            }
            Log.i("supenta", intent.getDataString());
            Log.i("supenta", intent.getAction());
        }
    }
}
