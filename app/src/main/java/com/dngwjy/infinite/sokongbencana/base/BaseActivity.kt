package com.dngwjy.infinite.sokongbencana.base

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.dngwjy.infinite.sokongbencana.utilities.Connectivity
import com.dngwjy.infinite.sokongbencana.R
import com.google.android.material.snackbar.BaseTransientBottomBar

@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity(),
    Connectivity.ConnectivityReceiverListener {
    var isConnected:Boolean=false
    override fun networkConnect(connected: Boolean) {
        isConnected=connected
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
        val snackBar= Snackbar.make(findViewById(R.id.rootLayout),msg,
            Snackbar.LENGTH_LONG)
        snackBar.duration= BaseTransientBottomBar.LENGTH_SHORT
        snackBar.show()

    }

    override fun onResume() {
        super.onResume()
        Connectivity.connectListener =this
    }

}
