public class WidgetClima {
    private String ciudad;
    private double temperatura;
    private String descripcion;

    public WidgetClima(String ciudad, double temperatura, String descripcion) {
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
