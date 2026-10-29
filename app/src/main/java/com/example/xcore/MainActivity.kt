package com.example.xcore

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.xcore.data.model.Classification
import com.example.xcore.data.sources.CoursesData
import com.example.xcore.ui.feature.info.Info
import com.example.xcore.ui.theme.XCoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Execute Log.d testing suite for Course methods
        runCourseLogTests()

        setContent {
            XCoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Info(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    private fun runCourseLogTests() {
        val tag = "XCoreCourses"
        val courses = CoursesData()

        Log.d(tag, "=================== STARTING COURSES LOG.D TESTS ===================")

        // (a) Test getCoursesByCategory
        Log.d(tag, "--- (a) Testing getCoursesByCategory('Foundations') ---")
        val foundations = courses.getCoursesByCategory("Foundations")
        Log.d(tag, "Found ${foundations.size} Foundations courses:")
        foundations.take(5).forEach { Log.d(tag, "  [Foundations] ${it.code}: ${it.title} (${it.area})") }

        Log.d(tag, "--- (a) Testing getCoursesByCategory('Explorations') ---")
        val explorations = courses.getCoursesByCategory("Explorations")
        Log.d(tag, "Found ${explorations.size} Explorations courses")

        Log.d(tag, "--- (a) Testing getCoursesByCategory('Engagements') ---")
        val engagements = courses.getCoursesByCategory("Engagements")
        Log.d(tag, "Found ${engagements.size} Engagements courses")

        // (a.2) Test getCoursesByArea
        Log.d(tag, "--- (a.2) Testing getCoursesByArea('Faith & Society') ---")
        val faithArea = courses.getCoursesByArea("Faith & Society")
        Log.d(tag, "Found ${faithArea.size} courses in 'Faith & Society':")
        faithArea.take(3).forEach { Log.d(tag, "  [Area: Faith & Society] ${it.code}: ${it.title}") }

        // (b) Test getCoursesByDepartment
        Log.d(tag, "--- (b) Testing getCoursesByDepartment('HIST') ---")
        val histCourses = courses.getCoursesByDepartment("HIST")
        Log.d(tag, "Found ${histCourses.size} HIST courses:")
        histCourses.forEach { course ->
            val crossListText = if (course.crossListedCourses.isNotEmpty()) {
                " (Cross-listed with: ${course.crossListedCourses.joinToString { it.code }})"
            } else ""
            Log.d(tag, "  [HIST] ${course.code}: ${course.title}$crossListText")
        }

        // (c) Test getCoursesByClassification
        Log.d(tag, "--- (c) Testing getCoursesByClassification(Classification.SR) ---")
        val seniorCourses = courses.getCoursesByClassification(Classification.SR)
        Log.d(tag, "Found ${seniorCourses.size} Senior-level (SR) courses:")
        seniorCourses.take(5).forEach { Log.d(tag, "  [SR] ${it.code}: ${it.title} (Level: ${it.number})") }

        // Verify specific prompt example PERF 4010 is senior-level
        val perf4010 = seniorCourses.find { it.code == "PERF 4010" }
        Log.d(tag, "  VERIFICATION: PERF 4010 classification = ${perf4010?.classification}")

        // (d) Test getCoursesByKeywords
        Log.d(tag, "--- (d) Testing getCoursesByKeywords('History, Justice') ---")
        val keywordResults = courses.getCoursesByKeywords("History, Justice")
        Log.d(tag, "Found ${keywordResults.size} courses matching 'History, Justice':")
        keywordResults.take(5).forEach { Log.d(tag, "  [Keyword Match] ${it.code}: ${it.title}") }

        Log.d(tag, "=================== COMPLETED COURSES LOG.D TESTS ===================")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    XCoreTheme {
        Greeting("Android")
    }
}
