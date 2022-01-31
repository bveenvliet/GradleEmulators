package com.example.gradleemulators

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.gradleemulators", appContext.packageName)
    }

    @Test
    fun mainActivity_HasText_HelloWorld_isDisplayed() {
        launchActivity<MainActivity>()
        onView(withText("Hello World!")).check(matches(isDisplayed()))
        onView(withText("Hello World!")).check(matches(isCompletelyDisplayed()))
        onView(withText("GradleEmulators")).check(matches(isDisplayed()))
        onView(withText("GradleEmulators")).check(matches(isCompletelyDisplayed()))
        onView(withText("Test")).check(matches(isDisplayed()))
    }

    @Test
    fun mainActivity_HasText_HelloWorld_notFocusedClickableSelected() {
        launchActivity<MainActivity>()
        onView(withId(R.id.tvHelloWorld)).check(matches(isNotFocused()))
        onView(withId(R.id.tvHelloWorld)).check(matches(isNotClickable()))
        onView(withId(R.id.tvHelloWorld)).check(matches(isNotSelected()))
    }

}