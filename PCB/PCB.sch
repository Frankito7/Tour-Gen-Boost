EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 1
Title ""
Date ""
Rev ""
Comp ""
Comment1 ""
Comment2 ""
Comment3 ""
Comment4 ""
$EndDescr
$Comp
L MCU_Microchip_PIC16:PIC16F628A-ISS U1
U 1 1 5F53FA67
P 3600 2550
F 0 "U1" H 3600 3431 50  0000 C CNN
F 1 "PIC16F628A-ISS" H 3600 3340 50  0000 C CNN
F 2 "Package_DIP:DIP-18_W7.62mm" H 3600 2550 50  0001 C CIN
F 3 "http://ww1.microchip.com/downloads/en/DeviceDoc/40044G.pdf" H 3600 2550 50  0001 C CNN
	1    3600 2550
	1    0    0    -1  
$EndComp
$Comp
L Device:Battery BT2
U 1 1 5F60214F
P 1750 2450
F 0 "BT2" H 1858 2496 50  0000 L CNN
F 1 "3.7V" H 1858 2405 50  0000 L CNN
F 2 "Battery:BatteryHolder_Keystone_1042_1x18650" V 1750 2510 50  0001 C CNN
F 3 "~" V 1750 2510 50  0001 C CNN
	1    1750 2450
	1    0    0    -1  
$EndComp
$Comp
L Device:Battery BT1
U 1 1 5F602CD6
P 1450 2450
F 0 "BT1" H 1558 2496 50  0000 L CNN
F 1 "3.7V" H 1558 2405 50  0000 L CNN
F 2 "Battery:BatteryHolder_Keystone_1042_1x18650" V 1450 2510 50  0001 C CNN
F 3 "~" V 1450 2510 50  0001 C CNN
	1    1450 2450
	1    0    0    -1  
$EndComp
$Comp
L power:GND #PWR0101
U 1 1 5F6057F2
P 3550 3450
F 0 "#PWR0101" H 3550 3200 50  0001 C CNN
F 1 "GND" H 3555 3277 50  0000 C CNN
F 2 "" H 3550 3450 50  0001 C CNN
F 3 "" H 3550 3450 50  0001 C CNN
	1    3550 3450
	1    0    0    -1  
$EndComp
Wire Wire Line
	3500 3250 3550 3250
Wire Wire Line
	3550 3250 3550 3450
Connection ~ 3550 3250
Wire Wire Line
	3550 3250 3600 3250
Wire Wire Line
	1450 2650 1600 2650
$Comp
L power:GND #PWR0102
U 1 1 5F606652
P 2300 2000
F 0 "#PWR0102" H 2300 1750 50  0001 C CNN
F 1 "GND" H 2305 1827 50  0000 C CNN
F 2 "" H 2300 2000 50  0001 C CNN
F 3 "" H 2300 2000 50  0001 C CNN
	1    2300 2000
	1    0    0    -1  
$EndComp
Wire Wire Line
	2300 2000 2300 1900
$Comp
L Switch:SW_Push BTN2
U 1 1 5F607205
P 5300 2250
F 0 "BTN2" H 5300 2535 50  0000 C CNN
F 1 "SW" H 5300 2444 50  0000 C CNN
F 2 "Button_Switch_THT:SW_PUSH_6mm_H13mm" H 5300 2450 50  0001 C CNN
F 3 "~" H 5300 2450 50  0001 C CNN
	1    5300 2250
	1    0    0    -1  
$EndComp
Wire Wire Line
	5100 2250 4800 2250
$Comp
L Switch:SW_Push BTN3
U 1 1 5F607EDD
P 5300 2350
F 0 "BTN3" H 5300 2635 50  0000 C CNN
F 1 "SW" H 5300 2544 50  0000 C CNN
F 2 "Button_Switch_THT:SW_PUSH_6mm_H13mm" H 5300 2550 50  0001 C CNN
F 3 "~" H 5300 2550 50  0001 C CNN
	1    5300 2350
	1    0    0    -1  
$EndComp
$Comp
L Switch:SW_Push BTN4
U 1 1 5F60815D
P 5300 2450
F 0 "BTN4" H 5300 2735 50  0000 C CNN
F 1 "SW" H 5300 2644 50  0000 C CNN
F 2 "Button_Switch_THT:SW_PUSH_6mm_H13mm" H 5300 2650 50  0001 C CNN
F 3 "~" H 5300 2650 50  0001 C CNN
	1    5300 2450
	1    0    0    -1  
$EndComp
$Comp
L Switch:SW_Push BTN5
U 1 1 5F608383
P 5300 2550
F 0 "BTN5" H 5300 2835 50  0000 C CNN
F 1 "SW" H 5300 2744 50  0000 C CNN
F 2 "Button_Switch_THT:SW_PUSH_6mm_H13mm" H 5300 2750 50  0001 C CNN
F 3 "~" H 5300 2750 50  0001 C CNN
	1    5300 2550
	1    0    0    -1  
$EndComp
Wire Wire Line
	5100 2350 4850 2350
Wire Wire Line
	5100 2450 4900 2450
Wire Wire Line
	5100 2550 4950 2550
$Comp
L power:GND #PWR0103
U 1 1 5F6105FF
P 5700 2450
F 0 "#PWR0103" H 5700 2200 50  0001 C CNN
F 1 "GND" V 5705 2322 50  0000 R CNN
F 2 "" H 5700 2450 50  0001 C CNN
F 3 "" H 5700 2450 50  0001 C CNN
	1    5700 2450
	0    -1   -1   0   
$EndComp
Wire Wire Line
	5700 2450 5700 2350
Wire Wire Line
	5700 2150 5500 2150
Wire Wire Line
	5500 2250 5700 2250
Connection ~ 5700 2250
Wire Wire Line
	5700 2250 5700 2150
Wire Wire Line
	5500 2350 5700 2350
Connection ~ 5700 2350
Wire Wire Line
	5700 2350 5700 2250
Wire Wire Line
	5500 2450 5700 2450
Connection ~ 5700 2450
Wire Wire Line
	5500 2550 5700 2550
Wire Wire Line
	5700 2550 5700 2450
$Comp
L Switch:SW_Push BTN1
U 1 1 5F603ED4
P 5300 2150
F 0 "BTN1" H 5300 2435 50  0000 C CNN
F 1 "SW" H 5300 2344 50  0000 C CNN
F 2 "Button_Switch_THT:SW_PUSH_6mm_H13mm" H 5300 2350 50  0001 C CNN
F 3 "~" H 5300 2350 50  0001 C CNN
	1    5300 2150
	1    0    0    -1  
$EndComp
$Comp
L Connector:Conn_01x04_Female J1
U 1 1 5F614497
P 1500 3150
F 0 "J1" H 1392 3435 50  0000 C CNN
F 1 "HC-06" H 1392 3344 50  0000 C CNN
F 2 "Connector_PinSocket_2.00mm:PinSocket_1x04_P2.00mm_Horizontal" H 1500 3150 50  0001 C CNN
F 3 "~" H 1500 3150 50  0001 C CNN
	1    1500 3150
	-1   0    0    -1  
$EndComp
Wire Wire Line
	1700 3050 2400 3050
Wire Wire Line
	2400 3050 2400 1850
$Comp
L power:GND #PWR0104
U 1 1 5F6183D4
P 1900 3150
F 0 "#PWR0104" H 1900 2900 50  0001 C CNN
F 1 "GND" V 1905 3022 50  0000 R CNN
F 2 "" H 1900 3150 50  0001 C CNN
F 3 "" H 1900 3150 50  0001 C CNN
	1    1900 3150
	0    -1   -1   0   
$EndComp
Wire Wire Line
	1700 3150 1900 3150
Wire Wire Line
	1700 3250 2300 3250
Wire Wire Line
	2300 3250 2300 2250
Wire Wire Line
	2300 2250 2500 2250
Wire Wire Line
	1700 3350 2350 3350
Wire Wire Line
	2350 3350 2350 2350
Wire Wire Line
	2350 2350 2500 2350
Wire Wire Line
	1450 2250 1600 2250
Wire Wire Line
	3500 1850 3550 1850
$Comp
L power:GND #PWR0105
U 1 1 5F68E912
P 1600 2750
F 0 "#PWR0105" H 1600 2500 50  0001 C CNN
F 1 "GND" H 1605 2577 50  0000 C CNN
F 2 "" H 1600 2750 50  0001 C CNN
F 3 "" H 1600 2750 50  0001 C CNN
	1    1600 2750
	1    0    0    -1  
$EndComp
Wire Wire Line
	1600 2750 1600 2650
Connection ~ 1600 2650
Wire Wire Line
	1600 2650 1750 2650
Wire Wire Line
	2300 1900 2000 1900
Wire Wire Line
	2000 1900 2000 1700
Wire Wire Line
	2000 1600 1600 1600
Wire Wire Line
	1600 1600 1600 2250
Connection ~ 1600 2250
Wire Wire Line
	1600 2250 1750 2250
Wire Wire Line
	2300 1900 2300 1800
Wire Wire Line
	2300 1800 2800 1800
Wire Wire Line
	2800 1800 2800 1700
Connection ~ 2300 1900
Wire Wire Line
	2400 1850 2850 1850
Wire Wire Line
	2850 1850 2850 1600
Wire Wire Line
	2850 1600 2800 1600
Wire Wire Line
	2850 1600 3550 1600
Wire Wire Line
	3550 1600 3550 1850
Connection ~ 2850 1600
Connection ~ 3550 1850
Wire Wire Line
	3550 1850 3600 1850
$Comp
L Device:R R1
U 1 1 5F698130
P 4500 1550
F 0 "R1" H 4570 1596 50  0000 L CNN
F 1 "10k" H 4570 1505 50  0000 L CNN
F 2 "Resistor_THT:R_Axial_DIN0309_L9.0mm_D3.2mm_P15.24mm_Horizontal" V 4430 1550 50  0001 C CNN
F 3 "~" H 4500 1550 50  0001 C CNN
	1    4500 1550
	1    0    0    -1  
$EndComp
$Comp
L Device:R R2
U 1 1 5F6989CC
P 4650 1550
F 0 "R2" H 4720 1596 50  0000 L CNN
F 1 "10k" H 4720 1505 50  0000 L CNN
F 2 "Resistor_THT:R_Axial_DIN0309_L9.0mm_D3.2mm_P15.24mm_Horizontal" V 4580 1550 50  0001 C CNN
F 3 "~" H 4650 1550 50  0001 C CNN
	1    4650 1550
	1    0    0    -1  
$EndComp
$Comp
L Device:R R3
U 1 1 5F698BBC
P 4800 1550
F 0 "R3" H 4870 1596 50  0000 L CNN
F 1 "10k" H 4870 1505 50  0000 L CNN
F 2 "Resistor_THT:R_Axial_DIN0309_L9.0mm_D3.2mm_P15.24mm_Horizontal" V 4730 1550 50  0001 C CNN
F 3 "~" H 4800 1550 50  0001 C CNN
	1    4800 1550
	1    0    0    -1  
$EndComp
$Comp
L Device:R R4
U 1 1 5F698ECA
P 4950 1550
F 0 "R4" H 5020 1596 50  0000 L CNN
F 1 "10k" H 5020 1505 50  0000 L CNN
F 2 "Resistor_THT:R_Axial_DIN0309_L9.0mm_D3.2mm_P15.24mm_Horizontal" V 4880 1550 50  0001 C CNN
F 3 "~" H 4950 1550 50  0001 C CNN
	1    4950 1550
	1    0    0    -1  
$EndComp
$Comp
L Device:R R5
U 1 1 5F6991A6
P 5100 1550
F 0 "R5" H 5170 1596 50  0000 L CNN
F 1 "10k" H 5170 1505 50  0000 L CNN
F 2 "Resistor_THT:R_Axial_DIN0309_L9.0mm_D3.2mm_P15.24mm_Horizontal" V 5030 1550 50  0001 C CNN
F 3 "~" H 5100 1550 50  0001 C CNN
	1    5100 1550
	1    0    0    -1  
$EndComp
Wire Wire Line
	4700 2150 4750 2150
Wire Wire Line
	4750 2150 4750 1950
Wire Wire Line
	4750 1950 4500 1950
Wire Wire Line
	4500 1950 4500 1700
Connection ~ 4750 2150
Wire Wire Line
	4750 2150 5100 2150
Wire Wire Line
	4800 2250 4800 1900
Wire Wire Line
	4800 1900 4650 1900
Wire Wire Line
	4650 1900 4650 1700
Connection ~ 4800 2250
Wire Wire Line
	4800 2250 4700 2250
Wire Wire Line
	4850 2350 4850 1850
Wire Wire Line
	4850 1850 4800 1850
Wire Wire Line
	4800 1850 4800 1700
Connection ~ 4850 2350
Wire Wire Line
	4850 2350 4700 2350
Wire Wire Line
	4900 2450 4900 1800
Wire Wire Line
	4900 1800 4950 1800
Wire Wire Line
	4950 1800 4950 1700
Connection ~ 4900 2450
Wire Wire Line
	4900 2450 4700 2450
Wire Wire Line
	4950 2550 4950 1850
Wire Wire Line
	4950 1850 5100 1850
Wire Wire Line
	5100 1850 5100 1700
Connection ~ 4950 2550
Wire Wire Line
	4950 2550 4700 2550
Wire Wire Line
	3550 1600 4400 1600
Wire Wire Line
	4400 1600 4400 1400
Wire Wire Line
	4400 1400 4500 1400
Connection ~ 3550 1600
Wire Wire Line
	4500 1400 4650 1400
Connection ~ 4500 1400
Wire Wire Line
	4650 1400 4800 1400
Connection ~ 4650 1400
Wire Wire Line
	4800 1400 4950 1400
Connection ~ 4800 1400
Wire Wire Line
	4950 1400 5100 1400
Connection ~ 4950 1400
$Comp
L Connector:Conn_01x01_Female E+1
U 1 1 5F745226
P 2200 1600
F 0 "E+1" H 2228 1626 50  0000 L CNN
F 1 "Conn_01x01_Female" H 2228 1535 50  0000 L CNN
F 2 "Connector:Banana_Jack_1Pin" H 2200 1600 50  0001 C CNN
F 3 "~" H 2200 1600 50  0001 C CNN
	1    2200 1600
	1    0    0    -1  
$EndComp
$Comp
L Connector:Conn_01x01_Female E-1
U 1 1 5F7458C3
P 2200 1700
F 0 "E-1" H 2228 1726 50  0000 L CNN
F 1 "Conn_01x01_Female" H 2228 1635 50  0000 L CNN
F 2 "Connector:Banana_Jack_1Pin" H 2200 1700 50  0001 C CNN
F 3 "~" H 2200 1700 50  0001 C CNN
	1    2200 1700
	1    0    0    -1  
$EndComp
$Comp
L Connector:Conn_01x01_Female S+1
U 1 1 5F745BF4
P 2600 1600
F 0 "S+1" H 2492 1375 50  0000 C CNN
F 1 "Conn_01x01_Female" H 2492 1466 50  0000 C CNN
F 2 "Connector:Banana_Jack_1Pin" H 2600 1600 50  0001 C CNN
F 3 "~" H 2600 1600 50  0001 C CNN
	1    2600 1600
	-1   0    0    1   
$EndComp
$Comp
L Connector:Conn_01x01_Female S-1
U 1 1 5F7467EF
P 2600 1700
F 0 "S-1" H 2492 1475 50  0000 C CNN
F 1 "Conn_01x01_Female" H 2492 1566 50  0000 C CNN
F 2 "Connector:Banana_Jack_1Pin" H 2600 1700 50  0001 C CNN
F 3 "~" H 2600 1700 50  0001 C CNN
	1    2600 1700
	-1   0    0    1   
$EndComp
$EndSCHEMATC
