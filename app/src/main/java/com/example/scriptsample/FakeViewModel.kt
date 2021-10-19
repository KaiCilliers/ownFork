package com.example.scriptsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class FakeViewModel {
    // Current implementation of backing property
    val loading: LiveData<Boolean>
        get() = _loading
    private val _loading = MutableLiveData<Boolean>()
}

/**
 * This is cool, it fits wth my contract approach to programming
 * It forces you to specify the type to have the benefit of LiveData
 * If you use the implementation classes directly, you will have access
 * to MutableLiveData (implementation detail)
 *
 * I already planned on having contracts for each VM so adding the field is not
 * a problem. I plan on having a generic abstract base VM and then individual contracts
 * for each of my own VMs
 *
 * Cool approach - it would clean up the ViewModels from all the backing properties
 * and also provide more contracts to project which I consider good
 * But a native solution would be better from Kotlin to support this feature
 *
 * There is a delegate option but I prefer the interface/abstract approach due
 * to the current planned project architecture making heavy use of interfaces
 * https://itnext.io/re-avoid-backing-properties-for-livedata-and-stateflow-2160cab96b56
 */
interface SolutionVMIContract {
    val loading: LiveData<Boolean>
}

class ContractViewModel: ViewModel(), SolutionVMIContract {
    override val loading = MutableLiveData<Boolean>()

    fun some() {
        loading.value = true
    }
}


private class WrapLiveData<T>(val startValue: T): LiveData<T>(startValue)
class MyViewModel : ViewModel() {
    var state by liveDataDelegate(1)
        private set
    fun updateState(newValue: Int) {
        state = newValue.post()
    }
}

fun <T> T.post(): LiveData<T> = WrapLiveData(this)

fun <T> liveDataDelegate(defaultValue: T): ReadWriteProperty<Any, LiveData<T>> = object : ReadWriteProperty<Any, LiveData<T>> {
    private val liveData: MutableLiveData<T> = MutableLiveData(defaultValue)

    override fun getValue(thisRef: Any, property: KProperty<*>): LiveData<T> = liveData

    override fun setValue(thisRef: Any, property: KProperty<*>, value: LiveData<T>) {
        liveData.postValue((value as WrapLiveData<T>).startValue)
    }
}