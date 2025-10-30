# PCD_Practica_AERON

Simulador secuencial de tráfico aéreo desarrollado como parte de la asignatura **Programación Concurrente y Distribuida**.

## Autor
Marina Rodríguez Rodríguez 
Estudiante de Ingeniería Informática 
Universidad de Extremadura

## Descripción

Este proyecto simula el comportamiento de una torre de control que gestiona el aterrizaje, embarque y despegue de aviones. Los eventos se registran en archivos `.log` y el número de aviones puede configurarse por entrada del usuario.

## Estructura del proyecto

AERON_MRR/
|-------Main.java
|-------Airplane.java
|-------Passenger.java
|-------ControlTower.java
|-------Logger.java
|-----logs/

## Cómo ejecutar

Compila y ejecuta desde la terminal:
javac *.java
java Main

## Funcionalidades
l. Simulación secuencial del tráfico aéreo
2. Registro de eventos en tiempo real
3. Control de embarque y despegue
4. Configuración dinámica del número de aviones




