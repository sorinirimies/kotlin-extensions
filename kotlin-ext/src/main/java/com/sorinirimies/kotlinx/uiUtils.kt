@file:JvmName("UiUtils")

package com.sorinirimies.kotlinx

import android.app.AlertDialog
import android.app.Notification
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.IntegerRes
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, msg, length).show()

/**
 * Extension function expression to create an [AlertDialog].
 */
inline fun alertDialog(context: Context, func: AlertDialog.Builder.() -> Unit): AlertDialog {
    val builder = AlertDialog.Builder(context)
    builder.func()
    builder.show()
    return builder.create()
}

/**
 * Extension function expression to expose the [AlertDialog.Builder] API.
 */
inline fun alertDialogBuilder(context: Context, func: AlertDialog.Builder.() -> Unit): AlertDialog {
    val builder = AlertDialog.Builder(context)
    builder.func()
    return builder.create()
}

/**
 * Extension function expression to create a [Notification].
 */
inline fun notification(context: Context, func: Notification.Builder.() -> Unit): Notification {
    val builder = Notification.Builder(context)
    builder.func()
    return builder.build()
}

/**
 * Extension function expression for creating a snack, with a given default value for length.
 * @param container where the snack is bound to
 * @param msg shown to the user
 * @param duration of the snack
 */
fun snack(container: View, msg: String, duration: Int = Snackbar.LENGTH_SHORT): Snackbar {
    val snackBar = Snackbar.make(container, msg, duration)
    snackBar.show()
    return snackBar
}

/**
 * Extension function expression for creating a snack, with a given default value for length.
 * @param container where the snack is bound to
 * @param msg shown to the user
 * @param duration of the snack
 */
fun snackBuild(container: View, msg: String, duration: Int = Snackbar.LENGTH_SHORT): Snackbar {
    return Snackbar.make(container, msg, duration)
}

/** Extension function. Gets a view at the given index*/
operator fun ViewGroup.get(index: Int): View? = getChildAt(index)

/**removes a child view*/
operator fun ViewGroup.minusAssign(child: View) = removeView(child)

/** Adds a child view*/
operator fun ViewGroup.plusAssign(child: View) = addView(child)

/**
 * Sets same height and width padding
 * @param dimen padding values
 */
fun View.setSamePadding(@IntegerRes dimen: Int) {
    this.setPadding(dimen, dimen, dimen, dimen)
}

/**
 * Sets view height
 * @param height to set
 *
 */
fun View.setHeight(height: Int) {
    val params = layoutParams
    params.height = height
    layoutParams = params
}

/**
 * Sets the view to visible
 */
fun View.invisible() {
    visibility = View.INVISIBLE
}

/**
 * Sets the view to visible
 */
fun View.visible() {
    visibility = View.VISIBLE
}

/**
 * Sets the view to gone
 */
fun View.gone() {
    visibility = View.GONE
}

/**
 * Inflates a layout based on a given layout id and viewGroup
 * @param layoutRes the layout id
 * @param attachToRoot
 * @return an inflated view
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

/**
 * Inflates a layout based on a given layout id and viewgroup
 * @param res the layout id
 * @param parent the container view
 * @return an inflated view
 */
fun LayoutInflater.init(res: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View =
        this.inflate(res, parent, attachToRoot)

/**
 * Inflates a layout based on a given layout id and viewgroup
 * @param res the layout id
 * @param parent the container view
 * @return an inflated view
 */
fun Context.inflate(res: Int, parent: ViewGroup? = null): View = LayoutInflater.from(this)
        .inflate(res, parent, false)

/**
 * Converts a drawable to bitmap
 * @return bitmap
 */
fun Drawable.toBitmap(): Bitmap {
    val bitmap = Bitmap.createBitmap(this.intrinsicWidth, this.intrinsicHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    this.setBounds(0, 0, canvas.width, canvas.height)
    this.draw(canvas)
    return bitmap
}

/**Get color utility*/
fun Context.getColorFromRes(@ColorRes colorRes: Int): Int = ContextCompat.getColor(this, colorRes)

/**Get drawable extension*/
fun Context.getDrawableFromRes(@DrawableRes colorRes: Int): Drawable? = ContextCompat.getDrawable(this, colorRes)

fun Context.createVectorDrawable(imgRes: Int): VectorDrawableCompat? =
        VectorDrawableCompat.create(resources, imgRes, this.theme)