package id.pantaucovid_19.auth

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import id.pantaucovid_19.Dashboard
import id.pantaucovid_19.MainActivity
import id.pantaucovid_19.R
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        mAuth = FirebaseAuth.getInstance()

        button_sign_in.setOnClickListener {
            val email = text_email.text.toString().trim()
            val password = edit_text_password.text.toString().trim()

            if (email.isEmpty()){
                text_email.error = "Email Requaired"
                text_email.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                text_email.error ="Valid Email Requaired"
                text_email.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length < 6){
                edit_text_password.error = "6 char password requaired"
                edit_text_password.requestFocus()
                return@setOnClickListener
            }
            loginUser(email,password)
        }

    }

    private fun loginUser(email: String, password: String) {

        progressbar.visibility = View.VISIBLE
        mAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){task ->
                progressbar.visibility = View.GONE
                if (task.isSuccessful){
                    val intent = Intent(this@LoginActivity, MainActivity::class.java).apply{
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    startActivity(intent)
                }else{
                    task.exception?.message?.let {
                        toast(it)
                    }
                }
            }
    }
}