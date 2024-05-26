package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDateTime;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/*
 * Pruebas para la clase REGISTRO
 * 
 * @authors: Allison López, Luisa Gómez, Daniel Valencia
 * @since 2024
 * Licencia GNU/GPL v3.0
 */

/**
 * Unit test for simple App.
 */
public class RegistroTest {
    private static final Logger LOG = Logger.getLogger(RegistroTest.class.getName());

    @Test
    public void costoEstadiaVehiculo() {
        LOG.info("Iniciado test costoEstadiaVehiculo");
       // Creación de la salida y entrada
        LocalDateTime momentoEntrada = LocalDateTime.of(2024, 5, 24, 8, 0);  // 24 de mayo de 2024 a las 8:00 AM
        LocalDateTime momentoSalida = LocalDateTime.of(2024, 5, 24, 20, 0);  // 24 de mayo de 2024 a las 20:00 PM

        //Creación del propietario
        Propietario propietario = new Propietario("Ana");

        // Creación del vehículo
        Vehiculo vehiculo = new Carro("GNJ421", "Honda", propietario); 

        // Creación del estado del puesto
        EstadoPuesto estadoPuesto = EstadoPuesto.VACIO;  

        // Se define el puesto con su posición 
        Puesto puesto = new Puesto(2, 2, estadoPuesto, vehiculo);  

        // Se crea la Tarifa con sus respectivos valores para cada vehiculo
        double tarifaHoraCarro = 5000.0;
        double tarifaHoraMotoClasica = 500.0;
        double tarifaHoraMotoHibrida = 1200.0;
        Tarifa tarifa = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, vehiculo);

        // Creación del registro
        Registro registro = new Registro(momentoEntrada, momentoSalida, puesto, vehiculo, tarifa);

        // Se calcula el costo total de la estadia del vehiculo en el parqueadero
        double costoTotal = registro.costoTotalEstacionamiento();

        // Se verifiva que el costo total sea el esperado
        assertEquals(60000.0, costoTotal);

        LOG.info("Finalizando test costoEstadiaVehiculo");
    }


}
