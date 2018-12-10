package com.dngwjy.infinite.sokongbencana

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
@SuppressLint("Registered")
open class MainActivity : AppCompatActivity(),Connectivity.ConnectivityReceiverListener {
    override fun networkConnect(connected: Boolean) {
        ShowMessage(connected)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(Connectivity(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
    }

    fun ShowMessage(state:Boolean){
        when(state){
            true->{
                tvState.text="You are Online"
            }
            else->{
                tvState.text="You are Offline"
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Connectivity.connectListener=this
    }

}
