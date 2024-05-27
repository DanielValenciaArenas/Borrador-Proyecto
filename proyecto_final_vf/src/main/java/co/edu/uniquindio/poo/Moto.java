package co.edu.uniquindio.poo;

/*
 * Clase que agrupa los datos de una moto
 * 
 * @authors: Allison López, Luisa Gómez, Daniel Valencia
 * @since 2024
 * Licencia GNU/GPL v3.0
 */

public class Moto extends Vehiculo {
    private final TipoMoto tipoMoto;
    private final double velocidad;

    /*
     * Método constructor de la clase Moto
     */
    public Moto(String placa, String modelo, Propietario propietario, TipoMoto tipoMoto, double velocidad) {
        super(placa, modelo, propietario);
        this.tipoMoto = tipoMoto;
        this.velocidad = velocidad;

        assert tipoMoto == TipoMoto.CLASICA || tipoMoto == TipoMoto.HIBRIDA;
    }

    /*
     * Método para obtener la velocidad de la moto
     */
    public double getVelocidad() {
        return velocidad;
    }

    /*
     * Método para obtener el tipo de moto
     */
    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

}