package com.example.daggersample;


import dagger.Subcomponent;

@Subcomponent
public interface UserComponent {

    @Subcomponent.Factory
    interface Factory{
    UserComponent create();
    }

    void inject(MainActivity activity);
}
