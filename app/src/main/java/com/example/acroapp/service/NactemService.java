package com.example.acroapp.service;

import com.example.acroapp.service.api.NactemAPI;
import com.example.acroapp.service.to.NactemResponse;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class NactemService {

    private final NactemAPI nactemAPI;

    @Inject
    public NactemService(NactemAPI nactemAPI) {
        this.nactemAPI = nactemAPI;
    }

    public Observable<List<NactemResponse>> getAcronyms(String acronym) {
        return nactemAPI.getAcronym(acronym);
    }

}
