package Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda(); // Crea agenda con tamaño por defecto (10)

        int opcion;

        do {
            System.out.println("\n--- AGENDA DE CONTACTOS ---");
            System.out.println("1. Añadir Contacto");
            System.out.println("2. Listar Contactos");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Eliminar Contacto");
            System.out.println("5. Modificar Teléfono");
            System.out.println("6. Espacios Libres");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner tras leer numero

            switch (opcion){
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    // Creamos el objeto y dejamos que Agenda valide todo
                    agenda.añadirContacto(new Contacto(nombre, apellido, telefono));
                    break;

                case 2:
                    System.out.println("\nLista de contactos ordenada:");
                    agenda.listarContactos();
                    break;

                case 3:
                    System.out.print("Nombre a buscar: ");
                    String nBusca = scanner.nextLine();
                    agenda.buscarContacto(nBusca);
                    break;

                case 4:
                    System.out.print("Nombre a eliminar: ");
                    String nElim = scanner.nextLine();
                    System.out.print("Apellido a eliminar: ");
                    String aElim = scanner.nextLine();

                    // Creamos un contacto temporal solo con nombre/apellido para buscarlo y borrarlo
                    // El teléfono da igual para borrar, así que lo dejamos vacío
                    Contacto aBorrar = new Contacto(nElim, aElim, "");
                    agenda.eliminarContacto(aBorrar);
                    break;

                case 5:
                    System.out.print("Nombre: ");
                    String nMod = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String aMod = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTel = scanner.nextLine();

                    agenda.modificarTelefono(nMod, aMod, nuevoTel);
                    break;

                case 6:
                    System.out.println("Espacios libres en la agenda: " + agenda.espaciosLibres());
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 7); // Repetir menú hasta que el usuario elija 7

        scanner.close();
    }
}