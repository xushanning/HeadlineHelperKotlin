package com.xu.headlinehelper.base

/**
 * @author 言吾許
 */
abstract class BasePresenter<T : IBaseView> {
    var mView: T? = null
    fun attachView(view: T) {
        this.mView = view
    }

    fun detachView() {
        mView = null
    }
}