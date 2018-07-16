package com.xu.headlinehelper.ui.newtask

import com.xu.headlinehelper.base.BasePresenter
import com.xu.headlinehelper.base.IBaseView

/**
 * @author 言吾許
 */
interface INewTaskContract {
    interface INewTaskView : IBaseView

    abstract class BaseNewTaskPresenter : BasePresenter<INewTaskView>() {
        abstract fun sayHello()
    }
}