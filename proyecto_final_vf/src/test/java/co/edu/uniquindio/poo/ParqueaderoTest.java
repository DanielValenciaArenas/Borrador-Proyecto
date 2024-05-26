package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/*
 * Pruebas para la clase PARQUEADERO
 * 
 * @authors: Allison López, Luisa Gómez, Daniel Valencia
 * @since 2024
 * Licencia GNU/GPL v3.0
 */

/**
 * Unit test for simple App.
 */
public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());


    @Test
    public void generarReporteDiario() {
        LOG.info("Iniciado test generarReporteDiario");
        //Precios de las Tarifas por hora
        double tarifaHoraCarro = 2000.0;
        double tarifaHoraMotoClasica = 1000.0;
        double tarifaHoraMotoHibrida = 1400.0;
        //Filas y columnas que tendrá el parqueadero
        int filasPuestos = 6;
        int columnasPuestos = 7;
        //Tarifa genérica
        Tarifa tarifaParqueadero = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, null);

        //Creación del administrador y del parqueadero
        Administrador administradorParqueadero = new Administrador("Admin", tarifaParqueadero);
        Parqueadero parqueadero = new Parqueadero("SuperParqueadero", tarifaParqueadero, filasPuestos, columnasPuestos, administradorParqueadero);

        //Creación del registro #1 con sus respectivos atributos
        LocalDateTime momentoEntrada1 = LocalDateTime.of(2024, 5, 24, 8, 5);
        LocalDateTime momentoSalida1 = LocalDateTime.of(2024, 5, 24, 12, 32);
        Propietario propietario1= new Propietario("Luisa");
        Vehiculo vehiculo1 = new Carro("YTV4", "LAMBORGINI", propietario1);   
        Puesto puesto1 = new Puesto(3, 2, EstadoPuesto.OCUPADO, vehiculo1);
        Tarifa tarifaIngreso1 = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, vehiculo1);
        Registro registro1 = new Registro(momentoEntrada1, momentoSalida1, puesto1, vehiculo1, tarifaIngreso1);

        // Creación del registro #2 con sus respectivos atributos (moto)
        LocalDateTime momentoEntrada2 = LocalDateTime.of(2024, 5, 24, 10, 0);
        LocalDateTime momentoSalida2 = LocalDateTime.of(2024, 5, 24, 15, 10);
        Propietario propietario2 = new Propietario("Marlon");
        Vehiculo vehiculo2 = new Moto("REW23", "DUCATI", propietario2, TipoMoto.HIBRIDA);
        Puesto puesto2 = new Puesto(1, 1, EstadoPuesto.OCUPADO, vehiculo2);
        Tarifa tarifaIngreso2 = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, vehiculo2);
        Registro registro2 = new Registro(momentoEntrada2, momentoSalida2, puesto2, vehiculo2, tarifaIngreso2);

        //Se agregan los registros a una lista de registros del parqueadero
        parqueadero.agregarRegistro(registro1);
        parqueadero.agregarRegistro(registro2);

        //Se calcula el reporte Diario de la fecha establecida
        double recaudoDiario = parqueadero.generarReporteDiario(LocalDate.of(2024, 5, 24));

        //Se verifica  el valor mediante un assertEquals
        assertEquals(15000.0, recaudoDiario);

        LOG.info("Finalizando test generarReporteDiario");
    }

    @Test
    public void generarReporteMensual() {
        LOG.info("Iniciado test generarReporteMensual");
        //Precios de las Tarifas por hora
        double tarifaHoraCarro = 6000.0;
        double tarifaHoraMotoClasica = 2000.0;
        double tarifaHoraMotoHibrida = 3200.0;
        //Filas y columnas que tendrá el parqueadero
        int filasPuestos = 5;
        int columnasPuestos = 5;
        //Tarifa genérica
        Tarifa tarifaParqueadero = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, null);

        //Creación del administrador y del parqueadero
        Administrador administradorParqueadero = new Administrador("Admin", tarifaParqueadero);
        Parqueadero parqueadero = new Parqueadero("SuperParqueadero", tarifaParqueadero, filasPuestos, columnasPuestos, administradorParqueadero);

        //Creación del registro #1 con sus respectivos atributos
        LocalDateTime momentoEntrada1 = LocalDateTime.of(2024, 2, 12, 13, 0);
        LocalDateTime momentoSalida1 = LocalDateTime.of(2024, 2, 12, 16, 40);
        Propietario propietario1= new Propietario("Didier");
        Vehiculo vehiculo1 = new Carro("KAJH5", "LAMBORGINI", propietario1);   
        Puesto puesto1 = new Puesto(3, 2, EstadoPuesto.OCUPADO, vehiculo1);
        Tarifa tarifaIngreso1 = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, vehiculo1);
        Registro registro1 = new Registro(momentoEntrada1, momentoSalida1, puesto1, vehiculo1, tarifaIngreso1);

        // Creación del registro #2 con sus respectivos atributos
        LocalDateTime momentoEntrada2 = LocalDateTime.of(2024, 8, 14, 11, 30);
        LocalDateTime momentoSalida2 = LocalDateTime.of(2024, 8, 14, 14, 10);
        Propietario propietario2 = new Propietario("Roman");
        Vehiculo vehiculo2 = new Moto("FNCX3", "APRILIA", propietario2, TipoMoto.CLASICA);
        Puesto puesto2 = new Puesto(1, 1, EstadoPuesto.OCUPADO, vehiculo2);
        Tarifa tarifaIngreso2 = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, vehiculo2);
        Registro registro2 = new Registro(momentoEntrada2, momentoSalida2, puesto2, vehiculo2, tarifaIngreso2);

        //Creación del registro #3 con sus respectivos atributos
        LocalDateTime momentoEntrada3 = LocalDateTime.of(2024, 2, 12, 19, 5);
        LocalDateTime momentoSalida3 = LocalDateTime.of(2024, 2, 12, 22, 32);
        Propietario propietario3= new Propietario("Allison");
        Vehiculo vehiculo3 = new Moto("QDZS9", "SUZUKI", propietario3, TipoMoto.HIBRIDA);   
        Puesto puesto3 = new Puesto(3, 2, EstadoPuesto.OCUPADO, vehiculo3);
        Tarifa tarifaIngreso3 = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, vehiculo3);
        Registro registro3 = new Registro(momentoEntrada3, momentoSalida3, puesto3, vehiculo3, tarifaIngreso3);

        //Se agregan los registros a una lista de registros del parqueadero
        parqueadero.agregarRegistro(registro1);
        parqueadero.agregarRegistro(registro2);
        parqueadero.agregarRegistro(registro3);

        //Se calcula el reporte Mensual del mes establecido
        double reporteMensual = parqueadero.generarReporteMensual(2); // Mes de febrero

        //Se verifica el valor del reporte Mensual de los dos registros correspondientes al mes establecido
        assertEquals(27600.0, reporteMensual);

        LOG.info("Finalizando test generarReporteDiario");
    }

    
    
}
