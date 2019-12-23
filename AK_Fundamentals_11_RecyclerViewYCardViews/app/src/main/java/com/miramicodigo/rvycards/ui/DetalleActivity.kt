package com.miramicodigo.rvycards.ui

import android.os.Bundle
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import com.miramicodigo.rvycards.R
import kotlinx.android.synthetic.main.activity_detalle.*

class DetalleActivity : AppCompatActivity() {

    lateinit var tf_black: Typeface
    lateinit var tf_thin: Typeface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)


    }
}
