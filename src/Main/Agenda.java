package Main;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contacto> contactos;
    private int tamañoMaximo;

    public Agenda() {
        this(10);
    }

    public Agenda(int tamañoMaximo) {
        this.tamañoMaximo = tamañoMaximo;
        this.contactos = new ArrayList<>();
    }

    public boolean agendaLlena() {
        return contactos.size() >= tamañoMaximo;
    }

    public boolean existeContacto(Contacto contacto) {
        return contactos.contains(contacto);
    }

    public boolean añadirContacto(Contacto contacto) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena");
            return false;
        }
        if (existeContacto(contacto)) {
            System.out.println("El contacto ya existe");
            return false;
        }

        contactos.add(contacto);
        return true;
    }

    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía");
        } else {
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }

    public void buscarContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Contacto encontrado: " + c);
                return;
            }
        }
        System.out.println("El contacto no se encuentra en la agenda.");
    }

    public void eliminarContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                contactos.remove(c);
                System.out.println("Contacto eliminado.");
                return;
            }
        }
        System.out.println("No se pudo eliminar, el contacto no existe.");
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró el contacto para modificar.");
    }
}