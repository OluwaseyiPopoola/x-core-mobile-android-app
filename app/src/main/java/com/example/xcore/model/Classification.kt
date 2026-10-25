package com.example.xcore.model

enum class Classification {
    FR, // Freshman (1000 - 1999)
    SO, // Sophomore (2000 - 2999)
    JR, // Junior (3000 - 3999)
    SR; // Senior (4000 - 4999)

    companion object {
        fun fromCourseNumber(number: Int): Classification {
            return when (number) {
                in 1000..1999 -> FR
                in 2000..2999 -> SO
                in 3000..3999 -> JR
                in 4000..4999 -> SR
                else -> FR
            }
        }
    }
}
