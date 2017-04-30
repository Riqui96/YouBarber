package unicauca.movil.tubarberia.models;



public class Barberia {

    private String nombre, direccion, image, horary, time;
    private String [] services, precios;

    public Barberia() {
        this.services = new String[5];
        this.precios = new String[5];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHorary() {
        return horary;
    }

    public void setHorary(String horary) {
        this.horary = horary;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String[] getServices() {
        return services;
    }


    public void setServices() {
        this.services[0] = "Servicios";
        this.services[1] = "Corte De Cabello";
        this.services[2] = "Arreglo De Barba";
        this.services[3] = "Afeitada";
        this.services[4] = "Corte y delineado de bigote";
    }

    public String[] getPrecios() {
        return precios;
    }

    public void setPrecios(String[] precios) {
        this.precios = precios;
    }
}
