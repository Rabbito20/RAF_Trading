package rs.raf.jun.nikola_djurovic_rn4316

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //  TODO: Splash screen proverava da li smo se logovali ranije ili ne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnMain)
        btnStart.setOnClickListener {

            //  Ovo ce nam biti potrebno kasnije
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }

    }


}