package com.example.acroapp.search;

import com.example.acroapp.app.component.AppComponent;

import dagger.Component;

/**
 * SearchComponent is a Dagger sub-component that depends on the {@link AppComponent}. This component
 * will enable the {@link SearchPresenter} to be injected with the {@link SearchContract.View} instance
 * as well as other application wide dependencies
 */
@SearchScope
@Component(dependencies = {AppComponent.class}, modules = {SearchModule.class})
public interface SearchComponent {

    /**
     * Abstract method to perform the actual injection in the {@link SearchActivity}
     * @param searchActivity the {@link SearchActivity} instance to be injected
     */
    void inject(SearchActivity searchActivity);

}
