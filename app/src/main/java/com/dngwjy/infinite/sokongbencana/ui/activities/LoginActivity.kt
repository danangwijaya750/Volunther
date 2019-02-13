package com.dngwjy.infinite.sokongbencana.ui.activities

import android.os.Bundle
import android.view.View
import com.dngwjy.infinite.sokongbencana.R
import com.dngwjy.infinite.sokongbencana.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
class LoginActivity : BaseActivity() {
var isLogin=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
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

    }
    fun doSingUp(){

    }
    fun addUserRole(){

    }

}
