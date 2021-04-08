package com.pratama.coroutineandroid

import android.view.LayoutInflater
import com.pratama.coroutineandroid.base.BaseActivityBinding
import com.pratama.coroutineandroid.databinding.ActivityMainBinding

class MainActivity : BaseActivityBinding<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setupView(binding: ActivityMainBinding) {

    }

}