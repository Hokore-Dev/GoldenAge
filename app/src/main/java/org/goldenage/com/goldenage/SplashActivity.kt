package org.goldenage.com.goldenage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import org.goldenage.com.goldenage.HowTo.HowToActivity

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        RegistActivityChangeTimer()
    }

    private fun RegistActivityChangeTimer()
    {
        var thread = Thread {
            run {
                Thread.sleep(1000)
                Handler(Looper.getMainLooper()).post {
                    var activity = Intent(this, HowToActivity::class.java)
                    startActivity(activity)
                }
            }
        }
        thread.start()
    }
}
