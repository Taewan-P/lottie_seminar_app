package page.chungjungsoo.splashscreenexample

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val logoTimeOut :Long = 2600
    private val textTimeOut :Long = 2100
    private val handler :Handler = Handler(Looper.getMainLooper())
    private lateinit var loadMainActivity :Runnable
    private lateinit var loadLogoText :Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        val jaramText = findViewById<TextView>(R.id.jaramText)

        loadMainActivity = Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        loadLogoText = Runnable {
            jaramText.visibility = View.VISIBLE
        }

        handler.postDelayed(loadMainActivity, logoTimeOut)
        handler.postDelayed(loadLogoText, textTimeOut)
    }

    override fun onDestroy() {
        handler.removeCallbacks(loadLogoText)
        handler.removeCallbacks(loadMainActivity)
        super.onDestroy()
    }
}