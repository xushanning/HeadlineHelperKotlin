package com.xu.headlinehelper.ui.newtask

import com.xu.headlinehelper.base.BaseActivity

/**
 * @author 言吾許
 */
class NewTaskActivity : BaseActivity<INewTaskContract, NewTaskPresenter>(), INewTaskContract {
    override fun setLayoutId(): Int {
        return 0
    }

    override fun setPresenter(): NewTaskPresenter {
        return NewTaskPresenter()
    }

    override fun initOthers() {
        mPresenter!!.sayHello()
    }
}