package com.example.acroapp.app.component;

import com.example.acroapp.app.module.NetworkModule;
import com.example.acroapp.service.api.NactemAPI;
import com.example.acroapp.service.module.NactemAPIModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, NactemAPIModule.class})
public interface AppComponent {
    NactemAPI nactemApi();
}
