package com.example.acroapp.util;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AppRxSchedulers implements RxSchedulers {

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler androidThread() {
        return AndroidSchedulers.mainThread();
    }

}
