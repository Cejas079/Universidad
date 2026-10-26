/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package jorgeromero.veetcare;

/**
 *
 * @author jorge romero
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VeetCare{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Mascota> listaMascotas = new ArrayList<>();
        List<Dueño> listaDueños = new ArrayList<>();
        List<Turno> listaTurnos = new ArrayList<>();
        List<HistoriaClinica> listaHistorias = new ArrayList<>();

        // Variable contador para ir incrementando los dias de los turnos automaticamente
        final LocalDate fechaBase = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM-dd");

        int opcion;

        do {
            System.out.println("\n--- SISTEMA VETCARE (CLINICA HUELLITAS) ---");
            System.out.println("1. Registrar Mascota y Dueño");
            System.out.println("2. Agendar Turno / Cita");
            System.out.println("3. Consultar Cita por ID de Mascota");
            System.out.println("4. Ver Sala de Espera (Turnos activos)");
            System.out.println("5. Atender Paciente (Crear Historia y Eliminar Turno)");
            System.out.println("6. Consultar Historia Clinica por ID de Mascota");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // --- ID-01 y ID-02: Registro ---
                    System.out.println("\n--- REGISTRO DE DUENO Y MASCOTA ---");
                    System.out.print("Ingrese cedula del dueno: ");
                    String idDueño = scanner.nextLine();

                    Dueño dueñoExistente = null;
                    for (Dueño d : listaDueños) {
                        if (d.getIdDueño().equals(idDueño)) {
                            dueñoExistente = d;
                            break;
                        }
                    }

                    if (dueñoExistente == null) {
                        System.out.print("El dueno no esta registrado. Ingrese nombre del dueno: ");
                        String nombreDueño = scanner.nextLine();
                        System.out.print("Ingrese telefono del dueno: ");
                        String telefono = scanner.nextLine();

                        dueñoExistente = new Dueño(idDueño, nombreDueño, telefono);
                        listaDueños.add(dueñoExistente);
                        System.out.println("¡Nuevo dueno registrado con exito!");
                    } else {
                        System.out.println("¡Dueno encontrado en el sistema: " + dueñoExistente.getNombre() + "!");
                    }

                    System.out.print("Ingrese ID de la mascota (ej. 000): ");
                    String idMascota = scanner.nextLine();

                    boolean mascotaYaExiste = false;
                    for (Mascota m : listaMascotas) {
                        if (m.getId().equals(idMascota)) {
                            mascotaYaExiste = true;
                            break;
                        }
                    }

                    if (mascotaYaExiste) {
                        System.out.println("¡Error! Ya existe una mascota registrada con el ID " + idMascota + ".");
                        break;
                    }

                    System.out.print("Ingrese nombre de la mascota: ");
                    String nombreMascota = scanner.nextLine();
                    System.out.print("Ingrese especie de la mascota: ");
                    String especie = scanner.nextLine();

                    Mascota mascota = new Mascota(idMascota, nombreMascota, especie);
                    listaMascotas.add(mascota);
                    dueñoExistente.agregarMascota(mascota);
                    System.out.println("¡Mascota registrada y vinculada con exito!");
                    break;

                case 2:
                    // --- ID-03: Agendar Turno con validacion de existencia de mascota ---
                    System.out.println("\n--- AGENDAR TURNO ---");
                    System.out.print("Ingrese el ID de la mascota para el turno: ");
                    String idBuscado = scanner.nextLine();

                    // Verificamos si la mascota existe en el sistema
                    Mascota mascotaEncontrada = null;
                    for (Mascota m : listaMascotas) {
                        if (m.getId().equals(idBuscado)) {
                            mascotaEncontrada = m;
                            break;
                        }
                    }

                    // Si la mascota NO existe, le damos la opcion de crearla (Regla de negocio)
                    if (mascotaEncontrada == null) {
                        System.out.println("¡Error! La mascota con ID " + idBuscado + " no se encuentra registrada.");
                        System.out.print("¿Desea registrar esta mascota ahora mismo? (si/no): ");
                        String respuestaCrear = scanner.nextLine().trim().toLowerCase();

                        if (respuestaCrear.equals("si") || respuestaCrear.equals("s")) {
                            // Pedimos los datos del dueño primero o verificamos si ya existe
                            System.out.print("Ingrese cedula del dueno para la mascota: ");
                            String idDueñoCita = scanner.nextLine();

                            Dueño dueñoCitaExistente = null;
                            for (Dueño d : listaDueños) {
                                if (d.getIdDueño().equals(idDueñoCita)) {
                                    dueñoCitaExistente = d;
                                    break;
                                }
                            }

                            if (dueñoCitaExistente == null) {
                                System.out.print("El dueno no esta registrado. Ingrese nombre del dueno: ");
                                String nombreDueñoCita = scanner.nextLine();
                                System.out.print("Ingrese telefono del dueno: ");
                                String telefonoCita = scanner.nextLine();

                                dueñoCitaExistente = new Dueño(idDueñoCita, nombreDueñoCita, telefonoCita);
                                listaDueños.add(dueñoCitaExistente);
                                System.out.println("¡Nuevo dueno registrado con exito!");
                            } else {
                                System.out.println("¡Dueno encontrado: " + dueñoCitaExistente.getNombre() + "!");
                            }

                            // Registramos la mascota con el ID que intento buscar
                            System.out.print("Ingrese nombre de la mascota: ");
                            String nombreMascotaCita = scanner.nextLine();
                            System.out.print("Ingrese especie de la mascota: ");
                            String especieCita = scanner.nextLine();

                            mascotaEncontrada = new Mascota(idBuscado, nombreMascotaCita, especieCita);
                            listaMascotas.add(mascotaEncontrada);
                            dueñoCitaExistente.agregarMascota(mascotaEncontrada);
                            System.out.println("¡Mascota creada y registrada con exito!");
                        } else {
                            System.out.println("Operacion cancelada. No se puede agendar turno sin una mascota registrada.");
                            break; // Rompe el caso y regresa al menu principal
                        }
                    }

                    // Si la mascota ya existe (o acaba de ser creada), procedemos a asignarle el turno incremental
                    int cantidadTurnosActuales = listaTurnos.size();
                    LocalDate fechaTurnoCalculada = fechaBase.plusDays(cantidadTurnosActuales);
                    String fechaTurno = fechaTurnoCalculada.format(formato);

                    System.out.print("Ingrese el motivo de la cita: ");
                    String motivo = scanner.nextLine();

                    Turno nuevoTurno = new Turno(idBuscado, fechaTurno, motivo);
                    listaTurnos.add(nuevoTurno);
                    System.out.println("¡Turno agendado automaticamente para la fecha " + fechaTurno + "!");
                    break;

                case 3:
                    // --- ID-04: Consultar Cita con opcion de agendar (fecha incremental) ---
                    System.out.println("\n--- CONSULTAR CITA ---");
                    System.out.print("Ingrese el ID de la mascota a consultar: ");
                    String idBusquedaCita = scanner.nextLine();

                    boolean citaEncontrada = false;
                    for (Turno t : listaTurnos) {
                        if (t.getIdMascota().equals(idBusquedaCita)) {
                            System.out.println("--- CITA ENCONTRADA ---");
                            System.out.println(t);
                            citaEncontrada = true;
                        }
                    }

                    if (!citaEncontrada) {
                        System.out.println("No se encontro ninguna cita activa para el ID ingresado.");
                        System.out.print("¿Desea agendar una cita nueva para esta mascota? (si/no): ");
                        String respuesta = scanner.nextLine().trim().toLowerCase();

                        if (respuesta.equals("si") || respuesta.equals("s")) {
                            // Incrementa la fecha automaticamente segun los turnos existentes
                            int turnosActualesConsulta = listaTurnos.size();
                            LocalDate fechaNuevaCalculada = fechaBase.plusDays(turnosActualesConsulta);
                            String fechaTurnoNueva = fechaNuevaCalculada.format(formato);

                            System.out.print("Ingrese el motivo de la cita: ");
                            String motivoNuevo = scanner.nextLine();

                            Turno turnoNuevoConsulta = new Turno(idBusquedaCita, fechaTurnoNueva, motivoNuevo);
                            listaTurnos.add(turnoNuevoConsulta);
                            System.out.println("¡Turno agendado automaticamente para la fecha " + fechaTurnoNueva + "!");
                        } else {
                            System.out.println("Operacion cancelada.");
                        }
                    }
                    break;

                case 4:
                    // --- ID-05: Sala de Espera ---
                    System.out.println("\n--- SALA DE ESPERA (TURNOS ACTIVOS) ---");
                    if (listaTurnos.isEmpty()) {
                        System.out.println("No hay turnos agendados en este momento.");
                    } else {
                        for (Turno t : listaTurnos) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 5:
                    // --- ID-06 y ID-07: Atencion y registro con fecha automatica del turno ---
                    System.out.println("\n--- ATENCION DE PACIENTE ---");
                    if (listaTurnos.isEmpty()) {
                        System.out.println("No hay turnos en espera para atender.");
                        break;
                    }
                    Turno turnoAtender = listaTurnos.get(0);
                    System.out.println("Atendiendo a mascota con ID: " + turnoAtender.getIdMascota());
                    System.out.println("Fecha de la cita programada: " + turnoAtender.getFechaTurno());

                    System.out.print("Ingrese el motivo de la consulta medica: ");
                    String motivoConsulta = scanner.nextLine();
                    System.out.print("Ingrese las observaciones / diagnostico: ");
                    String observaciones = scanner.nextLine();

                    HistoriaClinica historia = new HistoriaClinica(
                            turnoAtender.getIdMascota(),
                            turnoAtender.getFechaTurno(),
                            motivoConsulta,
                            observaciones
                    );
                    listaHistorias.add(historia);

                    listaTurnos.remove(0);
                    System.out.println("¡Atencion finalizada! Historia guardada y turno eliminado de la sala de espera.");
                    break;

                case 6:
                    // --- ID-08: Consultar Historia Clinica ---
                    System.out.println("\n--- CONSULTAR HISTORIA CLINICA ---");
                    System.out.print("Ingrese el ID de la mascota a consultar: ");
                    String idConsulta = scanner.nextLine();

                    boolean historiaEncontrada = false;
                    for (HistoriaClinica h : listaHistorias) {
                        if (h.getIdMascota().equals(idConsulta)) {
                            System.out.println("--- HISTORIA ENCONTRADA ---");
                            System.out.println(h);
                            historiaEncontrada = true;
                        }
                    }
                    if (!historiaEncontrada) {
                        System.out.println("No se encontro historia clinica para el ID ingresado.");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del sistema VetCare. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
