package com.example.acroapp.search;

import android.util.Log;

import com.example.acroapp.service.NactemService;
import com.example.acroapp.service.to.NactemResponse;
import com.example.acroapp.util.RxSchedulers;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 *
 */
public class SearchPresenter implements SearchContract.Presenter {

    private static final String TAG = SearchPresenter.class.getSimpleName() + "_TAG";

    private NactemService nactemService;
    private CompositeSubscription subscription;
    private SearchContract.View searchView;
    private RxSchedulers rxSchedulers;

    @Inject
    public SearchPresenter(NactemService nactemService,
                           RxSchedulers rxSchedulers,
                           SearchContract.View searchView) {
        this.nactemService = nactemService;
        this.searchView = searchView;
        this.rxSchedulers = rxSchedulers;
        subscription = new CompositeSubscription();
    }

    @Override
    public void loadData(String acronym) {
        searchView.onFetchDataStarted();
        subscription.clear();
        Subscription subs = nactemService
                .getAcronyms(acronym)
                .subscribeOn(rxSchedulers.io())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(new Observer<List<NactemResponse>>() {
                    @Override
                    public void onCompleted() {
                        searchView.onFetchDataCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        searchView.onFetchDataError(e);
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onNext(List<NactemResponse> response) {
                        searchView.onFetchDataSuccess(response.get(0).getLfs());
                    }
                });
        subscription.add(subs);
    }

    @Override
    public void unsubscribe() {
        subscription.clear();
    }

    @Override
    public void detach() {
        searchView = null;
    }

}
