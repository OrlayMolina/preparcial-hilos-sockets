package seguimiento.tallerhilos_sockets.interfazGrafica.model;

public class Estudiante {

    private String documento;
    private String nombres;
    private String apellidos;
    private String edad;
    private String ocupacion;

    public Estudiante(){

    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return documento + ';' +nombres + ';' + apellidos + ';' + edad + ';' + ocupacion;
    }
}
