package com.example.xcore.model

sealed interface Area {
    val displayName: String
    val category: Category

    companion object {
        val allAreas: List<Area> by lazy {
            FoundationsArea.entries + ExplorationsArea.entries + EngagementsArea.entries
        }

        fun fromName(name: String): Area? {
            val trimmed = name.trim()
            return allAreas.find {
                it.displayName.equals(trimmed, ignoreCase = true) ||
                        (it as Enum<*>).name.equals(trimmed, ignoreCase = true)
            }
        }
    }
}

enum class FoundationsArea(override val displayName: String) : Area {
    COLLEGE_EXPERIENCE("College Experience"),
    XAVIER_EXPERIENCE("Xavier Experience"),
    NEW_ORLEANS_EXPERIENCE("New Orleans Experience"),
    COLLEGE_WRITING("College Writing"),
    ADVANCED_COMPOSITION_AND_RHETORIC("Advanced Composition & Rhetoric"),
    QUANTITATIVE_REASONING("Quantitative Reasoning");

    override val category: Category = Category.FOUNDATIONS
}

enum class ExplorationsArea(override val displayName: String) : Area {
    AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES("African American Heritage & Legacies"),
    CREATIVE_EXPRESSION_AND_ENGAGEMENT("Creative Expression & Engagement"),
    EXAMINED_LIFE("Examined Life"),
    FAITH_AND_SOCIETY("Faith & Society"),
    HUMAN_BEHAVIOR("Human Behavior"),
    HUMAN_PAST("Human Past"),
    SCIENTIFIC_REASONING("Scientific Reasoning");

    override val category: Category = Category.EXPLORATIONS
}

enum class EngagementsArea(override val displayName: String) : Area {
    ENGAGING_THE_MISSION("Engaging the Mission"),
    ENGAGING_GLOBAL_ISSUES("Engaging Global Issues"),
    PROGRAM_REQUIRED_SENIOR_CAPSTONES("Program Required Senior Capstones");

    override val category: Category = Category.ENGAGEMENTS
}
