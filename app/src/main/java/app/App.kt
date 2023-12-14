package app
import android.app.Application
import di.appModule
import di.dataModule
import di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR) //насколько сильно логируются ошибки
            androidContext(this@App) //applicationContext в MainActivity - это файл App
            modules(listOf(appModule, domainModule, dataModule))
        }
    }

}

