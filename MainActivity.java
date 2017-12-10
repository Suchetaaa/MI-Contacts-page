package com.example.satyakaam.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

public void sendemail(View v)
{
    Intent intent=null, chooser=null;
    intent = new Intent(Intent.ACTION_SEND);
    intent.setData(Uri.parse("mailto"));
    Button b= (Button)v;
    String buttonText=b.getText().toString();
    intent.putExtra(Intent.EXTRA_EMAIL, buttonText);
    intent.setType("message/rfc822");
    chooser=Intent.createChooser(intent, "Send Email");
    startActivity(chooser);
}

public void call(View v)
{
    Button b = (Button)v;
    String phoneNumber=b.getText().toString();
    String uri = "tel:" + phoneNumber;
    Intent intent = new Intent(Intent.ACTION_DIAL);
    intent.setData(Uri.parse(uri));
    startActivity(intent);
}