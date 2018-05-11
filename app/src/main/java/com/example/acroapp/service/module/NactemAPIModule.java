package com.example.acroapp.service.module;

import com.example.acroapp.service.api.NactemAPI;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * NactemAPIModule is a dagger module class that would provide the required dependencies to generate </br>
 * concrete {@link NactemAPI} interface instance.
 */
@Module
public class NactemAPIModule {

    /**
     * Provider method to return the {@link NactemAPI} instance
     * This is a named provider method, should in the future this app interacted with more APIs
     * @param retrofit the configured {@link Retrofit} client with the Nactem API set up
     * @return the concrete {@link NactemAPI} interface instance
     */
    @Singleton
    @Provides
    public NactemAPI provideNactemAPI(@Named("nactem-client")Retrofit retrofit) {
        return retrofit.create(NactemAPI.class);
    }

}
