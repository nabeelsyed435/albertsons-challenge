package com.example.acroapp.search;

import com.example.acroapp.service.to.Lf;
import com.example.acroapp.service.to.NactemResponse;

import java.util.List;

/**
 * SearchContract is the binding contract for the Search feature.
 * This interface defines the roles for View and Presenter in this user path
 */
public interface SearchContract {

    /**
     * View interface provides places to notify the user of a result based on interaction
     */
    interface View {

        /**
         * This method allows the app to show progress as well as collect analytic events like user engagement
         */
        void onFetchDataStarted();

        /**
         * This method allows the app to collect production stability events through services like Firebase
         * as well as analytics data
         */
        void onFetchDataCompleted();

        /**
         * This method is the main entry point once search results are received from the API
         * @param acronyms
         */
        void onFetchDataSuccess(List<Lf> acronyms);

        /**
         * This method allows the app to collect production stability events through services like Firebase
         * Crash Reporting, and ultimately notifying the user that something has gone wrong
         * @param throwable
         */
        void onFetchDataError(Throwable throwable);
    }

    /**
     * Presenter interface provides the entry points for the application to react based on a user request
     * as well as to deal with thew view lifecycle
     */
    interface Presenter {

        /**
         * Searches the Nactem API for the users acronym input query {@link String}
         * @param acronym the {@link String} value of the acronym to search
         */
        void loadData(String acronym);

        /**
         * Unsubscribe the observer as user has navigated away from the View
         */
        void unsubscribe();

        /**
         * Ultimately remove the reference to view once its been destroyed
         */
        void detach();

    }

}
