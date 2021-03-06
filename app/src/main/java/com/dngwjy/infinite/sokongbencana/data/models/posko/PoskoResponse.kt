package com.dngwjy.infinite.sokongbencana.data.models.posko

import com.google.gson.annotations.SerializedName

data class PoskoResponse(
    @SerializedName("poskos")
    val poskoModel: List<PoskoModel>
) {

    data class PoskoModel(
        @SerializedName("idposko")
        var idPosko:String,
        @SerializedName("namaposko")
        var namaPosko:String,
        @SerializedName("lokasi")
        var lokasiPosko:String,
        @SerializedName("image")
        var imagePosko:String)

}