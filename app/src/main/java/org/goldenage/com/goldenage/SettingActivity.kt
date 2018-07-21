package org.goldenage.com.goldenage

import android.app.ActionBar
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setCustomView(R.layout.custom_actionbar)
    }
}
