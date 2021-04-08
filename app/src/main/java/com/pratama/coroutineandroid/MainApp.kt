package com.pratama.coroutineandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pratama.coroutineandroid.base.BaseFragmentBinding
import com.pratama.coroutineandroid.databinding.FragmentMainAppBinding

class MainApp : BaseFragmentBinding<FragmentMainAppBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMainAppBinding
        get() = FragmentMainAppBinding::inflate

    override fun setupView(binding: FragmentMainAppBinding) {
        with(binding) {
            btnViewModel.setOnClickListener {
                findNavController().navigate(R.id.action_mainApp_to_androidViewModelDemo)
            }
        }
    }
}