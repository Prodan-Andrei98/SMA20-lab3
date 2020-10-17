package com.example.helloworld.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;


public class MainIntentActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_intent);



        final Button buttonA = (Button) findViewById(R.id.buttonA);
        buttonA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String googleUrl = "https://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(googleUrl));
                startActivity(i);
            }

        });

        final Button buttonB = (Button) findViewById(R.id.buttonB);
        buttonB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                Uri.parse("tel:00401213456");
                startActivity(i);
            }

        });
        final Button buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent("com.e.helloandroid2.intents.LAUNCH", Uri.parse("www.google.com"));
                startActivity(i);
            }

        });
        final Button buttonD = (Button) findViewById(R.id.buttonD);
        buttonD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent("com.e.helloandroid2.intents.LAUNCH", Uri.parse("tel:00401213456"));
                startActivity(i);
            }

        });

    }
}
