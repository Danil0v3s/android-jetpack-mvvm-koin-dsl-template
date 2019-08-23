package com.boilerplate.android.business.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

@Entity(tableName = "Category")
data class Category(
    @PrimaryKey
    @field:Json(name = "id")
    val id: String,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "categories")
    val categories: List<Category>?
) : Serializable