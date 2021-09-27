package com.john.mrclean;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Send_Email extends AppCompatActivity {

    EditText h2_FullName, h2_Email, h2_Subject, h2_Message;
    Button buttonClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__email);
        getSupportActionBar().hide();
        h2_FullName = findViewById(R.id.history2FullName);
        h2_Email = findViewById(R.id.history2Email);
        h2_Subject = findViewById(R.id.history2Subject);
        h2_Message = findViewById(R.id.history2Message);
        buttonClick = findViewById(R.id.send_Email);

//        buttonClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NotificationManager notification = (NotificationManager)
//                        getApplicationContext().getSystemService(
//                                Context.NOTIFICATION_SERVICE);
//
//                Intent notification1 = new Intent(Send_Email.this, Notification.class);
//                notification1.putExtra("yes", true);
//
//                notification1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                PendingIntent pendingNotification1 = PendingIntent.getActivity(
//                        Send_Email.this, 0, notification1, PendingIntent.FLAG_ONE_SHOT
//                );
//                Intent notification2 = new Intent(Send_Email.this, Notification.class);
//                notification2.putExtra("no", false);
//
//                notification2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                PendingIntent pendingNotification2 = PendingIntent.getActivity(
//                        Send_Email.this, 1, notification2, PendingIntent.FLAG_ONE_SHOT
//                );
//                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(
//                        Send_Email.this,getString(R.string.app_name)
//                );
//                builder.setContentTitle("Request");
//                builder.setContentText("Are you sure you want to accept this request?");
//                builder.setSmallIcon(R.drawable.ic_notification);
//                builder.setSound(uri);
//                builder.setAutoCancel(true);
//                builder.setPriority(NotificationCompat.PRIORITY_HIGH);
//                builder.addAction(R.drawable.ic_launcher_foreground,"Yes", pendingNotification1);
//                builder.addAction(R.drawable.ic_launcher_foreground, "no",pendingNotification2);
//                notification.notify(1,builder.build());
//
//            }
//        });
    }

    // Send Email
    public void send(View v) {
        String fullName, email, subject, message;
        fullName = h2_FullName.getText().toString();
        email = h2_Email.getText().toString();
        subject = h2_Subject.getText().toString();
        message = h2_Message.getText().toString();

        Intent send = new Intent(Intent.ACTION_SEND);
        send.setType("message/rfc822");
        send.putExtra(Intent.EXTRA_EMAIL, new String[]{"support@app.com"});
        send.putExtra(Intent.EXTRA_SUBJECT, "contact: " + subject);
        send.putExtra(Intent.EXTRA_TEXT, "Message from: " + fullName + "User Email: " + email + "Message: " + message);
        try {
            startActivity(Intent.createChooser(send, "send email..."));

        } catch (android.content.ActivityNotFoundException e){
            Toast.makeText(this, "No email from client", Toast.LENGTH_SHORT).show();
        }
    }
    public void call(View v) {
        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:1 800 389 0535"));
        startActivity(call);
    }

}