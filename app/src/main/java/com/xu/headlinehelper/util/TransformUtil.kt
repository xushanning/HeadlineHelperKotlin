package com.xu.headlinehelper.util

import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by xusn10
 *
 * @author xu
 */

object TransformUtil {
    fun <T> defaultSchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
        }
    }

    fun <T> allIo(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.observeOn(Schedulers.io())
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
        }
    }
}
