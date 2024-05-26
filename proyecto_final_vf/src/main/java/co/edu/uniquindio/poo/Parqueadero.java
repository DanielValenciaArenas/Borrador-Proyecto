package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * Clase principal que agrupa la info del parqueadero
 * 
 * @authors: Allison López, Luisa Gómez, Daniel Valencia
 * @since 2024
 * Licencia GNU/GPL v3.0
 */

 public class Parqueadero {
    private final String nombre;
    private final Tarifa tarifa;
    private final Puesto[][] puestos;
    private final Collection<Registro> listaRegistros;
    private final Administrador administrador;

    /*
     * Método constructor de la clase Parqueadero
     */
    public Parqueadero(String nombre, Tarifa tarifa, int filas, int columnas, Administrador administrador) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.puestos = new Puesto[filas][columnas];
        this.listaRegistros = new LinkedList<>();
        this.administrador = administrador;
        crearPuestos(filas, columnas);
    }

    /*
     * Método para obtener el nombre del parqueadero
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * Método para obtener la tarifa del parqueadero
     */
    public Tarifa getTarifa() {
        return tarifa;
    }

    /*
     * Método para obtener la matriz de puestos
     */
    public Puesto[][] getPuestos() {
        return puestos;
    }

    /*
     * Método para obtener la lista de registros
     */
    public Collection<Registro> getListaRegistros() {
        return listaRegistros;
    }

    /*
     * Método para obtener el Administrador del parqueadero
     */
    public Administrador getAdministrador() {
        return administrador;
    }


    /*
     * Método para crear los puestos del parqueadero
     */
    public void crearPuestos(int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                puestos[i][j] = new Puesto(i, j, EstadoPuesto.VACIO, null);
            }
        }
    }

    /*
     * Método para encontrar un puesto especifico
     */
    public Puesto encontrarPuestoEspecifico(int fila, int columna) {
        if (fila >= 0 && fila < puestos.length && columna >= 0 && columna < puestos[0].length) {
            return puestos[fila][columna];
        } else {
            return null; // Retorna null si las coordenadas están fuera de los límites
        }
    }

    /*
     * Método para verificar si un puesto está disponible
     */
    public String verificarDisponibilidadPuesto(int fila, int columna) {
        if (fila >= 0 && fila < puestos.length && columna >= 0 && columna < puestos[0].length) {
            Puesto puesto = puestos[fila][columna];
            if (puesto.getEstadoPuesto() == EstadoPuesto.VACIO) {
                return "El puesto en la posición (" + fila + ", " + columna + ") está disponible.";
            } else {
                return "El puesto en la posición (" + fila + ", " + columna + ") está ocupado.";
            }
        } else {
            return "Coordenadas fuera de los límites de la matriz de puestos.";
        }
    }

    /*
     * Método para encontrar un puesto Disponible
     */
    private Puesto encontrarPuestoDisponible() {
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                if (puestos[i][j].getEstadoPuesto() == EstadoPuesto.VACIO) {
                    return puestos[i][j];
                }
            }
        }
        return null; // Retorna null si no se encuentra ningún puesto disponible
    }


    /*
     * Método para registrar el ingreso de un vehículo al parqueadero
     */
    public void RegistrarEntrada(Vehiculo vehiculo) {
        // Encontrar un puesto disponible
        Puesto puestoDisponible = encontrarPuestoDisponible();

        if (puestoDisponible != null) {
            // Actualizar el estado del puesto
            puestoDisponible.setEstadoPuesto(EstadoPuesto.OCUPADO);
            puestoDisponible.setVehiculo(vehiculo);

            // Obtener el momento de entrada
            LocalDateTime momentoEntrada = LocalDateTime.now();

            // Crear un nuevo registro
            Registro nuevoRegistro = new Registro(momentoEntrada, null, puestoDisponible, vehiculo, tarifa);

            // Agregar el registro a la lista de registros del parqueadero
            listaRegistros.add(nuevoRegistro);
            System.out.println("Se ha registrado el "+vehiculo+" Correctamente");
        } else {
            System.out.println("No hay puestos disponibles en el parqueadero.");
        }
    }

    /*
     * Método para registrar la salida de un vehículo al parqueadero
     */
    public void registrarSalida(Vehiculo vehiculo) {
        boolean encontrado = false;

        for (Registro registro : listaRegistros) {
            if (registro.getVehiculo().equals(vehiculo) && registro.getMomentoSalida() == null) {
                // Actualizar el momento de salida del registro
                registro.setMomentoSalida(LocalDateTime.now());
                // Liberar el puesto
                liberarPuesto(registro.getPuesto());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El vehículo no tiene un registro de entrada válido.");
        }
    }

    /*
     * Método para liberar el puesto ocupado por un vehículo que sale
     */
    private void liberarPuesto(Puesto puesto) {
        puesto.setEstadoPuesto(EstadoPuesto.VACIO);
        puesto.setVehiculo(null);
    }

     /*
     * Método para identificar el propietario de un vehículo por su posición
     */
     public String identificarPropietario(int fila, int columna) {
        assert (fila >= 0 && fila < puestos.length && columna >= 0 && columna < puestos[0].length) : "Coordenadas del puesto fuera de rango.";
    
        Puesto puesto = puestos[fila][columna];
        Vehiculo vehiculo = puesto.getVehiculo();
    
        if (vehiculo != null) {
            return vehiculo.getPropietario().getNombre();
        } else {
            return "No hay vehículo en el puesto especificado";
        }
    }


    public Collection<Registro> reporteDiario(Collection<Registro> listaRegistros) {
        Collection<Registro> listaReporteDiario = new LinkedList<>();
        LocalDate hoy = LocalDate.now(); // Obtener la fecha actual

        for (Registro registro : listaRegistros) {
            // Extraer solo la parte de la fecha de 'momentoEntrada'
            LocalDate fechaEntrada = registro.getMomentoEntrada().toLocalDate();
            
            if (fechaEntrada.equals(hoy)) { // Comparar la fecha del registro con la fecha actual
                listaReporteDiario.add(registro); // Agregar el registro a la lista de reporte diario si es de hoy
            }
        }
        
        return listaReporteDiario; // Devolver la lista de registros del día
    }

   /*
    * Método para agregar un registro a la lista de registros del parqueadero
    */
    public void agregarRegistro(Registro registro) {
        listaRegistros.add(registro);
    }

    /*
     * Método para generar un reporte diario del dinero recaudado
     */
     public Map<String, Double> generarReporteDiario(LocalDate fecha) {

        Map<String, Double> reporte = new HashMap<>();
        reporte.put("Carro", 0.0);
        reporte.put("MotoClasica", 0.0);
        reporte.put("MotoHibrida", 0.0);

        for (Registro registro : listaRegistros) {

            LocalDate fechaRegistro = registro.getMomentoEntrada().toLocalDate();

            if (fechaRegistro.equals(fecha)) {
                Vehiculo vehiculo = registro.getVehiculo();
                double costo = registro.costoTotalEstacionamiento();

                if (vehiculo instanceof Carro) {
                    reporte.put("Carro", reporte.get("Carro") + costo);
                } else if (vehiculo instanceof Moto) {
                    Moto moto = (Moto) vehiculo;
                    if (moto.getTipoMoto() == TipoMoto.CLASICA) {
                        reporte.put("MotoClasica", reporte.get("MotoClasica") + costo);
                    } else if (moto.getTipoMoto() == TipoMoto.HIBRIDA) {
                        reporte.put("MotoHibrida", reporte.get("MotoHibrida") + costo);
                    }
                }
            }
        }
        System.out.println("Reporte diario por vehiculo:");
        System.out.println("Carro: " + reporte.get("Carro"));
        System.out.println("Moto Clasica: " + reporte.get("MotoClasica"));
        System.out.println("Moto Hibrida: " + reporte.get("MotoHibrida"));
        
        return reporte;
    }

    /*
     * Método para generar un reporte mensual del dinero recaudado
     */
    public double generarReporteMensual(int mes) {
        assert mes > 0 && mes <= 12;

        double recaudoMensual = 0;
        for (Registro registro : listaRegistros) {
            LocalDate fechaRegistro = registro.getMomentoEntrada().toLocalDate();
            if (fechaRegistro.getMonthValue() == mes) {
                recaudoMensual += registro.costoTotalEstacionamiento();
            }
        }
        System.out.println("Reporte Mensual (Mes " + mes + "): Recaudo Total = $" + recaudoMensual);
        return recaudoMensual;
    }
    
}