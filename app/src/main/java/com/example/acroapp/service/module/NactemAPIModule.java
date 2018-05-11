package com.example.acroapp.service.module;

import com.example.acroapp.service.api.NactemAPI;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 *
 */
@Module
public class NactemAPIModule {

    @Singleton
    @Provides
    public NactemAPI provideNactemAPI(@Named("nactem-client")Retrofit retrofit) {
        return retrofit.create(NactemAPI.class);
    }

}
