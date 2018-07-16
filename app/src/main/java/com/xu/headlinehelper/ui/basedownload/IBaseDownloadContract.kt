package com.xu.headlinehelper.ui.basedownload

import com.xu.headlinehelper.base.BasePresenter
import com.xu.headlinehelper.base.IBaseView

/**
 * @author 言吾許
 */
interface IBaseDownloadContract {
    interface IBaseDownloadView : IBaseView {
        fun showDownLoadWindow()
        /**
         * 解析视频地址失败
         * @param msg 失败原因
         */
        fun analysisUrlFailed(msg: String)

        /**
         * 正在下载
         */
        fun downloading()
    }

    abstract class BaseDownloadPresenter : BasePresenter<IBaseDownloadView>() {
        /**
         * 获取视频的真实地址
         * @param shareUrl 分享地址
         */
        abstract fun getVideoUrl(shareUrl: String)

        /**
         * 下载视频
         */
        abstract fun downloadVideo()
    }


}