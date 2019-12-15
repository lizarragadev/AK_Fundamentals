package com.miramicodigo.intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_segunda.*

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val bundle = intent.extras

        if(bundle != null) {
            tvTextoUno.text = bundle.getString("valor1", "No llega dato")
            tvTextoDos.text = bundle.getInt("valor2", 0).toString()
            etCajaTexto.setText(bundle.getString("valor3", "No llega dato"))
        }

        btnRespuesta.setOnClickListener {
            val intent = Intent().apply {
                putExtra("respuesta", etCajaTexto.text.toString())
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
