package com.miramicodigo.intents

import android.Manifest
import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val DEVUELVE_DATOS = 111
    val PERMISO_LLAMADA = 222
    val FOTO_CAMARA = 333
    val FOTO_GALERIA = 444
    val PERMISO_GALERIA = 555

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ibAbrirActivity.setOnClickListener(this)
        ibEnviarDatos.setOnClickListener(this)
        ibDevolverDatos.setOnClickListener(this)
        ibAbrirMarcado.setOnClickListener(this)
        ibLlamar.setOnClickListener(this)
        ibAbrirGoogleMaps.setOnClickListener(this)
        ibAbrirStreetView.setOnClickListener(this)
        ibAbrirPaginaWeb.setOnClickListener(this)
        ibAbrirBuscador.setOnClickListener(this)
        ibImagenCamara.setOnClickListener(this)
        ibImagenGaleria.setOnClickListener(this)
        ibCompartirTexto.setOnClickListener(this)
        ibCompartirImagen.setOnClickListener(this)
        ibEnviarEmail.setOnClickListener(this)
        ibAsignarAlarma.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.ibAbrirActivity -> abrirActivity()
            R.id.ibEnviarDatos -> enviarDatos()
            R.id.ibDevolverDatos -> devolverDatos()
            R.id.ibAbrirMarcado -> abrirMarcado()
            R.id.ibLlamar -> llamar()
            R.id.ibAbrirGoogleMaps -> abrirGoogleMaps()
            R.id.ibAbrirStreetView -> abrirStreetView()
            R.id.ibAbrirPaginaWeb -> abrirPaginaWeb()
            R.id.ibAbrirBuscador -> abrirBusquedaEnGoogle()
            R.id.ibImagenCamara -> imagenCamara()
            R.id.ibImagenGaleria -> imagenGaleria()
            R.id.ibCompartirTexto -> compartirTexto()
            R.id.ibCompartirImagen -> compartirImagen()
            R.id.ibEnviarEmail -> enviarEmail()
            R.id.ibAsignarAlarma -> asignarAlarma()
        }
    }

    fun abrirActivity() {

    }

    fun enviarDatos() {

    }

    fun devolverDatos() {

    }

    fun abrirMarcado() {

    }

    fun llamar() {

    }

    fun abrirGoogleMaps() {

    }

    fun abrirStreetView() {

    }

    fun abrirPaginaWeb() {

    }

    fun abrirBusquedaEnGoogle() {

    }

    fun imagenCamara() {

    }

    fun imagenGaleria() {

    }

    fun compartirTexto() {

    }

    fun compartirImagen() {

    }

    fun enviarEmail() {

    }

    fun asignarAlarma() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }

}
