package com.dngwjy.infinite.sokongbencana.data.repository

import com.dngwjy.infinite.sokongbencana.data.ApiService
import com.dngwjy.infinite.sokongbencana.ui.models.Disasters
import io.reactivex.Observable
import java.util.*

class DisasterRepository(val api:ApiService) {

    fun getDisaster():Observable<List<Disasters>>{
        return  api.getDisasters().flatMapIterable {
            it.disasters
        }.map {
            Disasters(
                idDisaster = it.idDisaster,
                disasterName = it.disasterName,
                locationDisaster = it.locationDisaster,
                imageDisaster = it.imageDisaster
            )
        }.toList().toObservable()
    }

}