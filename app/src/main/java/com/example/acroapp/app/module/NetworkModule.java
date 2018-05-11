package com.example.acroapp.app.module;

import com.example.acroapp.service.api.NactemAPI;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * NetworkModule is a dagger module class that would provide the required dependencies to generate </br>
 * configured {@link Retrofit} clients. This is possible through the use of @Named qualifiers.
 *
 * With this setup AcroApp can work with multiple API services cleanly.
 */
@Module
public class NetworkModule {

    /**
     * Named retrofit client configured to work with the Nactem REST API service
     *
     * @param okHttpClient Provided instance of the OkHttpClient enabled with a logging interceptor
     * @param converterFactory Provided instance of the GSON Converter for mapping JSON to POJOs
     * @param callAdapterFactory Provided instance of the RxJava call adapter to work with {@link rx.Observable}
     * @return The built {@link Retrofit} client instance
     */
    @Singleton
    @Provides
    @Named("nactem-client")
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, GsonConverterFactory converterFactory, RxJavaCallAdapterFactory callAdapterFactory) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NactemAPI.NACTEM_API_URL)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build();
        return retrofit;
    }

    /**
     *
     * @return
     */
    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    /**
     *
     * @return
     */
    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    /**
     *
     * @param loggingInterceptor
     * @return
     */
    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build();
        return client;
    }

    /**
     *
     * @return
     */
    @Singleton
    @Provides
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return loggingInterceptor;
    }

}
