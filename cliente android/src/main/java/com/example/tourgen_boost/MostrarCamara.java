package com.example.tourgen_boost;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class MostrarCamara extends SurfaceView implements SurfaceHolder.Callback {

    //Objetos

    Camera camera;
    SurfaceHolder holder;

    // Constructor

    public MostrarCamara(Context context, Camera camera) {
        super(context);
        this.camera = camera;   // Asignamos la cámara
        holder = getHolder();
        holder.addCallback(this);
    }

    // Surface Created, sería apenas se crea la vista de la cámara en el Frame layout

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Camera.Parameters parameters = camera.getParameters(); // Objeto para modificar los parametros de la camara

        // Cambios en orientacion y rotación dependiendo de si el celular está horizontal o vertical

        if (this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE){ // Horizontal

            parameters.set("orientation", "portrait");
            camera.setDisplayOrientation(90);
            parameters.setRotation(90);
        } else { //Vertical

            parameters.set("orientation", "landscape");
            camera.setDisplayOrientation(0);
            parameters.setRotation(0);
        }

        camera.setParameters(parameters); //Asignamos los parametros anteriores a la cámara

        //Iniciamos la vista previa de la cámara en el surface Holder, el cual va a ir al Frame Layout

        try {
            camera.setPreviewDisplay(holder); //Ponemos la cámara en el surfaceHolder
            camera.startPreview();  // Iniciamos la vista previa de la cámara
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        camera.stopPreview();  // Detenemos la vista previa de la cámara
        camera.release();      // Liberamos la cámara
    }
}
