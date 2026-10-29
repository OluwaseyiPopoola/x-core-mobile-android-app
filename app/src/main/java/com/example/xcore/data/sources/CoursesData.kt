package com.example.xcore.data.sources

import com.example.xcore.data.model.Area
import com.example.xcore.data.model.Category
import com.example.xcore.data.model.Classification
import com.example.xcore.data.model.Course
import com.example.xcore.data.model.EngagementsArea
import com.example.xcore.data.model.ExplorationsArea
import com.example.xcore.data.model.FoundationsArea

class CoursesData(val allCourses: List<Course> = defaultCourses) {

    fun getCoursesByCategory(category: Category): List<Course> {
        return allCourses.filter { it.category == category }
    }

    fun getCoursesByCategory(categoryName: String): List<Course> {
        val cat = Category.fromName(categoryName) ?: return emptyList()
        return getCoursesByCategory(cat)
    }

    fun getCoursesByArea(area: Area): List<Course> {
        return allCourses.filter { it.area == area }
    }

    fun getCoursesByArea(areaName: String): List<Course> {
        val foundArea = Area.fromName(areaName) ?: return emptyList()
        return getCoursesByArea(foundArea)
    }

    fun getCoursesByDepartment(department: String): List<Course> {
        val trimmedDept = department.trim()
        if (trimmedDept.isEmpty()) return emptyList()
        return allCourses.filter {
            it.department.equals(trimmedDept, ignoreCase = true)
        }
    }

    /**
     * (c) List all courses based on classification (FR, SO, JR, SR)
     */
    fun getCoursesByClassification(classification: Classification): List<Course> {
        return allCourses.filter { it.classification == classification }
    }

    fun getCoursesByKeywords(keywordsCsv: String): List<Course> {
        val keywords = keywordsCsv.split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }

        if (keywords.isEmpty()) return emptyList()

        return allCourses.filter { course ->
            keywords.any { keyword ->
                course.title.contains(keyword, ignoreCase = true) ||
                        course.code.contains(keyword, ignoreCase = true) ||
                        course.category.displayName.contains(keyword, ignoreCase = true) ||
                        course.category.name.contains(keyword, ignoreCase = true) ||
                        course.area.displayName.contains(keyword, ignoreCase = true) ||
                        course.department.contains(keyword, ignoreCase = true)
            }
        }
    }

    companion object {
        val defaultCourses: List<Course> = buildList {
            // =========================================================================
            // FOUNDATIONS AT XAVIER (6 AREAS)
            // =========================================================================
            // Area: College Experience (XCOR 1000)
            addAll(createCourses("XCOR 1000", "College Experience", FoundationsArea.COLLEGE_EXPERIENCE))

            // Area: Xavier Experience (XCOR 1011 - 15 Topics)
            addAll(createCourses("XCOR 1011", "Behind the Music: The History of Hip Hop & Social Justice", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Black Intellectual Tradition", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Communicating Social Justice", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Education in Literature & Action (SL)", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Food Matters", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Freedom Dreams: Social Justice in the African American Imagination", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Green Practices & Sustainability", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Immigration & Social Justice", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Internalizing Antiracism", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Moral Philosophy & Business Decision Making", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Nat Turner & the Theology of Slave Rebellions", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Photography & Social Justice", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Religion, Science, the Universe & Us", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Satire & Social Justice", FoundationsArea.XAVIER_EXPERIENCE))
            addAll(createCourses("XCOR 1011", "Socrates & the City (SL)", FoundationsArea.XAVIER_EXPERIENCE))

            // Area: New Orleans Experience (XCOR 1012 - 24 Topics)
            addAll(createCourses("XCOR 1012", "Carnival in New Orleans: History, Theory & Practice", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Cities of the Dead", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Coastal Climate, Risk, Resilience & Homeland Security", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Creole Louisiana", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Cultures & Trade in New Orleans", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Digitizing New Orleans", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Environmental Justice in New Orleans & Beyond", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Historical & Cultural Influences on Medical Practices in New Orleans", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Homelessness in New Orleans (SL)", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Innovate, Create & Make", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Learn French in New Orleans", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Learn Spanish in New Orleans", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "New Orleans & African Creolization", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "New Orleans & the Philosophy of Pharmacy", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "New Orleans Book Club", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "New Orleans in the Headlines", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "New Orleans Literature", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "New Orleans Technology & Innovation Bootcamp", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Performing New Orleans", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Production & Consumption of Mardi Gras", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Race & Housing Inequality in New Orleans", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Seeing New Orleans", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "Vietnamese Diaspora in Louisiana", FoundationsArea.NEW_ORLEANS_EXPERIENCE))
            addAll(createCourses("XCOR 1012", "World Religions in New Orleans", FoundationsArea.NEW_ORLEANS_EXPERIENCE))

            // Area: College Writing
            addAll(createCourses("ENGL 1000", "Intensive English Composition & Rhetoric", FoundationsArea.COLLEGE_WRITING))
            addAll(createCourses("ENGL 1010", "English Composition & Rhetoric", FoundationsArea.COLLEGE_WRITING))

            // Area: Advanced Composition & Rhetoric
            addAll(createCourses("ENGL 1020", "English Composition & Literature", FoundationsArea.ADVANCED_COMPOSITION_AND_RHETORIC))
            addAll(createCourses("ENGL 1023H", "Introduction to Literature for Honors Students", FoundationsArea.ADVANCED_COMPOSITION_AND_RHETORIC))
            addAll(createCourses("ENGL 1025", "Food & Literature", FoundationsArea.ADVANCED_COMPOSITION_AND_RHETORIC))
            addAll(createCourses("ENGL 1026", "Digital Rhetoric & Composition", FoundationsArea.ADVANCED_COMPOSITION_AND_RHETORIC))
            addAll(createCourses("HIST 2415", "Introduction to Historical Research & Writing", FoundationsArea.ADVANCED_COMPOSITION_AND_RHETORIC))
            addAll(createCourses("SOCI 2500", "Reading & Writing for Sociology", FoundationsArea.ADVANCED_COMPOSITION_AND_RHETORIC))

            // Area: Quantitative Reasoning
            addAll(createCourses("MATH 1010", "Principles of Modern Mathematics", FoundationsArea.QUANTITATIVE_REASONING))
            addAll(createCourses("MATH 1015", "College Algebra for Elementary Education Majors", FoundationsArea.QUANTITATIVE_REASONING))
            addAll(createCourses("MATH 1020 / STAT 2010", "Basic Statistics I", FoundationsArea.QUANTITATIVE_REASONING))
            addAll(createCourses("MATH 1030 / MATH 1030I", "Pre-Calculus", FoundationsArea.QUANTITATIVE_REASONING))
            addAll(createCourses("MATH 1070 / MATH 1070H", "Introductory Calculus", FoundationsArea.QUANTITATIVE_REASONING))

            // =========================================================================
            // EXPLORATIONS IN THE LIBERAL ARTS (7 AREAS)
            // =========================================================================
            // Area: African American Heritage & Legacies
            addAll(createCourses("AADS 1060 / HIST 1060 / MSCM 1060", "The Black Press", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2000", "Introduction to African American History & Culture", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2010", "Introduction to African American Social Sciences", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2060 / SOCI 2060", "Race & Ethnic Relations", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2070 / CMST 2070 / MSCM 2070", "African American Rhetoric & Culture", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2075", "New Social Justice Movements", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2080 / PHIL 2080", "African American Philosophy", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2090", "Black Health Disparities", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2130 / MUSH 2130", "Afro-American Music", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2140 / MUSH 2140", "Afro-American Music II", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2180 / MSCM 2080", "Black Health Literacy", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2200", "Decolonial Studies", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2500", "Transatlantic Blackness", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2590 / MSCM 2590", "Black Cinema", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 2600 / HIST 2600", "Africa & the World", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 3025 / SOCI 3025", "African American Urban Life", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 3350", "African American History I", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("AADS 3385", "Civil Rights Movement in the US", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("ENGL 2085", "Survey of African American Literature I", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))
            addAll(createCourses("ENGL 2095", "Survey of Twentieth Century African American Literature II", ExplorationsArea.AFRICAN_AMERICAN_HERITAGE_AND_LEGACIES))

            // Area: Creative Expression & Engagement
            addAll(createCourses("ALCS 2050 / AADS 2050", "Readings on Afro Latin America & the Caribbean", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ART 1010", "Design 1A", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ART 1030", "Drawing 1", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ART 1050", "Introduction to Ceramics", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ART 1060", "Introduction to Painting", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ART 1090", "Art Appreciation", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ART 2011", "Black & White Photography", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ART 2020", "Introduction to Graphic Design & Advertising", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ART 2070", "Introduction to Sculpture", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ART 2510 / ENGL 2510", "Graphic Novel & Social Justice", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ART 3065 / CRWT 3065 / ENGL 3065", "Writing About Art", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("CRWT 1050", "Introduction to Creative Writing", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("CRWT 2050", "Poetry Workshop", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("CRWT 2060", "Fiction Writing", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("CRWT 2070", "Creative Nonfiction", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 2010", "Introduction to World Literature I", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 2011H", "Introduction to World Literature for Honors Students", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 2020", "Introduction to World Literature II", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 2022", "Explorations in World Literature", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 2070", "Origins of Literary English", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 2080", "Literature and Revolution", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 2125 / WMST 2125", "Women's Writing", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 3040", "Shakespeare at the Globe", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 3050", "Shakespeare in Adaptation", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 3160", "Survey of American Literature 1", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 3170", "Survey of American Literature II", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("ENGL 3260", "Studies in American Literature", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("MSCM 2540", "Storytelling through Digital Editing", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("MSCM 2580", "Film Appreciation", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("MUSH 1080 / DGHU 1080", "Introduction to Musiking Around the World", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("MUSH 2000", "Music Appreciation", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("PERF 1000", "Introduction to Performance Studies", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("PERF 2010", "Performance of Literature", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("PERF 2035", "Performance of Everyday Life", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))
            addAll(createCourses("PHIL 2260", "Philosophy of Art", ExplorationsArea.CREATIVE_EXPRESSION_AND_ENGAGEMENT))

            // Area: Examined Life
            addAll(createCourses("PHIL 1040", "The Meaning of Life", ExplorationsArea.EXAMINED_LIFE))
            addAll(createCourses("PHIL 1050", "The Quest for Knowledge", ExplorationsArea.EXAMINED_LIFE))
            addAll(createCourses("PHIL 1060", "Law, Liberty & Philosophy", ExplorationsArea.EXAMINED_LIFE))
            addAll(createCourses("PHIL 2011", "Ancient & Medieval Philosophy", ExplorationsArea.EXAMINED_LIFE))
            addAll(createCourses("PHIL 2021", "Modern Philosophy", ExplorationsArea.EXAMINED_LIFE))
            addAll(createCourses("PHIL 2031", "19th & 20th Century Philosophy", ExplorationsArea.EXAMINED_LIFE))
            addAll(createCourses("PHIL 2080", "African American Philosophy", ExplorationsArea.EXAMINED_LIFE))
            addAll(createCourses("PHIL 2260", "Philosophy of Art", ExplorationsArea.EXAMINED_LIFE))
            addAll(createCourses("PHIL 2270", "Philosophy of Religion", ExplorationsArea.EXAMINED_LIFE))

            // Area: Faith & Society
            addAll(createCourses("THEO 1100", "The Christian Faith", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 1120", "Introduction to Biblical Studies", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 1122", "Introduction to Biblical Hebrew", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 1123", "Introduction to Biblical Hebrew", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 1130", "Introduction to Black Catholic Theology", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 1170", "Introduction to Theology", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2001", "The Torah of Israel", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2002", "Prophets & Prophecy", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2003", "Psalms & Wisdom Literature", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2021", "The Synoptic Gospels & Acts", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2022", "Letters of Paul", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2023", "Apocalyptic Literature & the Book of Revelation", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2070", "Introduction to Bioethics", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2100", "Comparative Religion", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2150", "Theological Perspectives of African American Christianity", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2220 / HIST 2200", "Islam: Origins & Historical Impact", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2250 / HIST 2250", "Religions of the Ancient Near East", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2500", "Theological Ethics", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2600", "Women in Religion", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2650", "Creation Theologies and Ecology", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2750", "Queer Theologies", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 2900", "Christianity & Racial Capitalism", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 3060", "Theological Understanding of Jesus Christ", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 3666 / ENGL 3666", "The Devil in Sacred & Secular Literature", ExplorationsArea.FAITH_AND_SOCIETY))
            addAll(createCourses("THEO 3900", "Caribbean Theologies", ExplorationsArea.FAITH_AND_SOCIETY))

            // Area: Human Behavior
            addAll(createCourses("CMST 1500", "Intercultural Communication", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("ECON 1030", "Introduction to Economics", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("ECON 2010", "Principles of Micro Economics", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("ECON 2020", "Principles of Macro Economics", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("MSCM 1080", "Health Communication", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("MSCM 1100", "Introduction to Mass Communication", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("MSCM 2400", "Social Media", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("PHLT 1001", "Introduction to Public Health", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("PHLT 1002", "Nutrition & Health", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("PSCI 1010", "Introduction to Political Science", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("PSCI 1020", "American Government", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("PSCI 2040", "International Relations", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("PSCI 2050", "Introduction to Public Policy & Administration", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("PSCI 2240 / WMST 2240", "Politics of Gender & Sexuality", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("PSCI 3360", "Public Policy", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("PSCI 3400", "Urban Politics", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("PSYC 1010", "Introductory Psychology", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("PSYC 2500", "Positive Psychology", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("SOCI 1010", "Introduction to Sociology", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("SOCI 1015", "Popular Culture & Society", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("SOCI 2010", "Social Problems", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("SOCI 2050", "Sociology of the Family", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("SOCI 3010", "Sociology of Education", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("WMST 1030", "Introduction to Women's Studies", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("WMST 3400", "Dimensions in Women's Health", ExplorationsArea.HUMAN_BEHAVIOR))
            addAll(createCourses("WMST 3990", "Feminist Theory", ExplorationsArea.HUMAN_BEHAVIOR))

            // Area: Human Past
            addAll(createCourses("AADS 1060 / HIST 1060 / MSCM 1060", "The Black Press", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("ART 4130", "African Arts & Culture", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("ENGL 2010", "Introduction to World Literature I", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("ENGL 2011H", "Introduction to World Literature for Honors Students", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("ENGL 2020", "Introduction to World Literature II", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 1030", "World Civilizations to 1500", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 1031H", "World Civilizations to 1500 Honors", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 1040", "World Civilizations Since 1500", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 1041H", "World Civilizations Since 1500 Honors", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 1050", "Twentieth Century World History", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 1400", "Worlds of Trade: Consumers & Goods in World History since 1400", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 1500", "Women in World History", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 1600", "Colonial Encounters in the Modern World", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 1800", "Slavery & Servitude in World History", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 1801H", "Slavery & Servitude in World History Honors", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 1810", "Human Rights in Global History", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 2060", "Ethnicity & Immigration in US History", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 2170", "Survey of Medieval Europe", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 2220 / THEO 2220", "Islam: Origins & Historical Impact", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 2250 / THEO 2250", "Religions of the Ancient Near East", ExplorationsArea.HUMAN_PAST))
            addAll(createCourses("HIST 2600", "Africa & the World", ExplorationsArea.HUMAN_PAST))

            // Area: Scientific Reasoning
            addAll(createCourses("BIOL 1050", "Environmental Biology", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("BIOL 1100 + BIOL 1100L", "Life Science", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("BIOL 1230 + BIOL 1230L", "General Biology I", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("CHEM 1004", "Chemistry of Art", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("CHEM 1005", "Food Chemistry", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("CHEM 1010 + CHEML 1011L", "General Chemistry I", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("CHEM 1110 + CHEM 1111L", "Chemistry I", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("IPSC 2010", "Integrated Physical Science", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("PHYS 1010", "General Astronomy", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("PHYS 1121", "General Physics I", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("PHYS 1530", "How Things Work", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("PHYS 2010 + PHYS 2010L", "General Physics I", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("PHYS 2060 + PHYS 2060L", "Physics of Music", ExplorationsArea.SCIENTIFIC_REASONING))
            addAll(createCourses("PHYS 2510", "Computational Science & Engineering", ExplorationsArea.SCIENTIFIC_REASONING))

            // =========================================================================
            // ENGAGEMENTS WITH KNOWLEDGE & PRACTICE (3 AREAS)
            // (Page 8 Rule: Asterisk * items lacking course numbers are excluded)
            // =========================================================================
            // Area: Engaging the Mission
            addAll(createCourses("THEO 3200", "Theological Foundations of Social Justice", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("PHIL 3015", "Aristotle in New Orleans", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("ART 2600", "Building Community through the Arts", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("AADS 3700 / HIST 3700", "Caribbean History & Roots", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("PSCI 3110", "Civil Rights & Civil Liberties", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("AADS 3385 / DGHU 3385 / HIST 3385", "Civil Rights Movement in the US", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("PSCI 3100", "Constitutional Law", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("MGMT 3100", "Corporate Social Responsibility & Sustainability", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("MSCM 3700", "Environmental Communications", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("PHIL 3050 / DGHU 3080", "Ethics at the End of Life", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("ENGL 3025 / PHIL 3025 / THEO 3025", "Ideal Society", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("PSCI 2100", "Law, Politics, & Society", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("PERF 4010", "Performing the Archive", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("AADS 3620 / HIST 3620", "Race & Resistance in South Africa", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("PERF 3030", "Race, Culture & Communication", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("MSCM 3080", "Science Communication", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("SOCI 3090", "Social Movements", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("SOCI 3010", "Sociology of Education", EngagementsArea.ENGAGING_THE_MISSION))
            addAll(createCourses("THEO 3500 / ENGL 3500", "Theology of Flannery O'Connor", EngagementsArea.ENGAGING_THE_MISSION))

            // Area: Engaging Global Issues
            addAll(createCourses("AADS 4130 / ART 4130", "African Art", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("AADS 4050 / PSCI 4050", "African Politics", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("ALCS 4025 / AADS 4025", "Afro Latin American Oral Traditions", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("AADS 4140 / ART 4140", "Art of the African Diaspora", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("THEO 3666 / ENGL 3666", "Devil in Sacred & Secular Literature", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("THEO 2550", "Environmental Issues in Christian Perspective", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("MSCM 3040", "Global Media", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("SOCI 3011", "Global Social Change", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("HIST 3610 / AADS 3610", "History of Popular Culture in Africa", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("HIST 3190", "History of Scientific Thought", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("HIST 2220 / THEO 2220", "Islam: Origins & Historical Impact", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("PSCI 4640", "Politics of Developing Nations", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("SOCI 3040", "Population & Society", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("AADS 3800 / HIST 3800", "Race in the Americas", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("PERF 3040", "Readings In Ethnography", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("HIST 3830", "Revolutions in Modern History", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("PERF 3070", "Site-Specific Performance", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("WMST 3020", "Transnational Feminist Perspectives", EngagementsArea.ENGAGING_GLOBAL_ISSUES))
            addAll(createCourses("HIST 3450", "The Vietnam War Era", EngagementsArea.ENGAGING_GLOBAL_ISSUES))

            // Area: Program Required Senior Capstones
            addAll(createCourses("BIOL 4230", "Biology Capstone", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("BSAD 4000", "Strategic Management", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("CHEM 4150L", "Genomics & Proteomics Lab", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("CHEM 4310L", "Synthesis Lab", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("CHEM 4320L", "Molecular Structure & Organic Synthesis Lab", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("CPSC 4800", "Capstone Project 1", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("CPSC 4805", "Capstone Project 2", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("ENGL 4500", "Senior Thesis", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("ENGL 4999", "Senior Capstone", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("FREN 4999", "Senior Capstone", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("HIST 4999", "Senior Capstone", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("MATH 4511 / STAT 4511", "Colloquium", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("MSCM 4999", "Senior Capstone", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("MURE 4000", "Senior Recital", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("MUSM 4999", "Senior Comprehensive", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("PHYS 4200", "Senior Capstone", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("PHYS 4210", "Senior Capstone", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("PSCI 4999", "Senior Comprehensive Exam", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("PSCY 4996", "Historical & Applied Perspectives in Psychology", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("SOCI 4950", "Senior Capstone", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("SPAN 4999", "Senior Capstone", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
            addAll(createCourses("THEO 4000", "Senior Capstone", EngagementsArea.PROGRAM_REQUIRED_SENIOR_CAPSTONES))
        }

        private fun createCourses(
            codeStr: String,
            title: String,
            area: Area
        ): List<Course> {
            val parts = codeStr.split("/").map { it.trim() }.filter { it.isNotEmpty() }

            val courseList = parts.map { codePart ->
                val dept = extractDepartment(codePart)
                val num = extractNumber(codePart)
                Course(
                    code = codePart,
                    title = title,
                    area = area,
                    department = dept,
                    number = num
                )
            }

            if (courseList.size > 1) {
                for (i in courseList.indices) {
                    val current = courseList[i]
                    val siblings = courseList.filterIndexed { index, _ -> index != i }
                    current.crossListedCourses = siblings
                }
            }

            return courseList
        }

        private fun extractDepartment(codePart: String): String {
            val regex = Regex("([A-Z]{3,4})")
            val match = regex.find(codePart)
            return match?.groupValues?.get(1) ?: "XCOR"
        }

        private fun extractNumber(codePart: String): Int {
            val regex = Regex("(\\d{4})")
            val match = regex.find(codePart)
            return match?.groupValues?.get(1)?.toIntOrNull() ?: 1000
        }
    }
}
