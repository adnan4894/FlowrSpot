package com.example.flowrspot.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<B : ViewDataBinding, ViewModel : BaseViewModel<Model, State>, Model, State : BaseFullScreenState>(
    val layout: Int, private val viewModelClass: Class<ViewModel>
) : Fragment() {

    protected lateinit var binding: B

    val viewModel: ViewModel by lazy {
        ViewModelProvider(this).get(viewModelClass)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        onLoad()
    }

    protected abstract fun initUI()

    protected abstract fun onLoad()

}