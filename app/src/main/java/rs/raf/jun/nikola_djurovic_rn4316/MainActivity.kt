package rs.raf.jun.nikola_djurovic_rn4316

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import rs.raf.jun.nikola_djurovic_rn4316.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //  TODO: Splash screen proverava da li smo se logovali ranije ili ne

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        try {
            splashScreen.apply {
                setContentView(R.layout.activity_main)
            }

            //  TODO: If ulogovan idi na main
            //   else
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            //  Zavrsava prethodni activity
            finish()



        } catch (e: RuntimeException) {
            e.printStackTrace()
        }


    }


}