package com.example.marvel.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.marvel.R
import com.example.marvel.viewmodel.ViewModelRegister
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var buttonSave: Button
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var confirmPassword: EditText
    lateinit var email: EditText

    private val viewModelRegister by lazy {
        ViewModelProviders.of(this).get(ViewModelRegister::class.java)
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val window = window
        window.statusBarColor = getColor(R.color.loginColor)
        getWindow().navigationBarColor = ContextCompat.getColor(this, R.color.loginColor)

        buttonSave = findViewById(R.id.buttonSave)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        confirmPassword = findViewById(R.id.confirm_password)
        email = findViewById(R.id.email)

        viewModelRegister.validao.observe(this, Observer {
            if(it){
                startActivity(Intent(this, HomeActivity::class.java))
                Toast.makeText(this, R.string.welcome, Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, R.string.fill_in_correctly, Toast.LENGTH_LONG).show()
            }
        })

        firebaseAuth = FirebaseAuth.getInstance()
        buttonSave.setOnClickListener(View.OnClickListener {
            viewModelRegister.validarCampo(username.text.toString(),email.text.toString(),password.text.toString(),confirmPassword.text.toString())
        })
    }
}