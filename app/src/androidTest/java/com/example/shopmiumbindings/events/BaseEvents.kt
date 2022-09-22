package com.example.shopmiumbindings.events

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

class BaseEvents {
    fun clickOnViewId(@IdRes viewId: Int) {
        onView(withId(viewId)).perform(click())
    }

    fun clickOnViewWithText(text: String) {
        onView(withText(text)).perform(click())
    }

    fun clickOnViewWithTextResId(@IdRes text: Int) {
        onView(withText(text)).perform(click())
    }
}
