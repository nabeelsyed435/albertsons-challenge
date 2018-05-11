package com.example.acroapp.search;

import com.example.acroapp.app.component.AppComponent;

import dagger.Component;

@SearchScope
@Component(dependencies = {AppComponent.class}, modules = {SearchModule.class})
public interface SearchComponent {
    void inject(SearchActivity searchActivity);
}
