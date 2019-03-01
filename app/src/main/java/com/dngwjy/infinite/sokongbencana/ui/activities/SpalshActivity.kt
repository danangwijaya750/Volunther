package com.dngwjy.infinite.sokongbencana.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dngwjy.infinite.sokongbencana.R
import com.dngwjy.infinite.sokongbencana.base.BaseActivity

class SpalshActivity : BaseActivity() {
    private var mHandler: Handler? = null
    private val SPLASH_DELAY : Long = 3000
    internal val mRunnable : Runnable = Runnable {
        if(!isFinishing){
            val intent = Intent(applicationContext,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)
        supportActionBar!!.hide()

        mHandler = Handler()

        mHandler!!.postDelayed(mRunnable,SPLASH_DELAY)
    }

    public override fun onDestroy() {
        if (mHandler != null) {
            mHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }
}
