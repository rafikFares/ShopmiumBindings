package com.example.shopmiumbindings.ui.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.shopmiumbindings.BaseAndroidUiActivityTest
import com.example.shopmiumbindings.rule.DisableAnimationsRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest : BaseAndroidUiActivityTest<MainActivity>(MainActivity::class) {

    @get:Rule
    val disableAnimationsRule = DisableAnimationsRule()

    @Test
    fun defaultViewInteraction() {
        Espresso.onView(
            withId(com.example.shopmiumbindings.R.id.headerImageView)
        ).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed())
        )

        Espresso.onView(
            withId(com.example.shopmiumbindings.R.id.listView)
        ).check(
            ViewAssertions.matches(matchers.recyclerViewSizeMatcher(0))
        )

        Espresso.onView(
            withId(com.example.shopmiumbindings.R.id.buttonView)
        ).check(
            ViewAssertions.matches(withText("Click Me ?"))
        )

        events.clickOnViewId(com.example.shopmiumbindings.R.id.buttonView)

        Espresso.onView(
            withId(com.example.shopmiumbindings.R.id.listView)
        ).check(
            ViewAssertions.matches(matchers.recyclerViewSizeMatcher(51))
        )

        Espresso.onView(
            withId(com.example.shopmiumbindings.R.id.buttonView)
        ).check(
            ViewAssertions.matches(withText("Clicked!!"))
        )
    }
}
