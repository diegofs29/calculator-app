package com.dfs.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dfs.calculatorapp.ui.result.ResultFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ResultFragment.newInstance())
                .commitNow()
        }
    }
}