package com.dngwjy.infinite.sokongbencana.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.dngwjy.infinite.sokongbencana.R
import com.dngwjy.infinite.sokongbencana.base.*
import com.dngwjy.infinite.sokongbencana.ui.models.PoskoModel
import com.dngwjy.infinite.sokongbencana.ui.viewmodels.PoskoViewModel
import com.dngwjy.infinite.sokongbencana.utilities.extensions.logD
import com.dngwjy.infinite.sokongbencana.utilities.extensions.toast
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity(),Observer<LiveDataState> {
    override fun onChanged(t: LiveDataState?) {
        when(t){
            is showPosko-> showData(t.data)
            is isLoading-> toast(t.toString())
            is isError->toast(t.toString())
        }
    }
    fun showData(data:List<PoskoModel>){
        logD(data.size.toString())
    }
    var poskoData :MutableList<PoskoViewModel> = mutableListOf()
    val poskoViewModel by viewModel<PoskoViewModel>()
    override fun networkConnect(connected: Boolean) {
        super.networkConnect(connected)
        when(connected){
            true->poskoViewModel.getPosko()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_korban)
        poskoViewModel.liveDataState.observe(this,this)
    }
}
