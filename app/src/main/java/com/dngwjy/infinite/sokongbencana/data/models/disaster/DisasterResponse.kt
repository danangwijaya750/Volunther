package com.dngwjy.infinite.sokongbencana.data.models.disaster

data class DisasterResponse(
    val disasters:List<Disasters>
) {
    data class Disasters(
        val idDisaster:String,
        val disasterName:String,
        val locationDisaster:String,
        val imageDisaster:String
    ) {

    }
}