package com.example.xcore.model

data class Course(
    val code: String,
    val title: String,
    val area: Area,
    val department: String,
    val number: Int,
    val category: Category = area.category,
    val classification: Classification = Classification.fromCourseNumber(number),
    var crossListedCourses: List<Course> = emptyList()
)
