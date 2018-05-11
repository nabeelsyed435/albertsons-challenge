package com.example.acroapp.service;

import com.example.acroapp.service.api.NactemAPI;
import com.example.acroapp.service.to.NactemResponse;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * NactemService serves as a wrapper and entry point for presenters wishing to interact with the
 * Nactem API
 */
public class NactemService {

    private final NactemAPI nactemAPI;

    @Inject
    public NactemService(NactemAPI nactemAPI) {
        this.nactemAPI = nactemAPI;
    }

    /**
     * Returns the {@link retrofit2.Retrofit} {@link Observable} call querying the Nactem API with the
     * input {@link String} argument
     *
     * @param acronym {@link String} argument with the acronym to search
     * @return the {@link Observable<List<NactemResponse>>} that will interact with the API upon subscription
     */
    public Observable<List<NactemResponse>> getAcronyms(String acronym) {
        return nactemAPI.getAcronym(acronym);
    }

}
