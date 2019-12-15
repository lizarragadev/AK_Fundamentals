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
        startActivity(Intent(this, SegundaActivity::class.java))
    }

    fun enviarDatos() {
        val intent = Intent(this, SegundaActivity::class.java).apply {
            putExtra("valor1", "Hola a todos")
            putExtra("valor2", 555)
        }
        if(intent.resolveActivity(packageManager) != null)
            startActivity(intent)
    }

    fun devolverDatos() {
        val intent = Intent(this, SegundaActivity::class.java).apply {
            putExtra("valor3", "Dato enviado ")
        }
        if(intent.resolveActivity(packageManager) != null)
            startActivityForResult(intent, DEVUELVE_DATOS)
    }

    fun abrirMarcado() {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:77752810")
        }
        if(intent.resolveActivity(packageManager) != null)
            startActivity(intent)
    }

    fun llamar() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), PERMISO_LLAMADA)
        } else {
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:77752810")
            }
            if(intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }
    }

    fun abrirGoogleMaps() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("geo:-16.495869,-68.133623")
        }
        if(intent.resolveActivity(packageManager) != null)
            startActivity(intent)
    }

    fun abrirStreetView() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("google.streetview:cbll=-16.495869,-68.133623")
        }
        if(intent.resolveActivity(packageManager) != null)
            startActivity(intent)
    }

    fun abrirPaginaWeb() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://www.google.com")
        }
        if(intent.resolveActivity(packageManager) != null)
            startActivity(intent)
    }

    fun abrirBusquedaEnGoogle() {
        val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
            putExtra(SearchManager.QUERY, "Bolivia")
        }
        if(intent.resolveActivity(packageManager) != null)
            startActivity(intent)
    }

    fun imagenCamara() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePicture ->
            takePicture.resolveActivity(packageManager)?.also {
                startActivityForResult(takePicture, FOTO_CAMARA)
            }
        }
    }

    fun imagenGaleria() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PERMISO_GALERIA)
        } else {
            val intent = Intent(Intent.ACTION_PICK).apply {
                type = "image/*"
            }
            if(intent.resolveActivity(packageManager) != null)
                startActivityForResult(intent, FOTO_GALERIA)
        }
    }

    fun compartirTexto() {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Descarga ésta aplicacion en https://play.google.com/id=com/miramicodigo.intent")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(intent, "Compartir este texto con...")
        if(shareIntent.resolveActivity(packageManager) != null)
            startActivity(shareIntent)
    }

    fun compartirImagen() {
        val uriImage = Uri.parse("android.resource://com.miramicodigo.intents/drawable/foto")
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, uriImage)
            type = "image/*"
        }
        if(shareIntent.resolveActivity(packageManager) != null)
            startActivity(Intent.createChooser(shareIntent, "Enviar fotito a..."))
    }

    fun enviarEmail() {
        val TO = arrayOf("lizarraga.gux@gmail.com", "lizarraga.dev@gmail.com")
        val CC = arrayOf("kotlinlapaz@gmail.com")
        val asunto = "Correo importante"
        val contenido = "Comunicado urgente para reunión."

        val intent = Intent(Intent.ACTION_SENDTO).apply {
            type = "text/plain"
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, TO)
            putExtra(Intent.EXTRA_CC, CC)
            putExtra(Intent.EXTRA_SUBJECT, asunto)
            putExtra(Intent.EXTRA_TEXT, contenido)
        }
        if(intent.resolveActivity(packageManager) != null)
            startActivity(Intent.createChooser(intent, "Enviar correo (demo) a:"))
    }

    fun asignarAlarma() {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, "Despierta GUS! DEMO")
            putExtra(AlarmClock.EXTRA_HOUR, 23)
            putExtra(AlarmClock.EXTRA_MINUTES, 54)
            putExtra(AlarmClock.EXTRA_IS_PM, true)
        }
        if(intent.resolveActivity(packageManager) != null)
            startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            DEVUELVE_DATOS -> {
                if(resultCode == Activity.RESULT_OK) {
                    val resultado = data?.getStringExtra("respuesta").toString() ?: ""
                    Toast.makeText(this, "Resultado: $resultado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Se cancelo la respuesta", Toast.LENGTH_SHORT).show()
                }
            }
            FOTO_CAMARA -> {
                if(resultCode == Activity.RESULT_OK) {
                    val imagen = data?.extras?.get("data") as Bitmap
                    ibImagenCamara.setColorFilter(Color.argb(0, 255, 255, 255))
                    ibImagenCamara.setImageBitmap(imagen)
                } else {
                    Toast.makeText(this, "Se cancelo la captura por Camara", Toast.LENGTH_SHORT).show()
                }
            }
            FOTO_GALERIA -> {
                if(resultCode == Activity.RESULT_OK) {
                    ibImagenGaleria.setColorFilter(Color.argb(0, 255, 255, 255))
                    ibImagenGaleria.setImageURI(data?.data)
                } else {
                    Toast.makeText(this, "Se cancelo la obtención por Galeria", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            PERMISO_LLAMADA -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    llamar()
                } else {
                    Toast.makeText(this, "Permiso denegado", Toast.LENGTH_LONG).show()
                }
            }
            PERMISO_GALERIA -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    imagenGaleria()
                } else {
                    Toast.makeText(this, "Permiso denegado", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}
