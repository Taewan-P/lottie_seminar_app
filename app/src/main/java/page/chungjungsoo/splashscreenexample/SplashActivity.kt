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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        val jaramText = findViewById<TextView>(R.id.jaramText)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, logoTimeOut)

        Handler(Looper.getMainLooper()).postDelayed({
            jaramText.visibility = View.VISIBLE
        }, textTimeOut)
    }
}