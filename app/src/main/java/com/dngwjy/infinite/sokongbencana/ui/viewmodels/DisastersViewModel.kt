package com.dngwjy.infinite.sokongbencana.ui.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.dngwjy.infinite.sokongbencana.base.BaseViewModel
import com.dngwjy.infinite.sokongbencana.base.isError
import com.dngwjy.infinite.sokongbencana.base.isLoading
import com.dngwjy.infinite.sokongbencana.base.showDisaster
import com.dngwjy.infinite.sokongbencana.data.repository.DisasterRepository
import com.dngwjy.infinite.sokongbencana.ui.models.Disasters
import com.dngwjy.infinite.sokongbencana.utilities.extensions.logD
import com.dngwjy.infinite.sokongbencana.utilities.extensions.logE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DisastersViewModel(val repo:DisasterRepository):BaseViewModel() {
private lateinit var disasters: MutableList<Disasters>
    fun getDisasters(){
        if(this::disasters.isInitialized){
            liveDataState.value=showDisaster(disasters)
            return
        }
        disasters = mutableListOf()
        disposable.add(
            repo.getDisaster().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    logD("onSUb")
                    liveDataState.value=isLoading(true)
                }
                .doOnComplete{
                    liveDataState.value=isLoading(false)
                    logD(disasters.size as String)
                }
                .subscribe({
                    disasters.addAll(it)
                },this::onErrors)
        )
    }
    fun onErrors(t:Throwable){
        liveDataState.value=isError(t.message as String)
        logE(t.message)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy(){
        dispose()
    }
}