package com.demo.foodorders.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A  [BaseFragment] class.
 * Activities that contain this fragment must implement the
 * [BaseFragment.FragmentCallBack] interface
 * to handle interaction events.
 */
abstract class BaseFragment<out T : ViewDataBinding> : Fragment() {
    private lateinit var fragmentChildBinding: T
    private var listener: FragmentCallBack? = null
    private var mActivity: BaseActivity<*>? = null
    private var mRootView: View? = null
//    private var mLastClickTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentChildBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mRootView = fragmentChildBinding.root
        return mRootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentCallBack) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onDetach() {
        mActivity = null
        listener = null
        super.onDetach()
    }

    fun getBaseActivity(): BaseActivity<*>? {
        return mActivity
    }

    /**
     * Get Binding Object
     */

    fun getFragmentDataBinding(): T = fragmentChildBinding

    fun isNetworkConnected(): Boolean {
        return mActivity != null && mActivity!!.isNetworkConnected()
    }

    fun hideKeyboard() {
        if (mActivity != null) {
            mActivity!!.hideKeyBoard()
        }
    }


    interface FragmentCallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }
}
