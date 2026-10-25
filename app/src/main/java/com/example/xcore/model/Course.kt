package com.example.xcore.model

data class Course(
    val code: String,
    val title: String,
    val category: String,
    val area: String,
    val departments: List<String>,
    val number: Int,
    val classification: Classification = Classification.fromCourseNumber(number)
)
