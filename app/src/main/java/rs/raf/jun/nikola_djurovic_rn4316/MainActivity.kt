package rs.raf.jun.nikola_djurovic_rn4316

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    //  TODO: Splash screen proverava da li smo se logovali ranije ili ne

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        try {
            splashScreen.apply { /* TODO */ }

            setContentView(R.layout.activity_main)

            val btnStart = findViewById<Button>(R.id.btnMain)
            btnStart.setOnClickListener {
                //  Ovo ce nam biti potrebno kasnije
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                //  Zavrsava prethodni activity
                finish()
            }
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }


    }


}