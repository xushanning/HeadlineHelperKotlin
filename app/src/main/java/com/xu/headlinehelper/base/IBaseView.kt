package com.xu.headlinehelper.base

import com.trello.rxlifecycle2.LifecycleTransformer

/**
 * @author 言吾許
 */
interface IBaseView {
    /**
     * 绑定生命周期
     * @param <T> 泛型
     */
    fun <T> bindToLife(): LifecycleTransformer<T>

    /**
     * 设置layout
     */
    fun setLayoutId(): Int

}