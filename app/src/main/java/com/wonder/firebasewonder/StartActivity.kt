package com.wonder.firebasewonder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.wonder.firebasewonder.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //se setea la accion del boton
        binding.btnLogout.setOnClickListener {
            logOutSession()
        }
    }

    private fun logOutSession(){
        AuthUI.getInstance()
            .signOut(this)
            .addOnCompleteListener {
                // ...
                startMainActivity()
            }
    }

    private fun startMainActivity(){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}