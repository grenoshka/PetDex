package com.example.petdex.auth.resetpassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.base.SingleLiveEvent
import com.example.domain.base.Utilities.isValidEmail
import com.example.domain.usecase.ResetPasswordParams
import com.example.domain.usecase.ResetPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor(private val resetPasswordUseCase: ResetPasswordUseCase) :
    ViewModel() {
    private val _isEmailEmptyError = SingleLiveEvent<Boolean>()
    val isEmailEmptyError: LiveData<Boolean> get() = _isEmailEmptyError

    private val _isEmailValidError = SingleLiveEvent<Boolean>()
    val isEmailValidError: LiveData<Boolean> get() = _isEmailValidError

    private val _isResetPasswordError = SingleLiveEvent<String>()
    val isResetPasswordError: LiveData<String> get() = _isResetPasswordError

    private val _isResetPasswordSuccessful = SingleLiveEvent<String>()
    val isResetPasswordSuccessful: LiveData<String> get() = _isResetPasswordSuccessful

    fun onResetPasswordClicked(email: String?) {
        if (!email.isNullOrBlank() && email.isValidEmail())
            resetPassword(email)
        else {
            if (email.isNullOrBlank()) _isEmailEmptyError.call()
            if (!email.isNullOrBlank() && !email.isValidEmail()) _isEmailValidError.call()
        }
    }

    private fun resetPassword(email: String) {
        viewModelScope.launch {
            if (resetPasswordUseCase.invoke(ResetPasswordParams(email)).isSuccess)
                _isResetPasswordSuccessful.call()
            else
                _isResetPasswordError.call()
        }
    }
}