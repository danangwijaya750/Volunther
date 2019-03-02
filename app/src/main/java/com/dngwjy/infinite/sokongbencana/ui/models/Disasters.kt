package com.dngwjy.infinite.sokongbencana.ui.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Disasters(
    val idDisaster:String,
    val disasterName:String,
    val locationDisaster:String,
    val imageDisaster:String
) : Parcelable {

}