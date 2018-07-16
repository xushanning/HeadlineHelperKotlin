package com.xu.headlinehelper

import android.app.Application
import android.os.Environment
import com.lzy.okgo.OkGo
import com.lzy.okserver.OkDownload
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.xu.headlinehelper.db.dao.DaoMaster
import com.xu.headlinehelper.db.dao.DaoSession
import com.xu.headlinehelper.db.dao.DownLoadSettingDbBeanDao
import com.xu.headlinehelper.db.dbbean.DownLoadSettingDbBean
import com.xu.headlinehelper.util.TransformUtil
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.functions.Consumer

/**
 * @author 言吾許
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        mInstance = this
        initLogger()
        initDataBase()
        initDownloadSetting()
    }

    //单例模式
    companion object {
        @JvmStatic lateinit var mInstance: MyApplication
            private set
        lateinit var mDaoSession: DaoSession
    }

    fun getInstance(): MyApplication {
        return mInstance
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(AndroidLogAdapter())
        }
    }

    private fun initDataBase() {
        val mHelper = DaoMaster.DevOpenHelper(this, "video-helper-db", null)
        val db = mHelper.writableDatabase
        val mDaoMaster = DaoMaster(db)
        mDaoSession = mDaoMaster.newSession()
    }

    fun getDaoSession(): DaoSession {
        return mDaoSession
    }

    private fun initDownloadSetting() {

        Observable.create({ e: ObservableEmitter<DownLoadSettingDbBean> ->
            val dbBeanDao = getDaoSession().downLoadSettingDbBeanDao
            val dbBean = dbBeanDao.queryBuilder().unique()
            if (dbBean != null) {
                e.onNext(dbBean)
            } else {
                val newDbBean = DownLoadSettingDbBean()
                //默认只有wifi才能下载
                newDbBean.wifiDownLoad = true
                //默认显示通知
                newDbBean.showNotify = true
                //默认不震动
                newDbBean.shock = false
                //默认最大下载数为3
                newDbBean.downLoadCount = 3
                //默认最大尝试次数为3
                newDbBean.retryCount = 3
                //默认存储路径
                val path = Environment.getExternalStorageDirectory().path + "/头条助手/"
                newDbBean.savePath = path
                dbBeanDao.insert(newDbBean)
                e.onNext(newDbBean)
            }
            e.onComplete()
        }).compose(TransformUtil.defaultSchedulers())
                .subscribe({ downLoadSettingDbBean ->
                    OkGo.getInstance().init(this)
                            .setRetryCount(downLoadSettingDbBean.retryCount)

                    OkDownload.getInstance().setFolder(downLoadSettingDbBean.savePath)
                            .threadPool.setCorePoolSize(downLoadSettingDbBean.downLoadCount)
                }, { throwable ->
                    throwable.message
                })

    }


}