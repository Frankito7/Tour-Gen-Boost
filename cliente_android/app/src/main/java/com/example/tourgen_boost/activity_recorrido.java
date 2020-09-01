package com.example.tourgen_boost;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class activity_recorrido extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    //Objetos

    ProgressBar barra_progreso;
    Camera camera;
    FrameLayout framelayout;
    MostrarCamara mostrarCamara;
    ImageView img_camera;
    ZXingScannerView Escaner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorrido);

        //Castings

        framelayout = (FrameLayout)findViewById(R.id.camera_view);
        barra_progreso = (ProgressBar)findViewById(R.id.progreso_recorrido);
        img_camera = (ImageView)findViewById(R.id.img_camara);

        //Invisible la imagen estética de la cámara

        img_camera.setVisibility(View.INVISIBLE);

        //Cámara

        camera = Camera.open(); // Abrimos la cámara

        mostrarCamara = new MostrarCamara(this, camera); //Asociamos el objeto cámara creado con un objeto de tipo MostrarCamara
        framelayout.addView(mostrarCamara); // Añadimos la vista al Frame layout

    }

    private void Salir (){
        Intent a = new Intent(this, Pantalla_Pre_Recorrido.class);   // Intent para volver a la activity pre-recorrido
        camera.stopPreview();   // Se detiene la vista previa de la cámara
        camera.release();  // Liberamos la cámara
        startActivity(a);  // Volvemos a la activity pre-recorrido
    }

    // Método para saltar la zona actual del recorrido

    private void SaltarZona(){

    }

    // Método para mostrar el siguiente lugar del recorrido

    private void SiguienteLugar(){

    }

    // Método para mostrar la zona actual

    private void ZonaActual(){

    }

    // Método para mostrar la cantidad de zonas restantes en el recorrido

    private void ZonasRestantes(){

    }

    // Método para mostrar los lugares restantes en la zona actual del recorrido

    private void LugaresRestantes(){

    }

    //Función del Escáner

    public void QR(View view){
        Escaner = new ZXingScannerView(this);
        framelayout.addView(Escaner);
        Escaner.setResultHandler(this);
        Escaner.startCamera();
    }

    @Override
    protected void onResume() {
        camera.startPreview();
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        camera.stopPreview();

    }

    @Override
    protected void onStop(){
        super.onStop();
        camera.stopPreview();
        //camera.release();
    }

    // Función que muestra el resultado del Escáner

    @Override
    public void handleResult(Result result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); // Objeto AlertDialog.Builder, que muestra el mensaje
        builder.setTitle("");
        builder.setMessage(result.getText()); // Se obtiene el texto del escaner
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        Escaner.resumeCameraPreview(this);
    }

    // Instrucciones a seguir cuando se presione el botón atrás del teléfono

    @Override
    public void onBackPressed(){

    }
}




