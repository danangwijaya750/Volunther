package com.dngwjy.infinite.sokongbencana.ui.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PoskoModel(
    var idPosko:String,
    var namaPosko:String,
    var lokasiPosko:String
) : Parcelable