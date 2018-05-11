package com.example.acroapp.search;

import com.example.acroapp.service.to.Lf;
import com.example.acroapp.service.to.NactemResponse;

import java.util.List;

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
         * @param acronyms
         */
        void onFetchDataSuccess(List<Lf> acronyms);

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
         * @param acronym
         */
        void loadData(String acronym);

        /**
         *
         */
        void unsubscribe();

        /**
         *
         */
        void detach();

    }

}
