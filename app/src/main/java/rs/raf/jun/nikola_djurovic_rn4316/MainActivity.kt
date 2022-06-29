package rs.raf.jun.nikola_djurovic_rn4316

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import rs.raf.jun.nikola_djurovic_rn4316.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val SHARED_LOGIN_KEY = "loginPref"

    private lateinit var binding: ActivityMainBinding

    //    private var _binding: T? = null
//    // This property is only valid between onCreateView and onDestroyView.
//    val binding get() = _binding!!

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
            splashScreen.apply {
                val user = sharedPref.getString(USER_KEY, null)
                val email = sharedPref.getString(EMAIL_KEY, null)
                val password = sharedPref.getString(PASS_KEY, null)

                //  If ulogovan idi na main screen, u suprotnom idi na login
                if (user == userValue && email == emailValue && password == passwordValue)
                    setContentView(R.layout.activity_main)
                else
                    loginActivityStart()
            }

            //  FUnction for the rest of functionalities in main
            setUpMain()
        } catch (e: RuntimeException) {
            e.printStackTrace()
        }

    }

//    private fun work() {
//
//        //    Log out + clear share pref
//        binding.btnLogOut.setOnClickListener {
//
//            Toast.makeText(this, "Logging out", Toast.LENGTH_SHORT).show()
//
//            val sharedPref = getSharedPreferences(SHARED_LOGIN_KEY, Context.MODE_PRIVATE)
//            val editor = sharedPref.edit().clear()
//            editor.apply {
//                println("Clearing shared pref...")
//                apply()///
//            }
//            loginActivityStart()
//
////            Toast.makeText(this, "Logging out", Toast.LENGTH_SHORT).show()
//        }
//    }

    //  Pozvacemo je kasnije iz druge klase
    private fun loginActivityStart() {
        val intentLogin = Intent(this, LoginActivity::class.java)
        startActivity(intentLogin)
        finish()    //  Zavrsava prethodni activity
    }

    private fun fragmentSwap(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(
            R.id.fragmentMain,
            fragment
        )
        fragmentTransaction.commit()
    }

    private fun setUpMain() {
        //  Fragment Discover
        fragmentSwap(DiscoverFragment())

        //  Fragment Portfolio
//            fragmentSwap(PortfolioFragment())

        //  Fragment Profile

        //  TODO: bind buttons to swap between fragments
    }


}