package com.example.ufours_24.workmanager;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;


public class MainActivity extends AppCompatActivity
{

    private WorkManager mWorkManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWorkManager = WorkManager.getInstance();

        findViewById(R.id.oneTimeRequest).setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                startWorkManager();
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

        OneTimeWorkRequest request2 = new OneTimeWorkRequest
                .Builder(MyWorker.class)
                .setConstraints(networkConstraints())
                .build();


        mWorkManager.enqueue(request2);



    }

    private void startWorkManager() {
        PeriodicWorkRequest someWork = new PeriodicWorkRequest.Builder(MyWorker.class,15,TimeUnit.MINUTES)
                .setConstraints(networkConstraints())
                .build();
        mWorkManager.enqueue(someWork);
    }

    private Constraints networkConstraints() {
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        return constraints;
    }

}
