package com.example.helloworld.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.helloworld.R;

public class ActivityC extends Activity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        setTitle("C");
        Log.d(TAG, "onCreate C");
    }

    public void clicked(View view){
        switch(view.getId()){
            case R.id.buttonSA:
                startActivity(new Intent(this, ActivityC.class));
                break;
            case R.id.buttonSB:
                startActivity(new Intent(this, ActivityC.class));
                break;
            case R.id.buttonSC:
                startActivity(new Intent(this, ActivityC.class));
                break;
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(ActivityC.TAG, "onResume C");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(ActivityC.TAG, "onStart C");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(ActivityC.TAG, "onPause C");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(ActivityC.TAG, "onStop C");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(ActivityC.TAG,"onRestart C");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(ActivityC.TAG, "onDestroy C");
    }
}
