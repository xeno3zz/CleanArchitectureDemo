package domain.usecase

import domain.repository.UserRepository
import domain.models.SaveUserNameParam

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean{
        val result = userRepository.saveName(param = param)
        return result
    }
}