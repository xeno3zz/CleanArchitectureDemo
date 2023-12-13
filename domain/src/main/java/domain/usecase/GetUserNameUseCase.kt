package domain.usecase

import domain.repository.UserRepository
import domain.models.UserName

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}