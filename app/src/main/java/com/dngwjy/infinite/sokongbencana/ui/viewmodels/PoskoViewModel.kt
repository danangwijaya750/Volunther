package com.dngwjy.infinite.sokongbencana.ui.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.dngwjy.infinite.sokongbencana.base.BaseViewModel
import com.dngwjy.infinite.sokongbencana.base.isError
import com.dngwjy.infinite.sokongbencana.base.isLoading
import com.dngwjy.infinite.sokongbencana.base.showPosko
import com.dngwjy.infinite.sokongbencana.data.repository.PoskoRepository
import com.dngwjy.infinite.sokongbencana.ui.models.PoskoModel
import com.dngwjy.infinite.sokongbencana.utilities.extensions.logE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PoskoViewModel(val repo:PoskoRepository):BaseViewModel() {
private lateinit var poskoList: MutableList<PoskoModel>
    fun getPosko(){
        if(this::poskoList.isInitialized){
            liveDataState.value=showPosko(poskoList)
            return
        }
        poskoList= mutableListOf()
        disposable.add(
            repo.getPosko().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    liveDataState.value=isLoading(true)
                }
                .doOnComplete {
                    liveDataState.value=isLoading(false)
                }.subscribe({
                    this.poskoList.addAll(it)
                    liveDataState.value=showPosko(poskoList)
                },this::onError)
        )
    }
    private fun onError(t:Throwable){
        liveDataState.value=isError(t.message.toString())
        t.stackTrace
        logE(t.message.toString())
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy(){
        dispose()
    }
}