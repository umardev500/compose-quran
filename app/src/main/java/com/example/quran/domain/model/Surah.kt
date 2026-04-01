package com.example.quran.domain.model

data class Surah(
    val index: Int,
    val ayas: Int?,
    val start: Int?,
    val name: String?,
    val tname: String?,
    val ename: String?,
    val type: String?,
    val order: Int?,
    val rukus: Int?
)