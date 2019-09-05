package com.boilerplate.android.data.repository

import androidx.lifecycle.LiveData
import com.boilerplate.android.business.model.DummyEntity
import com.boilerplate.android.data.database.dao.DummyDao
import com.boilerplate.android.data.network.category.DummyApi

class DummyRepository(
    private val dummyDao: DummyDao,
    private val dummyService: DummyApi
) {

    fun getAll(): LiveData<List<DummyEntity>> = dummyDao.getAll()

    suspend fun fetchAll(): List<DummyEntity> {
        val list = mutableListOf<DummyEntity>()

        val response = dummyService.fetchAll()

        if (response.isSuccessful) {
            response.body()?.let {
                list.addAll(it)
            }
        }

        return list
    }

    suspend fun save(entities: List<DummyEntity>) = dummyDao.save(entities)
}
