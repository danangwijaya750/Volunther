package com.dngwjy.infinite.sokongbencana.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dngwjy.infinite.sokongbencana.R
import com.dngwjy.infinite.sokongbencana.base.*
import com.dngwjy.infinite.sokongbencana.ui.adapters.PostAdapter
import com.dngwjy.infinite.sokongbencana.ui.models.PoskoModel
import com.dngwjy.infinite.sokongbencana.ui.viewmodels.PoskoViewModel
import com.dngwjy.infinite.sokongbencana.utilities.extensions.toast
import org.koin.android.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.activity_posko_list.*
class PoskoListActivity : BaseActivity(), Observer<LiveDataState> {
    override fun onChanged(t: LiveDataState?) {
        when(t){
            is showPosko->{showData(t.data)}
            is isLoading->{
            }
            is isError->{
                toast("error ${t.msg}")
            }
        }
    }

    override fun networkConnect(connected: Boolean) {
        super.networkConnect(connected)
        when(connected){
            true->{
                if(poskoList.size<1){
                    poskoViewModel.getPosko()
                }
            }
        }
    }
    private fun showData(data:List<PoskoModel>){
        poskoList.clear()
        poskoList.addAll(data)
        adapter.notifyDataSetChanged()
    }
    private var poskoList:MutableList<PoskoModel> = mutableListOf()
    private lateinit var  adapter:PostAdapter
    private val poskoViewModel by viewModel<PoskoViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posko_list)
        adapter= PostAdapter(poskoList,this){
            toast(it.namaPosko)
        }

        val layMan= LinearLayoutManager(this)
        layMan.orientation=RecyclerView.VERTICAL
        recyclerView.layoutManager=layMan
        recyclerView.adapter=adapter
        poskoViewModel.liveDataState.observe(this,this)
        poskoViewModel.getPosko()
    }
}
