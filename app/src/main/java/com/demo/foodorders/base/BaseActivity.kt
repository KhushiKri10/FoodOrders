package com.demo.foodorders.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import com.demo.foodorders.R
import com.demo.foodorders.utils.Utils
import kotlinx.android.synthetic.main.header_tool_bar.*

abstract class BaseActivity<out T : ViewDataBinding> : AppCompatActivity(), View.OnClickListener, BaseFragment.FragmentCallBack {
    private lateinit var childBinding: T
    lateinit var actBaseBinding: com.demo.foodorders.databinding.ActivityBaseBinding
    // variable to track event time
    private var mLastClickTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar()
        actBaseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base)!!
//        actBaseBinding.headerInterface = this;
        performDataBinding()
        initMethod()
    }

    fun setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = getWindow()
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary))
        }
    }

    protected abstract fun initMethod()
    private fun performDataBinding() {
        childBinding = DataBindingUtil.inflate(LayoutInflater.from(this), getLayoutId(), actBaseBinding.frmBaseContainer, false)
        actBaseBinding.frmBaseContainer.addView(childBinding.root)

    }

    /**
     * Get Binding Object
     */

    fun getViewDataBinding(): T = childBinding

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int


    fun isNetworkConnected(): Boolean = Utils.isNetworkAvailable(applicationContext)

    fun hideKeyBoard() {
        val view: View? = this.currentFocus
        val inputMethodManager: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }


    override fun onClick(view: View) {
        hideKeyBoard()
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return
        }

        when (view) {
            img_back -> {
                onBackPressed()
            }
        }

        mLastClickTime = SystemClock.elapsedRealtime()
    }

    override fun onBackPressed() {
        super.onBackPressed()
//        if (this !is DashBoardActivity)
//            Utils.finishActivity(this)
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {
    }

    fun setHeaderTitle(title: String) {
       // actBaseBinding.headerToolBar.binding.titleString = title

    }


}
