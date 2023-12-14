package di

import data.respository.UserRepositoryImpl
import data.storage.UserStorage
import data.storage.sharedPrefs.SharedPrefUserStorage
import domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get()) //get() ищет зависимость для контекста
    }
    single<UserRepository> { UserRepositoryImpl(userStorage = get()) }
}
