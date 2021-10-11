package com.example.petdex.auth.resetpassword

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.petdex.R
import com.example.petdex.databinding.FragmentResetPasswordBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : Fragment(R.layout.fragment_reset_password) {
    private var _binding: FragmentResetPasswordBinding? = null
    private val binding get() = _binding!!
    private val viewModel:ResetPasswordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResetPasswordBinding.inflate(layoutInflater, container, false)

        handleResetPasswordAttempt()
        handleFieldErrors()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnResetPassword.setOnClickListener {
            viewModel.onResetPasswordClicked(binding.edEmail.text.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleResetPasswordAttempt(){
        viewModel.isResetPasswordError.observe(viewLifecycleOwner, {
            Snackbar.make(
                binding.root,
                it,
                Snackbar.LENGTH_LONG
            ).show()
        })

        viewModel.isResetPasswordSuccessful.observe(viewLifecycleOwner, {
            showResetPasswordDialog()
        })
    }

    private fun showResetPasswordDialog(){
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.apply {
            setTitle(getString(R.string.reset_password_dialog_title))
            setMessage(getString(R.string.reset_password_dialog_text))
            setNeutralButton(getString(R.string.cancel)) { _, _ -> }
        }.create().show()
    }

    private fun handleFieldErrors(){
        viewModel.isEmailEmptyError.observe(viewLifecycleOwner, {
            binding.edEmail.error = getString(R.string.field_empty_error)
        })

        viewModel.isEmailValidError.observe(viewLifecycleOwner, {
            binding.edEmail.error = getString(R.string.email_invalid_error)
        })
    }
}