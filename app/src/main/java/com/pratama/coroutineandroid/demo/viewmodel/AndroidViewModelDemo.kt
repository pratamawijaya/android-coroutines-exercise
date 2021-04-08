package com.pratama.coroutineandroid.demo.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import com.pratama.coroutineandroid.base.BaseFragmentBinding
import com.pratama.coroutineandroid.databinding.FragmentAndroidViewmodelBinding

class AndroidViewModelDemo : BaseFragmentBinding<FragmentAndroidViewmodelBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAndroidViewmodelBinding
        get() = FragmentAndroidViewmodelBinding::inflate

    override fun setupView(binding: FragmentAndroidViewmodelBinding) {
    }
}