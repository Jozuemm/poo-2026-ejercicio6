public class WidgetAlerta {
    private String mensaje;
    private String tipo;
    private String fecha;

    public WidgetAlerta(String mensaje, String tipo, String fecha) {
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}