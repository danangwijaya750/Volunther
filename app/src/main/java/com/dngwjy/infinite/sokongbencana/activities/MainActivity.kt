package com.dngwjy.infinite.sokongbencana.activities

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.dngwjy.infinite.sokongbencana.utilities.Connectivity
import com.dngwjy.infinite.sokongbencana.R

@SuppressLint("Registered")
open class MainActivity : AppCompatActivity(),
    Connectivity.ConnectivityReceiverListener {
    override fun networkConnect(connected: Boolean) {
        ShowMessage(connected)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(
            Connectivity(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
    }

    fun ShowMessage(state:Boolean){
        var msg=""
        when(state){
            true->{
               msg="You are Online"
            }
            else->{
                msg="You are Offline"
            }
        }
        val snackBar= Snackbar.make(findViewById(R.id.rootLayout),msg,Snackbar.LENGTH_LONG)
        snackBar.duration=Snackbar.LENGTH_INDEFINITE
        snackBar.show()
    }

    override fun onResume() {
        super.onResume()
        Connectivity.connectListener =this
    }

}
