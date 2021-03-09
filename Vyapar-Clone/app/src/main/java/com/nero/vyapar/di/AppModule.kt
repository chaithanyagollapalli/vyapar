package com.nero.vyapar.di

import android.app.Application
import androidx.room.Room
import com.nero.vyapar.local.database.VyaparDatabase
import com.nero.vyapar.repository.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDataBase(
        app: Application
    ): VyaparDatabase {
        return Room.databaseBuilder(app, VyaparDatabase::class.java, "VyaparDatabase")
            .fallbackToDestructiveMigration().build()
    }


    @Provides
    @Singleton
    fun provideItemRepository(
        database: VyaparDatabase
    ): ItemsRepository {
        return ItemsRepository(database.getDAO())
    }

}