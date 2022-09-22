package com.example.shopmiumbindings.matcher

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

class BaseMatchers : Matchers() {

    fun recyclerViewSizeMatcher(expectedSize: Int): Matcher<View> =
        object : TypeSafeMatcher<View>() {
            override fun matchesSafely(item: View?): Boolean {
                if (item !is RecyclerView) return false
                return item.adapter!!.itemCount == expectedSize
            }

            override fun describeTo(description: Description?) {
            }
        }
}
