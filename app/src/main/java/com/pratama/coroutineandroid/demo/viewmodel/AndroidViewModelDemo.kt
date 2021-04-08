package com.pratama.coroutineandroid.demo.viewmodel

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pratama.coroutineandroid.base.BaseFragmentBinding
import com.pratama.coroutineandroid.databinding.FragmentAndroidViewmodelBinding
import com.pratama.coroutineandroid.getCurrentThread

class AndroidViewModelDemo : BaseFragmentBinding<FragmentAndroidViewmodelBinding>() {

    private val viewModel: MyViewModel by viewModels()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAndroidViewmodelBinding
        get() = FragmentAndroidViewmodelBinding::inflate

    override fun setupView(binding: FragmentAndroidViewmodelBinding) {

        with(binding) {
            btnStartTracking.setOnClickListener {
                viewModel.toggleTrackElapsedTime()
            }
        }

        viewModel.elapsedTime.observe(viewLifecycleOwner, {
            Log.d("debug", "elapsed time : $it")
            binding.tvCounter.text = "$it"
        })

        viewModel.isTrackingTime.observe(viewLifecycleOwner, {
            Log.d("debug", "is tracking time : $it")
            binding.btnStartTracking.text = if (it) "Stop" else "Start Tracking"
        })
    }

    override fun onStop() {
        super.onStop()
        getCurrentThread("on stop")
    }
}