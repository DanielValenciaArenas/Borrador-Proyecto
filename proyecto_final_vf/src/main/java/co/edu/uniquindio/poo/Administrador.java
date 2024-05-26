package co.edu.uniquindio.poo;
/*
 * Clase que contiene el nombre y la funcionalidad del administrador
 * 
 * @authors: Allison López, Luisa Gómez, Daniel Valencia
 * @since 2024
 * Licencia GNU/GPL v3.0
 */
public class Administrador {
    private final String nombre;
    private final Tarifa tarifa;

    /*
     * Método constructor de la clase Administrador
     */
    public Administrador(String nombre, Tarifa tarifa) {
        this.nombre = nombre;
        this.tarifa = tarifa;
    }

    /*
     * Método para obtener el nombre del administrador
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * Metodo para obtener la tarifa 
     */
    public Tarifa getTarifa() {
        return tarifa;
    }

    /*
     * Método para modificar la tarifa del carro
     */
    public void modificarTarifaCarro(double nuevaTarifa) {
        tarifa.setTarifaHoraCarro(nuevaTarifa);
    }

    /*
     * Método para modificar la tarifa de la moto clasica
     */
    public void modificarTarifaMotoClasica(double nuevaTarifa) {
        tarifa.setTarifaHoraMotoClasica(nuevaTarifa);
    }

    /*
     * Método para modificar la tarifa de la moto hibrida
     */
    public void modificarTarifaMotoHibrida(double nuevaTarifa) {
        tarifa.setTarifaHoraMotoHibrida(nuevaTarifa);
    }
}