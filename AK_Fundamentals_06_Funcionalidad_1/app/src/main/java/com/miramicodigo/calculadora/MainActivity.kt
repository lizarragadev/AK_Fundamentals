package com.miramicodigo.calculadora

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Llamar a un recurso dentro de la carpeta src:
    // @TipoResurso/nombreRecurso
    // @color/colorBlanco

    // Llamar a un recurso desde Kotlin
    // R.TipoRecurso.nombreRecurso
    // R.color.colorBlanco

    var listaValores = mutableListOf<Any>()
    var OPERAR = false
    val engine = ScriptEngineManager().getEngineByName("rhino")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        punto.setOnClickListener(this)
        cero.setOnClickListener(this)
        igual.setOnClickListener(this)
        uno.setOnClickListener(this)
        dos.setOnClickListener(this)
        tres.setOnClickListener(this)
        cuatro.setOnClickListener(this)
        cinco.setOnClickListener(this)
        seis.setOnClickListener(this)
        siete.setOnClickListener(this)
        ocho.setOnClickListener(this)
        nueve.setOnClickListener(this)
        delete.setOnClickListener(this)
        divide.setOnClickListener(this)
        multiplica.setOnClickListener(this)
        resta.setOnClickListener(this)
        suma.setOnClickListener(this)

    }

    override fun onClick(p0: View) {
        when(p0.id) {
            R.id.punto -> { showNumber(".") }
            R.id.cero -> { showNumber("0") }
            R.id.igual -> { calcular() }
            R.id.uno -> { showNumber("1") }
            R.id.dos -> { showNumber("2") }
            R.id.tres -> { showNumber("3") }
            R.id.cuatro -> { showNumber("4") }
            R.id.cinco -> { showNumber("5") }
            R.id.seis -> { showNumber("6") }
            R.id.siete -> { showNumber("7") }
            R.id.ocho -> { showNumber("8") }
            R.id.nueve -> { showNumber("9") }
            R.id.delete -> { eliminar() }
            R.id.divide -> { showOperator("/") }
            R.id.multiplica -> { showNumber("*") }
            R.id.resta -> { showOperator("-") }
            R.id.suma -> { showOperator("+") }
        }
    }

    fun showNumber(num: String) {
        listaValores.add(num)
        mostrarValores()
    }

    fun showOperator(oper: String) {
        if(OPERAR)
            calcular()

        listaValores.add(oper)
        OPERAR = true
        mostrarValores()
    }

    fun mostrarValores() {
        var valor = ""
        listaValores.forEach {
            valor += it
        }
        tvPreview.text = valor
        tvPreview.setTextColor(Color.RED)
    }

    fun calcular() {
        if(tvPreview.text.toString() != "") {
            try {
                val res = engine.eval(tvPreview.text.toString()) as Double
                var verifica = res - res.toInt()
                var final: Any
                if(verifica > 0)
                    final = res
                else
                    final = res.toInt()
                tvResult.text = final.toString()
                listaValores.clear()
                listaValores.add(final)
                OPERAR = false
            } catch (e: ScriptException) {
                Toast.makeText(this, "Error en operación", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun eliminar() {
        if(listaValores.size > 0) {
            listaValores.removeAt(listaValores.size - 1)
            mostrarValores()
        } else {
            OPERAR = false
        }
    }

}
