package co.edu.uniquindio.poo;

/*
 * Clase que contiene la información relacionada a un propietario (de un vehículo)
 * 
 * @authors: Allison López, Luisa Gómez, Daniel Valencia
 * @since 2024
 * Licencia GNU/GPL v3.0
 */

public class Propietario {
    private final String nombre;

    /*
     * Método constructor de la clase Propietario
     */
    public Propietario(String nombre) {
        this.nombre = nombre;
    }

    /*
     * Método para obtener el nombre del propietario
     */
    public String getNombre() {
        return nombre;
    }

    
    
}