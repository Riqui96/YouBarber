package unicauca.movil.tubarberia.models;

/**
 * Created by EQUIPO on 22/05/2017.
 */

public class Reserva {
    Long id;
    String fecha, hora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
