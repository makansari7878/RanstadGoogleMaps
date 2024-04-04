package com.ansari.myapplication

object RegistrationUtil {

    var existingUsers = listOf("abc","xyz")
    /**
     * Test Cases
     * username / pwd is empty
     * username is already present
     * pwd contains less than 2 digits
     */
    fun validateRegistrationInput(
        userName : String,
        password : String,
        confirmPassword : String,
    ) : Boolean{
        if (userName.isEmpty() || password.isEmpty()){
            return  false
        }
        else{
            return true
        }

        if(password != confirmPassword){
            return false
        }else{ return  true}
    }
}
