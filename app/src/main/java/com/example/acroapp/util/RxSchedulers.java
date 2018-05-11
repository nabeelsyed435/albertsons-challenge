package com.example.acroapp.util;

import rx.Scheduler;

/**
 * This interface abstracts the different {@link rx.schedulers.Schedulers} we have available with
 * RxJava. If required we can also add an abstract method for a computation scheduler or more.
 */
public interface RxSchedulers {

    /**
     * This method provides the reference to the RxJava io {@link Scheduler}
     * @return the io {@link Scheduler}
     */
    Scheduler io();

    /**
     * This method provides the reference to the {@link rx.android.schedulers.AndroidSchedulers} main thread
     * @return the mainThread {@link Scheduler}
     */
    Scheduler androidThread();

}
