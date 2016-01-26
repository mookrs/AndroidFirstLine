package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Notification.Builder builder = new Notification.Builder(this);
                builder.setAutoCancel(true);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                // Android 5.0以上不会显示ticker text
                builder.setTicker("This is ticker text");
                builder.setContentTitle("This is content title");
                builder.setContentText("This is content text");
                builder.setSubText("This is subtext");
                // 下标为0的值表示手机静止的时长，下标为1的值表示手机振动的时长，
                // 下标为2的值又表示手机静止的时长，以此类推
                long[] vibrates = {0, 1000, 1000, 1000};
                builder.setVibrate(vibrates);
                builder.setLights(Color.GREEN, 1000, 1000);

                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                builder.setContentIntent(pendingIntent);

                Notification notification = builder.build();

                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }
}
