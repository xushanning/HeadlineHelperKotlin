package com.xu.headlinehelper.base

import android.os.Bundle
import butterknife.ButterKnife
import butterknife.Unbinder
import com.jaeger.library.StatusBarUtil
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import io.reactivex.disposables.CompositeDisposable

/**
 * @author 言吾許
 * activity基类
 */
abstract class BaseActivity<V : IBaseView, T : BasePresenter<V>> : RxAppCompatActivity(), IBaseView {
    protected var mPresenter: T? = null
    private var bind: Unbinder? = null
    var mCompositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null)
        mPresenter = setPresenter()
        if (mPresenter == null) {
            throw NullPointerException("presenter 不能为空!")
        }
        bind = ButterKnife.bind(this)
        mPresenter!!.attachView(this as V)
        initOthers()
    }

    /**
     * 初始化presenter
     */
    abstract fun setPresenter(): T

    /**
     * 初始化其他
     */
    abstract fun initOthers()

    override fun <T> bindToLife(): LifecycleTransformer<T> {
        return this.bindToLife()
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable.dispose()
        if (mPresenter != null) {
            mPresenter?.detachView()
        }
        bind?.unbind()
    }

}