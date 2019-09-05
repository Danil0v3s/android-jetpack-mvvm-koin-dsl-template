package com.boilerplate.android.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.boilerplate.android.business.model.DummyEntity

@Dao
interface DummyDao : BaseDao<DummyEntity> {

    @Query("SELECT * FROM DummyEntity")
    fun getAll(): LiveData<List<DummyEntity>>

}