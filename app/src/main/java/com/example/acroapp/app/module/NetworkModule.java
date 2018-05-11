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
     * Provider method to set RxJava as the call adapter for {@link Retrofit}. Through this we can
     * use {@link rx.Observable} instead of {@link retrofit2.Call} for our network calls
     * @return The concrete instance of the {@link RxJavaCallAdapterFactory}
     */
    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    /**
     * Provider method for {@link Retrofit}'s converter factory. Retrofit can be configure with
     * different converters like Moshi, Jackson and/or SimpleXML. This method provides GSON's concrete
     * {@link GsonConverterFactory} instance
     * @return The concrete instance of {@link GsonConverterFactory}
     */
    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    /**
     * Provider method for the configured {@link OkHttpClient} through this method we can set different
     * and/or multiple interceptors, timeout values, etc.
     * @param loggingInterceptor the already configured {@link HttpLoggingInterceptor} instance.
     * @return the built {@link OkHttpClient} client
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
     * Provider method for the configured {@link HttpLoggingInterceptor} instance. Current level is
     * set to BASIC, but further configuration can be enabled through {@link com.example.acroapp.BuildConfig}
     * flags for different levels set to release or debug apks
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
