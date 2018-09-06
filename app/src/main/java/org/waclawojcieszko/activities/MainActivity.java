package org.waclawojcieszko.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String tag = "events";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "onCreate");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(tag, "onStart()");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(tag, "onResume()");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(tag, "onRestart()");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(tag, "onPause()");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(tag, "onStop()");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(tag, "onDestroy()");
    }

}
