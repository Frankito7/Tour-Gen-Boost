package com.example.tourgen_boost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class DispositivosBluetooth extends AppCompatActivity {

    // Objetos

    ListView lista; // ListView con los dispositivos Bluetooth disponibles
    TextView txt_bluetooth; // Texto que indica el estado del Bluetooth
    Button boton_bluetooth; // Botón para iniciar el Bluetooth
    String a = "1"; // String enviado a la activity pre-recorrido para indicar el recorrido seleccionado

    public static String Direccion = "direccion";   // String que va a almacenar la dirección MAC del dispositivo Bluetooth que el usuario seleccione

    private BluetoothAdapter btAdapter; // BluetoothAdapter para esta activity
    private ArrayAdapter arrayAdapter;  // Array para la listview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispositivos_bluetooth);

        //Color del titulo y alineacion

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.titulo_centrado);

        //Poner el icono en el Action Bar de la app

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Castings

        lista = (ListView)findViewById(R.id.ListView);
        txt_bluetooth = (TextView)findViewById(R.id.txt_bluetooth);
        boton_bluetooth = (Button)findViewById(R.id.btn_bluetooth);
    }

    @Override
    protected void onResume() {
        super.onResume();

        VerificarEstadoBluetooth(); // Llamo a la función que comprueba si el bluetooth está activado

        arrayAdapter = new ArrayAdapter(this, R.layout.bluetooth_1);    // Inicio el array
        lista.setAdapter(arrayAdapter); // Vinculo el array con la listview
        lista.setOnItemClickListener(clickListener);    // Le configuro el itemclicklistener a la listView

        btAdapter = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();  // Obtengo los dispositivos Bluetooth vinculados

        // Pongo los dispositivos vinculados en el array, y este en la listview

        if (pairedDevices.size() > 0){
            for (BluetoothDevice device : pairedDevices){
                arrayAdapter.add(device.getName() + "\n" + device.getAddress());
            }
        }

    }

    // Click Listener para la ListView

    private AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener(){
        public void onItemClick(AdapterView av, View v, int arg2, long arg3){

            String info = ((TextView) v).getText().toString();  // Obtengo la información del dispositivo seleccionado
            String direccion = info.substring(info.length() - 17);  // Obtengo la dirección MAC

            finishAffinity();   // Finalizo

            Intent intent = new Intent (DispositivosBluetooth.this, Pantalla_Pre_Recorrido.class);  // Intent para pasar a la activity pre-recorrido
            intent.putExtra(Direccion, direccion);  // Pongo en el intent el string de la MAC
            intent.putExtra("Recorrido",a); // Pongo en el intent el string del recorrido
            startActivity(intent);  // Inicio el intent

        }
    };

    //Funcion para mostrar el menu encabezado en la pantalla

    public boolean onCreateOptionsMenu (Menu menu_bluetooth){

        getMenuInflater().inflate(R.menu.encabezado_bluetooth,menu_bluetooth);
        return true;
    }

    //Funcion para asignarle las funciones a los botones del menú

    public boolean onOptionsItemSelected(MenuItem btn_atras){

        int id = btn_atras.getItemId();

        //Accion al tocar el boton

        if (id == R.id.btn_atras_bluetooth){
            Intent btnatras = new Intent(this, MainActivity.class);
            startActivity(btnatras);
            return true;
        }
        return super.onOptionsItemSelected(btn_atras);
    }

    // Función del botón para activar el Bluetooth

    public void btn_bluetooth (View view){

        Intent activar_bluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(activar_bluetooth, 1);
    }

    // Funcion para verificar el estado del Bluetooth

    private void VerificarEstadoBluetooth() {

        btAdapter= BluetoothAdapter.getDefaultAdapter();

        // Evalúo el estado del Bluetooth

        // Bluetooth no activado

        if(btAdapter==null){
            Toast.makeText(this, "Bluetooth no soportado", Toast.LENGTH_LONG);

            // Bluetooth Activado

        } else if (btAdapter.isEnabled()){
            txt_bluetooth.setText("Bluetooth Activado");  // Cambio de texto estado
            boton_bluetooth.setVisibility(View.INVISIBLE);  // Hago invisible el botón de activar el Bluetooth
            boton_bluetooth.setClickable(false);  // Deshabilito el botón para activar el Bluetooth
        } else {
            txt_bluetooth.setText("Bluetooth Desactivado"); // Cambio el texto de estado de Bluetooth
            boton_bluetooth.setVisibility(View.VISIBLE);  // Hago visible el botón para activar el Bluetooth
            boton_bluetooth.setClickable(true);
        }
    }


}