package com.example.petdex.auth.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.domain.base.SingleLiveEvent
import com.example.domain.base.Utilities.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(): ViewModel() {
    private val _isEmailEmptyError = SingleLiveEvent<Boolean>()
    val isEmailEmptyError: LiveData<Boolean> get() = _isEmailEmptyError

    private val _isEmailValidError = SingleLiveEvent<Boolean>()
    val isEmailValidError: LiveData<Boolean> get() = _isEmailValidError

    private val _isPasswordEmptyError = SingleLiveEvent<Boolean>()
    val isPasswordEmptyError: LiveData<Boolean> get() = _isPasswordEmptyError

    private val _isSignInError = SingleLiveEvent<String>()
    val isSignInError: LiveData<String> get() = _isSignInError

    private val _isSignInSuccessful = SingleLiveEvent<String>()
    val isSignInSuccessful: LiveData<String> get() = _isSignInSuccessful

    fun onSignInClick(email: String?, password: String?) {
        if (!email.isNullOrBlank() && email.isValidEmail() && !password.isNullOrBlank())
            signIn(email, password)
        else {
            if (email.isNullOrBlank()) _isEmailEmptyError.call()
            if (!email.isNullOrBlank() && !email.isValidEmail()) _isEmailValidError.call()
            if (password.isNullOrBlank()) _isPasswordEmptyError.call()
        }
    }

    private fun signIn(email: String, password: String) {
        //todo вход в аккаунт
        _isSignInError.value = "lol no"
    }
}