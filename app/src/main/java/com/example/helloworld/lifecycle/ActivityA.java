package com.example.helloworld.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.helloworld.R;

public class ActivityA extends Activity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        setTitle("A");
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
        Log.d(ActivityA.TAG, "onResume A");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(ActivityA.TAG, "onStart A");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(ActivityA.TAG, "onPause A");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(ActivityA.TAG, "onStop A");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(ActivityA.TAG,"onRestart A");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(ActivityA.TAG, "onDestroy A");
    }
}