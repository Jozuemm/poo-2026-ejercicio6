public class WidgetReloj {
    private String hora;
    private String fecha;
    private String zonaHoraria;

    public WidgetReloj(String hora, String fecha, String zonaHoraria) {
        this.hora = hora;
        this.fecha = fecha;
        this.zonaHoraria = zonaHoraria;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }
    
}
