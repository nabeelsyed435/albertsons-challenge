package com.example.acroapp.util;

import rx.Scheduler;

public interface RxSchedulers {

    Scheduler io();
    Scheduler androidThread();

}
