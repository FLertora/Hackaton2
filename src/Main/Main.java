package Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        // Datos iniciales
        agenda.añadirContacto(new Contacto("Juan", "Pérez", "123456"));
        agenda.añadirContacto(new Contacto("María", "Gómez", "987654"));

        int opcion;

        do {
            System.out.println("\n--- AGENDA DE CONTACTOS ---");
            System.out.println("1. Añadir Contacto");
            System.out.println("2. Listar Contactos");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Eliminar Contacto");
            System.out.println("5. Modificar Teléfono");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese teléfono: ");
                    String telefono = scanner.nextLine();

                    if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty()){
                        System.out.println("Error: Faltan datos obligatorios.");
                    } else {
                        agenda.añadirContacto(new Contacto(nombre, apellido, telefono));
                        System.out.println("Operación realizada.");
                    }
                    break;

                case 2:
                    System.out.println("\nLista de contactos:");
                    agenda.mostrarContactos();
                    break;

                case 3:
                    System.out.print("Nombre a buscar: ");
                    String nBusca = scanner.nextLine();
                    System.out.print("Apellido a buscar: ");
                    String aBusca = scanner.nextLine();
                    agenda.buscarContacto(nBusca, aBusca);
                    break;

                case 4:
                    System.out.print("Nombre a eliminar: ");
                    String nElim = scanner.nextLine();
                    System.out.print("Apellido a eliminar: ");
                    String aElim = scanner.nextLine();
                    agenda.eliminarContacto(nElim, aElim);
                    break;

                case 5:
                    System.out.print("Nombre del contacto: ");
                    String nMod = scanner.nextLine();
                    System.out.print("Apellido del contacto: ");
                    String aMod = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTel = scanner.nextLine();
                    agenda.modificarTelefono(nMod, aMod, nuevoTel);
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 7);

        scanner.close();
    }
}
