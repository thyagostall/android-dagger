package com.thyago.dagger;

import dagger.Component;

/**
 * Created by thyago on 17/01/2017.
 */

@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
