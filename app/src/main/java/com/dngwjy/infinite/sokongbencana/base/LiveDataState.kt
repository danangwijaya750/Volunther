package com.dngwjy.infinite.sokongbencana.base

import com.dngwjy.infinite.sokongbencana.ui.models.Disasters
import com.dngwjy.infinite.sokongbencana.ui.models.LogisticModel
import com.dngwjy.infinite.sokongbencana.ui.models.PoskoModel

sealed class LiveDataState
data class showPosko(val data:List<PoskoModel>):LiveDataState()
data class  isLoading(val show:Boolean):LiveDataState()
data class  isError(val msg:String):LiveDataState()
data class showDisaster(val data:List<Disasters>):LiveDataState()
data class showLogistics(val data:List<LogisticModel>):LiveDataState()