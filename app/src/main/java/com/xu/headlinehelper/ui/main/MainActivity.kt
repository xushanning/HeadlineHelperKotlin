package com.xu.headlinehelper.ui.main

import com.orhanobut.logger.Logger
import com.xu.headlinehelper.R
import com.xu.headlinehelper.base.BaseActivity

class MainActivity : BaseActivity<IMainContract.IMainView, IMainContract.BaseMainPresenter>(), IMainContract.IMainView {
    override fun viewHello() {
        Logger.d("hello2")
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setPresenter(): IMainContract.BaseMainPresenter {
        return MainPresenter()
    }

    override fun initOthers() {
        mPresenter!!.sayHello()
    }

}
