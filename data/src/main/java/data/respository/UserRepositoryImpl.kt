package data.respository



import data.storage.models.User
import data.storage.UserStorage
import domain.models.SaveUserNameParam
import domain.models.UserName
import domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveName(saveParam: SaveUserNameParam): Boolean{
        val user = User(firstName = saveParam.name, "")
        val result = userStorage.save(user)
        return result
    }
    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = UserName(firstName = user.firstName, lastName = user.lastName)
        return userName
    }
}