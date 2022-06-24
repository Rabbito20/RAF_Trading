package rs.raf.jun.nikola_djurovic_rn4316

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    val SHARED_LOGIN_KEY = "loginPref"

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        //  Shared pref
        val sharedPref = getSharedPreferences(SHARED_LOGIN_KEY, Context.MODE_PRIVATE)!!
        val USER_KEY = "username"
        val PASS_KEY = "password"
        val EMAIL_KEY = "email"

        val userValue = "Nikola"
        val emailValue = "mail@gmail.rs"
        val passwordValue = "sifra123"

        try {
            val intentLogin = Intent(this, LoginActivity::class.java)
//            val intentMainScreen = Intent(this, MainScreenActivity::class.java)
            splashScreen.apply {

                val user = sharedPref.getString(USER_KEY, null)
                val email = sharedPref.getString(EMAIL_KEY, null)
                val password = sharedPref.getString(PASS_KEY, null)

                //  If ulogovan idi na main screen, u suprotnom idi na login
                if (user == userValue && email == emailValue && password == passwordValue) {
                    setContentView(R.layout.activity_main)
//                    startActivity(intentMainScreen)
                } else {
                    startActivity(intentLogin)
                    finish()    //  Zavrsava prethodni activity
                }
            }

        } catch (e: RuntimeException) {
            e.printStackTrace()
        }

    }


}