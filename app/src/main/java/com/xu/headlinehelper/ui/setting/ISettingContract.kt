package com.xu.headlinehelper.ui.setting

import com.xu.headlinehelper.base.BasePresenter
import com.xu.headlinehelper.base.IBaseView

/**
 * @author 言吾許
 */
interface ISettingContract {
    interface ISettingView : IBaseView
    abstract class BaseSettingPresenter : BasePresenter<ISettingView>() {

    }
}