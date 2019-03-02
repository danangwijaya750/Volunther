package com.dngwjy.infinite.sokongbencana.ui.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.dngwjy.infinite.sokongbencana.base.BaseViewModel
import com.dngwjy.infinite.sokongbencana.base.isError
import com.dngwjy.infinite.sokongbencana.base.isLoading
import com.dngwjy.infinite.sokongbencana.base.showLogistics
import com.dngwjy.infinite.sokongbencana.data.repository.LogisticRepository
import com.dngwjy.infinite.sokongbencana.ui.models.LogisticModel
import com.dngwjy.infinite.sokongbencana.utilities.extensions.logE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LogisticViewModel(val repo:LogisticRepository):BaseViewModel() {
    private  lateinit var  logistics :MutableList<LogisticModel>

    fun getLogistics(){
        if(this::logistics.isInitialized){
            liveDataState.value=showLogistics(logistics)
            return
        }
        logistics= mutableListOf()
        disposable.add(
        repo.getLogistic().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{
                liveDataState.value=isLoading(true)
            }
            .doOnComplete {
                liveDataState.value=isLoading(false)

            }.subscribe({
                logistics.addAll(it)
            },this::onError))
    }
    fun onError(t:Throwable){
        liveDataState.value=isError(t.message as String)
        logE(t.message)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy(){
        dispose()
    }
}