package rs.raf.jun.nikola_djurovic_rn4316

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.UserHandleCompat
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import rs.raf.jun.nikola_djurovic_rn4316.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val USERNAME = "Nikola"
    private val EMAIL = "mail@gmail.rs"
    private val PASSWORD = "sifra123"

    //  Email check
    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            var username = binding.etUsername.text!!.toString()
            var password = binding.etPassword.text!!.toString()
            var email = binding.etMail.text.toString()

            //  Provera maila
            var boolMail = false
            if (email.trim { it <= ' ' }.matches(emailPattern.toRegex()))
                boolMail = true

            //  Provera duzine passworda
            if (password.length < 5)
                binding.passwordErrorMsg.isVisible = true
            else
                binding.passwordErrorMsg.isGone = true

            //  Login provera
            if (username == USERNAME &&
                boolMail && email == EMAIL &&
                password == PASSWORD
            ) {
                binding.mailErrorMsg.isGone = true
                //  Otvaramo Main Screen
                Toast.makeText(this, "Processing...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainScreenActivity::class.java)
                startActivity(intent)
                //  Zavrsava prethodni activity
                finish()
            } else {
                if (boolMail)
                    binding.mailErrorMsg.isGone = true
                else
                    binding.mailErrorMsg.isVisible = true

                Toast.makeText(this, "Check your login info!", Toast.LENGTH_SHORT).show()
            }
        }

    }

}