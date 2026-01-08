package Main;
//listas dinámicas
import java.util.ArrayList;

public class Agenda{
    //lista que almacena los contactos
    private ArrayList<Contacto> contactos;
    //variable que define el número máximo de contactos
    private int tamañoMaximo;

// Constructor
    public Agenda() {this(10);}

//tamaño max
    public Agenda(int tamañoMaximo) {
        this.tamañoMaximo = tamañoMaximo;
        this.contactos = new ArrayList<>();
    }
    // metodo que verifica si la agenda está llena
    public boolean agendaLlena() {
        return contactos.size() >= tamañoMaximo;
    }
    //metodo que verifica si el contacto existe
    public boolean existeContacto(Contacto contacto) {
        return contactos.contains(contacto);
    }
    //metodo que verifica si un contacto existe en la agenda
    public boolean añadirContacto(Contacto contacto) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena");
            return false;
        }
    //metodo que verifica si el contacto existe
        if (existeContacto(contacto)) {
            System.out.println("El contacto ya existe");
            return false;
        }

        contactos.add(contacto);
        return true;
    }
    //metodo para mostrar los contactos
    public void mostrarContactos() {
        //verifica si la lista de contactos está vacía
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía");
        // Recorre la lista de contactos e imprime
        } else {
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }

}