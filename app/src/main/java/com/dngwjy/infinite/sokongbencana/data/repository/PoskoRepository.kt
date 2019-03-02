package com.dngwjy.infinite.sokongbencana.data.repository

import com.dngwjy.infinite.sokongbencana.data.ApiService
import com.dngwjy.infinite.sokongbencana.ui.models.PoskoModel
import io.reactivex.Observable

class PoskoRepository(val api:ApiService) {
fun getPosko():Observable<List<PoskoModel>>{
    return api.getPosko().flatMapIterable {
        it.poskoModel
    }.map {
        PoskoModel(
            namaPosko = it.namaPosko,
            idPosko = it.idPosko,
            lokasiPosko = it.lokasiPosko,
            imagePosko = it.imagePosko
        )
    }.toList().toObservable()
}
}