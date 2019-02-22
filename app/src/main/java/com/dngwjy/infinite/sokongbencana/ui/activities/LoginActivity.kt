package com.dngwjy.infinite.sokongbencana.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.dngwjy.infinite.sokongbencana.R
import com.dngwjy.infinite.sokongbencana.base.BaseActivity
import com.dngwjy.infinite.sokongbencana.data.shared.Preferences
import kotlinx.android.synthetic.main.activity_login.*
class LoginActivity : BaseActivity() {
var isLogin=true
    private val preferences=Preferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()
        email_sign_in_button.setOnClickListener {
            when(isLogin){
                true->doLogin()
                else->doSingUp()
            }
        }
        textViewSignup.setOnClickListener {
            isLogin = when(isLogin){
                true->{
                    //change
                    textViewSignup.text="Already Have account?, Sign In "
                    spinnerRole.visibility= View.VISIBLE
                    email_sign_in_button.text="Sign Up!"
                    false
                }
                else->{
                    //change
                    textViewSignup.text="Dont have an account?, Sign Up"
                    spinnerRole.visibility= View.GONE
                    email_sign_in_button.text="Sign In!"
                    true
                }
            }
        }
    }
    fun doLogin(){
        preferences.isLogged=true
    }
    fun doSingUp(){
        preferences.isLogged=true
    }
    fun addUserRole(){

    }
    fun checkLogged(){
        when(preferences.isLogged){
            true-> {startActivity(Intent(this,HomeActivity::class.java))
                this.finish()}
                else->{
                    startActivity(Intent(this,HomeActivity::class.java))
                this.finish()}
        }

        }
    }


