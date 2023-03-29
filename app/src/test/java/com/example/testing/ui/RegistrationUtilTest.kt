package com.example.testing.ui


import com.example.testing.utils.RegistrationUtil
import com.example.testing.models.User
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `Should return false for invalidate input`() {
        val user = User(null, "123", "123")
        val isValidInput = RegistrationUtil.validateRegistrationInput(user)
        assertFalse(isValidInput)
    }


    @Test
    fun `Should return true for valid input`() {
        val user = User("Philipp", "123", "123")
        val result = RegistrationUtil.validateRegistrationInput(user)
        assertTrue(result)
    }

    @Test
    fun `Should return false for non identical passwords`() {
        val user = User("Philipp", "123", "132")
        val result = RegistrationUtil.validateRegistrationInput(user)
        assertFalse(result)
    }

    @Test
    fun `Should return user already exist`() {
        val user = User("Carl", "123", "123")
        val result = RegistrationUtil.isUserExist(user)
        assertTrue(result)
    }


    //empty password
    //password was repeated incorrectly
    //password contains less than 2 digits

}