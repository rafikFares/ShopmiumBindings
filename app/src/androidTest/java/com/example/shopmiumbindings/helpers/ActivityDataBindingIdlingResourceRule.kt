package com.example.shopmiumbindings.helpers

import androidx.fragment.app.FragmentActivity
import androidx.test.espresso.IdlingRegistry
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class ActivityDataBindingIdlingResourceRule<T : FragmentActivity>(
    private val idlingResource: ActivityDataBindingIdlingResource<T>
) : TestWatcher() {

    override fun finished(description: Description) {
        IdlingRegistry.getInstance().unregister(idlingResource)
        super.finished(description)
    }

    override fun starting(description: Description) {
        IdlingRegistry.getInstance().register(idlingResource)
        super.starting(description)
    }
}
