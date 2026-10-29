package com.example.xcore.data.model

data class Course(
    val code: String,
    val title: String,
    val area: Area,
    val department: String,
    val number: Int,
    val classification: Classification = Classification.fromCourseNumber(number)
) {
    val category: Category = area.category
    var crossListedCourses: List<Course> = emptyList()

}
