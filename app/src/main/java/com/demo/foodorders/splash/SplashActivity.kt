package com.demo.foodorders.splash

import android.os.Handler
import com.demo.foodorders.R
import com.demo.foodorders.activity.DashBoardActivity
import com.demo.foodorders.activity.StarterActivity
import com.demo.foodorders.base.BaseActivity
import com.demo.foodorders.databinding.ActivitySplashBinding
import com.demo.foodorders.utils.Utils

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun initMethod() {
        Handler().postDelayed({
            //
            Utils.navigateToOtherScreen(this, DashBoardActivity::class.java, true)
        }, 3000)

    }

    override fun getLayoutId(): Int = R.layout.activity_splash
}
