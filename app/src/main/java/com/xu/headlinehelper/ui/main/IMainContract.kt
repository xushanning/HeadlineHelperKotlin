package com.xu.headlinehelper.ui.main

import com.xu.headlinehelper.base.BasePresenter
import com.xu.headlinehelper.base.IBaseView

/**
 * @author 言吾許
 */
interface IMainContract {
    interface IMainView : IBaseView {
        fun viewHello()
    }

    abstract class BaseMainPresenter : BasePresenter<IMainView>() {
        abstract fun sayHello()
    }
}