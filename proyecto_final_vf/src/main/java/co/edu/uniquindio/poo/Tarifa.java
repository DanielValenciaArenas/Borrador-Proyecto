package co.edu.uniquindio.poo;

/*
 * Clase que que agrupa la información de la tarifa del parqueadero
 * 
 * @authors: Allison López, Luisa Gómez, Daniel Valencia
 * @since 2024
 * Licencia GNU/GPL v3.0
 */

public class Tarifa {
    public double tarifaHoraCarro;
    public double tarifaHoraMotoClasica;
    public double tarifaHoraMotoHibrida;
    private final Vehiculo vehiculo;

    /*
     * Método constructor de la clase tarifa
     */
    public Tarifa(double tarifaHoraCarro, double tarifaHoraMotoClasica, double tarifaHoraMotoHibrida,
            Vehiculo vehiculo) {
        this.tarifaHoraCarro = tarifaHoraCarro;
        this.tarifaHoraMotoClasica = tarifaHoraMotoClasica;
        this.tarifaHoraMotoHibrida = tarifaHoraMotoHibrida;
        this.vehiculo = vehiculo;
    }

    /*
     * Método para obtener la tarifa por hora de un Carro
     */
    public double getTarifaHoraCarro() {
        return tarifaHoraCarro;
    }

    /*
     * Método para modificar/cambiar la tarifa de un carro
     */
    public void setTarifaHoraCarro(double tarifaHoraCarro) {
        this.tarifaHoraCarro = tarifaHoraCarro;
    }

    /*
     * Método para obtener la tarifa por hora de una moto clasica
     */
    public double getTarifaHoraMotoClasica() {
        return tarifaHoraMotoClasica;
    }

    /*
     * Método para modificar/cambiar la tarifa de una moto clasica
     */
    public void setTarifaHoraMotoClasica(double tarifaHoraMotoClasica) {
        this.tarifaHoraMotoClasica = tarifaHoraMotoClasica;
    }

    /*
     * Método para obtener la tarifa por hora de una moto hribrida
     */
    public double getTarifaHoraMotoHibrida() {
        return tarifaHoraMotoHibrida;
    }

    /*
     * Método para modificar/cambiar la tarifa de la moto hibrida
     */
    public void setTarifaHoraMotoHibrida(double tarifaHoraMotoHibrida) {
        this.tarifaHoraMotoHibrida = tarifaHoraMotoHibrida;
    }   

    /*
     * Método para obtener el vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /*
     * Método para obtener el precio de la tarifa según el Vehiculo
     */
    public double getPrecioTarifa(Vehiculo vehiculo) {
        double precioTarifa = 0.0;
        if(vehiculo instanceof Carro) {
            precioTarifa = getTarifaHoraCarro();
        }
        else if (vehiculo instanceof Moto){
            Moto moto = (Moto) vehiculo;
                if(moto.getTipoMoto() == TipoMoto.CLASICA){
                    precioTarifa = getTarifaHoraMotoClasica();
                }
                else{
                    precioTarifa = getTarifaHoraMotoHibrida();
                }
            }

        return precioTarifa;
    }

}