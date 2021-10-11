package com.example.petdex.auth.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.domain.base.SingleLiveEvent
import com.example.domain.base.Utilities.isValidEmail

class SignUpViewModel : ViewModel() {
    private val _isPasswordMatchingError = SingleLiveEvent<Boolean>()
    val isPasswordMatchingError: LiveData<Boolean> get() = _isPasswordMatchingError

    private val _isNameEmptyError = SingleLiveEvent<Boolean>()
    val isNameEmptyError: LiveData<Boolean> get() = _isNameEmptyError

    private val _isLastNameEmptyError = SingleLiveEvent<Boolean>()
    val isLastNameEmptyError: LiveData<Boolean> get() = _isLastNameEmptyError

    private val _isEmailEmptyError = SingleLiveEvent<Boolean>()
    val isEmailEmptyError: LiveData<Boolean> get() = _isEmailEmptyError

    private val _isEmailValidError = SingleLiveEvent<Boolean>()
    val isEmailValidError: LiveData<Boolean> get() = _isEmailValidError

    private val _isPasswordEmptyError = SingleLiveEvent<Boolean>()
    val isPasswordEmptyError: LiveData<Boolean> get() = _isPasswordEmptyError

    private val _isPasswordRepeatedEmptyError = SingleLiveEvent<Boolean>()
    val isPasswordRepeatedEmptyError: LiveData<Boolean> get() = _isPasswordRepeatedEmptyError

    private val _isSignUpError = SingleLiveEvent<String>()
    val isSignUpError: LiveData<String> get() = _isSignUpError

    private val _isSignUpSuccessful = SingleLiveEvent<String>()
    val isSignUpSuccessful: LiveData<String> get() = _isSignUpSuccessful

    fun onSignUpClick(
        name: String?,
        lastName: String?,
        email: String?,
        password: String?,
        repeatedPassword: String?
    ) {
        if (
            !name.isNullOrBlank()
            && !lastName.isNullOrBlank()
            && !email.isNullOrBlank()
            && email.isValidEmail()
            && !password.isNullOrBlank()
            && !repeatedPassword.isNullOrBlank()
            && password == repeatedPassword
        )
            signUp(name, lastName, email, password, repeatedPassword)
        else {
            if (name.isNullOrBlank()) _isNameEmptyError.call()
            if (lastName.isNullOrBlank()) _isLastNameEmptyError.call()
            if (email.isNullOrBlank()) _isEmailEmptyError.call()
            if (!email.isNullOrBlank() && !email.isValidEmail()) _isEmailValidError.call()
            if (password.isNullOrBlank()) _isPasswordEmptyError.call()
            if (repeatedPassword.isNullOrBlank()) _isPasswordRepeatedEmptyError.call()
            if (password != repeatedPassword) _isPasswordMatchingError.call()
        }
    }

    private fun signUp(
        name: String,
        lastName: String,
        email: String,
        password: String,
        repeatedPassword: String
    ) {
        //todo создание аккаунта
        _isSignUpError.value = "u suck"
    }
}