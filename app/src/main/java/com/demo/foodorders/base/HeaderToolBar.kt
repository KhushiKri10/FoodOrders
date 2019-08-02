package com.demo.foodorders.base


import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.demo.foodorders.R
import com.demo.foodorders.utils.interfaces.HeaderInterface

/**
 * Handle tool bar
 */
class HeaderToolBar : Toolbar {
    lateinit var binding: com.demo.foodorders.databinding.HeaderToolBarBinding
    private lateinit var headerInterface: HeaderInterface

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(context)
    }


    private fun init(context: Context) {
        setContentInsetsAbsolute(0, 0)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.header_tool_bar, this, true)
        binding.instance = this
        /* when (context) {
             is SplashActivity -> binding.rlToolBarRoot.visibility = View.GONE
             is LanguageActivity -> binding.rlToolBarRoot.visibility = View.GONE
             is LoginActivity -> binding.rlToolBarRoot.visibility = View.GONE
             is RegistrationActivity -> {
                 binding.rlToolBarRoot.visibility = View.VISIBLE
                 binding.titleString = context.getString(R.string.title_registration)
                 binding.imgBack.visibility = View.VISIBLE
             }
             is MainActivity -> {
                 binding.rlToolBarRoot.visibility = View.VISIBLE
                 binding.imgBack.visibility = View.GONE
                 binding.imgSearch.visibility = View.VISIBLE
             }
             is ServicesActivity -> {
                 binding.rlToolBarRoot.visibility = View.VISIBLE
                 binding.imgBack.visibility = View.GONE
                 binding.imgSearch.visibility = View.GONE
             }
         }*/
    }

    /**
     * On back event.
     *
     * @param view the view
     */
    fun onBackEvent(view :View) {
        if (context != null) {
            (this.context as BaseActivity<*>).onBackPressed()
        }
    }

    /**
     * On search event.
     *
     * @param view the view
     */
    fun onHomeClick(view: View) {
        /*  if (headerInterface != null) {
              headerInterface.onHomeClick()
          }*/

//        if (context != null) {
//            (this.context as BaseActivity<*>).clearStack()
//        }
    }

    /**
     * Sets handler call back.
     *
     * @param headerInterface the handler call back
     */
    fun setHeaderInterface(headerInterface: HeaderInterface) {
        this.headerInterface = headerInterface
    }

}
