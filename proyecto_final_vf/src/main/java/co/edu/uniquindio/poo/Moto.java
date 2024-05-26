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

    /*
     * Método constructor de la clase Moto
     */
    public Moto(String placa, String modelo, Propietario propietario, TipoMoto tipoMoto) {
        super(placa, modelo, propietario);
        this.tipoMoto = tipoMoto;

        assert tipoMoto == TipoMoto.CLASICA || tipoMoto == TipoMoto.HIBRIDA;
    }

    /*
     * Método para obtener el tipo de moto
     */
    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

}