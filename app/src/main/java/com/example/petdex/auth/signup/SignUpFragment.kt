package com.example.petdex.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.petdex.R
import com.example.petdex.databinding.FragmentSignInBinding
import com.example.petdex.databinding.FragmentSignUpBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)

        handleSignUpAttempt()
        handleFieldErrors()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignUp.setOnClickListener {
            viewModel.onSignUpClick(
                binding.edName.text.toString(),
                binding.edLastName.text.toString(),
                binding.edEmail.text.toString(),
                binding.edPassword.text.toString(),
                binding.edRepeatPassword.text.toString()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleSignUpAttempt() {
        viewModel.isSignUpError.observe(viewLifecycleOwner, {
            Snackbar.make(
                binding.root,
                it,
                Snackbar.LENGTH_LONG
            ).show()
        })

        viewModel.isSignUpSuccessful.observe(viewLifecycleOwner, {
            //todo переход на главный экран
            Snackbar.make(
                binding.root,
                "Создание аккаунта успешно",
                Snackbar.LENGTH_LONG
            ).show()
        })
    }

    private fun handleFieldErrors() {
        viewModel.isNameEmptyError.observe(viewLifecycleOwner, {
            binding.edName.error = getString(R.string.field_empty_error)
        })

        viewModel.isLastNameEmptyError.observe(viewLifecycleOwner, {
            binding.edLastName.error = getString(R.string.field_empty_error)
        })

        viewModel.isEmailEmptyError.observe(viewLifecycleOwner, {
            binding.edEmail.error = getString(R.string.field_empty_error)
        })

        viewModel.isEmailValidError.observe(viewLifecycleOwner, {
            binding.edEmail.error = getString(R.string.email_invalid_error)
        })

        viewModel.isPasswordEmptyError.observe(viewLifecycleOwner, {
            binding.edPassword.error = getString(R.string.field_empty_error)
        })

        viewModel.isPasswordRepeatedEmptyError.observe(viewLifecycleOwner, {
            binding.edRepeatPassword.error = getString(R.string.field_empty_error)
        })

        viewModel.isPasswordMatchingError.observe(viewLifecycleOwner, {
            binding.edPassword.error = getString(R.string.password_matching_error)
            binding.edRepeatPassword.error = getString(R.string.password_matching_error)
        })
    }
}