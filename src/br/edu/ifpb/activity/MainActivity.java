package br.edu.ifpb.activity;

import android.R;
import android.app.Activity;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.edu.ifpb.asynctask.LoginAs;
import br.edu.*;

public class MainActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        Button notificacaoButton = (Button)findViewById(R.id.addToDictionary);
        notificacaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("NotificationWearApp", "Clique no bot√£o da NotificaÁ„oo");
                int notificationId = 001;

                NotificationCompat.Builder notificationBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setContentTitle("Title")
                                .setContentText("Android Wear Notification");

                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(MainActivity.this);

                notificationManager.notify(notificationId, notificationBuilder.build());

                Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION); //sonzinho (musiquinha) de notifica√ß√£o do smartphone
                Ringtone toque = RingtoneManager.getRingtone(v.getContext(), som); //toque
                toque.play();
            }
        });

        Button asyncTaskButton = (Button)findViewById(R.id.addToDictionary);
        asyncTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("NotificationWearApp", "Clique no bot„o da AsyncTask");

                EditText nomeEditText = (EditText) findViewById(R.id.addToDictionary);
                String nome = nomeEditText.getText().toString();

                LoginAs loginAsyncTask = new LoginAs(v.getContext());
                String[] valores = {nome};

                loginAsyncTask.execute(valores);
            }
        });
    }
}