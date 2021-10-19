package com.example.scriptsample

import androidx.lifecycle.observe

class FakeView {
    private val viewModel = FakeViewModel()
    // could also be abstract class
    private val contractViewModel: SolutionVMIContract = ContractViewModel()

    fun main() {
        // Current implementation of backing property
        viewModel.loading.observeForever {

        }

        // New implementation exposes LiveData but uses MutableLiveData as implementation detail without backing property
        contractViewModel.loading.observeForever {

        }
    }
}

