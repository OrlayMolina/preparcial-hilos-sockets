package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Sockets;

public class Vehiculo {

    private String documentoPropietario;
    private TipoVehiculo tipoVehiculo;
    private Double cantidadGalones;
    private String fechaTanqueo;

    public Vehiculo(){

    }

    public Vehiculo(String documentoPropietario, TipoVehiculo tipoVehiculo, Double cantidadGalones, String fechaTanqueo) {
        this.documentoPropietario = documentoPropietario;
        this.tipoVehiculo = tipoVehiculo;
        this.cantidadGalones = cantidadGalones;
        this.fechaTanqueo = fechaTanqueo;
    }

    public String getDocumentoPropietario() {
        return documentoPropietario;
    }

    public void setDocumentoPropietario(String documentoPropietario) {
        this.documentoPropietario = documentoPropietario;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Double getCantidadGalones() {
        return cantidadGalones;
    }

    public void setCantidadGalones(Double cantidadGalones) {
        this.cantidadGalones = cantidadGalones;
    }

    public String getFechaTanqueo() {
        return fechaTanqueo;
    }

    public void setFechaTanqueo(String fechaTanqueo) {
        this.fechaTanqueo = fechaTanqueo;
    }

    @Override
    public String toString() {
        return documentoPropietario + ';' + tipoVehiculo + ';' + cantidadGalones + ';' + fechaTanqueo;
    }
}
