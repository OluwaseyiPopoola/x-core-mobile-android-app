package com.example.xcore.data.model

enum class Category(val displayName: String) {
    FOUNDATIONS("FOUNDATIONS AT XAVIER"),
    EXPLORATIONS("EXPLORATIONS IN THE LIBERAL ARTS"),
    ENGAGEMENTS("ENGAGEMENTS WITH KNOWLEDGE & PRACTICE");

    companion object {
        fun fromName(name: String): Category? {
            val trimmed = name.trim()
            if (trimmed.isEmpty()) return null
            return entries.find {
                it.name.equals(trimmed, ignoreCase = true) ||
                        it.displayName.equals(trimmed, ignoreCase = true)
            }
        }
    }
}
