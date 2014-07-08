package com.testy;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.*;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1= (Button) findViewById(R.id.button1);
        Button button2= (Button) findViewById(R.id.button2);
        Button button3= (Button) findViewById(R.id.button3);

        View.OnClickListener l = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.button1:
                        Toast.makeText(getApplicationContext(), "bal al", Toast.LENGTH_SHORT).show();
                        createNotification();
                        break;
                    case R.id.button2:
                        Toast.makeText(getApplicationContext(), "ciska w chuj", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button3:
                        Toast.makeText(getApplicationContext(), "ciska w chuuuuuuj", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        };
        button1.setOnClickListener(l);
        button2.setOnClickListener(l);
        button3.setOnClickListener(l);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void createNotification()
    {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent p_intent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notif = new NotificationCompat.Builder(this)
                .setContentTitle("Nowe powiadomienie")
                .setContentText("blo blo")
                .setTicker("powiadomionko")
                .setSmallIcon(R.drawable.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(p_intent)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, notif);

    }


}
