package com.example.acroapp.service.api;

import com.example.acroapp.service.to.NactemResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface NactemAPI {

    String NACTEM_API_URL = "http://www.nactem.ac.uk/";

    @GET("software/acromine/dictionary.py")
    Observable<List<NactemResponse>> getAcronym(@Query("sf") String sf);

}
