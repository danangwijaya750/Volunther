package com.dngwjy.infinite.sokongbencana.data

import com.dngwjy.infinite.sokongbencana.data.models.disaster.DisasterResponse
import com.dngwjy.infinite.sokongbencana.data.models.logistic.LogisticResoponse
import com.dngwjy.infinite.sokongbencana.data.models.posko.PoskoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("bins/16bn1k")
    fun getPosko():Observable<PoskoResponse>

    @GET("")
    fun getLogistic():Observable<LogisticResoponse>

    @GET("")
    fun getDisasters():Observable<DisasterResponse>

}