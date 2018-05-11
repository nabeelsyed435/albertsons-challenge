package com.example.acroapp.service.api;

import com.example.acroapp.service.to.NactemResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * NactemAPI is the {@link retrofit2.Retrofit} interface with the endpoints the {@link com.example.acroapp.app.AcroApp} interacts
 */
public interface NactemAPI {

    /**
     * Constant {@link String} value with the Nactem API base URL
     */
    String NACTEM_API_URL = "http://www.nactem.ac.uk/";

    @GET("software/acromine/dictionary.py")
    Observable<List<NactemResponse>> getAcronym(@Query("sf") String sf);

}
