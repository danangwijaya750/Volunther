package com.dngwjy.infinite.sokongbencana.data.models.logistic

data class LogisticResoponse(
    val logisticModel: List<LogisticModel>
) {
    data class LogisticModel(
        val idLogistic:String,
        val poskoId:String
    )
}
