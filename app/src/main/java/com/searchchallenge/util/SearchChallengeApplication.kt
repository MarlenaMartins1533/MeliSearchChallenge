package com.searchchallenge.util

import android.app.Application
import com.searchchallenge.data.dataModule
import com.searchchallenge.domain.domainModule
import com.searchchallenge.ui.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class SearchChallengeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() = startKoin {
        androidLogger(Level.DEBUG)
        androidContext(this@SearchChallengeApplication)
        modules(dataModule + domainModule + uiModule)
    }
}
