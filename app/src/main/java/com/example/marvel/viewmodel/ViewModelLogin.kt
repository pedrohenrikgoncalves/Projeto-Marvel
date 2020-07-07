package com.example.marvel.viewmodel

import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class ViewModelLogin : ViewModel(){

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    val loginResponse = MutableLiveData<Boolean>()

    val exitresponse = MutableLiveData<Boolean>()

    val user get() = auth.currentUser

    val callbackManager: CallbackManager = CallbackManager.Factory.create()

    fun logIn(data: Intent?) = try {
        GoogleSignIn.getSignedInAccountFromIntent(data).run {
            val credential = GoogleAuthProvider.getCredential(result?.idToken, null)
            auth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) onLoginSuccess() else onLoginFail()
                    }
        }
    } catch (exception: Exception) {
        onLoginFail()
    }
    val onLoginSuccess = {
        loginResponse.postValue(true)
    }

    val onLoginFail = {
        loginResponse.postValue(false)
    }
    fun logOff() {
        if (user != null) {
            auth.signOut()
            exitresponse.postValue(true)
        } else {
        exitresponse.postValue(false)
        }
    }


    fun loginWithFacebookCall() {
        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                handleFacebookAccessToken(loginResult.accessToken)
            }

            override fun onCancel() {}

            override fun onError(error: FacebookException) {}
        })
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = auth.currentUser
                loginResponse.postValue(true)
            } else {
                // If sign in fails, display a message to the user.
                Log.w("TAG", "signInWithCredential:failure", task.exception)
                loginResponse.postValue(false)
            }
        }
    }
}