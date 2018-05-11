package com.example.acroapp.service;

import com.example.acroapp.service.api.NactemAPI;
import com.example.acroapp.service.to.NactemResponse;

import rx.Observable;

public class NactemService {

    private final NactemAPI nactemAPI;


    public NactemService(NactemAPI nactemAPI) {
        this.nactemAPI = nactemAPI;
    }

    public Observable<NactemResponse> getAcronyms(String acronym) {
        return nactemAPI.getAcronym(acronym);
    }

}
