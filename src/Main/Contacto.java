package Main;

public class Contacto {

    private String nombre;
    private String apellido;
    private String telefono;

    // Constructor: Inicializa los datos cuando creamos el objeto
    public Contacto(String nombre, String apellido, String telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // Getters para obtener la info privada desde fuera
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getTelefono(){
        return telefono;
    }

    // Setter: Necesario para la opción de "Modificar teléfono"
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Sobrescribimos equals para que Java sepa comparar dos contactos
    // Se consideran iguales si tienen mismo nombre y apellido (ignorando mayúsculas)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Contacto contacto = (Contacto) obj;
        // Comparamos ignorando mayúsculas/minúsculas (IgnoreCase)
        return nombre.equalsIgnoreCase(contacto.nombre) &&
                apellido.equalsIgnoreCase(contacto.apellido);
    }

    // Método para imprimir el contacto bonito en consola
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}