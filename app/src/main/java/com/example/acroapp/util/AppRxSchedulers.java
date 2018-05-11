package com.example.acroapp.util;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * AppRxSchedulers class is the concrete implementation of the {@link RxSchedulers} interface
 */
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
