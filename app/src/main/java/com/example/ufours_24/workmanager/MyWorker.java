package com.example.ufours_24.workmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Result;
import androidx.work.Worker;
import androidx.work.WorkerParameters;


public class MyWorker extends Worker
{
    private static final String TAG = "MyWorker";

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams)
    {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork()
    {
        Log.d(TAG, "doWork called");
        return Result.success();
    }
}