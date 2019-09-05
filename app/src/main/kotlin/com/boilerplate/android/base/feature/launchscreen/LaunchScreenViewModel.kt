package com.boilerplate.android.base.feature.launchscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.boilerplate.android.business.model.DummyEntity
import com.boilerplate.android.data.repository.DummyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LaunchScreenViewModel(
    private val dummyRepository: DummyRepository
) : ViewModel() {

    private val dummyLiveData: MutableLiveData<List<DummyEntity>> = MutableLiveData()

    fun fetchDummyData(coroutineContext: CoroutineContext = Dispatchers.IO): LiveData<List<DummyEntity>> {
        dummyLiveData.value = dummyRepository.getAll().value

        CoroutineScope(coroutineContext).launch {
            val newData = dummyRepository.fetchAll()
            dummyRepository.save(newData)
        }

        return dummyLiveData
    }

}