package com.thyago.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by thyago on 17/01/2017.
 */

@Module
public class AppModule {

    @Provides
    public NameGenerator provideNameGenerator() {
        return new NameGenerator();
    }

}
