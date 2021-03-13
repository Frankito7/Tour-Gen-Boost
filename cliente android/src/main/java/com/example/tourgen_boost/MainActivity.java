package com.example.tourgen_boost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Creación de los objetos a modificar en la parte lógica

    TextView txt_ssidwifi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Color del titulo y alineación

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.titulo_centrado);

        //Poner el icono en el Action Bar de la app

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //Castings para asociar los elementos gráficos con la parte lógica

        txt_ssidwifi = (TextView)findViewById(R.id.txt_ssidwifi);

        //Llamamos a la función que detecta el SSID del Wi-Fi

        SSIDWifi();

    }


    //Método para mostrar el boton de configuración

    public boolean onCreateOptionsMenu(Menu config){
        getMenuInflater().inflate(R.menu.menu_encabezado, config);
        return true;
    }

    // Método para agregar acciones al boton configuracion
    public boolean onOptionsItemSelected(MenuItem config){
        int id = config.getItemId();

        // Acción al tocar el boton de configuración
        if (id == R.id.img_configuracion){
            Intent btn_configuracion = new Intent(this, activity_configuracion.class);
            startActivity(btn_configuracion); // Pasamos a la pantalla configuración
            return true;
        }
        return super.onOptionsItemSelected(config);
    }

    //Obtener el SSID del Wi-Fi

    private void SSIDWifi(){
        WifiManager managerwifi = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE); // Objeto WifiManager, con el cual accedemos a la información de la Wifi
        WifiInfo infowifi = managerwifi.getConnectionInfo(); // Accedemos a la información de la conexión Wifi actual

        String SSID = infowifi.getSSID(); // Obtenemos el SSID

        if (SSID.equals("")){
            txt_ssidwifi.setText("Wi-Fi no conectado");
        } else {
            txt_ssidwifi.setText(SSID);
        }


    }
    //Método del botón del recorrido IMPA

    public void Boton_Recorrido(View view){
        Intent btn_recorrido_IMPA = new Intent(this, DispositivosBluetooth.class);
        startActivity(btn_recorrido_IMPA); // Pasamos a la pantalla Bluetooth
    }
}