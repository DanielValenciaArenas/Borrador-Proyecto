package co.edu.uniquindio.poo;

/*
 * Clase abstracta que define que todo vehículo tiene una placa, un modelo y está asociado a un propietario
 * 
 * @authors: Allison López, Luisa Gómez, Daniel Valencia
 * @since 2024
 * Licencia GNU/GPL v3.0
 */
public abstract class Vehiculo {
    private final String placa;
    private final String modelo;
    private final Propietario propietario;
    
    /*
     * Método constructor de la clase Vehiculo
     */
    public Vehiculo(String placa, String modelo, Propietario propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    /*
     * Método para obtener la placa del vehículo
     */
    public String getPlaca() {
        return placa;
    }

    /*
     * Método para obtener el modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /*
     * Método para obtener el propietario asociado a un vehículo
     */
    public Propietario getPropietario() {
        return propietario;
    }
    
    
}