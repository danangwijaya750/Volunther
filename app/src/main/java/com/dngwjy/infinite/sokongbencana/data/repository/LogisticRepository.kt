package com.dngwjy.infinite.sokongbencana.data.repository

import com.dngwjy.infinite.sokongbencana.data.ApiService
import com.dngwjy.infinite.sokongbencana.ui.models.LogisticModel
import io.reactivex.Observable

class LogisticRepository(val api:ApiService) {

    fun getLogistic():Observable<List<LogisticModel>>{
        return api.getLogistic().flatMapIterable {
            it.logisticModel
        }.map {
            LogisticModel(
                idLogistic = it.idLogistic,
                poskoId = it.poskoId
            )
        }.toList().toObservable()
    }
}