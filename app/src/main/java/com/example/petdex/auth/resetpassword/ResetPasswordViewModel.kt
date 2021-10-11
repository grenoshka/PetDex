package com.example.petdex.auth.resetpassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.domain.base.SingleLiveEvent
import com.example.domain.base.Utilities.isValidEmail

class ResetPasswordViewModel: ViewModel() {
    private val _isEmailEmptyError = SingleLiveEvent<Boolean>()
    val isEmailEmptyError: LiveData<Boolean> get() = _isEmailEmptyError

    private val _isEmailValidError = SingleLiveEvent<Boolean>()
    val isEmailValidError: LiveData<Boolean> get() = _isEmailValidError

    private val _isResetPasswordError = SingleLiveEvent<String>()
    val isResetPasswordError: LiveData<String> get() = _isResetPasswordError

    private val _isResetPasswordSuccessful = SingleLiveEvent<String>()
    val isResetPasswordSuccessful: LiveData<String> get() = _isResetPasswordSuccessful

    fun onResetPasswordClicked(email:String?){
        if (!email.isNullOrBlank() && email.isValidEmail())
            resetPassword(email)
        else {
            if (email.isNullOrBlank()) _isEmailEmptyError.call()
            if (!email.isNullOrBlank() && !email.isValidEmail()) _isEmailValidError.call()
        }
    }

    private fun resetPassword(email:String){
        //todo восстановление пароля
        _isResetPasswordError.value = "no reset idk"
    }
}