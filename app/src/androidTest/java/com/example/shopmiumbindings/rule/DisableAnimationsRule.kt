package com.example.shopmiumbindings.rule

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * Disable emulator animation during the test,
 * and re-enable animation back after the test
 */
class DisableAnimationsRule : TestWatcher() {
    override fun starting(description: Description) {
        // disable animations for test run
        disableUiAnimation()
    }

    override fun finished(description: Description) {
        // enable after test run
        enableUiAnimation()
    }

    fun enableUiAnimation() {
        println(">>>enableUiAnimation>>>")
        changeAnimationStatus(enable = true)
    }

    fun disableUiAnimation() {
        println(">>>disableUiAnimation>>>")
        changeAnimationStatus(enable = false)
    }

    private fun changeAnimationStatus(enable: Boolean = true) {
        val value = "${if (enable) 1 else 0}"
        with(UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())) {
            executeShellCommand("settings put global transition_animation_scale $value")
            executeShellCommand("settings put global window_animation_scale $value")
            executeShellCommand("settings put global animator_duration_scale $value")
        }
    }
}
