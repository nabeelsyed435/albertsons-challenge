package com.example.acroapp.search;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {
    private final SearchContract.View searchView;

    public SearchModule(SearchContract.View searchView) {
        this.searchView = searchView;
    }

    @SearchScope
    @Provides
    public SearchContract.View provideSearchView() {
        return searchView;
    }

}
