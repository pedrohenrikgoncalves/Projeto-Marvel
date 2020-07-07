package com.example.marvel.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.marvel.R
import com.example.marvel.viewmodel.ViewModelLogin
import com.example.marvel.viewmodel.ViewModelLoginFire
import com.facebook.FacebookSdk
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import kotlinx.coroutines.flow.callbackFlow

class LoginActivity : AppCompatActivity() {
    lateinit var buttonEnviar: Button
    lateinit var senha: EditText
    lateinit var email: EditText
    lateinit var textView: TextView
    lateinit var cadastro: TextView
    lateinit var google: ImageView
    lateinit var facebook: ImageView
    lateinit var loginFirebaseAuth: FirebaseAuth
    lateinit var authStateListener: AuthStateListener
    var activity = this
    private val loginCode = 300

    private val viewModelLogin by lazy {
        ViewModelProviders.of(this).get(ViewModelLogin::class.java)
    }

    private val viewModelLoginFire by lazy {
        ViewModelProviders.of(this).get(ViewModelLoginFire::class.java)
    }

    private val signInClient by lazy {
        GoogleSignIn.getClient(
                this@LoginActivity, GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this)
        setContentView(R.layout.activity_login)

        val window = window
        window.statusBarColor = getColor(R.color.loginColor)
        getWindow().navigationBarColor = ContextCompat.getColor(this, R.color.loginColor)

        buttonEnviar = findViewById(R.id.login)
        senha = findViewById(R.id.password)
        email = findViewById(R.id.email)
        cadastro = findViewById(R.id.register)
        google = findViewById(R.id.imageViewGoogle)
        facebook = findViewById(R.id.imageViewFacebook)

        cadastro.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        })
        viewModelLoginFire.validinho.observe(this, Observer {
            if (it) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Toast.makeText(this, R.string.username_or_password, Toast.LENGTH_LONG).show()
            }
        })
        loginFirebaseAuth = FirebaseAuth.getInstance()
        buttonEnviar = findViewById(R.id.login)
        buttonEnviar.setOnClickListener(View.OnClickListener {
            viewModelLoginFire.validaLogin(email.text.toString(), senha.text.toString())
        })
        authStateListener = AuthStateListener {
            val firebaseUser = viewModelLoginFire.user
            if (firebaseUser != null) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, R.string.welcome, Toast.LENGTH_SHORT).show()
            }
        }
        viewModelLogin.loginResponse.observe(this, Observer {
            if (it){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(activity, R.string.failed, Toast.LENGTH_LONG).show()
            }
        })

        google.setOnClickListener(View.OnClickListener {
            startActivityForResult(signInClient.signInIntent, loginCode)
            viewModelLogin.logOff()
            signInClient.revokeAccess()
        })
        facebook.setOnClickListener ( View.OnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email", "public_profile"))
            viewModelLogin.loginWithFacebookCall()
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModelLogin.callbackManager.onActivityResult(requestCode,resultCode,data)
        when (requestCode) {
            loginCode -> viewModelLogin.logIn(data)
        }
    }
}