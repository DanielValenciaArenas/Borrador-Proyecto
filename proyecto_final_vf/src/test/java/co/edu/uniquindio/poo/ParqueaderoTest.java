package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
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
    public void crearPuestos() {
    LOG.info("Iniciado test crearPuestos");
    // Definir tarifas
    double tarifaHoraCarro = 2000.0;
    double tarifaHoraMotoClasica = 1000.0;
    double tarifaHoraMotoHibrida = 1400.0;

    // Tarifa genérica
    Tarifa tarifaParqueadero = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, null);

    // Crear administrador
    Administrador administradorParqueadero = new Administrador("Admin", tarifaParqueadero);

    // Crear parqueadero
    Parqueadero parqueadero = new Parqueadero("SuperParqueadero", tarifaParqueadero, 4, 4, administradorParqueadero);

    Puesto[][] puestos = parqueadero.getPuestos();
    assertNotNull(puestos);
    assertEquals(4, puestos.length);
    assertEquals(4, puestos[0].length);
    assertEquals(EstadoPuesto.VACIO, puestos[0][0].getEstadoPuesto());

    // Imprimir los puestos y su estado
    for (int i = 0; i < puestos.length && i < 4; i++) {
        for (int j = 0; j < puestos[i].length && j < 4; j++) {
            Puesto puesto = puestos[i][j];
            System.out.println("Puesto (" + i + "," + j + "): " + puesto.getEstadoPuesto());
            }   
        }

    LOG.info("Finalizando test crearPuestos");
    }

    @Test
    public void registrarEntrada() {
    LOG.info("Iniciado test registrarEntrada");
    // Definir tarifas
    double tarifaHoraCarro = 2000.0;
    double tarifaHoraMotoClasica = 1000.0;
    double tarifaHoraMotoHibrida = 1400.0;

    // Tarifa genérica
    Tarifa tarifaParqueadero = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, null);

    // Crear administrador
    Administrador administradorParqueadero = new Administrador("Admin", tarifaParqueadero);

    // Crear parqueadero
    Parqueadero parqueadero = new Parqueadero("SuperParqueadero", tarifaParqueadero, 6, 7, administradorParqueadero);

    // Crear propietario y vehículos
    Propietario propietario1 = new Propietario("Juan Perez");
    Propietario propietario2 = new Propietario("Edier");
    Vehiculo vehiculo1 = new Carro("ABC123", "Toyota", propietario1);
    Vehiculo vehiculo2 = new Moto("JQR314", "Kawasaki", propietario2, TipoMoto.HIBRIDA);

    parqueadero.RegistrarEntrada(vehiculo1);
    parqueadero.RegistrarEntrada(vehiculo2);

    Puesto[][] puestos = parqueadero.getPuestos();
    boolean carroFound = false;
    boolean motoFound = false;
    for (int i = 0; i < puestos.length; i++) {
        for (int j = 0; j < puestos[i].length; j++) {
            if (puestos[i][j].getVehiculo() != null) {
                Vehiculo vehiculo = puestos[i][j].getVehiculo();
                System.out.println("El vehículo con placa " + vehiculo.getPlaca() + " y tipo " + vehiculo.getClass().getSimpleName() + " está en el puesto (" + i + "," + j + ")");
                if (vehiculo instanceof Carro && vehiculo.getPlaca().equals("ABC123")) {
                    carroFound = true;
                } else if (vehiculo instanceof Moto && vehiculo.getPlaca().equals("JQR314")) {
                    motoFound = true;
                }
            }
        }
    }
    assertTrue(carroFound);
    assertTrue(motoFound);

    LOG.info("Finalizando test registrarEntrada");
    }

    @Test
    public void registrarSalida() {
    LOG.info("Iniciado test registrarSalida");
    // Definir tarifas
    double tarifaHoraCarro = 2000.0;
    double tarifaHoraMotoClasica = 1000.0;
    double tarifaHoraMotoHibrida = 1400.0;

    // Tarifa genérica
    Tarifa tarifaParqueadero = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, null);

    // Crear administrador
    Administrador administradorParqueadero = new Administrador("Admin", tarifaParqueadero);

    // Crear parqueadero
    Parqueadero parqueadero = new Parqueadero("SuperParqueadero", tarifaParqueadero, 6, 7, administradorParqueadero);

    // Crear propietario y vehículos
    Propietario propietario1 = new Propietario("Juan Perez");
    Propietario propietario2 = new Propietario("Edier");
    Vehiculo vehiculo1 = new Carro("ABC123", "Toyota", propietario1);
    Vehiculo vehiculo2 = new Moto("JQR314", "Kawasaki", propietario2, TipoMoto.HIBRIDA);

    parqueadero.RegistrarEntrada(vehiculo1);
    parqueadero.RegistrarEntrada(vehiculo2);

    // Registrar la salida del vehículo 1
    parqueadero.registrarSalida(vehiculo1);
    parqueadero.registrarSalida(vehiculo2);

    System.out.println("El vehículo con placa " + vehiculo1.getPlaca() + " de tipo " + vehiculo1.getClass().getSimpleName() + " salió del parqueadero.");
    
    // Comentario para imprimir la salida de la moto
    System.out.println("El vehículo con placa " + vehiculo2.getPlaca() + " de tipo " + vehiculo2.getClass().getSimpleName() + " salió del parqueadero.");

    LOG.info("Finalizando test registrarSalida");

    }

    @Test
    public void modificacionTarifasPorAdministrador() {
        LOG.info("Iniciado test modificacionTarifasPorAdministrador");
        // Precios iniciales de las tarifas por hora
        double tarifaHoraCarro = 7000.0;
        double tarifaHoraMotoClasica = 3000.0;
        double tarifaHoraMotoHibrida = 1400.0;

        // Filas y columnas que tendrá el parqueadero
        int filasPuestos = 3;
        int columnasPuestos = 3;

        // Tarifa genérica inicial
        Tarifa tarifaParqueadero = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, null);

        // Creación del administrador y del parqueadero
        Administrador administradorParqueadero = new Administrador("Admin", tarifaParqueadero);
        Parqueadero parqueadero = new Parqueadero("SuperParqueadero", tarifaParqueadero, filasPuestos, columnasPuestos, administradorParqueadero);

        // Modificación de las tarifas por parte del administrador
        administradorParqueadero.modificarTarifaCarro(10000.0);
        administradorParqueadero.modificarTarifaMotoClasica(500.0);
        administradorParqueadero.modificarTarifaMotoHibrida(1200.0);

        // Verificar que las tarifas se han modificado correctamente
        assertEquals(10000.0, tarifaParqueadero.getTarifaHoraCarro());
        assertEquals(500.0, tarifaParqueadero.getTarifaHoraMotoClasica());
        assertEquals(1200.0, tarifaParqueadero.getTarifaHoraMotoHibrida());

        LOG.info("Finalizando test modificacionTarifasPorAdministrador");
    }
    
    @Test
    public void identificarPropietario() {
        LOG.info("Iniciado test identificarPropietario");
        // Definir tarifas
        double tarifaHoraCarro = 2000.0;
        double tarifaHoraMotoClasica = 1000.0;
        double tarifaHoraMotoHibrida = 1400.0;

        // Tarifa genérica
        Tarifa tarifaParqueadero = new Tarifa(tarifaHoraCarro, tarifaHoraMotoClasica, tarifaHoraMotoHibrida, null);

        // Crear administrador
        Administrador administradorParqueadero = new Administrador("Admin", tarifaParqueadero);

        // Crear parqueadero
        Parqueadero parqueadero = new Parqueadero("SuperParqueadero", tarifaParqueadero, 6, 7, administradorParqueadero);

        // Crear propietario y vehículo
        Propietario propietario1 = new Propietario("Juan Perez");
        Vehiculo vehiculo1 = new Carro("ABC123", "Toyota", propietario1);
        
        // Asignar vehículo a un puesto específico
        Puesto puesto1 = new Puesto(3, 2, EstadoPuesto.OCUPADO, vehiculo1);
        parqueadero.getPuestos()[3][2] = puesto1;

        // Verificar el propietario del vehículo en el puesto (3, 2)
        String propietario = parqueadero.identificarPropietario(3, 2);
        assertEquals("Juan Perez", propietario);

        LOG.info("Finalizando test identificarPropietario");
    }
    
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

        // Se calcula el reporte diario de la fecha establecida
        Map<String, Double> reporteDiario = parqueadero.generarReporteDiario(LocalDate.of(2024, 5, 24));

        // Verificaciones
        assertEquals(8000.0, reporteDiario.get("Carro"));
        assertEquals(0.0, reporteDiario.get("MotoClasica"));
        assertEquals(7000.0, reporteDiario.get("MotoHibrida"));

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
