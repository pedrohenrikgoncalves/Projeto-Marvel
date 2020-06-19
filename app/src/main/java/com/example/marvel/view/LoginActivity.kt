package com.example.marvel.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.marvel.R
import com.example.marvel.viewmodel.ViewModelLogin
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class LoginActivity : AppCompatActivity() {
    lateinit var buttonEnviar: Button
    lateinit var senha: EditText
    lateinit var email: EditText
    lateinit var textView: TextView
    lateinit var cadastro: TextView
    lateinit var google: ImageView
    var activity = this
    private val loginCode = 300
    private val viewModel: ViewModelLogin by viewModels()

    private val loginIntent by lazy {
        GoogleSignIn.getClient(
                this@LoginActivity, GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        ).signInIntent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val window = window
        window.statusBarColor = getColor(R.color.loginColor)
        getWindow().navigationBarColor = ContextCompat.getColor(this, R.color.loginColor)

        buttonEnviar = findViewById(R.id.enviar)
        senha = findViewById(R.id.password)
        email = findViewById(R.id.email)
        cadastro = findViewById(R.id.register)
        google = findViewById(R.id.imageViewGoogle)

        cadastro.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        })
        buttonEnviar.setOnClickListener(View.OnClickListener {
            val textoNome = senha.getText().toString()
            val textoEmail = email.getText().toString()
            if (textoNome.isEmpty() || textoEmail.isEmpty()) {
                Toast.makeText(activity, "Please! Fill in all the fields.", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
            }
        })
        viewModel.loginResponse.observe(this, Observer {
            if (it){
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(activity, R.string.failed, Toast.LENGTH_LONG).show()
            }
        })
        google.setOnClickListener(View.OnClickListener {
            startActivityForResult(loginIntent, loginCode)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            loginCode -> viewModel.logIn(data)
        }
    }
}