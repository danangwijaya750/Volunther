package com.dngwjy.infinite.sokongbencana
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
class Connectivity:BroadcastReceiver() {
    companion object {
        var connectListener:ConnectivityReceiverListener? = null
    }
    override fun onReceive(context: Context, intent: Intent) {
        if(connectListener!=null){
            connectListener!!.networkConnect(isConnectorConnecting(context))
        }
    }

    fun isConnectorConnecting(context: Context):Boolean{
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }

    interface ConnectivityReceiverListener{
        fun networkConnect(connected:Boolean)
    }

}