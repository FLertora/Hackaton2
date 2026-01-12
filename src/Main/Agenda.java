package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Agenda {

    private ArrayList<Contacto> contactos;
    private int tamañoMaximo;

    // Constructor por defecto (10 espacios)
    public Agenda() {
        this(10);
    }

    // Constructor con tamaño personalizado
    public Agenda(int tamañoMaximo) {
        this.tamañoMaximo = tamañoMaximo;
        this.contactos = new ArrayList<>();
    }

    // Verifica si llegamos al límite de la lista
    public boolean agendaLlena() {
        if (contactos.size() >= tamañoMaximo) {
            System.out.println("La agenda está llena. No hay espacio disponible.");
            return true;
        }
        return false;
    }

    // Calcula cuántos huecos quedan (Requerimiento extra)
    public int espaciosLibres() {
        return tamañoMaximo - contactos.size();
    }

    // Usa el método .equals() de Contacto para ver si ya está en la lista
    public boolean existeContacto(Contacto contacto) {
        return contactos.contains(contacto);
    }

    // Añade contacto con todas las validaciones pedidas
    public boolean añadirContacto(Contacto contacto) {
        // 1. Validar que no vengan datos vacíos
        if (contacto.getNombre().isEmpty() || contacto.getApellido().isEmpty()) {
            System.out.println("No se puede añadir: Nombre y Apellido son obligatorios.");
            return false;
        }

        // 2. Validar espacio
        if (agendaLlena()) {
            return false;
        }

        // 3. Validar duplicados
        if (existeContacto(contacto)) {
            System.out.println("El contacto ya existe.");
            return false;
        }

        // Si pasa todo, se guarda
        contactos.add(contacto);
        System.out.println("Contacto añadido exitosamente.");
        return true;
    }

    // Muestra la lista ordenada alfabéticamente
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía");
        } else {
            // Usamos un comparador para ordenar por Nombre y luego por Apellido
            Collections.sort(contactos, new Comparator<Contacto>() {
                @Override
                public int compare(Contacto c1, Contacto c2) {
                    int res = c1.getNombre().compareToIgnoreCase(c2.getNombre());
                    if (res == 0) {
                        // Si tienen el mismo nombre, desempatamos por apellido
                        return c1.getApellido().compareToIgnoreCase(c2.getApellido());
                    }
                    return res;
                }
            });

            // Imprimimos la lista ya ordenada
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }

    // Busca coincidencias por nombre e imprime el teléfono
    public void buscarContacto(String nombre) {
        boolean encontrado = false;
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Teléfono de " + c.getNombre() + " " + c.getApellido() + ": " + c.getTelefono());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se ha encontrado el contacto con ese nombre.");
        }
    }

    // Elimina usando el objeto contacto (requiere nombre y apellido correctos)
    public void eliminarContacto(Contacto c) {
        // .remove usa internamente .equals para encontrar cuál borrar
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado exitosamente.");
        } else {
            System.out.println("No se ha eliminado: El contacto no existe.");
        }
    }

    // Busca, encuentra y actualiza el teléfono
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto c : contactos) {
            // Buscamos manualmente
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono modificado.");
                return;
            }
        }
        System.out.println("El contacto no existe, no se puede modificar.");
    }
}