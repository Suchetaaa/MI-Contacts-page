package com.example.satyakaam.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

public void sendemail(View v)
{
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setData(Uri.parse("mailto"));
    TextView b= (TextView)v;
    String buttonText=b.getText().toString();
    intent.putExtra(Intent.EXTRA_EMAIL, buttonText);
    intent.setType("text/plain");
    Intent chooser=Intent.createChooser(intent, "Send Email");
    startActivity(chooser);
}

public void call(View v)
{
    TextView b = (TextView)v;
    String phoneNumber=b.getText().toString();
    String uri = "tel:" + phoneNumber;
    Intent intent = new Intent(Intent.ACTION_DIAL);
    intent.setData(Uri.parse(uri));
    startActivity(intent);
}