package com.example.shopmiumbindings

import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.shopmiumbindings.events.BaseEvents
import com.example.shopmiumbindings.matcher.BaseMatchers
import kotlin.reflect.KClass
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseAndroidUiActivityTest<T : FragmentActivity>(activity: KClass<T>) {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(activity.java)

    protected val scenario: ActivityScenario<T>?
        get() = activityScenarioRule.scenario

    @Before
    fun intentsInit() {
        checkNotNull(scenario) {
            Log.e("BaseAndroidUiActivityTest", "scenario is null")
        }
        // initialize Espresso Intents capturing
        Intents.init()
    }

    @After
    fun intentsTeardown() {
        // release Espresso Intents capturing
        Intents.release()
    }

    protected val appContext: Context
        get() = InstrumentationRegistry.getInstrumentation().targetContext

    protected val matchers: BaseMatchers = BaseMatchers()
    protected val events: BaseEvents = BaseEvents()
}
