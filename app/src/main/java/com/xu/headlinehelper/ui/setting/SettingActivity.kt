package com.xu.headlinehelper.ui.setting

import com.xu.headlinehelper.R
import com.xu.headlinehelper.base.BaseActivity

/**
 * @author 言吾許
 */
class SettingActivity : BaseActivity<ISettingContract.ISettingView, ISettingContract.BaseSettingPresenter>(), ISettingContract.ISettingView {
    override fun setPresenter(): ISettingContract.BaseSettingPresenter {
        return SettingPresenter()
    }


    override fun setLayoutId(): Int {
        return R.layout.activity_setting
    }


    override fun initOthers() {

    }
}