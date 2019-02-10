package com.dngwjy.infinite.sokongbencana.data.models.posko

import com.dngwjy.infinite.sokongbencana.data.models.posko.PoskoModel
import com.google.gson.annotations.SerializedName

data class PoskoResponse(
    @SerializedName("poskos")
    val poskoModel: List<PoskoModel>
) {
}