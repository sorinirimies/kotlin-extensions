@file:JvmName("AnimUtils")


package com.greenspand.kotlin_ext

import android.support.v4.view.ViewCompat
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.Interpolator

/**
 * Extension function for simple view fade in and out animations
 * @param duration of the animation
 * @param scale of the the view
 * @param alpha visibility of the the view
 * @param interpolator the Bezier curve animation of the view
 * @param visibility of the animated view
 */
fun View.animateScaleAlpha(delay: Long = 0,
                           duration: Long = 300,
                           scale: Float = 0.7f,
                           alpha: Float = 0f,
                           interpolator: Interpolator = AccelerateInterpolator(),
                           visibility: Int = View.GONE) {
    ViewCompat.animate(this)
            .setStartDelay(delay)
            .setDuration(duration)
            .scaleX(scale)
            .scaleY(scale)
            .alpha(alpha)
            .setInterpolator(interpolator)
            .withEndAction {
                this.visibility = visibility
            }
}

/**
 * Animates a view upwards
 * @param translateY the vertical vector
 * @param duration the default duration
 * @param interpolator the default interpolator
 */
fun View.animateUp(translateY: Float = 0f,
                   duration: Long = 300,
                   interpolator: Interpolator = AccelerateInterpolator()) {
    visible()
    ViewCompat.animate(this)
            .setDuration(duration)
            .translationY(translateY)
            .interpolator = interpolator
}

/**
 * Animates a view to a visible state, with an alpha transition
 * @param duration the default duration
 * @param alpha the given opacity level
 * @param interpolator the default interpolator
 */
fun View.animateVisible(duration: Long = 300,
                        alpha: Float = 1f) {
    visible()
    ViewCompat.animate(this)
            .setDuration(duration)
            .alpha(alpha)
}

/**
 * Animates a view to gone, with an alpha transition
 * @param duration the default duration
 * @param alpha the given opacity level
 * @param interpolator the default interpolator
 */
fun View.animateGone(duration: Long = 300,
                     alpha: Float = 0f,
                     visibility: Int = View.GONE) {
    ViewCompat.animate(this)
            .setDuration(duration)
            .alpha(alpha)
            .withEndAction {
                this.visibility = visibility
            }
}

/**
 * Animates a view downwards
 * @param translateY the vertical vector
 * @param duration the default duration
 * @param interpolator the default interpolator
 */
fun View.animateDown(translateY: Float = 400f,
                     duration: Long = 300,
                     visibility: Int = View.GONE) {
    ViewCompat.animate(this)
            .setDuration(duration)
            .translationY(translateY)
            .withEndAction {
                this.visibility = visibility
            }
}
