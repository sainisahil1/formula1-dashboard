package io.sahil.f1dashboard.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.sahil.f1dashboard.R
import io.sahil.f1dashboard.ui.view.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame, HomeFragment(), HomeFragment::class.java.simpleName)
            .commit()

    }
}