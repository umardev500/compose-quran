package com.example.quran.core.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "surahs")
data class SurahEntity(
    @PrimaryKey
    @ColumnInfo(name = "s_index")
    val index: Int,

    val ayas: Int?,

    val name: String?,

    val tname: String?,

    val ename: String?,

    val type: String?,

    @ColumnInfo(name = "order_num")
    val order: Int?,

    @ColumnInfo(name = "start_pos")
    val start: Int?,

    val rukus: Int?
)