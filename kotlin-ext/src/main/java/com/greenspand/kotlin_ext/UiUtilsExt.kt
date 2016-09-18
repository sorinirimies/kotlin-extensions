package com.greenspand.kotlin_ext

import android.app.AlertDialog
import android.app.Notification
import android.content.Context
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast

/***
 *
 * Created by Sorin Albu-Irimies on 03/04/16 <br>
 */



fun Context.toast(msg : String, length : Int = Toast.LENGTH_SHORT) = Toast.makeText(this, msg, length).show()

inline fun alertDialog(context : Context, func : AlertDialog.Builder.() -> Unit) : AlertDialog{
    val builder = AlertDialog.Builder(context)
    builder.func()
    return builder.create()
}

inline fun notification(context: Context, func : Notification.Builder.() -> Unit) : Notification {
    val builder = Notification.Builder(context)
    builder.func()
    return builder.build()
}

 fun snack(container: View, msg : String, duration: Int = Snackbar.LENGTH_SHORT): Snackbar{
    val snackbar = Snackbar.make(container, msg, duration)
     snackbar.show()
    return snackbar
}