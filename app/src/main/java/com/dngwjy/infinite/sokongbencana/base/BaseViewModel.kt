package com.dngwjy.infinite.sokongbencana.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel:ViewModel() {
    protected val disposable = CompositeDisposable()
    val liveDataState = MutableLiveData<LiveDataState>()
    protected fun dispose(){
        if(!disposable.isDisposed)disposable.dispose()
    }
}