package com.xu.headlinehelper.ui.main

import com.orhanobut.logger.Logger

/**
 * @author 言吾許
 */
class MainPresenter : IMainContract.BaseMainPresenter() {
    override fun sayHello() {
        Logger.d("hello")
        mView!!.viewHello()
    }

    fun abs() {

    }
}