package com.example.marvel.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class ViewModelLoginFire : ViewModel() {
    val validinho = MutableLiveData<Boolean>()
    private val authLogin: FirebaseAuth = FirebaseAuth.getInstance()
    val user get() = authLogin.currentUser

    fun validaLogin(email: String, senha: String){
        if (email.isEmpty() || senha.isEmpty()) {
            validinho.postValue(false)
        } else if (email.isNotEmpty() && senha.isNotEmpty()) {
            authLogin.signInWithEmailAndPassword(email, senha).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    validinho.postValue(true)
                    Log.i("AUTENTICAÇÃO", "Bem-vindo ao App")
                } else {
                    validinho.postValue(false)
                    Log.i("AUTENTICAÇÃO", "erro ao AUTENTICAR")
                }
            }
        }
    }
}