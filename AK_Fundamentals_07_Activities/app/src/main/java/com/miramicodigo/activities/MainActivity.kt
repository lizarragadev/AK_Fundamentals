package com.miramicodigo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "Ingreso a OnCreate")

        btnIrAUno.setOnClickListener {
            val intent = Intent(this, UnoActivity::class.java)
            startActivity(intent)
        }

        btnIrADos.setOnClickListener {
            startActivity(Intent(this, DosActivity::class.java))
        }

        btnIrATres.setOnClickListener {
            startActivity(Intent(this, TresActivity::class.java))
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "Ingreso a OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "Ingreso a OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "Ingreso a OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "Ingreso a OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "Ingreso a OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "Ingreso a OnRestart")
    }

}
