package com.tommartin.atlas.di

import com.tommartin.atlas.data.network.FetchMethods
import com.tommartin.atlas.data.repository.AtlasRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class BinderModule {
    @Binds
    abstract fun provideRepository(atlasRepository: AtlasRepository): FetchMethods
}