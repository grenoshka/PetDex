package com.example.petdex.auth.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.petdex.R
import com.example.petdex.databinding.FragmentSignInBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(layoutInflater, container, false)

        handleSignInAttempt()
        handleFieldErrors()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignIn.setOnClickListener {
            viewModel.onSignInClick(
                binding.edEmail.text.toString(),
                binding.edPassword.text.toString()
            )
        }
        binding.tvForgotPassword.setOnClickListener {
            val action = SignInFragmentDirections.actionSignInFragmentToResetPasswordFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleSignInAttempt() {
        viewModel.isSignInSuccessful.observe(viewLifecycleOwner, {
            //todo переход на главный экран
            Snackbar.make(
                binding.root,
                "Вход в аккаунт успешен",
                Snackbar.LENGTH_LONG
            ).show()
        })
        viewModel.isSignInError.observe(viewLifecycleOwner, {
            Snackbar.make(
                binding.root,
                it,
                Snackbar.LENGTH_LONG
            ).show()
        })
    }

    private fun handleFieldErrors() {
        viewModel.isEmailEmptyError.observe(viewLifecycleOwner, {
            binding.edEmail.error = getString(R.string.field_empty_error)
        })

        viewModel.isEmailValidError.observe(viewLifecycleOwner, {
            binding.edEmail.error = getString(R.string.email_invalid_error)
        })

        viewModel.isPasswordEmptyError.observe(viewLifecycleOwner, {
            binding.edPassword.error = getString(R.string.field_empty_error)
        })
    }
}