package com.example.testing.utils

import com.example.testing.models.User

object RegistrationUtil {

    private val existingUsers = listOf(User("Peter"), User("Carl"))
    private const val MINIMUM_CHAR_REQUIRED = 2

    /**
     * the input is not valid if...
     * ... the username/password is empty
     * ... the username is already taken
     * ... the confirmed password is not the same as the real password
     * ... the password contains less than 2 digits
     */
    fun validateRegistrationInput(user: User): Boolean {
        val (userName, password, confirmationPassword) = user
        return !userName.isNullOrEmpty() && !password.isNullOrEmpty() && !confirmationPassword.isNullOrEmpty() &&
                password == confirmationPassword && password.length >= MINIMUM_CHAR_REQUIRED
    }

    fun isUserExist(user: User): Boolean {
        existingUsers.forEach { currUser ->
            if (currUser.userName == user.userName) {
                return true
            }
        }
        return false
    }
}