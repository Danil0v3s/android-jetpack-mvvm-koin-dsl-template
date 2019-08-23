package com.boilerplate.android.util

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LiveDataObserverTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    lateinit var mockLiveData: MutableLiveData<Any>

    private lateinit var liveDataObserver: LiveDataObserver<Any>

    @Before
    fun setup() {
        liveDataObserver = LiveDataObserver(mockLiveData)
    }

    @Test
    fun onChange_anyValueReceived_setValueToLiveData() {
        // prepare
        val changedValue = Any()

        // act
        liveDataObserver.onChanged(changedValue)

        // assert
        verify(mockLiveData).value = changedValue
    }
}