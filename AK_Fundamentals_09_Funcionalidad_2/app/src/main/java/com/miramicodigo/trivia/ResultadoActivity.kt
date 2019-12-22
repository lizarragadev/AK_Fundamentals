package com.miramicodigo.trivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val corr = intent.getIntExtra("correctos", -1)
        val incorr = intent.getIntExtra("incorrectos", -1)

        tvResultadoCorrecta.text = corr.toString()
        tvResultadoIncorrecta.text = incorr.toString()

        btnAceptar.setOnClickListener {
            finish()
        }
    }
}
