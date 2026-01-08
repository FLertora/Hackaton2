package Main;

public class Main {

    public static void main(String[] args) {

        Agenda agenda = new Agenda(); // tamaño por defecto: 10

        Contacto c1 = new Contacto("Juan", "Pérez", "123456");
        Contacto c2 = new Contacto("María", "Gómez", "987654");
        Contacto c3 = new Contacto("juan", "pérez", "555555"); // duplicado

        agenda.añadirContacto(c1);
        agenda.añadirContacto(c2);
        agenda.añadirContacto(c3);

        agenda.mostrarContactos();
    }
}
