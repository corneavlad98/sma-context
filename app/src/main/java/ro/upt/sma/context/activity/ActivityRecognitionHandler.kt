package ro.upt.sma.context.activity

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.google.android.gms.location.ActivityRecognition
import com.google.android.gms.location.ActivityRecognitionClient

class ActivityRecognitionHandler(context: Context) {

    private val client: ActivityRecognitionClient = ActivityRecognition.getClient(context)
    val thisContext = context;

    fun registerPendingIntent(): PendingIntent {

        // TODO 5: Create a pending intent for ActivityRecognitionService and register for updates to activity recognition client.
        val intent = Intent(thisContext, ActivityRecognitionService::class.java);
        val pendingIntent = PendingIntent.getService(thisContext, 0, intent, 0);

        val detectionIntervalMillis = 2000L;
        client.requestActivityUpdates(detectionIntervalMillis, pendingIntent)

        return pendingIntent;
    }

    fun unregisterPendingIntent(pendingIntent: PendingIntent) {
        client.removeActivityUpdates(pendingIntent)
    }

}
