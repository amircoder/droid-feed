package com.droidfeed.di

import com.droidfeed.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Dogan Gulcan on 9/22/17.
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)
}