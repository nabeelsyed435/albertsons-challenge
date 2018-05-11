package com.example.acroapp.service.api;

import com.example.acroapp.service.to.NactemResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface NactemAPI {

    String NACTEM_API_ULR = "http://www.nactem.ac.uk/";

    @GET("software/acromine/dictionary.py")
    Observable<NactemResponse> getAcronym(@Query("sf") String sf);

}
