package com.example.helloworld.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.helloworld.R;

public class ActivityB extends Activity {


    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        setTitle("B");
        Log.d(TAG, "onCreate B");
    }

    public void clicked(View view){
        switch(view.getId()){
            case R.id.buttonSA:
                startActivity(new Intent(this, ActivityB.class));
                break;
            case R.id.buttonSB:
                startActivity(new Intent(this, ActivityB.class));
                break;
            case R.id.buttonSC:
                startActivity(new Intent(this, ActivityC.class));
                break;
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(ActivityB.TAG, "onResume B");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(ActivityB.TAG, "onStart B");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(ActivityB.TAG, "onPause B");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(ActivityB.TAG, "onStop B");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(ActivityB.TAG,"onRestart B");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(ActivityB.TAG, "onDestroy B");
    }
}