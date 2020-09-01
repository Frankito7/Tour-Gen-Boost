package com.example.tourgen_boost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class Pantalla_Pre_Recorrido extends AppCompatActivity {

    // Objetos

    TextView txt_recorrido;  // Texto que indica el nombre del recorrido
    TextView txt_hc, prueba;  // Texto de la conexión con el módulo
    BluetoothAdapter adapter = null;  // BluetoothAdapter para controlar el Bluetooth y su comportamiento
    Button boton_empezar;  // Botón que inicia el recorrido
    BluetoothSocket mmSocket = null;  // Socket de conexión Bluetooth
    Handler BluetoothEntrada;   // Handler receptor de los datos por Bluetooth
    final int EstadoHandler = 0;
    private ConexionBT conexionBT;  // Objeto de la clase para la recepción de datos

    private static final UUID mUUID = UUID.fromString("d3f37dd8-a650-4d33-b13f-f416c82d64b8");  // UUID de la netbook
    public static String address = "";  // Variable String que va a recibir la dirección MAC de la activity anterior




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla__pre__recorrido);

        adapter = BluetoothAdapter.getDefaultAdapter(); // Obtengo el control para el adaptador local Bluetooth

        //Color del titulo y alineacion

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.titulo_centrado);

        //Poner el icono en el Action Bar de la app

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //Castings

        txt_recorrido = (TextView)findViewById(R.id.txt_recorrido_seleccionado);
        txt_hc=(TextView)findViewById(R.id.txt_bluetooth_hc06);
        boton_empezar = (Button)findViewById(R.id.btn_empezar);
        prueba = (TextView)findViewById(R.id.prueba);

        //Obtener el titulo del recorrido seleccionado

        String recorrido = getIntent().getStringExtra("Recorrido"); // Obtenemos el string creado en la pantalla de inicio
        int recorrido_seleccionado = Integer.parseInt(recorrido);

        //Mostrar el recorrido seleccionado

        if (recorrido_seleccionado == 1){
            txt_recorrido.setText(R.string.recorrido_seleccionado); // Dependiendo del valor de la variable traída de la pantalla inicio, cambia el recorrido
        }

        // Handler receptor de datos

        BluetoothEntrada = new Handler(){
            public void mensaje(android.os.Message msg){
                if (msg.what == EstadoHandler){  // Compruebo si llegan mensajes

                    char B = (char) msg.obj;  // Guardo el mensaje en una variable Char

                    // Empiezo a comparar en base a qué dato llega y hago determinada acción para cada caso

                    if (B == 'A'){
                        prueba.setText("Llego el dato");
                    }
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();  // Obtengo el intent de la activity anterior
        address = intent.getStringExtra(DispositivosBluetooth.Direccion);  // Obtengo el string que se guardo en el intent
        prueba.setText(address);

        BluetoothDevice device = adapter.getRemoteDevice(address);  // Obtengo el dispositivo que le corresponde a la dirección MAC seleccionada y lo almaceno en un BluetoothDevice

        adapter.cancelDiscovery();  // Cancelo la busqueda de dispositivos para ahorrar recursos

        try {
            mmSocket = btsocket(device);    // Intento establecer una comunicación con el dispositivo anteriormente obtenido
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("TAG", "No se pudo conectar el socket");
        }

        try {
            mmSocket.connect();     // Una vez establecida la comunicación, intento conectarme
//            txt_hc.setText("Modulo Conectado");
        } catch (IOException e){
            Log.e("TAG", "No se pudo conectar el módulo");
            try {
                mmSocket.close();   // Cierro el socket en caso de que no se haya podido concretar la conexión
            } catch (IOException e2){
                Log.e("TAG", "No se pudo cerrar el socket");
            }
        }

        conexionBT = new ConexionBT(mmSocket);  // Inicializo un objeto que recibe los datos Bluetooth pasandole el BluetoothSocket ya conectado con la netbook
        conexionBT.start();     // Inicio el objeto
    }

    @Override
    protected void onPause() {
        super.onPause();

        try {
            mmSocket.close();   // Intento cerrar el socket para evitar crasheos de la aplicación
        } catch (IOException e){

        }
    }

    //Funcion para mostrar el menu encabezado en la pantalla

    public boolean onCreateOptionsMenu(Menu menu_pre_recorrido){
        getMenuInflater().inflate(R.menu.encabezado_pre_recorrido,menu_pre_recorrido);
        return true;
    }

    //Funcion para asignarle las funciones a los botones del menú

    public boolean onOptionsItemSelected (MenuItem btn_atras){
        int id = btn_atras.getItemId();

        //Accion al tocar el boton
        if (id == R.id.btn_atras_pr){
            Intent btnatras = new Intent(this, MainActivity.class);
            startActivity(btnatras); // Con el botón de atrás, volvemos a la activity de inicio
            return true;
        }
        return super.onOptionsItemSelected(btn_atras);
    }

    //Función del botón EMPEZAR

    public void btn_empezar(View view){
        Intent btn_Empezar = new Intent(this, activity_recorrido.class);
        startActivity(btn_Empezar); // Pasamos a la activity recorrido
    }

    // Función que permite obtener un BluetoothSocket en base a la UUID del dispositivo al que quiero conectarme

    private BluetoothSocket btsocket (BluetoothDevice device) throws IOException{
        return device.createRfcommSocketToServiceRecord(mUUID);
    }

    // Clase que recibe los datos Bluetooth

    private class ConexionBT extends Thread{

        private final InputStream inputStream;  // Esta variable es la que recibe los datos entrantes por Bluetooth

        public ConexionBT(BluetoothSocket socket){
            InputStream tmpIn = null;   // Inicializo una variable tipo InputStream

            try {
                tmpIn = socket.getInputStream();    // Obtengo los datos que entren por el socket Bluetooth
            } catch (IOException e){
                Log.e("TAG", "No se pudo recibir el dato");
            }

            inputStream = tmpIn;    // Guardo los datos en la variable InputStream anteriormente creada
        }

        // Recepción de datos

        public void run(){
            byte[] byte_entrada = new byte[1024];   // Vector de bytes que almacenan los datos

            while (true){
                try {
                    inputStream.read(byte_entrada); // Leo los datos que entran
                    char a = (char) byte_entrada[0];    // Guardo los datos en un char
                    BluetoothEntrada.obtainMessage(EstadoHandler, a).sendToTarget();    // Envio los datos al Handler
                } catch (IOException e){
                    Log.e("TAG", "No se pudo enviar el mensaje al Handler");
                    break;
                }
            }
        }
    }

}