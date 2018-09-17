package org.waclawojcieszko.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String tag = "events";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialogWindow2(View v){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setTitle("Pobieram dane...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which){
                    Toast.makeText(getBaseContext(),"Kliknięto OK", Toast.LENGTH_SHORT).show();
                }
            });
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Anuluj",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Kliknięto Anuluj", Toast.LENGTH_SHORT).show();
                    }
                });
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i<=10; ++i){
                    try {
                        Thread.sleep(1500);
                        progressDialog.incrementProgressBy(10);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                progressDialog.dismiss();
            }
        }).start();
    }

    public void dialogWindow(View view){
        final ProgressDialog dialog = ProgressDialog.show(this, "Ralizuję zadanie", "Proszę czekać...");
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                    } catch (InterruptedException e){
                    e.printStackTrace();
                }
                dialog.dismiss();
            }
        }).start();
    }

    public void dialogWindow3(View view){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Informacja");
        dialogBuilder.setMessage("Witamy w aplikacji");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getBaseContext(), "Okienko zostało zamknięte", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
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
