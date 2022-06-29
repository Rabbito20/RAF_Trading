package rs.raf.jun.nikola_djurovic_rn4316

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import rs.raf.jun.nikola_djurovic_rn4316.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    val SHARED_LOGIN_KEY = "loginPref"
    private lateinit var binding: ActivityLoginBinding

    private val USERNAME = "Nikola"
    private val EMAIL = "mail@gmail.rs"
    private val PASSWORD = "sifra123"

    //  Email check
    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    //  Kljucevi
    val USER_KEY = "username"
    val PASS_KEY = "password"
    val EMAIL_KEY = "email"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            //  Uzimamo vrednosti
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            val email = binding.etMail.text.toString()

            //  Provera maila
            var boolMail = false
            if (email.trim { it <= ' ' }.matches(emailPattern.toRegex()))
                boolMail = true

            //  Provera duzine passworda
            if (password.length < 5) binding.passwordErrorMsg.isVisible =
                true else binding.passwordErrorMsg.isGone = true

            //  Login provera
            if (username == USERNAME &&
                boolMail && email == EMAIL &&
                password == PASSWORD
            ) {
                binding.mailErrorMsg.isGone = true
                //  Otvaramo Main Screen
                Toast.makeText(this, "Processing...", Toast.LENGTH_SHORT).show()

                //  Pamtimo u shared pref
                val sharedPref = getSharedPreferences(SHARED_LOGIN_KEY, Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.apply {
//                    putString("key", vrednost)
                    putString(USER_KEY, username)
                    putString(EMAIL_KEY, email)
                    putString(PASS_KEY, password)
                    apply()
                }

                //  Otvaramo main screen
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                //  Zavrsava prethodni activity
                finish()
            } else {
                if (boolMail) binding.mailErrorMsg.isGone =
                    true else binding.mailErrorMsg.isVisible = true

                Toast.makeText(this, "Check your login info!", Toast.LENGTH_SHORT).show()
            }
        }

    }

}