package com.example.tourgen_boost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;


public class activity_configuracion extends AppCompatActivity {

    //Creación de los objetos a modificar en la parte lógica

    Switch switch_dark_mode;
    TextView txt_acerca_de;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        //Color del titulo y alineacion

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); // Decimos que el Action Bar en este activity va a tener un diseño personalizado por nosotros
        getSupportActionBar().setCustomView(R.layout.titulo_centrado);   // Le establecemos el titulo personalizado que hicimos al ActionBar

        //Poner el icono en el Action Bar de la app

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher); // Insertamos el icono en el ActionBar

        //Castings para asociar los elementos gráficos con la parte lógica

        switch_dark_mode = (Switch)findViewById(R.id.switch_modo_oscuro);
        txt_acerca_de = (TextView)findViewById(R.id.txt_acerca_de);

        //Obtener el estado del modo oscuro

        SharedPreferences modo_oscuro = getSharedPreferences("darkmode", Context.MODE_PRIVATE); // Obtenemos el estado del modo oscuro
        Boolean nightmode = modo_oscuro.getBoolean("estado",false); // Obtenemos la variable booleana del estado del modo oscuro

        //Establecer el estado modo oscuro o no

        if (nightmode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES); // Modo oscuro ON
            switch_dark_mode.setChecked(true); // Switch encendido
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // Modo Oscuro OFF
            switch_dark_mode.setChecked(false); //Switch no encendido
        }
    }

    //Funcion para mostrar el menu encabezado en la pantalla

    public boolean onCreateOptionsMenu(Menu menu_configuracion){
        getMenuInflater().inflate(R.menu.menu_configuracion,menu_configuracion);
        return true;
    }

    //Funcion para asignarle las funciones a los botones del menú

    public boolean onOptionsItemSelected (MenuItem btn_atras){
        int id = btn_atras.getItemId();

        //Accion al tocar el boton atrás
        if (id == R.id.btn_atras_bluetooth){
            Intent btnatras = new Intent(this, MainActivity.class);
            startActivity(btnatras); // Volvemos a la activity inicio
            return true;
        }
        return super.onOptionsItemSelected(btn_atras);
    }

    //Funcion del boton acerca de

    public void btn_acerca_de(View view){
        int visibility_txt = txt_acerca_de.getVisibility(); // Obtenemos el estado de visibilidad del texto

        // Comparo el estado de la visibilidad del texto

        if (visibility_txt == View.INVISIBLE){  // Si está invisible, al tocar el botón, el texto se hace visible
            txt_acerca_de.setVisibility(View.VISIBLE);
        }
        else if (visibility_txt == View.VISIBLE){   // Si está visible, al tocar el botón, el texto se hace invisible
            txt_acerca_de.setVisibility(View.INVISIBLE);
        }
    }

    // Método del switch modo oscuro

    public void switch_modo_oscuro (View view){
        if (switch_dark_mode.isChecked()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES); // Modo Oscuro ON
            SharedPreferences modooscuro = getSharedPreferences("darkmode", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = modooscuro.edit();
            editor.putBoolean("estado", true); // Editamos el estado del modo oscuro y lo ponemos en ON
            editor.commit(); // Guardamos el cambio
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // Modo Oscuro OFF
            SharedPreferences modooscuro = getSharedPreferences("darkmode", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = modooscuro.edit();
            editor.putBoolean("estado", false); // El estado del modo oscuro lo establecemos en OFF
            editor.commit();  // Guardamos el cambio
        }
    }
}