/*
 * File:   main.c
 * Author: Franco
 *
 * Created on 26 de julio de 2020, 2:29
 */

// PIC16F628A Configuration Bit Settings

// 'C' source line config statements

// CONFIG
#pragma config FOSC = INTOSCIO  // Oscillator Selection bits (INTOSC oscillator: I/O function on RA6/OSC2/CLKOUT pin, I/O function on RA7/OSC1/CLKIN)
#pragma config WDTE = OFF       // Watchdog Timer Enable bit (WDT disabled)
#pragma config PWRTE = OFF      // Power-up Timer Enable bit (PWRT disabled)
#pragma config MCLRE = OFF      // RA5/MCLR/VPP Pin Function Select bit (RA5/MCLR/VPP pin function is digital input, MCLR internally tied to VDD)
#pragma config BOREN = OFF      // Brown-out Detect Enable bit (BOD disabled)
#pragma config LVP = OFF        // Low-Voltage Programming Enable bit (RB4/PGM pin has digital I/O function, HV on MCLR must be used for programming)
#pragma config CPD = OFF        // Data EE Memory Code Protection bit (Data memory code protection off)
#pragma config CP = OFF         // Flash Program Memory Code Protection bit (Code protection off)

// #pragma config statements should precede project file includes.
// Use project enums instead of #define for ON and OFF.

#include <xc.h>
//#include <stdio.h>
#include <stdint.h>



#define _XTAL_FREQ 4000000  // Frecuencia del cristal interno, 4MHz

 // Funcion para transmitir un caracter por el TX
    
    void UART_write (char dato){
        TXREG = dato;
        while (TXSTAbits.TRMT == 0);
    }
    
    // Función para transmitir un String por el TX
    
    void UART_printf (unsigned char*cadena){
        while (*cadena !=0){
            UART_write(*cadena);
            cadena++;
        }
    }

void main() {
    
// Cambios en registros
    
    TRISA = 0b00111111;   // Los bits 6 y 7 los dejo en Default, salidas, no los voy a usar. Los pines 0 al 5 los configuro como entradas, para los botones
    TRISB = 0b00000110;   // Los bits 0,3,4,5,6,7 no se usan. Los bits 1 y 2 (TX y RX) los configuro como entradas
    SPBRG = 25;   // Establezco el Baud Rate en 9600 para el modo asincronico en el PIC
    CMCON = 7;    // Deshabilito las entradas del comparador analógico de los pines del puerto A
    TXSTA = 0b00100100;  // Establezco el modo asincrónico y habilito las transmisiones del pin TX. También establezco el Baud Rate en High Speed
    RCSTA = 0b10000000;  // Habilito los pines TX y RX como pines de puerto serial
    
// Configuración del Módulo Bluetooth
    
    UART_printf ("AT+BAUD4");  // Establezco el Baud Rate del Módulo en 9600
    __delay_ms(1000);
    UART_printf("AT+NAMETourGenBoost"); // Nombre del módulo
    __delay_ms(1000);
    UART_printf("AT+PIN1234");  // Contraseña del módulo
    __delay_ms(1000);
    
// Variables
    
    uint8_t Lectura;   // Esta variable va a chequear el estado del puerto A, que es el que tiene los botones
    uint8_t ValidacionLectura;   // Esta variable va a chequear si se presiono un botón, en base a cambios en la variable Lectura
    
// Loop
    
    while (1){
        Lectura = PORTA;   // Lectura va a tomar el valor del Puerto A apenas inicia el PIC
        Lectura &= 0b00111111;   // AND con los pines de los botones, para comprobar si se presiono un botón
        
        if (Lectura!= 0b00111111){   // Comparo si Lectura es distinto al estado del PORTA sin que se hubiese tocado ningun botón. Básicamente me fijo si se presionó un botón
            
            // Hago otro chequeo del cambio en el PORTA para evitar el rebote del botón
            __delay_ms (10);   // Delay para el anti rebote de los botones
            Lectura = PORTA;   // Lectura toma el valor del PORTA
            Lectura &= 0b00111111;   // Compruebo una vez más si se presionó un botón y hubo un cambio en Lectura
            
            if (Lectura!= 0b00111111){   // Vuelvo a comprobar el estado del PORTA
                ValidacionLectura = 1;   // Validacion Lectura lo pongo en 1
            } else {
                ValidacionLectura = 0;   // Validacion Lectura lo pongo en 0
            }
        }
        
        // Si ValidacionLectura es igual a 1, significa que hubo un cambio en el PORTA, que se presionó un botón
        
        if (ValidacionLectura == 1){
            switch (Lectura){   // Comparo el valor de Lectura, para determinar cuál de los botones es el que se presionó
                
                case 0b00111110: {   // Se presionó el botón del pin RA0
                    UART_write('A');  // Imprimo un caracter 'A'
                    break;
                }
                case 0b00111101:{   // Se presionó el botón del pin RA1
                    UART_printf("Hola");
                    break;
                }
                case 0b00111011:{   // Se presionó el botón del pin RA2
                    UART_write('C');
                    break;
                }
                case 0b00110111:{   // Se presionó el botón del pin RA3
                    UART_write('D');
                    break;
                }
                case 0b00101111:{   // Se presionó el botón del pin RA4
                    UART_write('E');
                    break;
                }
                case 0b00011111:{   // Se presionó el botón del pin RA5
                    UART_write('F');
                    break;
                }
            }
            
            while ((PORTA & 0b00111111)!= 0b00111111);    // Le digo al programa que espere mientras se presiona una tecla, es decir, mientras que el PORTA sea distinto a como debería estar si estuviese sin ningún botón presionado (por defecto)
            ValidacionLectura = 0;   // Reinicio la variable ValidacionLectura
        }
    }
}


