package com.demo.foodorders.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.Toast
import com.demo.foodorders.R


object Utils {

    fun isNetworkAvailable(context: Context): Boolean {
        val networkTypes = intArrayOf(ConnectivityManager.TYPE_MOBILE, ConnectivityManager.TYPE_WIFI)
        try {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            for (networkType in networkTypes) {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo.type == networkType)
                    return true
            }
        } catch (e: Exception) {
            return false
        }

        return false
    }

    /**
     * This function is used to show activity using class name
     * call this method when you don't have any data via intent
     */
    fun navigateToOtherScreen(context: Activity, cls: Class<*>, clearStack: Boolean) {
        val intent = Intent(context, cls)
        if (clearStack)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
        context.overridePendingTransition(
            R.anim.push_in_from_left,
            R.anim.push_out_to_right
        )
    }

    /**
     * Finish activity.
     *
     * @param activity the activity
     */
    fun finishActivity(activity: Activity) {
        activity.finish()
        activity.overridePendingTransition(R.anim.push_in_from_right, R.anim.push_out_to_left)
    }

    /**
     * This function is used to load fragment to container by replacing existing.
     *
     * @param isAnim          flag to define that have to load fragment with animation or not
     * @param container       frame where we have to load
     * @param fragmentManager [FragmentManager] instance used to load fragment into container
     * @param targetFragment  [Fragment] instance which needs to be loaded in given container
     * @param tag             String entry attached to being loaded fragment to identify it
     */
    fun navigateFragmentWithoutStack(
        isAnim: Boolean,
        container: Int,
        fragmentManager: FragmentManager,
        targetFragment: Fragment,
        tag: String
    ) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (isAnim)
            fragmentTransaction.setCustomAnimations(
                R.anim.push_in_from_left,
                R.anim.push_out_to_right
            )
        fragmentTransaction.replace(container, targetFragment, tag)
        fragmentTransaction.commitAllowingStateLoss()

    }


    /**
     * This function is used to load fragment to container by replacing existing.
     * It also adds transaction entry in back stack maintained by fragment transaction
     *
     * @param isAnim          flag to define that have to load fragment with animation or not
     * @param container       frame where we have to load
     * @param fragmentManager [FragmentManager] instance used to load fragment into container
     * @param targetFragment  [Fragment] instance which needs to be loaded in given container
     * @param tag             String entry attached to being loaded fragment to identify it
     */
    fun navigateFragmentWithStack(
        isAnim: Boolean,
        container: Int,
        fragmentManager: FragmentManager,
        targetFragment: Fragment,
        tag: String
    ) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (isAnim)
            fragmentTransaction.setCustomAnimations(
                R.anim.push_in_from_left,
                R.anim.push_out_to_right
            )
        fragmentTransaction.replace(container, targetFragment, tag)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commitAllowingStateLoss()

    }


    /**
     * This function is used to add targeted fragment into container.
     */
    fun navigateFragmentAddStack(
        isAnim: Boolean,
        container: Int,
        fragmentManager: FragmentManager,
        targetFragment: Fragment,
        tag: String
    ) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (isAnim)
            fragmentTransaction.setCustomAnimations(
                R.anim.push_in_from_left,
                R.anim.push_out_to_right
            )
        fragmentTransaction.add(container, targetFragment, tag)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commitAllowingStateLoss()

    }

    /**
     * This function is used to check installed android sdk version is greater than 23 or not.
     *
     * @return version status
     */
    fun checkSdkVersion(): Boolean {
        return Build.VERSION.SDK_INT >= 23
    }

    /**
     * This function is used to show toast message for long time
     *
     * @param context
     * @param message String message to be displayed
     */
    fun showLongToast(context: Context, message: CharSequence): Toast {
        return Toast.makeText(context, message, Toast.LENGTH_LONG).apply { show() }
    }

    /**
     * This function is used to show Toast messages for short time
     *
     * @param context
     * @param message String message to be displayed
     */
    fun showShortToast(context: Context, message: CharSequence): Toast {
        return Toast.makeText(context, message, Toast.LENGTH_SHORT).apply { show() }
    }


}