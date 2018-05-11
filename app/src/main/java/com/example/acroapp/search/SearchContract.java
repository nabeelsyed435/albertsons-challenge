package com.example.acroapp.search;

import com.example.acroapp.service.to.NactemResponse;

/**
 *
 */
public interface SearchContract {

    /**
     *
     */
    interface View {

        /**
         *
         */
        void onFetchDataStarted();

        /**
         *
         */
        void onFetchDataCompleted();

        /**
         *
         * @param nactemResponse
         */
        void onFetchDataSuccess(NactemResponse nactemResponse);

        /**
         *
         * @param throwable
         */
        void onFetchDataError(Throwable throwable);
    }

    /**
     *
     */
    interface Presenter {

        /**
         *
         */
        void loadData();

        /**
         *
         */
        void subscribe();

        /**
         *
         */
        void unsubscribe();

        /**
         *
         */
        void onDestroy();

    }

}
