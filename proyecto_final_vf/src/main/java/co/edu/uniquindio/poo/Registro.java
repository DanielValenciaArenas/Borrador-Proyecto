package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;

/*
 * Clase que agrupa la información del registro del parqueadero
 * 
 * @authors: Allison López, Luisa Gómez, Daniel Valencia
 * @since 2024
 * Licencia GNU/GPL v3.0
 */

public class Registro {
    private final LocalDateTime momentoEntrada;
    private  LocalDateTime momentoSalida;
    private final Puesto puesto;
    private final Vehiculo vehiculo;
    private final Tarifa tarifa;

    /*
     * Método constructor de la clase Registro
     */
    public Registro(LocalDateTime momentoEntrada, LocalDateTime momentoSalida, Puesto puesto, Vehiculo vehiculo, Tarifa tarifa) {
        this.momentoEntrada = momentoEntrada;
        this.momentoSalida = momentoSalida != null ? momentoSalida:null;
        this.puesto = puesto;
        this.vehiculo = vehiculo;
        this.tarifa = tarifa;
    }

    /*
     * Método para obtener el momento de entrada de un vehiculo
     */
    public LocalDateTime getMomentoEntrada() {
        return momentoEntrada;
    }

    /*
     * Método para obtener el momento de salida de un vehiculo
     */
    public LocalDateTime getMomentoSalida() {
        return momentoSalida;
    }

    /*
     * Método para obtener el puesto registrado
     */
    public Puesto getPuesto() {
        return puesto;
    }

    /*
     * Método para obtener el vehiculo registrado 
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /*
     * Método para obtener la tarifa por hora del vehiculo
     */
    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setMomentoSalida(LocalDateTime momentoSalida) {
        this.momentoSalida = momentoSalida;
    }


    /*
     * Método que define el precio a pagar por el uso del parqueadero
     */
    public double costoTotalEstacionamiento() {

        Duration duracion = Duration.between(momentoEntrada, momentoSalida);
        long horas = duracion.toHours();
        double tarifaPorHora = tarifa.getPrecioTarifa(vehiculo);
        double precioTotal = horas * tarifaPorHora;

        return precioTotal;
    }
    
}