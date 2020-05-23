package com.example.draft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class ExampleActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1001;
    TelephonyManager telephonyManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

         telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#
            String strIemi = telephonyManager.getDeviceId();
            Log.i("xxx", "onRequestPermissionsResult: "+strIemi);

            //return;
        }else{
            Log.i("xxx", "permission requirement");
            ActivityCompat.requestPermissions(ExampleActivity.this,new String[]{Manifest.permission.READ_PHONE_STATE},PERMISSION_REQUEST_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==PERMISSION_REQUEST_CODE && grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED ){
            String strIemi = telephonyManager.getDeviceId();
            Log.i("xxx", "onRequestPermissionsResult: "+strIemi);
        }
    }
}
