package com.ansari.myapplication

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{
    @Test
    fun emptyUsernameTest(){
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "233",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result).isFalse()
    }


    @Test
    fun validateUsernameAndRepeatPasswordTest(){
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "lmn",
            password = "123",
            confirmPassword = "234"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `password repeated incorrectly returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Peter",
            "1234",
            "1234"
        )
        assertThat(result).isTrue()
    }


}
